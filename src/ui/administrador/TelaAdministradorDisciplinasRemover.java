package ui.administrador;

import javax.swing.DefaultComboBoxModel;
import negocios.Fachada;
import negocios.entidades.Disciplina;
import negocios.excecoes.SemDisciplinaCadastradaException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TelaAdministradorDisciplinasRemover extends javax.swing.JFrame {

    private final Fachada fachada;
    private ArrayList<Disciplina> disciplinas;

    public TelaAdministradorDisciplinasRemover(Fachada fachada) {
        initComponents();
        this.fachada = fachada;
        try {
            this.disciplinas = this.fachada.listarDisciplinas();
            this.preencherBox();
        } catch (SemDisciplinaCadastradaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            dispose();
        }
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void preencherBox() {
        String[] disciplinasString = new String[this.disciplinas.size()];
        for (int i = 0; i < disciplinasString.length; i++) {
            disciplinasString[i] = this.disciplinas.get(i).getId() + " - " + this.disciplinas.get(i).getNome();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(disciplinasString);
        this.disciplinasBox.setModel(model);
    }

    private void atualizarDisciplinas() {
        try {
            this.disciplinas = this.fachada.listarDisciplinas();
        } catch (SemDisciplinaCadastradaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        removerButton = new javax.swing.JButton();
        disciplinasBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Remover Disciplina");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(disciplinasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(removerButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(disciplinasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removerButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerButtonActionPerformed
        String disciplinaSelecionada = this.disciplinasBox.getSelectedItem().toString();
        Disciplina disc = null;
        int disciplinaId = Integer.parseInt(disciplinaSelecionada.split(" ")[0]);
        if (this.fachada.removerDisciplina(disciplinaId)) {
            JOptionPane.showMessageDialog(null, "Disciplina removida com sucesso!");
            this.atualizarDisciplinas();
            this.preencherBox();
        }
    }//GEN-LAST:event_removerButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> disciplinasBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton removerButton;
    // End of variables declaration//GEN-END:variables
}
