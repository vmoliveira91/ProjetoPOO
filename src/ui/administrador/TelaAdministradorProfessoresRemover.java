package ui.administrador;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import negocios.Fachada;
import negocios.entidades.Professor;
import negocios.excecoes.UsuarioNaoCadastradoException;

public class TelaAdministradorProfessoresRemover extends javax.swing.JFrame {

    private final Fachada fachada;
    private ArrayList<Professor> professores;

    public TelaAdministradorProfessoresRemover(Fachada fachada) {
        initComponents();
        this.fachada = fachada;
        try {
            this.professores = this.fachada.listarProfessores();
            this.preencherBox();
        } catch (UsuarioNaoCadastradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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
        this.removerBox.setModel(model);
    }

    private void atualizarProfessores() {
        try {
            this.professores = this.fachada.listarProfessores();
        } catch (UsuarioNaoCadastradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        removerBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Remover Professor");

        jButton1.setText("Remover");
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
                .addGap(52, 52, 52)
                .addComponent(removerBox, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(74, 74, 74))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(removerBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String professorSelecionado = this.removerBox.getSelectedItem().toString();
        Professor prof = null;
        int professorId = Integer.parseInt(professorSelecionado.split(" ")[0]);
        if (this.fachada.removerProfessor(professorId)) {
            JOptionPane.showMessageDialog(null, "Professor removido com sucesso!");
            this.atualizarProfessores();
            this.preencherBox();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> removerBox;
    // End of variables declaration//GEN-END:variables
}
