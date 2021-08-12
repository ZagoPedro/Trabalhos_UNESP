//Pedro Henrique Zago Costa - Estrutura de Dados I - 2020//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include "Fila.h"

#define TRUE 1

int main(void){
    setlocale(LC_ALL, "Portuguese");

    struct Descritor F;
    char opcao = (char)48, nome[10];
    int res;
    Inicializa_Fila(&F);

    while(TRUE){
        system("cls");
        printf("\n====================\n FILA DIN�MICA\n====================\n Escolha uma op��o:\n\n");
        printf("1. Colocar algu�m no final da Fila (entrar)\n");
        printf("2. Tirar algu�m do come�o da Fila (sair)\n");
        printf("3. Verificar quem est� no come�o da Fila\n");
        printf("4. Verificar quem est� no final da Fila\n");
        printf("5. Encerrar a execu��o do programa\n\n");
        printf(" Sua op��o: ");
        fflush(stdin);
        scanf("%c",&opcao);
        if(opcao == (char)49){
            printf("\n\n Insira o nome de quem entrar� na fila: ");
            fflush(stdin);
            gets(nome);
            Entrar_Fila(&F, nome);
            system("pause");
            opcao = (char)48;
        }
        else if(opcao == (char)50){
            Sair_Fila(&F);
            system("pause");
            opcao = (char)48;
        }
        else if(opcao == (char)51){
            verInicio(&F);
            system("pause");
            opcao = (char)48;
        }
        else if(opcao == (char)52){
            verFim(&F);
            system("pause");
            opcao = (char)48;
        }
        else if(opcao == (char)53){
            break;
        }
        else{
            printf("\n\n Por favor, insira uma entrada v�lida (1, 2, 3, 4 ou 5).\n");
            system("pause");
            opcao = (char)48;
        }
    }
    printf("\n\n Programa encerrado.\n");
    printf("=======================");
    return(0);
}

//Pedro Henrique Zago Costa - Estrutura de Dados I - 2020//
