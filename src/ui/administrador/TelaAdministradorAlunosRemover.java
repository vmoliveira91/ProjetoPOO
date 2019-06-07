package ui.administrador;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import negocios.Fachada;
import negocios.entidades.Aluno;
import negocios.excecoes.UsuarioNaoCadastradoException;

public class TelaAdministradorAlunosRemover extends javax.swing.JFrame {

    private final Fachada fachada;
    private ArrayList<Aluno> alunos;

    public TelaAdministradorAlunosRemover(Fachada fachada) {
        initComponents();
        this.fachada = fachada;
        try {
            this.alunos = this.fachada.listarAlunos();
            this.preencherBox();
        } catch (UsuarioNaoCadastradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

    private void atualizarAlunos() {
        try {
            this.alunos = this.fachada.listarAlunos();
        } catch (UsuarioNaoCadastradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        removerButton = new javax.swing.JButton();
        alunosBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Remover Aluno");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(removerButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(alunosBox, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alunosBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removerButton)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerButtonActionPerformed
        String alunoSelecionado = this.alunosBox.getSelectedItem().toString();
        Aluno alunoo = null;
        int alunoId = Integer.parseInt(alunoSelecionado.split(" ")[0]);
        if (this.fachada.removerAluno(alunoId)) {
            JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
            this.atualizarAlunos();
            this.preencherBox();
        }
    }//GEN-LAST:event_removerButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> alunosBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton removerButton;
    // End of variables declaration//GEN-END:variables
}
