package ui.aluno;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.Fachada;
import negocios.entidades.Aluno;
import negocios.entidades.Turma;
import negocios.excecoes.SemTurmaCadastradaException;

public class TelaAluno extends javax.swing.JFrame {

    private final Aluno aluno;
    private final Fachada fachada;
    private ArrayList<Turma> turmas;

    public TelaAluno(Aluno aluno, Fachada fachada) {
        initComponents();
        setLocationRelativeTo(null);
        this.aluno = aluno;
        this.fachada = fachada;
        this.alunoLabel.setText("Bem-vindo, " + this.aluno.getNome());
        this.pegarTurmas();
        if (this.turmas != null) {
            this.preencherBox();
            this.preencherTable();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        turmasTable = new javax.swing.JTable();
        alunoLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        turmasDispButton = new javax.swing.JButton();
        turmasBox = new javax.swing.JComboBox<>();
        detalhesButton = new javax.swing.JButton();
        atualizarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        turmasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Disciplina", "Professor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        turmasTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(turmasTable);
        if (turmasTable.getColumnModel().getColumnCount() > 0) {
            turmasTable.getColumnModel().getColumn(0).setResizable(false);
            turmasTable.getColumnModel().getColumn(1).setResizable(false);
            turmasTable.getColumnModel().getColumn(2).setResizable(false);
        }

        alunoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        alunoLabel.setText("Aluno");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Turmas:");

        turmasDispButton.setText("Ver turmas disponíveis");
        turmasDispButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turmasDispButtonActionPerformed(evt);
            }
        });

        detalhesButton.setText("Ver detalhes");
        detalhesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalhesButtonActionPerformed(evt);
            }
        });

        atualizarButton.setText("Atualizar");
        atualizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(turmasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(detalhesButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(turmasDispButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(atualizarButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(alunoLabel)
                .addGap(226, 226, 226))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(alunoLabel)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(atualizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(turmasDispButton)
                    .addComponent(turmasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detalhesButton))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pegarTurmas() {
        try {
            this.turmas = this.fachada.exibirTurmasAluno(this.aluno.getId());
        } catch (SemTurmaCadastradaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            this.detalhesButton.setEnabled(false);
        }
    }

    private void preencherBox() {
        String[] turmasString = new String[this.turmas.size()];
        for (int i = 0; i < this.turmas.size(); i++) {
            turmasString[i] = this.turmas.get(i).toString();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(turmasString);
        this.turmasBox.setModel(model);
    }

    private void preencherTable() {
        DefaultTableModel model = (DefaultTableModel) turmasTable.getModel();
        Object rowData[] = new Object[3];
        for (int i = 0; i < this.turmas.size(); i++) {
            rowData[0] = this.turmas.get(i).getId();
            rowData[1] = this.turmas.get(i).getDisciplina().getNome();
            rowData[2] = this.turmas.get(i).getProfessor().getNome();
            model.addRow(rowData);
        }
    }

    private void turmasDispButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turmasDispButtonActionPerformed
        TelaAlunoTurmasDisponiveis disponiveis = new TelaAlunoTurmasDisponiveis(this.aluno, this.fachada);
    }//GEN-LAST:event_turmasDispButtonActionPerformed

    private void detalhesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalhesButtonActionPerformed
        String turmaString = this.turmasBox.getSelectedItem().toString();
        String[] dadosTurma = turmaString.split(" ");
        int turmaId = Integer.parseInt(dadosTurma[0]);
        Turma turma = null;
        for (int i = 0; i < this.turmas.size(); i++) {
            if (this.turmas.get(i).getId() == turmaId) {
                turma = this.turmas.get(i);
            }
        }
        TelaAlunoDetalhesTurma detalhes = new TelaAlunoDetalhesTurma(turma, aluno, fachada);
        detalhes.setVisible(true);
        detalhes.setResizable(false);
    }//GEN-LAST:event_detalhesButtonActionPerformed

    private void atualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarButtonActionPerformed
        DefaultComboBoxModel modelBox = (DefaultComboBoxModel) turmasBox.getModel();
        modelBox.removeAllElements();
        DefaultTableModel modelTable = (DefaultTableModel) turmasTable.getModel();
        modelTable.setRowCount(0);
        this.pegarTurmas();
        if (this.turmas != null) {
            this.preencherBox();
            this.preencherTable();
            if (!this.detalhesButton.isEnabled()) {
                this.detalhesButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_atualizarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alunoLabel;
    private javax.swing.JButton atualizarButton;
    private javax.swing.JButton detalhesButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> turmasBox;
    private javax.swing.JButton turmasDispButton;
    private javax.swing.JTable turmasTable;
    // End of variables declaration//GEN-END:variables
}
