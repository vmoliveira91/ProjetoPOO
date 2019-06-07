package ui.administrador;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import negocios.Fachada;
import negocios.entidades.Aluno;
import negocios.excecoes.UsuarioNaoCadastradoException;

public class TelaAdministradorAlunosConsultar extends javax.swing.JFrame {

    private final Fachada fachada;
    private ArrayList<Aluno> alunos;

    public TelaAdministradorAlunosConsultar(Fachada fachada) {
        initComponents();
        this.fachada = fachada;
        try {
            this.alunos = this.fachada.listarAlunos();
            this.preencherBox();
        } catch (UsuarioNaoCadastradoException e) {
            JOptionPane.showMessageDialog(null, "Não há nenhum aluno cadastrado");
        }
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void preencherBox() {
        String[] alunosString = new String[this.alunos.size()];
        for (int i = 0; i < alunosString.length; i++) {
            alunosString[i] = this.alunos.get(i).getId() + " - " + this.alunos.get(i).getNome();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(alunosString);
        this.alunosBox.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        consultarButton = new javax.swing.JButton();
        alunosBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Consultar Aluno");

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(alunosBox, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(consultarButton)
                        .addGap(99, 99, 99))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(alunosBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(consultarButton)
                .addContainerGap())
        );

        alunosBox.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarButtonActionPerformed
        String alunoSelecionado = this.alunosBox.getSelectedItem().toString();
        Aluno alunoo = null;
        int alunoId = Integer.parseInt(alunoSelecionado.split(" ")[0]);
        for (int i = 0; i < this.alunos.size(); i++) {
            if (this.alunos.get(i).getId() == alunoId) {
                alunoo = this.alunos.get(i);
                break;
            }
        }
        TelaAdministradorAlunosConsultarResultado resultados = new TelaAdministradorAlunosConsultarResultado(alunoo);
        resultados.setVisible(true);
        resultados.setResizable(false);
    }//GEN-LAST:event_consultarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> alunosBox;
    private javax.swing.JButton consultarButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
