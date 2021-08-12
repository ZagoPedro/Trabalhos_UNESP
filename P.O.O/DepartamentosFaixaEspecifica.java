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
 * DepartamentoFaixaEspecifica.java -> Este JDialog é responsável por receber
 * as entradas que representam a faixa de valores de gastos de Departamentos a
 * serem buscados.
 */
public class DepartamentosFaixaEspecifica extends javax.swing.JDialog {

    /**
     * Creates new form DepartamentosFaixaEspecifica
     */
    public DepartamentosFaixaEspecifica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        DepartamentosFaixaEspecifica_Buscar.setEnabled(false);
        this.setTitle("Departamentos com Faixa de Gastos Específica");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DepartamentosFaixaEspecifica_Titulo = new javax.swing.JLabel();
        DepartamentosFaixaEspecifica_Descricao = new javax.swing.JLabel();
        DepartamentosFaixaEspecifica_Inserir_valor_min = new javax.swing.JLabel();
        DepartamentosFaixaEspecifica_Inserir_valor_max = new javax.swing.JLabel();
        DepartamentosFaixaEspecifica_min_in = new javax.swing.JTextField();
        DepartamentosFaixaEspecifica_max_in = new javax.swing.JTextField();
        DepartamentosFaixaEspecifica_Buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        DepartamentosFaixaEspecifica_Titulo.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        DepartamentosFaixaEspecifica_Titulo.setText("Departamentos com Faixas de Gastos Específicas");

        DepartamentosFaixaEspecifica_Descricao.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        DepartamentosFaixaEspecifica_Descricao.setForeground(new java.awt.Color(153, 102, 0));
        DepartamentosFaixaEspecifica_Descricao.setText("Apresentará um resumo do departamento se o gasto total com funcionários estiver na faixa definida:");

        DepartamentosFaixaEspecifica_Inserir_valor_min.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        DepartamentosFaixaEspecifica_Inserir_valor_min.setText("Inserir o valor mínimo de gastos:");

        DepartamentosFaixaEspecifica_Inserir_valor_max.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        DepartamentosFaixaEspecifica_Inserir_valor_max.setText("Inserir o valor máximo de gastos:");

        DepartamentosFaixaEspecifica_min_in.setBackground(new java.awt.Color(255, 255, 204));
        DepartamentosFaixaEspecifica_min_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DepartamentosFaixaEspecifica_min_inKeyPressed(evt);
            }
        });

        DepartamentosFaixaEspecifica_max_in.setBackground(new java.awt.Color(255, 255, 204));
        DepartamentosFaixaEspecifica_max_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DepartamentosFaixaEspecifica_max_inKeyPressed(evt);
            }
        });

        DepartamentosFaixaEspecifica_Buscar.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        DepartamentosFaixaEspecifica_Buscar.setText("Buscar");
        DepartamentosFaixaEspecifica_Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DepartamentosFaixaEspecifica_BuscarMouseClicked(evt);
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
                            .addComponent(DepartamentosFaixaEspecifica_Inserir_valor_min)
                            .addComponent(DepartamentosFaixaEspecifica_Inserir_valor_max))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DepartamentosFaixaEspecifica_min_in, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DepartamentosFaixaEspecifica_max_in, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(DepartamentosFaixaEspecifica_Descricao)
                    .addComponent(DepartamentosFaixaEspecifica_Titulo))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DepartamentosFaixaEspecifica_Buscar)
                .addGap(212, 212, 212))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DepartamentosFaixaEspecifica_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DepartamentosFaixaEspecifica_Descricao)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DepartamentosFaixaEspecifica_Inserir_valor_min)
                    .addComponent(DepartamentosFaixaEspecifica_min_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DepartamentosFaixaEspecifica_Inserir_valor_max)
                    .addComponent(DepartamentosFaixaEspecifica_max_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(DepartamentosFaixaEspecifica_Buscar)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DepartamentosFaixaEspecifica_BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DepartamentosFaixaEspecifica_BuscarMouseClicked
        if (DepartamentosFaixaEspecifica_Buscar.isEnabled()) {
            float min = Float.parseFloat(DepartamentosFaixaEspecifica_min_in.getText());
            float max = Float.parseFloat(DepartamentosFaixaEspecifica_max_in.getText());
            if (min > max) {
                new Mensagem16(null, true).setVisible(true);
                dispose();
                return;
            }
            Controlador control = new Controlador();
            Relatorio relatorio3 = new Relatorio(null, true);
            String aux = control.resumoDepartamentos(2, min, max);
            relatorio3.exibir(aux);
            dispose();
        }
    }//GEN-LAST:event_DepartamentosFaixaEspecifica_BuscarMouseClicked

    private void DepartamentosFaixaEspecifica_min_inKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DepartamentosFaixaEspecifica_min_inKeyPressed
        if (!"".equals(DepartamentosFaixaEspecifica_max_in.getText())) {
            if (!"".equals(DepartamentosFaixaEspecifica_min_in.getText())) {
                DepartamentosFaixaEspecifica_Buscar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_DepartamentosFaixaEspecifica_min_inKeyPressed

    private void DepartamentosFaixaEspecifica_max_inKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DepartamentosFaixaEspecifica_max_inKeyPressed
        if (!"".equals(DepartamentosFaixaEspecifica_max_in.getText())) {
            if (!"".equals(DepartamentosFaixaEspecifica_min_in.getText())) {
                DepartamentosFaixaEspecifica_Buscar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_DepartamentosFaixaEspecifica_max_inKeyPressed

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
            java.util.logging.Logger.getLogger(DepartamentosFaixaEspecifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepartamentosFaixaEspecifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepartamentosFaixaEspecifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepartamentosFaixaEspecifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DepartamentosFaixaEspecifica dialog = new DepartamentosFaixaEspecifica(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton DepartamentosFaixaEspecifica_Buscar;
    private javax.swing.JLabel DepartamentosFaixaEspecifica_Descricao;
    private javax.swing.JLabel DepartamentosFaixaEspecifica_Inserir_valor_max;
    private javax.swing.JLabel DepartamentosFaixaEspecifica_Inserir_valor_min;
    private javax.swing.JLabel DepartamentosFaixaEspecifica_Titulo;
    private javax.swing.JTextField DepartamentosFaixaEspecifica_max_in;
    private javax.swing.JTextField DepartamentosFaixaEspecifica_min_in;
    // End of variables declaration//GEN-END:variables
}
