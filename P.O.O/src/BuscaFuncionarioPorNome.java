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
 * BuscaFuncionarioPorNome.java -> Este JDialog é responsável por receber a en-
 * trada que representa o nome do Funcionário a ser buscado.
 */
public class BuscaFuncionarioPorNome extends javax.swing.JDialog {

    /**
     * Creates new form BuscaFuncionarioPorNome
     */
    public BuscaFuncionarioPorNome(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        BuscarFuncionarioPorNome_Buscar.setEnabled(false);
        this.setTitle("Busca de Funcionários por Nome");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BuscarFuncionarioPorNome_Titulo = new javax.swing.JLabel();
        BuscarFuncionarioPorNome_Descricao = new javax.swing.JLabel();
        BuscarFuncionarioPorNome_Inserir_nome = new javax.swing.JLabel();
        BuscarFuncionarioPorNome_nome_in = new javax.swing.JTextField();
        BuscarFuncionarioPorNome_Buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        BuscarFuncionarioPorNome_Titulo.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        BuscarFuncionarioPorNome_Titulo.setText("Busca de Funcionário por Nome");

        BuscarFuncionarioPorNome_Descricao.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        BuscarFuncionarioPorNome_Descricao.setForeground(new java.awt.Color(0, 0, 153));
        BuscarFuncionarioPorNome_Descricao.setText("Exibirá os dados de um funcionário a partir de seu nome (caso exista):");

        BuscarFuncionarioPorNome_Inserir_nome.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        BuscarFuncionarioPorNome_Inserir_nome.setText("Inserir nome:");

        BuscarFuncionarioPorNome_nome_in.setBackground(new java.awt.Color(204, 204, 255));
        BuscarFuncionarioPorNome_nome_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BuscarFuncionarioPorNome_nome_inKeyPressed(evt);
            }
        });

        BuscarFuncionarioPorNome_Buscar.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        BuscarFuncionarioPorNome_Buscar.setText("Buscar");
        BuscarFuncionarioPorNome_Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarFuncionarioPorNome_BuscarMouseClicked(evt);
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
                                .addComponent(BuscarFuncionarioPorNome_Inserir_nome)
                                .addGap(18, 18, 18)
                                .addComponent(BuscarFuncionarioPorNome_nome_in, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BuscarFuncionarioPorNome_Descricao)
                            .addComponent(BuscarFuncionarioPorNome_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(BuscarFuncionarioPorNome_Buscar)))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BuscarFuncionarioPorNome_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BuscarFuncionarioPorNome_Descricao)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscarFuncionarioPorNome_Inserir_nome)
                    .addComponent(BuscarFuncionarioPorNome_nome_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BuscarFuncionarioPorNome_Buscar)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarFuncionarioPorNome_BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarFuncionarioPorNome_BuscarMouseClicked
        if (BuscarFuncionarioPorNome_Buscar.isEnabled()) {
            String nome = BuscarFuncionarioPorNome_nome_in.getText();
            Controlador control = new Controlador();
            Relatorio relatorio12 = new Relatorio(null, true);
            String aux = control.buscaFuncionarios(2, nome);
            relatorio12.exibir(aux);
            dispose();
        }
    }//GEN-LAST:event_BuscarFuncionarioPorNome_BuscarMouseClicked

    private void BuscarFuncionarioPorNome_nome_inKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscarFuncionarioPorNome_nome_inKeyPressed
        if (!"".equals(BuscarFuncionarioPorNome_nome_in.getText())) {
            BuscarFuncionarioPorNome_Buscar.setEnabled(true);
        }
    }//GEN-LAST:event_BuscarFuncionarioPorNome_nome_inKeyPressed

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
            java.util.logging.Logger.getLogger(BuscaFuncionarioPorNome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaFuncionarioPorNome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaFuncionarioPorNome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaFuncionarioPorNome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                BuscaFuncionarioPorNome dialog = new BuscaFuncionarioPorNome(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BuscarFuncionarioPorNome_Buscar;
    private javax.swing.JLabel BuscarFuncionarioPorNome_Descricao;
    private javax.swing.JLabel BuscarFuncionarioPorNome_Inserir_nome;
    private javax.swing.JLabel BuscarFuncionarioPorNome_Titulo;
    private javax.swing.JTextField BuscarFuncionarioPorNome_nome_in;
    // End of variables declaration//GEN-END:variables
}