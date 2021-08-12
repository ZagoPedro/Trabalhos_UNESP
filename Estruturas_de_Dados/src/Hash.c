// Pedro Henrique Zago Costa - c�digo principal (.c) //

#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include "hash.h"    // fazendo link com o TAD //

int main (void){
    int Registro_Chaves[MAX], cont_Chaves = 0;    // "Registro_Chaves[MAX]" armazenar� as Chaves j� utilizadas e "cont_Chaves" a quantidade delas
    int loop = 1, resultado, ch, ra, aux;                     // eles ser�o utilizados para impedir duplica��o de Chaves (cada Chave deve ser �nica) //
    char option = '0', nm[35];

    for(cont_Chaves; cont_Chaves < MAX; cont_Chaves++) {Registro_Chaves[cont_Chaves] = 0;}    // inicializando o Registro de Chaves //
    cont_Chaves = 0;
    Inicializa_Tabela_Hash ();    // inicializando a Tabela Hash //

    setlocale(LC_ALL, "Portuguese");
    while(loop == 1){
        system("cls");
        printf("======================================================================================\n");    // menu //
        printf("   Implementa��o da Estrutura de Dados Hash em C - Pedro Henrique Zago Costa - 2020\n");
        printf("======================================================================================\n\n\n");
        printf(" Bem-vindo ao banco de dados de alunos. Op��es:\n\n");
        printf(" 1. Inserir aluno no banco de dados\n 2. Procurar aluno no banco de dados\n 3. Ver quanto de espa�o temos dispon�vel\n 4. Finalizar programa\n\n");
        printf(" Escolha a op��o desejada (1, 2, 3 ou 4): ");
        fflush(stdin);
        scanf("%c", &option);
        system("cls");
        if(option == (char)49){
            resultado = Espaco_Disponivel ();    // verificando o espa�o dispon�vel //
            if(resultado == 0){
                printf("\n\n N�o h� mais espa�o dispon�vel (todas as posi��es j� est�o ocupadas).\n");
                system("pause");
            }
            else{
                printf("==============\n  Novo Aluno\n==============\n\n");
                printf(" Insira o nome (string) do aluno: ");
                fflush(stdin);
                gets(nm);
                printf("\n Insira o RA (inteiro) do aluno: ");
                scanf("%d", &ra);
                printf("\n Cada aluno deve ter uma Chave �nica. Insira a Chave (inteiro) do aluno: ");
                scanf("%d", &ch);
                if(ch < 0) {ch = ch * (-1);}
                for(aux = 0; aux <= cont_Chaves; aux++){    // verificando a duplica��o de Chaves //
                    if(Registro_Chaves[aux] == ch){
                        printf("\n\n Essa Chave j� est� sendo utilizada por outro aluno. Escolha outra Chave.\n");
                        system("pause");
                        break;
                    }
                }
                if(Registro_Chaves[aux] != ch){
                    Registro_Chaves[cont_Chaves] = ch;
                    cont_Chaves++;
                    resultado = Operacao_de_Hash (&ch);    // chamando a fun��o de Hashing //
                    resultado = Insere_Aluno (nm, &ra, &ch, &resultado);    // chamando a fun��o de Inser��o de de Aluno na Tabela Hash //
                    if(resultado == 1) {printf("\n\n Aluno armazenado com sucesso.\n");}
                    else {printf("\n\n N�o foi poss�vel armazenar o aluno.\n");}
                    system("pause");
                }
            }
        }
        else if(option == (char)50){
            if(cont_Chaves == 0){
                printf("\n\n Ainda n�o h� nenhum aluno registrado no sistema.\n");
                system("pause");
            }
            else{
                printf("==============\n Busca de Aluno \n==============\n\n");
                printf(" Insira a Chave desejada: ");
                scanf("%d", &ch);
                if(ch < 0) {ch = ch * (-1);}
                resultado = Operacao_de_Hash (&ch);    // chamando a fun��o de Hashing //
                system("cls");
                resultado = Pesquisa_Aluno (&ch, &resultado);    // chamando a fun��o de Pesquisa de Aluno na Tabela Hash //
                if(resultado == 2){
                    for(aux = 0; aux < cont_Chaves; aux++){
                        if((Registro_Chaves[aux] == ch) && (aux == (cont_Chaves - 1))){
                            Registro_Chaves[aux] = 0;
                            cont_Chaves--;
                            break;
                        }
                        else if(Registro_Chaves[aux] == ch){
                            while(aux < cont_Chaves){
                                Registro_Chaves[aux] = Registro_Chaves[aux + 1];
                                aux++;
                            }
                            cont_Chaves--;
                            break;
                        }
                    }
                }
                else if(resultado == 0) {
                    printf("\n\n Aluno n�o encontrado (Chave n�o existente).\n");
                    system("pause");
                }
            }
        }
        else if(option == (char)51){
            resultado = Espaco_Disponivel ();    // chamando a fun��o de C�lculo de Espa�o Dispon�vel na Tabela Hash //
            if(resultado == 15) {printf("\n\n Todo o espa�o ainda est� dispon�vel (n�o h� nenhuma posi��o ocupada).\n");}
            else if(resultado == 0) {printf("\n\n N�o h� mais espa�o dispon�vel (todas as posi��es j� est�o ocupadas).\n");}
            else {printf("\n\n Temos %d posi��es dispon�veis (%d posi��es j� est�o ocupadas).\n", resultado, 15 - resultado);}
            system("pause");
        }
        else if(option == (char)52){loop = 0;}
        else{
            printf("\n Por favor, insira uma op��o v�lida.\n");
            system("pause");
            option = '0';
        }
    }
    printf(" Programa Encerrado\n");    // encerrando o programa //
    return(0);
}

// Pedro Henrique Zago Costa - 2020 //
