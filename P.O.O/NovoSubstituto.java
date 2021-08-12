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
 * NovoSubstituto.java -> Este JDialog é responsável pelas entradas de dados
 * que representam as informações de um novo Docente Substituto a ser cadastrado
 */
public class NovoSubstituto extends javax.swing.JDialog {

    /**
     * Creates new form NovoSubstituto
     */
    public NovoSubstituto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        NovoSubstituto_Criar.setEnabled(false);
        setTitle("Novo Substituto");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NovoSubstituto_Titulo = new javax.swing.JLabel();
        NovoSubstituto_Descricao = new javax.swing.JLabel();
        NovoSubstituto_Inserir_codigo = new javax.swing.JLabel();
        NovoSubstituto_Inserir_nome = new javax.swing.JLabel();
        NovoSubstituto_Inserir_salario = new javax.swing.JLabel();
        NovoSubstituto_Inserir_nivel = new javax.swing.JLabel();
        NovoSubstituto_Inserir_titulacao = new javax.swing.JLabel();
        NovoSubstituto_Inserir_area = new javax.swing.JLabel();
        NovoSubstituto_codigo_in = new javax.swing.JTextField();
        NovoSubstituto_nome_in = new javax.swing.JTextField();
        NovoSubstituto_salario_in = new javax.swing.JTextField();
        NovoSubstituto_departamento_in = new javax.swing.JTextField();
        NovoSubstituto_nivel_in = new javax.swing.JComboBox<>();
        NovoSubstituto_titulacao_in = new javax.swing.JComboBox<>();
        NovoSubstituto_Criar = new javax.swing.JButton();
        NovoSubstituto_carga_horaria_in = new javax.swing.JComboBox<>();
        NovoSubstituto_Inserir_departamento = new javax.swing.JLabel();
        NovoSubstituto_Aviso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        NovoSubstituto_Titulo.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        NovoSubstituto_Titulo.setText("Novo Docente Substituto");

        NovoSubstituto_Descricao.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        NovoSubstituto_Descricao.setForeground(new java.awt.Color(153, 0, 0));
        NovoSubstituto_Descricao.setText("Inserir novo Docente Substituto no Sistema:");

        NovoSubstituto_Inserir_codigo.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        NovoSubstituto_Inserir_codigo.setText("Inserir o código do Substituto:");

        NovoSubstituto_Inserir_nome.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        NovoSubstituto_Inserir_nome.setText("Inserir o nome do Substituto:");

        NovoSubstituto_Inserir_salario.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        NovoSubstituto_Inserir_salario.setText("Inserir o salário do Substituto:");

        NovoSubstituto_Inserir_nivel.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        NovoSubstituto_Inserir_nivel.setText("Inserir o nível do Substituto:");

        NovoSubstituto_Inserir_titulacao.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        NovoSubstituto_Inserir_titulacao.setText("Inserir a titulação do Substituto:");

        NovoSubstituto_Inserir_area.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        NovoSubstituto_Inserir_area.setText("Inserir a carga horária do Substituto:");

        NovoSubstituto_codigo_in.setBackground(new java.awt.Color(255, 204, 204));
        NovoSubstituto_codigo_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NovoSubstituto_codigo_inKeyPressed(evt);
            }
        });

        NovoSubstituto_nome_in.setBackground(new java.awt.Color(255, 204, 204));
        NovoSubstituto_nome_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NovoSubstituto_nome_inKeyPressed(evt);
            }
        });

        NovoSubstituto_salario_in.setBackground(new java.awt.Color(255, 204, 204));
        NovoSubstituto_salario_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NovoSubstituto_salario_inKeyPressed(evt);
            }
        });

        NovoSubstituto_departamento_in.setBackground(new java.awt.Color(255, 204, 204));
        NovoSubstituto_departamento_in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NovoSubstituto_departamento_inKeyPressed(evt);
            }
        });

        NovoSubstituto_nivel_in.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S1", "S2" }));

        NovoSubstituto_titulacao_in.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Graduação", "Mestrado", "Doutorado", "Livre-Docente", "Titular" }));

        NovoSubstituto_Criar.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        NovoSubstituto_Criar.setText("Criar");
        NovoSubstituto_Criar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NovoSubstituto_CriarMouseClicked(evt);
            }
        });

        NovoSubstituto_carga_horaria_in.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "24" }));

        NovoSubstituto_Inserir_departamento.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        NovoSubstituto_Inserir_departamento.setText("Inserir o departamento do Substituto:");

        NovoSubstituto_Aviso.setFont(new java.awt.Font("Yu Gothic", 0, 10)); // NOI18N
        NovoSubstituto_Aviso.setForeground(new java.awt.Color(102, 102, 102));
        NovoSubstituto_Aviso.setText("obs: O funcionário somente será criado se o departamento for válido (existir).");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NovoSubstituto_Titulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NovoSubstituto_Aviso))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NovoSubstituto_Descricao)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(NovoSubstituto_Inserir_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(NovoSubstituto_codigo_in, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(NovoSubstituto_Inserir_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(NovoSubstituto_nome_in, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(NovoSubstituto_Inserir_area)
                                        .addGap(18, 18, 18)
                                        .addComponent(NovoSubstituto_carga_horaria_in, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(NovoSubstituto_Inserir_salario, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(NovoSubstituto_salario_in, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(NovoSubstituto_Inserir_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NovoSubstituto_nivel_in, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(NovoSubstituto_Inserir_titulacao)
                                .addGap(18, 18, 18)
                                .addComponent(NovoSubstituto_titulacao_in, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NovoSubstituto_Inserir_departamento)
                        .addGap(25, 25, 25)
                        .addComponent(NovoSubstituto_departamento_in, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(NovoSubstituto_Criar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NovoSubstituto_Titulo)
                    .addComponent(NovoSubstituto_Aviso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NovoSubstituto_Descricao)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NovoSubstituto_Inserir_codigo)
                    .addComponent(NovoSubstituto_codigo_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NovoSubstituto_Inserir_nome)
                    .addComponent(NovoSubstituto_nome_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NovoSubstituto_Inserir_salario)
                    .addComponent(NovoSubstituto_salario_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NovoSubstituto_Inserir_nivel)
                    .addComponent(NovoSubstituto_nivel_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NovoSubstituto_Inserir_titulacao)
                    .addComponent(NovoSubstituto_titulacao_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NovoSubstituto_Inserir_area)
                    .addComponent(NovoSubstituto_carga_horaria_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NovoSubstituto_Inserir_departamento)
                    .addComponent(NovoSubstituto_departamento_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NovoSubstituto_Criar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NovoSubstituto_CriarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NovoSubstituto_CriarMouseClicked
        if (NovoSubstituto_Criar.isEnabled()) {
            String codigo = NovoSubstituto_codigo_in.getText();
            String nome = NovoSubstituto_nome_in.getText();
            float salario = Float.parseFloat(NovoSubstituto_salario_in.getText());
            String nivel = (String) NovoSubstituto_nivel_in.getSelectedItem();
            String titulacao = (String) NovoSubstituto_titulacao_in.getSelectedItem();
            String departamento = (String) NovoSubstituto_carga_horaria_in.getSelectedItem();
            int cargahoraria = Integer.parseInt(departamento);
            departamento = NovoSubstituto_departamento_in.getText();
            Sistema s20 = Sistema.getInstance();
            int aux1 = 0;
            String aux2;
            while (aux1 < s20.maxFunc) {
                aux2 = s20.funcionarios[aux1].getCodigo();
                if (aux2.equals(codigo)) {
                    new Mensagem05(null, true).setVisible(true);
                    dispose();
                    return;
                }
                aux1++;
            }
            aux1 = 0;
            while (aux1 < s20.maxDepart) {
                aux2 = s20.departamentos[aux1].getNome();
                if(aux2.equals(departamento)) {
                    Controlador control = new Controlador();
                    control.inserirFuncionario("Docente Substituto", codigo, nome, nivel, titulacao, "", salario, cargahoraria, aux1);
                    new Mensagem13(null, true).setVisible(true);
                    dispose();
                    return;
                }
                aux1++;
            }
            new Mensagem15(null, true).setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_NovoSubstituto_CriarMouseClicked

    private void NovoSubstituto_codigo_inKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NovoSubstituto_codigo_inKeyPressed
        if (!"".equals(NovoSubstituto_codigo_in.getText())) {
            if (!"".equals(NovoSubstituto_nome_in.getText())) {
                if (!"".equals(NovoSubstituto_salario_in.getText())) {
                    if (!"".equals(NovoSubstituto_departamento_in.getText())) {
                        NovoSubstituto_Criar.setEnabled(true);
                    }
                }
            }
        }
    }//GEN-LAST:event_NovoSubstituto_codigo_inKeyPressed

    private void NovoSubstituto_nome_inKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NovoSubstituto_nome_inKeyPressed
        if (!"".equals(NovoSubstituto_codigo_in.getText())) {
            if (!"".equals(NovoSubstituto_nome_in.getText())) {
                if (!"".equals(NovoSubstituto_salario_in.getText())) {
                    if (!"".equals(NovoSubstituto_departamento_in.getText())) {
                        NovoSubstituto_Criar.setEnabled(true);
                    }
                }
            }
        }
    }//GEN-LAST:event_NovoSubstituto_nome_inKeyPressed

    private void NovoSubstituto_salario_inKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NovoSubstituto_salario_inKeyPressed
        if (!"".equals(NovoSubstituto_codigo_in.getText())) {
            if (!"".equals(NovoSubstituto_nome_in.getText())) {
                if (!"".equals(NovoSubstituto_salario_in.getText())) {
                    if (!"".equals(NovoSubstituto_departamento_in.getText())) {
                        NovoSubstituto_Criar.setEnabled(true);
                    }
                }
            }
        }
    }//GEN-LAST:event_NovoSubstituto_salario_inKeyPressed

    private void NovoSubstituto_departamento_inKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NovoSubstituto_departamento_inKeyPressed
        if (!"".equals(NovoSubstituto_codigo_in.getText())) {
            if (!"".equals(NovoSubstituto_nome_in.getText())) {
                if (!"".equals(NovoSubstituto_salario_in.getText())) {
                    if (!"".equals(NovoSubstituto_departamento_in.getText())) {
                        NovoSubstituto_Criar.setEnabled(true);
                    }
                }
            }
        }
    }//GEN-LAST:event_NovoSubstituto_departamento_inKeyPressed

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
            java.util.logging.Logger.getLogger(NovoSubstituto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoSubstituto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoSubstituto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoSubstituto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NovoSubstituto dialog = new NovoSubstituto(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel NovoSubstituto_Aviso;
    private javax.swing.JButton NovoSubstituto_Criar;
    private javax.swing.JLabel NovoSubstituto_Descricao;
    private javax.swing.JLabel NovoSubstituto_Inserir_area;
    private javax.swing.JLabel NovoSubstituto_Inserir_codigo;
    private javax.swing.JLabel NovoSubstituto_Inserir_departamento;
    private javax.swing.JLabel NovoSubstituto_Inserir_nivel;
    private javax.swing.JLabel NovoSubstituto_Inserir_nome;
    private javax.swing.JLabel NovoSubstituto_Inserir_salario;
    private javax.swing.JLabel NovoSubstituto_Inserir_titulacao;
    private javax.swing.JLabel NovoSubstituto_Titulo;
    private javax.swing.JComboBox<String> NovoSubstituto_carga_horaria_in;
    private javax.swing.JTextField NovoSubstituto_codigo_in;
    private javax.swing.JTextField NovoSubstituto_departamento_in;
    private javax.swing.JComboBox<String> NovoSubstituto_nivel_in;
    private javax.swing.JTextField NovoSubstituto_nome_in;
    private javax.swing.JTextField NovoSubstituto_salario_in;
    private javax.swing.JComboBox<String> NovoSubstituto_titulacao_in;
    // End of variables declaration//GEN-END:variables
}
