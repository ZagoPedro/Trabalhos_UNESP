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
 * Efetivo.java -> classe filha da classe Docente.java. Ela instanciará objetos
 * do tipo Efetivo.
 */
public class Efetivo extends Docente {
    Constantes c2 = new Constantes();
    protected String area;
    
    public Efetivo() {
        codigo = "não definido";
        nome = "não definido";
        salario = 0.0f;
        nivel = "não definido";
        titulacao = "não definido";
        area = "não definido";
    }
    
    public Efetivo(String codigo, String nome, float salario, String nivel, String titulacao, String area) {
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario;
        this.nivel = nivel;
        this.titulacao = titulacao;
        this.area = area;
    }

    public String getArea() {
        return area;
    }
    public String getTitulacao() {
        return titulacao;
    }

    public void setArea(String area) {
        this.area = area;
    }
    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    
    @Override
    public double calcularSalario() {
        if(nivel.equalsIgnoreCase("D1")) {return salario + (salario * c2.returnD1());}
        else if(nivel.equalsIgnoreCase("D2")) {return salario + (salario * c2.returnD2());}
        else {return salario + (salario * c2.returnD3());}
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
        text = text + ("\n • área: " +area);
        text = text + "\n=================================\n";
        return text;
    }
}
