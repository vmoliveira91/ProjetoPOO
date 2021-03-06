package ui.administrador;

import negocios.Fachada;

public class TelaAdministradorTurmas extends javax.swing.JFrame {

    private final Fachada fachada;

    public TelaAdministradorTurmas(Fachada fachada) {
        initComponents();
        this.fachada = fachada;
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadastrarButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        listarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cadastrarButton.setText("Cadastrar");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarButtonActionPerformed(evt);
            }
        });

        listarButton.setText("Listar");
        listarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarButtonActionPerformed(evt);
            }
        });

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Turmas");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(consultarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cadastrarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removerButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerButtonActionPerformed
        TelaAdministradorTurmasRemover remover = new TelaAdministradorTurmasRemover(this.fachada);
    }//GEN-LAST:event_removerButtonActionPerformed

    private void listarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarButtonActionPerformed
        TelaAdministradorTurmasListar listar = new TelaAdministradorTurmasListar(this.fachada);
    }//GEN-LAST:event_listarButtonActionPerformed

    private void consultarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarButtonActionPerformed
        TelaAdministradorTurmasConsultar consultar = new TelaAdministradorTurmasConsultar(this.fachada);
    }//GEN-LAST:event_consultarButtonActionPerformed

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        TelaAdministradorTurmasCadastrar cadastrar = new TelaAdministradorTurmasCadastrar(this.fachada);
    }//GEN-LAST:event_cadastrarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JButton consultarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton listarButton;
    private javax.swing.JButton removerButton;
    // End of variables declaration//GEN-END:variables
}
