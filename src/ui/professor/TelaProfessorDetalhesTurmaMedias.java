package ui.professor;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import negocios.entidades.RendimentoEscolar;

public class TelaProfessorDetalhesTurmaMedias extends javax.swing.JFrame {
    
    private final ArrayList<RendimentoEscolar> rendimentos;
    
    public TelaProfessorDetalhesTurmaMedias(ArrayList<RendimentoEscolar> rendimentos) {
        initComponents();
        this.rendimentos = rendimentos;
        this.preencher();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void preencher() {
        DefaultTableModel model = (DefaultTableModel) mediasTable.getModel();
        Object rowData[] = new Object[4];
        int quantAprovado = 0, quantFinal = 0, quantReprovado = 0;
        
        for(int i = 0; i < this.rendimentos.size(); i++) {
            rowData[0] = this.rendimentos.get(i).getAluno().getNome();
            float[] notaTrabalhos = this.rendimentos.get(i).getNotaTrabalhos();
            float nota1 = (float) (this.rendimentos.get(i).getNota1() + (float) ((notaTrabalhos[0] + notaTrabalhos[1])/2.0)*(0.1));
            float nota2 = (float) (this.rendimentos.get(i).getNota2() + (float) ((notaTrabalhos[2] + notaTrabalhos[3])/2.0)*(0.1));
            nota1 = nota1 > 10 ? 10 : nota1;
            nota2 = nota2 > 10 ? 10 : nota2;
            float media = (nota1 + nota2)/2;
            rowData[1] = media;
            if(media >= 7) {
                rowData[2] = "-";
                rowData[3] = "APROVADO";
                quantAprovado++;
            } else if(media >= 3) {
                rowData[2] = 10 - media;
                rowData[3] = "FINAL";
                quantFinal++;
            } else {
                rowData[2] = 10 - media;
                rowData[3] = "REPROVADO";
                quantReprovado++;
            }
            model.addRow(rowData);
        }
        
        float porcAprovado = (100 * quantAprovado / this.rendimentos.size());
        float porcFinal = (100 * quantFinal / this.rendimentos.size());
        float porcReprovado = (100 * quantReprovado / this.rendimentos.size());
        this.aprovadoField.setText(quantAprovado + "(" + porcAprovado + "%)");
        this.aprovadoField.setEditable(false);
        this.finalField.setText(quantFinal + "(" + porcFinal + "%)");
        this.finalField.setEditable(false);
        this.reprovadoField.setText(quantReprovado + "(" + porcReprovado + "%)");
        this.reprovadoField.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mediasTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        aprovadoField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        finalField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        reprovadoField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Média dos alunos");

        mediasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aluno", "Média", "Nota necessária", "Situação"
            }
        ));
        jScrollPane1.setViewportView(mediasTable);
        if (mediasTable.getColumnModel().getColumnCount() > 0) {
            mediasTable.getColumnModel().getColumn(0).setResizable(false);
            mediasTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            mediasTable.getColumnModel().getColumn(1).setResizable(false);
            mediasTable.getColumnModel().getColumn(1).setPreferredWidth(40);
            mediasTable.getColumnModel().getColumn(2).setResizable(false);
            mediasTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            mediasTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Aprovados:");

        jLabel3.setText("Final:");

        jLabel4.setText("Reprovados:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 197, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aprovadoField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(finalField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reprovadoField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(aprovadoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(finalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(reprovadoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aprovadoField;
    private javax.swing.JTextField finalField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mediasTable;
    private javax.swing.JTextField reprovadoField;
    // End of variables declaration//GEN-END:variables
}
