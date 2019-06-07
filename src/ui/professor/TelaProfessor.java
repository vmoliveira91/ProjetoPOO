package ui.professor;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.Fachada;
import negocios.entidades.Professor;
import negocios.entidades.Turma;
import negocios.excecoes.SemTurmaCadastradaException;

public class TelaProfessor extends javax.swing.JFrame {

    private final Professor professor;
    private final Fachada fachada;
    private ArrayList<Turma> turmas;

    public TelaProfessor(Professor professor, Fachada fachada) {
        initComponents();
        setLocationRelativeTo(null);
        this.professor = professor;
        this.fachada = fachada;
        this.professorField.setText("Bem vindo,"+ this.professor.getNome());
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
        professorField = new javax.swing.JLabel();
        turmasBox = new javax.swing.JComboBox<>();
        detalhesButton = new javax.swing.JButton();
        turmasDispButton = new javax.swing.JButton();
        atualizarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        turmasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Disciplina"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        turmasTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(turmasTable);
        if (turmasTable.getColumnModel().getColumnCount() > 0) {
            turmasTable.getColumnModel().getColumn(0).setResizable(false);
            turmasTable.getColumnModel().getColumn(1).setResizable(false);
        }

        professorField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        professorField.setText("Professor");

        detalhesButton.setText("Ver detalhes");
        detalhesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalhesButtonActionPerformed(evt);
            }
        });

        turmasDispButton.setText("Ver turmas disponíveis");
        turmasDispButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turmasDispButtonActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(professorField))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(atualizarButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(turmasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(detalhesButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(turmasDispButton)))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(professorField)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(atualizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(turmasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detalhesButton)
                    .addComponent(turmasDispButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pegarTurmas() {
        try {
            this.turmas = this.fachada.exibirTurmasProfessor(this.professor.getId());
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
        Object rowData[] = new Object[2];
        for (int i = 0; i < this.turmas.size(); i++) {
            rowData[0] = this.turmas.get(i).getId();
            rowData[1] = this.turmas.get(i).getDisciplina().getNome();
            model.addRow(rowData);
        }
    }

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
        TelaProfessorDetalhesTurma detalhes = new TelaProfessorDetalhesTurma(turma, fachada);
        detalhes.setVisible(true);
        detalhes.setResizable(false);
    }//GEN-LAST:event_detalhesButtonActionPerformed

    private void turmasDispButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turmasDispButtonActionPerformed
        TelaProfessorTurmasDisponiveis disponiveis = new TelaProfessorTurmasDisponiveis(professor, fachada);
        disponiveis.setVisible(true);
        disponiveis.setResizable(false);
    }//GEN-LAST:event_turmasDispButtonActionPerformed

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
    private javax.swing.JButton atualizarButton;
    private javax.swing.JButton detalhesButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel professorField;
    private javax.swing.JComboBox<String> turmasBox;
    private javax.swing.JButton turmasDispButton;
    private javax.swing.JTable turmasTable;
    // End of variables declaration//GEN-END:variables
}
