/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 * @author Pedro Henrique Zago Costa - 181257084
 * 
 * Universidade.java -> Esta é a classe que instanciará objetos do tipo Univer-
 * sidade.
 */
public class Universidade {
    private String nome;
    private Departamento departamentos[] = new Departamento[10];
    private int atual = 0;

    public Universidade(String nome) {
        this.nome = nome;
    }
    public Universidade() {
        nome = "não definido";
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDepartamentos(Departamento depart) {
        this.departamentos[atual] = depart;
        atual++;
    }
    
}
