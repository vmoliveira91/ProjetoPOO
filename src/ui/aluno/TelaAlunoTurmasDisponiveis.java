package ui.aluno;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.Fachada;
import negocios.entidades.Aluno;
import negocios.entidades.Turma;
import negocios.excecoes.SemTurmaCadastradaException;
import negocios.excecoes.TurmaLotadaException;

public class TelaAlunoTurmasDisponiveis extends javax.swing.JFrame {
    
    private final Fachada fachada;
    private final Aluno aluno;
    private ArrayList<Turma> turmas;
    
    public TelaAlunoTurmasDisponiveis(Aluno aluno, Fachada fachada) {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.aluno = aluno;
        this.fachada = fachada;
        this.pegarTurmas();
        if(this.turmas != null) {
            this.preencherBox();
            this.preencherTable();
        } else {
            this.matricularButton.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        turmasTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        matricularButton = new javax.swing.JButton();
        turmasBox = new javax.swing.JComboBox<>();

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
        jScrollPane1.setViewportView(turmasTable);
        if (turmasTable.getColumnModel().getColumnCount() > 0) {
            turmasTable.getColumnModel().getColumn(0).setResizable(false);
            turmasTable.getColumnModel().getColumn(1).setResizable(false);
            turmasTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Turmas Disponíveis");

        matricularButton.setText("Matricular");
        matricularButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matricularButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(turmasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(matricularButton)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matricularButton)
                    .addComponent(turmasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void pegarTurmas() {
        try {
            this.turmas = this.fachada.exibirListagemTurmasDisponiveisAluno(this.aluno.getId());
        } catch(SemTurmaCadastradaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void preencherBox() {
        String[] turmasString = new String[this.turmas.size()];
        for(int i = 0; i < this.turmas.size(); i++) {
            turmasString[i] = this.turmas.get(i).toString();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(turmasString);
        this.turmasBox.setModel(model);
    }
    
    private void preencherTable() {
        DefaultTableModel model = (DefaultTableModel) turmasTable.getModel();
        Object rowData[] = new Object[3];
        for(int i = 0; i < this.turmas.size(); i++) {
            rowData[0] = this.turmas.get(i).getId();
            rowData[1] = this.turmas.get(i).getDisciplina().getNome();
            rowData[2] = this.turmas.get(i).getProfessor().getNome();
            model.addRow(rowData);
        }
    }
    
    private void matricularButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matricularButtonActionPerformed
        String turma = this.turmasBox.getSelectedItem().toString();
        String[] dadosTurma = turma.split(" ");
        int turmaId = Integer.parseInt(dadosTurma[0]);
        int cap = 0;
        for(int i = 0; i < this.turmas.size(); i++) {
            if(this.turmas.get(i).getId() == turmaId) {
                cap = this.turmas.get(i).getCapacidadaDaTurma();
            }
        }
        try {
            this.fachada.associarTurmaAluno(aluno, turmaId, cap);
            JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso!");
            dispose();
        } catch (TurmaLotadaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_matricularButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton matricularButton;
    private javax.swing.JComboBox<String> turmasBox;
    private javax.swing.JTable turmasTable;
    // End of variables declaration//GEN-END:variables
}
