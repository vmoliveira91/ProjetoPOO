package ui.administrador;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import negocios.Fachada;
import negocios.entidades.Turma;
import negocios.excecoes.SemTurmaCadastradaException;

public class TelaAdministradorTurmasRemover extends javax.swing.JFrame {

    private final Fachada fachada;
    private ArrayList<Turma> turmas;

    public TelaAdministradorTurmasRemover(Fachada fachada) {
        initComponents();
        this.fachada = fachada;
        try {
            this.turmas = this.fachada.listarTurmas();
            this.preencherBox();
        } catch (SemTurmaCadastradaException e) {
            JOptionPane.showConfirmDialog(null, "Não há nenhuma turma cadastrada");
        }
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void preencherBox() {
        String[] turmasString = new String[this.turmas.size()];
        for (int i = 0; i < turmasString.length; i++) {
            turmasString[i] = this.turmas.get(i).getId() + " - " + this.turmas.get(i).getDisciplina().getNome() + " - " + this.turmas.get(i).getProfessor().getNome();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(turmasString);
        this.removerBox.setModel(model);
    }

    private void atualizarTurmas() {
        try {
            this.turmas = this.fachada.listarTurmas();
        } catch (SemTurmaCadastradaException e) {
            JOptionPane.showConfirmDialog(null, "Não há nenhuma turma cadastrada");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        removerButton = new javax.swing.JButton();
        removerBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Remover Turma");

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(removerBox, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(removerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removerBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removerButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerButtonActionPerformed
        String turmaSelecionada = this.removerBox.getSelectedItem().toString();
        Turma turmaa = null;
        int turmaId = Integer.parseInt(turmaSelecionada.split(" ")[0]);
        try {
            if (this.fachada.removerTurma(turmaId)) {
                JOptionPane.showConfirmDialog(null, "Turma removida com sucesso!");
                this.atualizarTurmas();
                this.preencherBox();
            }
        } catch (SemTurmaCadastradaException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_removerButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAdministradorTurmasRemover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdministradorTurmasRemover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdministradorTurmasRemover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdministradorTurmasRemover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdministradorTurmasRemover(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> removerBox;
    private javax.swing.JButton removerButton;
    // End of variables declaration//GEN-END:variables
}
