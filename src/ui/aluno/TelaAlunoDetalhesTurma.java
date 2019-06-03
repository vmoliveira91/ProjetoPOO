package ui.aluno;

import negocios.Fachada;
import javax.swing.JOptionPane;
import negocios.entidades.Aluno;
import negocios.entidades.RendimentoEscolar;
import negocios.entidades.Turma;

public class TelaAlunoDetalhesTurma extends javax.swing.JFrame {

    private final Turma turma;
    private final Aluno aluno;
    private final Fachada fachada;
    private RendimentoEscolar rendimento;

    public TelaAlunoDetalhesTurma(Turma turma, Aluno aluno, Fachada fachada) {
        initComponents();
        this.turma = turma;
        this.aluno = aluno;
        this.fachada = fachada;
        this.pegarNotas();
        this.preencher();
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    }

    private void preencher() {
        this.idField.setText(this.turma.getId() + "");
        this.idField.setEditable(false);
        this.disciplinaField.setText(this.turma.getDisciplina().getNome());
        this.disciplinaField.setEditable(false);
        this.professorField.setText(this.turma.getProfessor().getNome());
        this.professorField.setEditable(false);
        this.nota1Field.setText(this.rendimento.getNota1() + "");
        this.nota1Field.setEditable(false);
        this.nota2Field.setText(this.rendimento.getNota2() + "");
        this.nota2Field.setEditable(false);
        String[] trabalhos = this.rendimento.getTrabalhos();
        float[] notaTrabalhos = this.rendimento.getNotaTrabalhos();
        // Primeiro trabalho
        if (!trabalhos[0].equals("")) {
            this.trabalho1Field.setText(trabalhos[0]);
            this.trabalho1Field.setEditable(false);
            this.notaTrabalho1Field.setText(notaTrabalhos[0] + "");
            this.notaTrabalho1Field.setEditable(false);
        } else {
            this.trabalho1Field.setText("");
            this.notaTrabalho1Field.setText("0");
            this.notaTrabalho1Field.setEditable(false);
        }
        // Segundo trabalho
        if (!trabalhos[1].equals("")) {
            this.trabalho2Field.setText(trabalhos[1]);
            this.trabalho2Field.setEditable(false);
            this.notaTrabalho2Field.setText(notaTrabalhos[1] + "");
            this.notaTrabalho2Field.setEditable(false);
        } else {
            this.trabalho2Field.setText("");
            this.notaTrabalho2Field.setText("0");
            this.notaTrabalho2Field.setEditable(false);
        }
        // Terceiro trabalho
        if (!trabalhos[2].equals("")) {
            this.trabalho3Field.setText(trabalhos[2]);
            this.trabalho3Field.setEditable(false);
            this.notaTrabalho3Field.setText(notaTrabalhos[2] + "");
            this.notaTrabalho3Field.setEditable(false);
        } else {
            this.trabalho3Field.setText("");
            this.notaTrabalho3Field.setText("0");
            this.notaTrabalho3Field.setEditable(false);
        }
        // Quarto trabalho
        if (!trabalhos[3].equals("")) {
            this.trabalho4Field.setText(trabalhos[3]);
            this.trabalho4Field.setEditable(false);
            this.notaTrabalho4Field.setText(notaTrabalhos[3] + "");
            this.notaTrabalho4Field.setEditable(false);
        } else {
            this.trabalho4Field.setText("");
            this.notaTrabalho4Field.setText("0");
            this.notaTrabalho4Field.setEditable(false);
        }
    }

    private void pegarNotas() {
        this.rendimento = this.fachada.exibirNotasAluno(this.turma.getId(), this.aluno.getId());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        adicionarButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        disciplinaField = new javax.swing.JTextField();
        professorField = new javax.swing.JTextField();
        nota1Field = new javax.swing.JTextField();
        trabalho1Field = new javax.swing.JTextField();
        trabalho2Field = new javax.swing.JTextField();
        trabalho3Field = new javax.swing.JTextField();
        trabalho4Field = new javax.swing.JTextField();
        nota2Field = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        notaTrabalho1Field = new javax.swing.JTextField();
        notaTrabalho2Field = new javax.swing.JTextField();
        notaTrabalho3Field = new javax.swing.JTextField();
        notaTrabalho4Field = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Trabalhos e Notas");

        adicionarButton.setText("Adicionar Trabalho");
        adicionarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Id:");

        jLabel3.setText("Disciplina:");

        jLabel4.setText("Professor:");

        jLabel5.setText("Notas");

        jLabel6.setText("Trabalhos:");

        jLabel7.setText("Trabalho 1:");

        jLabel8.setText("Trabalho 2:");

        jLabel9.setText("Trabalho 3:");

        jLabel10.setText("Trabalho 4:");

        jLabel11.setText("Nota 1");

        jLabel12.setText("Nota 2");

        jLabel13.setText("Nomes");

        jLabel14.setText("Notas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trabalho2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(notaTrabalho2Field))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(trabalho4Field, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(trabalho3Field, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(notaTrabalho3Field)
                                    .addComponent(notaTrabalho4Field)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(trabalho1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(notaTrabalho1Field))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                        .addComponent(jLabel14)
                                        .addGap(9, 9, 9))))))
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(nota1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(nota2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(professorField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(disciplinaField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(44, 44, 44)
                            .addComponent(jLabel12))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adicionarButton)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(disciplinaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(professorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nota1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nota2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(trabalho1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notaTrabalho1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(trabalho2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notaTrabalho2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(trabalho3Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(notaTrabalho3Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(trabalho4Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notaTrabalho4Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(adicionarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarButtonActionPerformed
        String[] trabalhos = new String[4];
        trabalhos[0] = trabalho1Field.getText();
        trabalhos[1] = trabalho2Field.getText();
        trabalhos[2] = trabalho3Field.getText();
        trabalhos[3] = trabalho4Field.getText();
        this.fachada.adicionarTrabalho(this.turma.getId(), this.aluno.getId(), trabalhos);
        JOptionPane.showMessageDialog(null, "Trabalho(s) adicionado(s) com sucesso!");
        dispose();
    }//GEN-LAST:event_adicionarButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarButton;
    private javax.swing.JTextField disciplinaField;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nota1Field;
    private javax.swing.JTextField nota2Field;
    private javax.swing.JTextField notaTrabalho1Field;
    private javax.swing.JTextField notaTrabalho2Field;
    private javax.swing.JTextField notaTrabalho3Field;
    private javax.swing.JTextField notaTrabalho4Field;
    private javax.swing.JTextField professorField;
    private javax.swing.JTextField trabalho1Field;
    private javax.swing.JTextField trabalho2Field;
    private javax.swing.JTextField trabalho3Field;
    private javax.swing.JTextField trabalho4Field;
    // End of variables declaration//GEN-END:variables
}
