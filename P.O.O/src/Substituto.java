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
 * Substituto.java -> classe filha da classe Docente.java. Ela instanciará obje-
 * tos do tipo Substituto.
 */
public class Substituto extends Docente {
    Constantes c3 = new Constantes();
    protected int cargaHoraria;
    
    public Substituto() {
        codigo = "não definido";
        nome = "não definido";
        salario = 0.0f;
        nivel = "não definido"; 
        titulacao = "não definido";
        cargaHoraria = 0;
    }
    
    public Substituto(String codigo, String nome, float salario, String nivel, String titulacao, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario;
        this.nivel = nivel;
        this.titulacao = titulacao;
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public String getTitulacao() {
        return titulacao;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    
    @Override
    public double calcularSalario() {
        if(nivel.equalsIgnoreCase("S1")) {return salario + (salario * c3.returnS1());}
        else {return salario + (salario * c3.returnS2());}
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
        text = text + ("\n • função: " +titulacao);
        text = text + ("\n • carga horária: " +cargaHoraria);
        text = text + "\n=================================\n";
        return text;
    }
}
