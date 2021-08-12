/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import universidade.Sistema;
import universidade.Controlador;

/**
 *
 * @author Pedro Henrique Zago Costa - R.A.: 181257084
 * 
 * NovoDepartamento.java -> Este JDialog é responsável pelas entradas de dados
 * que representam as informações de um novo Departamento a ser cadastrado.
 */
public class NovoDepartamento extends javax.swing.JDialog {

    /**
     * Creates new form NovoDepartamento
     */
    public NovoDepartamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        NovoDepartamento_Criar.setEnabled(false);
        this.setTitle("Novo Departamento");
    }

    NovoDepartamento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NovoDepartamento_Titulo = new javax.swing.JLabel();
        NovoDepartamento_Descricao = new javax.swing.JLabel();
        NovoDepartamento_Inserir_Codigo = new javax.swing.JLabel();
        NovoDepartamento_Inserir_Nome = new javax.swing.JLabel();
        NovoDepartamento_codigo_in = new javax.swing.JTextField();
        NovoDepartamento_nome_in = new javax.swing.JTextField();
        NovoDepartamento_Criar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        NovoDepartamento_Titulo.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        NovoDepartamento_Titulo.setText("Novo Departamento");

        NovoDepartamento_Descricao.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        NovoDepartamento_Descricao.setForeground(new java.awt.Color(153, 0, 0));
        NovoDepartamento_Descricao.setText("Inserir novo Departamento no Sistema:");

        NovoDepartamento_Inserir_Codigo.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        NovoDepartamento_Inserir_Codigo.setText("Inserir o código do Departamento:");

        NovoDepartamento_Inserir_Nome.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        NovoDepartamento_Inserir_Nome.setText("Inserir o nome do Departamento:");

        NovoDepartamento_codigo_in.setBackground(new java.awt.Color(255, 204, 204));
        NovoDepartamento_codigo_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NovoDepartamento_codigo_inKeyPressed(evt);
            }
        });

        NovoDepartamento_nome_in.setBackground(new java.awt.Color(255, 204, 204));
        NovoDepartamento_nome_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NovoDepartamento_nome_inKeyPressed(evt);
            }
        });

        NovoDepartamento_Criar.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        NovoDepartamento_Criar.setText("Criar");
        NovoDepartamento_Criar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NovoDepartamento_CriarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NovoDepartamento_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NovoDepartamento_Descricao)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NovoDepartamento_Inserir_Codigo)
                            .addComponent(NovoDepartamento_Inserir_Nome))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NovoDepartamento_codigo_in, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NovoDepartamento_nome_in, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NovoDepartamento_Criar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NovoDepartamento_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NovoDepartamento_Descricao)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NovoDepartamento_Inserir_Codigo)
                    .addComponent(NovoDepartamento_codigo_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NovoDepartamento_Inserir_Nome)
                    .addComponent(NovoDepartamento_nome_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(NovoDepartamento_Criar)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NovoDepartamento_CriarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NovoDepartamento_CriarMouseClicked
        if (NovoDepartamento_Criar.isEnabled()) {
            String codigo = NovoDepartamento_codigo_in.getText();
            String nome = NovoDepartamento_nome_in.getText();
            Sistema s17 = Sistema.getInstance();
            int aux1 = 0;
            String aux2;
            while (aux1 < s17.maxDepart) {
                aux2 = s17.departamentos[aux1].getCodigo();
                if (aux2.equals(codigo)) {
                    new Mensagem06(null, true).setVisible(true);
                    dispose();
                    return;
                }
                aux1++;
            }
            Controlador control = new Controlador();
            control.inserirDepartamento(codigo, nome);
            new Mensagem14(null, true).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_NovoDepartamento_CriarMouseClicked

    private void NovoDepartamento_codigo_inKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NovoDepartamento_codigo_inKeyPressed
        if (!"".equals(NovoDepartamento_codigo_in.getText())) {
            if (!"".equals(NovoDepartamento_nome_in.getText())) {
                NovoDepartamento_Criar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_NovoDepartamento_codigo_inKeyPressed

    private void NovoDepartamento_nome_inKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NovoDepartamento_nome_inKeyPressed
        if (!"".equals(NovoDepartamento_codigo_in.getText())) {
            if (!"".equals(NovoDepartamento_nome_in.getText())) {
                NovoDepartamento_Criar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_NovoDepartamento_nome_inKeyPressed

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
            java.util.logging.Logger.getLogger(NovoDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoDepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NovoDepartamento dialog = new NovoDepartamento(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton NovoDepartamento_Criar;
    private javax.swing.JLabel NovoDepartamento_Descricao;
    private javax.swing.JLabel NovoDepartamento_Inserir_Codigo;
    private javax.swing.JLabel NovoDepartamento_Inserir_Nome;
    private javax.swing.JLabel NovoDepartamento_Titulo;
    private javax.swing.JTextField NovoDepartamento_codigo_in;
    private javax.swing.JTextField NovoDepartamento_nome_in;
    // End of variables declaration//GEN-END:variables
}
