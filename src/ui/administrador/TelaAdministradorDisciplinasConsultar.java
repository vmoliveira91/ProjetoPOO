package ui.administrador;

import javax.swing.DefaultComboBoxModel;
import negocios.Fachada;
import negocios.entidades.Disciplina;
import negocios.excecoes.SemDisciplinaCadastradaException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TelaAdministradorDisciplinasConsultar extends javax.swing.JFrame {

    private final Fachada fachada;
    private ArrayList<Disciplina> disciplinas;

    public TelaAdministradorDisciplinasConsultar(Fachada fachada) {
        initComponents();
        this.fachada = fachada;
        try {
            this.disciplinas = this.fachada.listarDisciplinas();
            this.preencherBox();
            setVisible(true);
            setResizable(false);
        } catch (SemDisciplinaCadastradaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void preencherBox() {
        String[] disciplinasString = new String[this.disciplinas.size()];
        for (int i = 0; i < disciplinasString.length; i++) {
            disciplinasString[i] = this.disciplinas.get(i).getId() + " - " + this.disciplinas.get(i).getNome();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(disciplinasString);
        this.disciplinasBox.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        consultarButton = new javax.swing.JButton();
        disciplinasBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Consultar disciplina");

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
                .addGap(36, 36, 36)
                .addComponent(disciplinasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(consultarButton)
                        .addGap(87, 87, 87))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(disciplinasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(consultarButton)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarButtonActionPerformed
        String disciplinaSelecionada = this.disciplinasBox.getSelectedItem().toString();
        Disciplina disc = null;
        int disciplinaId = Integer.parseInt(disciplinaSelecionada.split(" ")[0]);
        for (int i = 0; i < this.disciplinas.size(); i++) {
            if (this.disciplinas.get(i).getId() == disciplinaId) {
                disc = this.disciplinas.get(i);
                break;
            }
        }
        TelaAdministradorDisciplinasConsultarResultados resultado = new TelaAdministradorDisciplinasConsultarResultados(disc);
        resultado.setVisible(true);
        resultado.setResizable(false);
        dispose();
    }//GEN-LAST:event_consultarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consultarButton;
    private javax.swing.JComboBox<String> disciplinasBox;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
