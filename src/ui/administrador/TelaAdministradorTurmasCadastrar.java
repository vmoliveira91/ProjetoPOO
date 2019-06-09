package ui.administrador;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import negocios.Fachada;
import negocios.entidades.Disciplina;
import negocios.entidades.Turma;
import negocios.excecoes.SemDisciplinaCadastradaException;
import negocios.excecoes.CapacidadeInvalidaException;

public class TelaAdministradorTurmasCadastrar extends javax.swing.JFrame {

    private final Fachada fachada;
    private ArrayList<Disciplina> disciplinas;

    public TelaAdministradorTurmasCadastrar(Fachada fachada) {
        initComponents();
        this.fachada = fachada;
        try {
            this.disciplinas = this.fachada.listarDisciplinas();
            this.preencherBox();
            setVisible(true);
            setResizable(false);
        } catch (SemDisciplinaCadastradaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void preencherBox() {
        String[] disciplinasString = new String[this.disciplinas.size()];
        for (int i = 0; i < disciplinasString.length; i++) {
            disciplinasString[i] = this.disciplinas.get(i).getId() + " - " + this.disciplinas.get(i).getNome();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(disciplinasString);
        this.disciplinasBox.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField6 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cadastrarButton = new javax.swing.JButton();
        capField = new javax.swing.JTextField();
        disciplinasBox = new javax.swing.JComboBox<>();

        jTextField6.setText("jTextField6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Cadastrar Turma");

        jLabel3.setText("Disciplina:");

        jLabel5.setText("Capacidade da turma:");

        cadastrarButton.setText("Cadastrar");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
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
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disciplinasBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(capField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel1)))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(cadastrarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(disciplinasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(capField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cadastrarButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        String disciplinaSelecionada = this.disciplinasBox.getSelectedItem().toString();
        Disciplina disc = null;
        int disciplinaId = Integer.parseInt(disciplinaSelecionada.split(" ")[0]);
        for (int i = 0; i < this.disciplinas.size(); i++) {
            if (this.disciplinas.get(i).getId() == disciplinaId) {
                disc = this.disciplinas.get(i);
                break;
            }
        }
        
        try {
            Turma turma = new Turma(0,disc,null,(Integer.parseInt(capField.getText())),null);
            if (this.fachada.cadastrarTurma(turma)) {
                JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso!");
            }
        } catch (CapacidadeInvalidaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch(NumberFormatException e2) {
            JOptionPane.showMessageDialog(null, "Capacidade de alunos na turma inválida!");
        }
    }//GEN-LAST:event_cadastrarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JTextField capField;
    private javax.swing.JComboBox<String> disciplinasBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
