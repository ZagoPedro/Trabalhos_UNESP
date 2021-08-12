//Pedro Henrique Zago Costa - Estrutura de Dados I - 2020//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include "Pilha.h"

#define TRUE 1

int main(void){
    setlocale(LC_ALL, "Portuguese");

    struct Descritor P;
    char opcao = (char)48, titulo[40];
    int res;
    Inicializa_Pilha(&P);

    while(TRUE){
        system("cls");
        printf("\n====================\n PILHA DINÂMICA\n====================\n Escolha uma opção:\n\n");
        printf("1. Inserir livro na Pilha (push)\n");
        printf("2. Remover livro da Pilha (pop)\n");
        printf("3. Verificar o topo da Pilha\n");
        printf("4. Encerrar a execução do programa\n\n");
        printf(" Sua opção: ");
        fflush(stdin);
        scanf("%c",&opcao);
        if(opcao == (char)49){
            printf("\n\n Insira o título do livro que deseja empilhar: ");
            fflush(stdin);
            gets(titulo);
            Push(&P, titulo);
            printf("\n\n Livro inserido com sucesso!\n");
            system("pause");
            opcao = (char)48;
        }
        else if(opcao == (char)50){
            res = Pop(&P);
            if(res == 0) {printf("\n\n A pilha está vazia (não há o que se remover).\n");}
            else {printf("Livro removido do topo com sucesso!\n");}
            system("pause");
            opcao = (char)48;
        }
        else if(opcao == (char)51){
            verTopo(&P);
            system("pause");
            opcao = (char)48;
        }
        else if(opcao == (char)52){
            break;
        }
        else{
            printf("\n\n Por favor, insira uma entrada válida (1, 2, 3 ou 4).\n");
            system("pause");
            opcao = (char)48;
        }
    }
    printf("\n\n Programa encerrado.\n");
    printf("=======================");
    return(0);
}

//Pedro Henrique Zago Costa - Estrutura de Dados I - 2020//
