package ui.administrador;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import negocios.Fachada;
import negocios.entidades.Professor;
import negocios.excecoes.UsuarioNaoCadastradoException;

public class TelaAdministradorProfessoresConsultar extends javax.swing.JFrame {

    private final Fachada fachada;
    private ArrayList<Professor> professores;

    public TelaAdministradorProfessoresConsultar(Fachada fachada) {
        initComponents();
        this.fachada = fachada;
        try {
            this.professores = this.fachada.listarProfessores();
            this.preencherBox();
        } catch (UsuarioNaoCadastradoException e) {
            JOptionPane.showMessageDialog(null, "Não há nenhuma disciplina cadastrada");
        }
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void preencherBox() {
        String[] professoresString = new String[this.professores.size()];
        for (int i = 0; i < professoresString.length; i++) {
            professoresString[i] = this.professores.get(i).getId() + " - " + this.professores.get(i).getNome();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(professoresString);
        this.consultarBox.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        consultarBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Consultar Professor");

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 48, Short.MAX_VALUE)
                .addComponent(consultarBox, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(consultarBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String professorSelecionado = this.consultarBox.getSelectedItem().toString();
        Professor prof = null;
        int professorId = Integer.parseInt(professorSelecionado.split(" ")[0]);
        for (int i = 0; i < this.professores.size(); i++) {
            if (this.professores.get(i).getId() == professorId) {
                prof = this.professores.get(i);
                break;
            }
        }
        TelaAdministradorProfessoresConsultarResultado resultado = new TelaAdministradorProfessoresConsultarResultado(prof);
        resultado.setVisible(true);
        resultado.setResizable(false);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> consultarBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
