/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import universidade.Controlador;

/**
 *
 * @author Pedro Henrique Zago Costa - R.A.: 181257084
 * 
 * NomeUniversidade.java -> Este JDialog é responsável pela entrada do nome da
 * Universidade.
 */
public class NomeUniversidade extends javax.swing.JDialog {

    /**
     * Creates new form NomeUniversidade
     */
    public NomeUniversidade(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        NomeUniversidade_Inserir.setEnabled(false);
        this.setTitle("Nome da Universidade");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NomeUniversidade_Titulo = new javax.swing.JLabel();
        NomeUniversidade_Descricao = new javax.swing.JLabel();
        NomeUniversidade_Inserir_nome = new javax.swing.JLabel();
        NomeUniversidade_nome_in = new javax.swing.JTextField();
        NomeUniversidade_Inserir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        NomeUniversidade_Titulo.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        NomeUniversidade_Titulo.setText("Nome da Universidade");

        NomeUniversidade_Descricao.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        NomeUniversidade_Descricao.setText("Insira o nome da Universidade:");

        NomeUniversidade_Inserir_nome.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        NomeUniversidade_Inserir_nome.setText("Inserir nome:");

        NomeUniversidade_nome_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NomeUniversidade_nome_inKeyPressed(evt);
            }
        });

        NomeUniversidade_Inserir.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        NomeUniversidade_Inserir.setText("Inserir");
        NomeUniversidade_Inserir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NomeUniversidade_InserirMouseClicked(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NomeUniversidade_Inserir_nome)
                                .addGap(18, 18, 18)
                                .addComponent(NomeUniversidade_nome_in, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(NomeUniversidade_Descricao)
                            .addComponent(NomeUniversidade_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(NomeUniversidade_Inserir)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NomeUniversidade_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NomeUniversidade_Descricao)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeUniversidade_Inserir_nome)
                    .addComponent(NomeUniversidade_nome_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(NomeUniversidade_Inserir)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NomeUniversidade_InserirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NomeUniversidade_InserirMouseClicked
        if (NomeUniversidade_nome_in.isEnabled()) {
            Controlador control = new Controlador();
            String nome = NomeUniversidade_nome_in.getText();
            control.nomeUniversidade(nome);
            new MenuPrincipal().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_NomeUniversidade_InserirMouseClicked

    private void NomeUniversidade_nome_inKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomeUniversidade_nome_inKeyPressed
        if (!"".equals(NomeUniversidade_nome_in.getText())) {NomeUniversidade_Inserir.setEnabled(true);}
    }//GEN-LAST:event_NomeUniversidade_nome_inKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NomeUniversidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NomeUniversidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NomeUniversidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NomeUniversidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NomeUniversidade dialog = new NomeUniversidade(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NomeUniversidade_Descricao;
    private javax.swing.JButton NomeUniversidade_Inserir;
    private javax.swing.JLabel NomeUniversidade_Inserir_nome;
    private javax.swing.JLabel NomeUniversidade_Titulo;
    private javax.swing.JTextField NomeUniversidade_nome_in;
    // End of variables declaration//GEN-END:variables
}
