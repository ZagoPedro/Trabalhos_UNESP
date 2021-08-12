// Pedro Henrique Zago Costa - código principal (.c) //

#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include "hash.h"    // fazendo link com o TAD //

int main (void){
    int Registro_Chaves[MAX], cont_Chaves = 0;    // "Registro_Chaves[MAX]" armazenará as Chaves já utilizadas e "cont_Chaves" a quantidade delas
    int loop = 1, resultado, ch, ra, aux;                     // eles serão utilizados para impedir duplicação de Chaves (cada Chave deve ser única) //
    char option = '0', nm[35];

    for(cont_Chaves; cont_Chaves < MAX; cont_Chaves++) {Registro_Chaves[cont_Chaves] = 0;}    // inicializando o Registro de Chaves //
    cont_Chaves = 0;
    Inicializa_Tabela_Hash ();    // inicializando a Tabela Hash //

    setlocale(LC_ALL, "Portuguese");
    while(loop == 1){
        system("cls");
        printf("======================================================================================\n");    // menu //
        printf("   Implementação da Estrutura de Dados Hash em C - Pedro Henrique Zago Costa - 2020\n");
        printf("======================================================================================\n\n\n");
        printf(" Bem-vindo ao banco de dados de alunos. Opções:\n\n");
        printf(" 1. Inserir aluno no banco de dados\n 2. Procurar aluno no banco de dados\n 3. Ver quanto de espaço temos disponível\n 4. Finalizar programa\n\n");
        printf(" Escolha a opção desejada (1, 2, 3 ou 4): ");
        fflush(stdin);
        scanf("%c", &option);
        system("cls");
        if(option == (char)49){
            resultado = Espaco_Disponivel ();    // verificando o espaço disponível //
            if(resultado == 0){
                printf("\n\n Não há mais espaço disponível (todas as posições já estão ocupadas).\n");
                system("pause");
            }
            else{
                printf("==============\n  Novo Aluno\n==============\n\n");
                printf(" Insira o nome (string) do aluno: ");
                fflush(stdin);
                gets(nm);
                printf("\n Insira o RA (inteiro) do aluno: ");
                scanf("%d", &ra);
                printf("\n Cada aluno deve ter uma Chave única. Insira a Chave (inteiro) do aluno: ");
                scanf("%d", &ch);
                if(ch < 0) {ch = ch * (-1);}
                for(aux = 0; aux <= cont_Chaves; aux++){    // verificando a duplicação de Chaves //
                    if(Registro_Chaves[aux] == ch){
                        printf("\n\n Essa Chave já está sendo utilizada por outro aluno. Escolha outra Chave.\n");
                        system("pause");
                        break;
                    }
                }
                if(Registro_Chaves[aux] != ch){
                    Registro_Chaves[cont_Chaves] = ch;
                    cont_Chaves++;
                    resultado = Operacao_de_Hash (&ch);    // chamando a função de Hashing //
                    resultado = Insere_Aluno (nm, &ra, &ch, &resultado);    // chamando a função de Inserção de de Aluno na Tabela Hash //
                    if(resultado == 1) {printf("\n\n Aluno armazenado com sucesso.\n");}
                    else {printf("\n\n Não foi possível armazenar o aluno.\n");}
                    system("pause");
                }
            }
        }
        else if(option == (char)50){
            if(cont_Chaves == 0){
                printf("\n\n Ainda não há nenhum aluno registrado no sistema.\n");
                system("pause");
            }
            else{
                printf("==============\n Busca de Aluno \n==============\n\n");
                printf(" Insira a Chave desejada: ");
                scanf("%d", &ch);
                if(ch < 0) {ch = ch * (-1);}
                resultado = Operacao_de_Hash (&ch);    // chamando a função de Hashing //
                system("cls");
                resultado = Pesquisa_Aluno (&ch, &resultado);    // chamando a função de Pesquisa de Aluno na Tabela Hash //
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
                    printf("\n\n Aluno não encontrado (Chave não existente).\n");
                    system("pause");
                }
            }
        }
        else if(option == (char)51){
            resultado = Espaco_Disponivel ();    // chamando a função de Cálculo de Espaço Disponível na Tabela Hash //
            if(resultado == 15) {printf("\n\n Todo o espaço ainda está disponível (não há nenhuma posição ocupada).\n");}
            else if(resultado == 0) {printf("\n\n Não há mais espaço disponível (todas as posições já estão ocupadas).\n");}
            else {printf("\n\n Temos %d posições disponíveis (%d posições já estão ocupadas).\n", resultado, 15 - resultado);}
            system("pause");
        }
        else if(option == (char)52){loop = 0;}
        else{
            printf("\n Por favor, insira uma opção válida.\n");
            system("pause");
            option = '0';
        }
    }
    printf(" Programa Encerrado\n");    // encerrando o programa //
    return(0);
}

// Pedro Henrique Zago Costa - 2020 //
