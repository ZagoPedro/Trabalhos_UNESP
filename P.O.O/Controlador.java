/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidade;

import Classes.*;

/**
 * @author Pedro Henrique Zago Costa - R.A.: 181257084
 * 
 * Controlador.java -> O Controlador serve como intermediário entre a interface
 * e o banco de dados. Na interface, há apenas a visualização das operações
 * e entrada de dados. Esses dados são passados para o Controlador que, por sua
 * vez, armazena no banco (ou busca no banco, caso seja uma operação de busca).
 * Se for uma operação de busca, o resultado é retornado para a interface, que
 * irá mostrar ao usuário. O Controlador realmente não tem essa funcção.
 * 
 *  nomeUniversidade(String nome) -> responsável por dar o nome da Universidade
 *  inserirDepartamento(String op1, String op2) -> responsável por inserir um
 * novo Departamento.
 *  inserirFuncionario (String op1, String op2, String op3, String op4, String
 * op5, String op6, float op7, int op8, int depart) -> responsável por inserir
 * um novo Funcionário.
 *  exibicaoGeral() -> responsável por apresentar todos os Departamentos, seus
 * respectivos Funcionários e o gasto total com Funcionários.
 *  resumoDepartamentos (int opcao, float min, float max) -> responsável por
 * apresentar informações resumidas dos Departamentos (nome, a quantidade de
 * Funcionários e o gasto total com Funcionários), com ou sem gasto em faixa
 * específica.
 *  funcionariosSalario (float min, float max) -> responsável por apresentar os
 * dados de Funcionários com salário em uma faixa específica de valores.
 *  exibicaoFuncionarios (int opcao) -> responsável por emitir um relatório
 * geral com todos os Funcionários da Universidade, somente os Técnicos, somen-
 * te os Docentes, somente os Docentes Efetivos ou somente os Docentes Substitu-
 * tos.
 *  exibicaoDepartamentos (String busca) -> responsável por exibir todas as 
 * informações de um Departamento selecionado pelo usuário.
 *  buscaFuncionarios (int opcao, String busca) -> responsável por exibir todos
 * os dados de um Funcionário, a partir de seu código ou seu nome.
 *  departamentosNomes () -> responsável por retornar os nomes de todos os
 * Departamentos.
 */
public class Controlador {
    private Sistema sistema = Sistema.getInstance();
    String vazio = "Ainda não há nenhum funcionário cadastrado.\n";
    
    public void nomeUniversidade(String nome) {
        sistema.universidade.setNome(nome);
    }
    
    public void inserirDepartamento(String op1, String op2) {
        sistema.departamentos[sistema.maxDepart] = new Departamento();
        sistema.departamentos[sistema.maxDepart].setCodigo(op1);
        sistema.departamentos[sistema.maxDepart].setNome(op2);
        sistema.universidade.setDepartamentos(sistema.departamentos[sistema.maxDepart]);
        sistema.maxDepart++;
    }
    
    public void inserirFuncionario(String op1, String op2, String op3, String op4, String op5, String op6, float op7, int op8, int depart) {
        if (op1.equals("Tecnico")) {
            sistema.funcionarios[sistema.maxFunc] = new Tecnico(op2, op3, op7, op4, op5);
            sistema.departamentos[depart].setFuncionarios(sistema.funcionarios[sistema.maxFunc]);
        }
        else if (op1.equals("Docente Efetivo")) {
            sistema.funcionarios[sistema.maxFunc] = new Efetivo(op2, op3, op7, op4, op5, op6);
            sistema.departamentos[depart].setFuncionarios(sistema.funcionarios[sistema.maxFunc]);
        }
        else if (op1.equals("Docente Substituto")) {
            sistema.funcionarios[sistema.maxFunc] = new Substituto(op2, op3, op7, op4, op5, op8);
            sistema.departamentos[depart].setFuncionarios(sistema.funcionarios[sistema.maxFunc]);
        }
        sistema.maxFunc++;
    }
    
    public String exibicaoGeral() {
            int aux1, aux2, aux3;
            double aux4;
            String relatorio = "  EXIBIÇÃO GERAL\n";
            for (aux1 = 0; aux1 < sistema.maxDepart; aux1++) {
                relatorio = relatorio + ("\n • código: " +sistema.departamentos[aux1].getCodigo());
                relatorio = relatorio + ("\n • nome: " +sistema.departamentos[aux1].getNome());
                if (sistema.departamentos[aux1].numeroFuncionarios() == 0) {
                    relatorio = relatorio + ("\n Ainda não há nenhum funcionário cadastrado.");
                }
                else {
                    for (aux2 = 0; aux2 < sistema.departamentos[aux1].numeroFuncionarios(); aux2++) {
                        aux3 = aux2 + 1;
                        relatorio = relatorio + ("\n • funcionário " +aux3 +": " +sistema.departamentos[aux1].nomeFuncionarios(aux2));
                    }
                }
                aux4 = sistema.departamentos[aux1].gastoTotal();
                relatorio = relatorio + "\n • gasto total: ";
                relatorio = relatorio + Double.toString(aux4);
                relatorio = relatorio + "\n=================================\n";
            }
            return relatorio;
    }
    
    public String resumoDepartamentos(int opcao, float min, float max) {
            int aux1 = 0, cont = 0;
            String aux2, relatorio = null;
            double aux3;
            while (aux1 < sistema.maxDepart) {
                aux2 = sistema.departamentos[aux1].getNome();
                aux3 = sistema.departamentos[aux1].gastoTotal();
                if (opcao == 1) {
                    if (aux1 == 0) {relatorio = "  RESUMO DE DEPARTAMENTOS\n";}
                    relatorio = relatorio + ("\n • nome: " +aux2);
                    relatorio = relatorio + ("\n • número de funcionários: " +sistema.departamentos[aux1].numeroFuncionarios());
                    relatorio = relatorio + "\n gasto total: ";
                    relatorio = relatorio + Double.toString(aux3);
                    relatorio = relatorio + "\n=================================\n";
                }
                else {
                    if ((sistema.departamentos[aux1].gastoTotal() >= min) && (sistema.departamentos[aux1].gastoTotal() <= max)) {
                        if (cont == 0) {relatorio = "  RESUMO DE DEPARTAMENTOS COM GASTO EM FAIXA ESPECÍFICA\n";}
                        relatorio = relatorio + ("\n • nome: " +aux2);
                        relatorio = relatorio + ("\n • número de funcionários: " +sistema.departamentos[aux1].numeroFuncionarios());
                        relatorio = relatorio + "\n • gasto total: ";
                        relatorio = relatorio + Double.toString(aux3);
                        relatorio = relatorio + "\n=================================\n";
                        cont++;
                    }
                }
                aux1++;
            }
            if ((opcao == 2) && (cont == 0)) {relatorio = " Nenhum departamento encontrado nessa faixa de gastos.";}
            return relatorio;
    }
    
    public String funcionariosSalario(float min, float max) {
        int aux, cont = 0;
        String relatorio = "  FUNCIONÁRIOS NESTA FAIXA DE SALÁRIO\n";
        for(aux = 0; aux < sistema.maxFunc; aux++) {
            if ((sistema.funcionarios[aux].calcularSalario() >= min) && (sistema.funcionarios[aux].calcularSalario() <= max)) {
                relatorio = relatorio + sistema.funcionarios[aux].exibirFuncionario();
                cont++;
            }
        }
        if (cont == 0) {relatorio = " Nenhum funcionário encontrado nessa faixa de salário.\n";}
        return relatorio;
    }
    
    public String exibicaoFuncionarios(int opcao) {
        int aux, cont = 0;
        String relatorio = null;
        switch (opcao) {
            case 1:
                relatorio = "  FUNCIONÁRIOS CADASTRADOS\n";
                for(aux = 0; aux < sistema.maxFunc; aux++) {relatorio = relatorio + sistema.funcionarios[aux].exibirFuncionario();}

                break;
            case 2:
                relatorio = "  TÉCNICOS CADASTRADOS\n";
                for(aux = 0; aux < sistema.maxFunc; aux++) {
                    if (sistema.funcionarios[aux] instanceof Tecnico) {
                        relatorio = relatorio + sistema.funcionarios[aux].exibirFuncionario();
                        cont++;
                    }
                }
                if (cont == 0) {relatorio = " Nenhum Técnico encontrado.\n";}

                break;
            case 3:
                relatorio = "  DOCENTES CADASTRADOS\n";
                for(aux = 0; aux < sistema.maxFunc; aux++) {
                    if (sistema.funcionarios[aux] instanceof Docente) {
                        relatorio = relatorio + sistema.funcionarios[aux].exibirFuncionario();
                        cont++;
                    }
                }
                if (cont == 0) {relatorio = " Nenhum Docente encontrado.\n";}

                break;
            case 4:
                relatorio = "  DOCENTES EFETIVOS CADASTRADOS\n";
                for(aux = 0; aux < sistema.maxFunc; aux++) {
                    if (sistema.funcionarios[aux] instanceof Efetivo) {
                        relatorio = relatorio + sistema.funcionarios[aux].exibirFuncionario();
                        cont++;
                    }
                }
                if (cont == 0) {relatorio = " Nenhum Docente Efetivo encontrado.\n";}

                break;
            case 5:
                relatorio = "  DOCENTES SUBSTITUTOS CADASTRADOS\n";
                for(aux = 0; aux < sistema.maxFunc; aux++) {
                    if (sistema.funcionarios[aux] instanceof Substituto) {
                        relatorio = relatorio + sistema.funcionarios[aux].exibirFuncionario();
                        cont++;
                    }
                }
                if (cont == 0) {relatorio = " Nenhum Docente Substituto encontrado.\n";}

                break;
        }
        return relatorio;
    }
    
    public String exibicaoDepartamentos(String busca) {
        int aux1 = 0;
        String aux2;
        double aux3;
        String relatorio = "  INFORMAÇÕES DO DEPARTAMENTO\n";
        while (aux1 < sistema.maxDepart) {
            aux2 = sistema.departamentos[aux1].getCodigo();
            if (aux2.equals(busca)) {
                aux3 = sistema.departamentos[aux1].gastoTotal();
                relatorio = relatorio + sistema.departamentos[aux1].exibirDepartamento();
                relatorio = relatorio + "\n • gasto total: ";
                relatorio = relatorio + Double.toString(aux3);
                relatorio = relatorio + "\n=================================\n";
                return relatorio;
            }
            aux1++;
        }
        relatorio = " Departamento não encontrado.\n";
        return relatorio;
    }
    
    public String buscaFuncionarios(int opcao, String busca) {
        int aux1;
        String aux2;
        String relatorio = "  DADOS DO FUNCIONÁRIO\n";
        if (opcao == 1) {
            for(aux1 = 0; aux1 < sistema.maxFunc; aux1++) {
                aux2 = sistema.funcionarios[aux1].getCodigo();
                if (aux2.equals(busca)) {
                    relatorio = relatorio + sistema.funcionarios[aux1].exibirFuncionario();
                    return relatorio;
                }
            }
            relatorio = " Funcionário não encontrado.";
            return relatorio;
        }
        else {
            for(aux1 = 0; aux1 < sistema.maxFunc; aux1++) {
                aux2 = sistema.funcionarios[aux1].getNome();
                if (aux2.equals(busca)) {
                    relatorio = relatorio + sistema.funcionarios[aux1].exibirFuncionario();
                    return relatorio;
                }
            }
            relatorio = " Funcionário não encontrado.";
            return relatorio;
        }
    } 
    
    public void departamentosNomes() {
        int aux1;
        String aux2;
        for(aux1 = 0; aux1 < sistema.maxDepart; aux1++) {
            aux2 = sistema.departamentos[aux1].getNome();
            aux1++;
            System.out.println(aux1 + ". " + aux2 + "\n");
            aux1--;
        }
    }
}
