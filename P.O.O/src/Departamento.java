/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 * @author Pedro Henrique Zago Costa - R.A.: 181257084
 * 
 * Departamento.java -> Esta é a classe que instanciará objetos do tipo Departa-
 * mento.
 * 
 *  exibirDepartamento () -> responsável por exibir todas as informações deste
 * Departamento.
 *  gastoTotal() -> responsável por calcular o gasto total deste Departamento,
 * somando o salário de todos os funcionários que fazem parte dele.
 *  atualizarAtual () -> responsável por atualizar a variável que percorre o
 * vetor funcionarios[], impedindo que um Funcionário sobreescreva o outro e que
 * o limite do vetor seja ultrapassado.
 *  numeroFuncionarios () -> responsável por retornar o número de Funcionários
 * cadastrados neste Departamento.
 *  nomeFuncionarios () -> responsável por retornar o nome de um Funcionário es-
 * pecífico deste Departamento.
 */
public class Departamento {
    private String codigo;
    private String nome;
    private final int quantidade = 10;
    private int atual = 0;
    private Funcionario funcionarios[] = new Funcionario[10];

    public Departamento() {
        codigo = "não definido";
        nome = "não definido";
    }
    public Departamento(String codigo, String nome, Funcionario[] funcionarios) {
        this.codigo = codigo;
        this.nome = nome;
        this.funcionarios = funcionarios;
    }

    public String getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public Funcionario[] getFuncionarios() {
        return funcionarios;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setFuncionarios(Funcionario func) {
        this.funcionarios[atual] = func;
        atual++;
    }
    
    public String exibirDepartamento() {
        String text = ("\n • código: " +codigo);
        text = text + ("\n • nome: " +nome);
        if (atual == 0) {text = text + ("\n  Este departamento ainda não possui nenhum funcionário.");}
        else {
            int aux1 = 0, aux2;
            while (aux1 < atual) {
                aux2 = aux1 + 1;
                text = text + ("\n • funcionário " +aux2 + ": " +funcionarios[aux1].getNome());
                aux1++;
            }
        }
        return text;
    }
    
    public double gastoTotal() {
        double total = 0.0;
        if (atual > 0) {
            int aux = 0;
            while (aux < atual) {
                total = total + funcionarios[aux].calcularSalario();
                aux++;
            }
        }
        total = Math.round(total * 100.0)/100.0;
        return total;
    }
    
    public void atualizarAtual() {atual++;}
    
    public int numeroFuncionarios() {return atual;}
    
    public String nomeFuncionarios(int aux) {
        return funcionarios[aux].getNome();
    }
}
