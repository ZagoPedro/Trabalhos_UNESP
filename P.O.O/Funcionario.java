/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 * @author Pedro Henrique Zago Costa - R.A.: 181257084
 * 
 * Funcionario.java -> esta é a classe abstrata que representará todos os possí-
 * veis Funcionários da Universidade.
 * 
 *  calcularSalario () -> responsável por calcular o salário real dos Funcioná-
 * rios (porcentagem de adicional + salário base).
 *  exibirFuncionario () -> responsável por exibir as informações dos Funcioná-
 * rios.
 */
public abstract class Funcionario {
    protected String codigo;
    protected String nome;
    protected double salario;
    protected String nivel;
    
    public String getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public double getSalario() {
        return salario;
    }
    public String getNivel() {
        return nivel;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    public abstract double calcularSalario();
    
    public abstract String exibirFuncionario();
}
