package ui.professor;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocios.Fachada;
import negocios.entidades.Professor;
import negocios.entidades.Turma;
import negocios.excecoes.SemTurmaCadastradaException;

public class TelaProfessorTurmasDisponiveis extends javax.swing.JFrame {

    private final Fachada fachada;
    private final Professor professor;
    private ArrayList<Turma> turmas;

    public TelaProfessorTurmasDisponiveis(Professor professor, Fachada fachada) {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.professor = professor;
        this.fachada = fachada;
        this.pegarTurmas();
        //if (!this.turmas.isEmpty()) {
        if(this.turmas != null) {
            this.preencherBox();
            this.preencherTable();
        } else {
            this.associarButton.setEnabled(false);
        }
    }

    private void pegarTurmas() {
        try {
            this.turmas = this.fachada.exibirListagemTurmasDisponiveisProfessor(this.professor.getId());
            System.out.println(this.turmas.size());
        } catch (SemTurmaCadastradaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        turmasTable = new javax.swing.JTable();
        turmasBox = new javax.swing.JComboBox<>();
        associarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Turmas disponíveis");

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
        jScrollPane1.setViewportView(turmasTable);
        if (turmasTable.getColumnModel().getColumnCount() > 0) {
            turmasTable.getColumnModel().getColumn(0).setResizable(false);
            turmasTable.getColumnModel().getColumn(1).setResizable(false);
        }

        associarButton.setText("Associar-se a turma");
        associarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                associarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(turmasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(associarButton)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(131, 131, 131))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(turmasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(associarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void associarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_associarButtonActionPerformed
        String turma = this.turmasBox.getSelectedItem().toString();
        String[] dadosTurma = turma.split(" ");
        int turmaId = Integer.parseInt(dadosTurma[0]);
        if (this.fachada.associarTurmaProfessor(professor, turmaId)) {
            JOptionPane.showMessageDialog(null, "Professor associado a turma com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Professor não associado a turma!");
        }
    }//GEN-LAST:event_associarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton associarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> turmasBox;
    private javax.swing.JTable turmasTable;
    // End of variables declaration//GEN-END:variables
}
