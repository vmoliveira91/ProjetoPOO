package ui.administrador;

import negocios.Fachada;

public class TelaAdministrador extends javax.swing.JFrame {
    
    private final Fachada fachada;
    
    public TelaAdministrador(Fachada fachada) {
        initComponents();
        setLocationRelativeTo(null);
        this.fachada = fachada;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        alunoButton = new javax.swing.JButton();
        professorButton = new javax.swing.JButton();
        disciplinaButton = new javax.swing.JButton();
        turmaButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        alunoButton.setText("Alunos");
        alunoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alunoButtonActionPerformed(evt);
            }
        });

        professorButton.setText("Professor");
        professorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                professorButtonActionPerformed(evt);
            }
        });

        disciplinaButton.setText("Disciplina");
        disciplinaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disciplinaButtonActionPerformed(evt);
            }
        });

        turmaButton.setText("Turmas");
        turmaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turmaButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Administrador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(disciplinaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alunoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(professorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(turmaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alunoButton)
                    .addComponent(professorButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disciplinaButton)
                    .addComponent(turmaButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alunoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alunoButtonActionPerformed
        TelaAdministradorAlunos aluno = new TelaAdministradorAlunos(this.fachada);
        aluno.setVisible(true);
        aluno.setResizable(false);
        aluno.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_alunoButtonActionPerformed

    private void professorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_professorButtonActionPerformed
        TelaAdministradorProfessores professor = new TelaAdministradorProfessores(this.fachada);
        professor.setVisible(true);
        professor.setResizable(false);
        professor.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_professorButtonActionPerformed

    private void disciplinaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disciplinaButtonActionPerformed
        TelaAdministradorDisciplinas disciplina = new TelaAdministradorDisciplinas(this.fachada);
        disciplina.setVisible(true);
        disciplina.setResizable(false);
        disciplina.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_disciplinaButtonActionPerformed
        
    private void turmaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turmaButtonActionPerformed
       TelaAdministradorTurmas turma = new TelaAdministradorTurmas(this.fachada);
       turma.setVisible(true);
       turma.setResizable(false);
       turma.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_turmaButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alunoButton;
    private javax.swing.JButton disciplinaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton professorButton;
    private javax.swing.JButton turmaButton;
    // End of variables declaration//GEN-END:variables
}
