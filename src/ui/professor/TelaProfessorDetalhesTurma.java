package ui.professor;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.entidades.*;
import negocios.excecoes.NotaInvalidaException;
import negocios.Fachada;
import negocios.excecoes.SemAlunoMatriculadoException;

public class TelaProfessorDetalhesTurma extends javax.swing.JFrame {

    private final Turma turma;
    private final Fachada fachada;
    private ArrayList<RendimentoEscolar> rendimento;

    public TelaProfessorDetalhesTurma(Turma turma, Fachada fachada) {
        initComponents();
        this.turma = turma;
        this.fachada = fachada;
        this.pegarAlunos();
        this.preencherTable();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    }

    private void pegarAlunos() {
        try {
            this.rendimento = this.fachada.exibirNotasProfessor(this.turma.getId());
        } catch (SemAlunoMatriculadoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            this.salvarButton.setEnabled(false);
            this.mediasButton.setEnabled(false);
        }
    }

    private void preencherTable() {
        DefaultTableModel model = (DefaultTableModel) alunosTable.getModel();
        Object rowData[] = new Object[7];

        if (this.rendimento != null) {
            for (int i = 0; i < rendimento.size(); i++) {
                rowData[0] = rendimento.get(i).getAluno().getNome();
                String[] trabalhos = rendimento.get(i).getTrabalhos();
                float[] notaTrabalhos = rendimento.get(i).getNotaTrabalhos();
                rowData[1] = rendimento.get(i).getNota1();
                rowData[2] = rendimento.get(i).getNota2();
                int cont = 3;
                if (trabalhos != null) {
                    for (int k = 0; k < 4; k++) {
                        if (trabalhos[k] != null) {
                            rowData[cont] = trabalhos[k] + " - " + notaTrabalhos[k];
                        } else {
                            rowData[cont] = "-";
                        }
                        cont++;
                    }
                } else {
                    for (int k = 0; k < 4; k++) {
                        rowData[cont] = "-";
                        cont++;
                    }
                }
                model.addRow(rowData);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alunosTable = new javax.swing.JTable();
        salvarButton = new javax.swing.JButton();
        mediasButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Trabalhos e Notas");

        alunosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aluno", "Nota 1", "Nota 2", "Trabalho 1", "Trabalho 2", "Trabalho 3", "Trabalho 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(alunosTable);
        if (alunosTable.getColumnModel().getColumnCount() > 0) {
            alunosTable.getColumnModel().getColumn(0).setResizable(false);
            alunosTable.getColumnModel().getColumn(1).setResizable(false);
            alunosTable.getColumnModel().getColumn(2).setResizable(false);
        }

        salvarButton.setText("Salvar");
        salvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarButtonActionPerformed(evt);
            }
        });

        mediasButton.setText("Ver médias");
        mediasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediasButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(175, 175, 175))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(salvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mediasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mediasButton)
                    .addComponent(salvarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) alunosTable.getModel();
        //ArrayList<Aluno> alunos = this.turma.getAlunos();
        int quantRow = model.getRowCount();
        String nome, trabalho;
        int cont;
        float nota1, nota2;
        String[] trabalhos = new String[4];
        float[] notaTrabalhos = new float[4];

        for (int i = 0; i < quantRow; i++) {
            nome = model.getValueAt(i, 0).toString();
            nota1 = Float.parseFloat(model.getValueAt(i, 1).toString());
            nota2 = Float.parseFloat(model.getValueAt(i, 2).toString());
            cont = 0;
            for (int j = 3; j < 7; j++) {
                trabalho = model.getValueAt(i, j).toString();
                if (!trabalho.equals("-")) {
                    trabalhos[cont] = trabalho.split("-")[0].trim();
                    notaTrabalhos[cont] = Float.parseFloat(trabalho.split("-")[1].trim());
                }
                cont++;
            }
            try {
                this.fachada.atualizarNotasProfessor(this.turma.getId(), this.rendimento.get(i).getAluno().getId(), nota1, nota2);
                this.fachada.atualizarNotasTrabalhosProfessor(this.turma.getId(), this.rendimento.get(i).getAluno().getId(), notaTrabalhos);
                this.pegarAlunos();
            } catch (NotaInvalidaException e) {
                JOptionPane.showConfirmDialog(null, e.getMessage());
            }
        }
        model.setRowCount(0);
        this.preencherTable();
    }//GEN-LAST:event_salvarButtonActionPerformed

    private void mediasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediasButtonActionPerformed
        TelaProfessorDetalhesTurmaMedias medias = null;
        try {
            medias = new TelaProfessorDetalhesTurmaMedias(this.fachada.exibirNotasProfessor(this.turma.getId()));
        } catch (SemAlunoMatriculadoException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
        medias.setVisible(true);
        medias.setResizable(false);
    }//GEN-LAST:event_mediasButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable alunosTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mediasButton;
    private javax.swing.JButton salvarButton;
    // End of variables declaration//GEN-END:variables
}
