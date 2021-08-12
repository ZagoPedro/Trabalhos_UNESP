/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import universidade.Constantes;

/**
 * @author Pedro Henrique Zago Costa - R.A.: 181257084
 * 
 * Tecnico.java -> classe filha da classe Funcionario.java. Ela instanciará
 * objetos do tipo Tecnico.
 */
public class Tecnico extends Funcionario {
    Constantes c1 = new Constantes();
    protected String funcao;
    
    public Tecnico() {
        codigo = "não definido";
        nome = "não definido";
        salario = 0.0f;
        nivel = "não definido"; 
        funcao = "não definido";
    }
    
    public Tecnico(String codigo, String nome, float salario, String nivel, String funcao) {
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario;
        this.nivel = nivel;
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
   
    
    @Override
    public String exibirFuncionario() {
        String text;
        double salarioReal = calcularSalario();
        salarioReal = Math.round(salarioReal * 100.0)/100.0;
        text = ("\n • código: " +codigo);
        text = text + ("\n • nome: " +nome);
        text = text + ("\n • salário: " +salarioReal);
        text = text + ("\n • nível: " +nivel);
        text = text + ("\n • função: " +funcao);
        text = text + "\n=================================\n";
        return text;
    }
    
    @Override
    public double calcularSalario() {
        if(nivel.equalsIgnoreCase("T1")) {return salario + (salario * c1.returnT1());}
        else {return salario + (salario * c1.returnT2());}
    }
}
