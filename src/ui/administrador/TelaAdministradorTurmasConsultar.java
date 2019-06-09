package ui.administrador;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import negocios.Fachada;
import negocios.entidades.Turma;
import negocios.excecoes.SemTurmaCadastradaException;

public class TelaAdministradorTurmasConsultar extends javax.swing.JFrame {

    private final Fachada fachada;
    private ArrayList<Turma> turmas;

    public TelaAdministradorTurmasConsultar(Fachada fachada) {
        initComponents();
        this.fachada = fachada;
        try {
            this.turmas = this.fachada.listarTurmas();
            preencherBox();
            setVisible(true);
            setResizable(false);
        } catch (SemTurmaCadastradaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void preencherBox() {
        String[] disciplinasString = new String[this.turmas.size()];
        for (int i = 0; i < disciplinasString.length; i++) {
            disciplinasString[i] = this.turmas.get(i).getId() + " - " + this.turmas.get(i).getDisciplina().getNome();
            if(this.turmas.get(i).getProfessor().getNome() != null)
                disciplinasString[i] += " - " + this.turmas.get(i).getProfessor().getNome();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(disciplinasString);
        this.turmasBox.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        turmasBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Consultar Turma");

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(189, 189, 189))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(turmasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(turmasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String disciplinaSelecionada = this.turmasBox.getSelectedItem().toString();
        Turma turmaa = null;
        int turmaId = Integer.parseInt(disciplinaSelecionada.split(" ")[0]);
        for (int i = 0; i < this.turmas.size(); i++) {
            if (this.turmas.get(i).getId() == turmaId) {
                turmaa = this.turmas.get(i);
                break;
            }
        }
        TelaAdministradorTurmasConsultarResultados resultado = new TelaAdministradorTurmasConsultarResultados(this.fachada, turmaa);
        resultado.setVisible(true);
        resultado.setResizable(false);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> turmasBox;
    // End of variables declaration//GEN-END:variables
}
