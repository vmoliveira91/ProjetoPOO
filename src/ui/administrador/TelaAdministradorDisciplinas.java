package ui.administrador;

import negocios.Fachada;

public class TelaAdministradorDisciplinas extends javax.swing.JFrame {

    private final Fachada fachada;

    public TelaAdministradorDisciplinas(Fachada fachada) {
        initComponents();
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        this.fachada = fachada;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadastarButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        listarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cadastarButton.setText("Cadastrar");
        cadastarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastarButtonActionPerformed(evt);
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
        jLabel1.setText("Disciplinas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consultarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cadastarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultarButton)
                .addGap(5, 5, 5)
                .addComponent(listarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removerButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastarButtonActionPerformed
        TelaAdministradorDisciplinasCadastrar cadastrar = new TelaAdministradorDisciplinasCadastrar(this.fachada);
        cadastrar.setVisible(true);
        cadastrar.setResizable(false);
    }//GEN-LAST:event_cadastarButtonActionPerformed

    private void consultarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarButtonActionPerformed
        TelaAdministradorDisciplinasConsultar consultar = new TelaAdministradorDisciplinasConsultar(this.fachada);
        consultar.setVisible(true);
        consultar.setResizable(false);
    }//GEN-LAST:event_consultarButtonActionPerformed

    private void listarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarButtonActionPerformed
        TelaAdministradorDisciplinasListar listar = new TelaAdministradorDisciplinasListar(this.fachada);
        listar.setVisible(true);
        listar.setResizable(false);
    }//GEN-LAST:event_listarButtonActionPerformed

    private void removerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerButtonActionPerformed
        TelaAdministradorDisciplinasRemover remover = new TelaAdministradorDisciplinasRemover(this.fachada);
        remover.setVisible(true);
        remover.setResizable(false);
    }//GEN-LAST:event_removerButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastarButton;
    private javax.swing.JButton consultarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton listarButton;
    private javax.swing.JButton removerButton;
    // End of variables declaration//GEN-END:variables
}
