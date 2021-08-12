/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidade;

import Classes.*;
import Interface.*;

/**
 * @author Pedro Henrique Zago Costa - R.A.: 181257084
 * 
 * Sistema.java -> Este é o Sistema, onde todo o banco de dados é declarado e
 * serve como "interface" do programa. Na verdade, inicialmente ele continha
 * toda a interface, mas com a implementação dos JFrames, ele apenas os chama
 * agora. Ainda assim, os JFrames são chamados dentro da função executar().
 */
public class Sistema {

    public Universidade universidade = new Universidade();
    public Departamento departamentos[] = new Departamento[10];
    public Funcionario funcionarios[]  = new Funcionario[100];
    public int maxDepart = 0;
    public int maxFunc = 0;
    private static Sistema instance = null;
    
    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }

    public void executar() {
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
}
