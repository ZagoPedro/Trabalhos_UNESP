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
 * FuncionariosSalarioEspecifico.java -> Este JDialog é responsável por receber
 * as entradas que representam a faixa de valores de salário de Funcionários a
 * serem buscados.
 */
public class FuncionariosSalarioEspecifico extends javax.swing.JDialog {

    /**
     * Creates new form FuncionariosSalarioEspecifico
     */
    public FuncionariosSalarioEspecifico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        FuncionariosSalarioEspecifico_Buscar.setEnabled(false);
        this.setTitle("Funcionários com Faixa de Salário Específica");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FuncionariosSalarioEspecifico_Titulo = new javax.swing.JLabel();
        FuncionariosSalarioEspecifico_Descricao = new javax.swing.JLabel();
        FuncionariosSalarioEspecifico_Inserir_salario_min = new javax.swing.JLabel();
        FuncionariosSalarioEspecifico_Inserir_salario_max = new javax.swing.JLabel();
        FuncionariosSalarioEspecifico_min_in = new javax.swing.JTextField();
        FuncionariosSalarioEspecifico_max_in = new javax.swing.JTextField();
        FuncionariosSalarioEspecifico_Buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        FuncionariosSalarioEspecifico_Titulo.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        FuncionariosSalarioEspecifico_Titulo.setText("Funcionários com Faixas de Salário Específicas");

        FuncionariosSalarioEspecifico_Descricao.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        FuncionariosSalarioEspecifico_Descricao.setForeground(new java.awt.Color(153, 102, 0));
        FuncionariosSalarioEspecifico_Descricao.setText("Apresentará os dados dos funcionários cujos salários estiverem na faixa de valor definida:");

        FuncionariosSalarioEspecifico_Inserir_salario_min.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        FuncionariosSalarioEspecifico_Inserir_salario_min.setText("Inserir o salário mínimo:");

        FuncionariosSalarioEspecifico_Inserir_salario_max.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        FuncionariosSalarioEspecifico_Inserir_salario_max.setText("Inserir o salário máximo:");

        FuncionariosSalarioEspecifico_min_in.setBackground(new java.awt.Color(255, 255, 204));
        FuncionariosSalarioEspecifico_min_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FuncionariosSalarioEspecifico_min_inKeyPressed(evt);
            }
        });

        FuncionariosSalarioEspecifico_max_in.setBackground(new java.awt.Color(255, 255, 204));
        FuncionariosSalarioEspecifico_max_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FuncionariosSalarioEspecifico_max_inKeyPressed(evt);
            }
        });

        FuncionariosSalarioEspecifico_Buscar.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        FuncionariosSalarioEspecifico_Buscar.setText("Buscar");
        FuncionariosSalarioEspecifico_Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FuncionariosSalarioEspecifico_BuscarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FuncionariosSalarioEspecifico_Inserir_salario_min)
                            .addComponent(FuncionariosSalarioEspecifico_Inserir_salario_max))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FuncionariosSalarioEspecifico_min_in, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FuncionariosSalarioEspecifico_max_in, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(FuncionariosSalarioEspecifico_Titulo)
                    .addComponent(FuncionariosSalarioEspecifico_Descricao))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FuncionariosSalarioEspecifico_Buscar)
                .addGap(212, 212, 212))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FuncionariosSalarioEspecifico_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FuncionariosSalarioEspecifico_Descricao)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FuncionariosSalarioEspecifico_Inserir_salario_min)
                    .addComponent(FuncionariosSalarioEspecifico_min_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FuncionariosSalarioEspecifico_Inserir_salario_max)
                    .addComponent(FuncionariosSalarioEspecifico_max_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(FuncionariosSalarioEspecifico_Buscar)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FuncionariosSalarioEspecifico_BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FuncionariosSalarioEspecifico_BuscarMouseClicked
        if (FuncionariosSalarioEspecifico_Buscar.isEnabled()) {
            float min = Float.parseFloat(FuncionariosSalarioEspecifico_min_in.getText());
            float max = Float.parseFloat(FuncionariosSalarioEspecifico_max_in.getText());
            if (min > max) {
                new Mensagem16(null, true).setVisible(true);
                dispose();
                return;
            }
            Controlador control = new Controlador();
            Relatorio relatorio4 = new Relatorio(null, true);
            String aux = control.funcionariosSalario(min, max);
            relatorio4.exibir(aux);
            dispose();
        }
    }//GEN-LAST:event_FuncionariosSalarioEspecifico_BuscarMouseClicked

    private void FuncionariosSalarioEspecifico_min_inKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FuncionariosSalarioEspecifico_min_inKeyPressed
        if (!"".equals(FuncionariosSalarioEspecifico_max_in.getText())) {
            if (!"".equals(FuncionariosSalarioEspecifico_min_in.getText())) {
                FuncionariosSalarioEspecifico_Buscar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_FuncionariosSalarioEspecifico_min_inKeyPressed

    private void FuncionariosSalarioEspecifico_max_inKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FuncionariosSalarioEspecifico_max_inKeyPressed
        if (!"".equals(FuncionariosSalarioEspecifico_max_in.getText())) {
            if (!"".equals(FuncionariosSalarioEspecifico_min_in.getText())) {
                FuncionariosSalarioEspecifico_Buscar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_FuncionariosSalarioEspecifico_max_inKeyPressed

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
            java.util.logging.Logger.getLogger(FuncionariosSalarioEspecifico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionariosSalarioEspecifico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionariosSalarioEspecifico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionariosSalarioEspecifico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FuncionariosSalarioEspecifico dialog = new FuncionariosSalarioEspecifico(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton FuncionariosSalarioEspecifico_Buscar;
    private javax.swing.JLabel FuncionariosSalarioEspecifico_Descricao;
    private javax.swing.JLabel FuncionariosSalarioEspecifico_Inserir_salario_max;
    private javax.swing.JLabel FuncionariosSalarioEspecifico_Inserir_salario_min;
    private javax.swing.JLabel FuncionariosSalarioEspecifico_Titulo;
    private javax.swing.JTextField FuncionariosSalarioEspecifico_max_in;
    private javax.swing.JTextField FuncionariosSalarioEspecifico_min_in;
    // End of variables declaration//GEN-END:variables
}
