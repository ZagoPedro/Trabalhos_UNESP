//Pedro Henrique Zago Costa - Estrutura de Dados I - 2020//

// INFORMAÇÕES GERAIS: //
// "String" ou "String 1" referem-se à String Dinâmica que será utilizada em todas as funções. //
// "String 2" refere-se à uma segunda String Dinâmica que será utilizada nas funções 05, 06, 09 e 10. //
// "String 3" refere-se à uma terceira String Dinâmica que será utilizada na função 06. //
// "S", "S2" e "S3" referem-se aos Descritores da String, String 2 e String 3, respectivamente. //

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include "strdim.h"

int status2 = 0, status3 = 0;  // "status2" verificará o status da String 2. "status3 verificará o status da String 3. //

int main(void){   // MAIN //
    setlocale(LC_ALL, "portuguese");

    struct Descritor S, S2, S3;                                         // Descritores //
    int ini = 0, opcao = 0, B;
    char A;
    Inicializa_String(&S);
    while(TRUE){
        system("cls");
        while(opcao == 0) {
            printf("\n====================\n STRINGS DINÂMICAS\n====================\n Escolha uma opção:\n\n");   // Menu //
            printf("01. Reinicializar String.\n");
            printf("02. Imprimir String.\n");
            printf("03. Ver tamanho de uma String.\n");
            printf("04. Inserir caractere em uma String.\n");
            printf("05. Copia a String para a String 2.\n");
            printf("06. Concatena a String e a String 2 e coloca o resultado na String 3.\n");
            printf("07. Remove uma quantidade de caracteres da String.\n");
            printf("08. Insere uma sub-string na String.\n");
            printf("09. Verifica se String é menor que String 2.\n");
            printf("10. Verifica se String e String 2 são iguais.\n");
            printf("11. Verifica se há (e onde) uma string padrão dentro da String.\n");
            printf("12. Finalizar execução do programa.\n\n");
            printf(" Sua opção: ");
            scanf("%d",&opcao);
            if((opcao < 1) || (opcao > 12)){opcao = 0;}
            system("cls");
        }
        if(opcao == 12){ break; }
        if(ini == 0){ Inicializa_String(&S), ini = 1;}
        switch(opcao){
            case 1:
                if(S.ini == NULL){printf("\n A String encontra-se vazia, não é necessário reiniciá-la.\n");}
                else{
                    Reinicializa_String(&S);
                    printf("\n String Dinâmica reinicializada com sucesso!\n");
                }
                break;
            case 2:
                if(S.ini == NULL){printf("\n A String encontra-se vazia.\n");}
                else{
                    printf("\n String atual: \"");
                    Imprime_String(&S);
                    printf("\"\n");
                }
                break;
            case 3:
                if(S.ini == NULL){printf("\n A String encontra-se vazia.\n");}
                else{Tamanho_String(&S);}
                break;
            case 4:
                printf("\n Insira o caractere desejado: ");
                fflush(stdin);
                scanf("%c",&A);
                Insere_Char_String(&S, A);
                printf("\n Inserção feita com sucesso!\n");
                break;
            case 5:
                if(S.ini == NULL){{printf("\n A String 1 encontra-se vazia.\n");}}
                else{
                    if(status2 != 0){Reinicializa_String(&S2), status2 = 0;}
                    else{Inicializa_String(&S2), status2++;}
                    Copia_String_String2(&S, &S2);
                    printf("\n\n String Dinâmica copiada para String Dinâmica 2 com sucesso!\n");
                }
                break;
            case 6:
                if((S.ini == NULL) && (status2 == 0)){printf("\n As Strings 1 e 2 encontram-se vazias.\n");}
                else if(S.ini == NULL){printf("\n A String 1 encontra-se vazia.\n");}
                else if(status2 == 0){printf("\n A String 2 encontra-se vazia.\n");}
                else{
                    if(status3 != 0){Reinicializa_String(&S3), status3 = 0;}
                    else{Inicializa_String(&S3), status3++;}
                    Concatena_Strings(&S, &S2, &S3);
                    printf("\n\n String Dinâmica 3 criada com sucesso!\n");
                }
                break;
            case 7:
                if(S.ini == NULL){printf("\n A String encontra-se vazia.\n");}
                else{
                    printf("\n Quantos caracteres deseja remover da String \"");
                    Imprime_String(&S);
                    printf("\" ? ");
                    fflush(stdin);
                    scanf("%d",&B);
                    Remove_Char_String(&S, B);
                    printf("\n Remoção feita com sucesso!\n");
                }
                break;
            case 8:
                if(S.ini == NULL){printf("\n A String encontra-se vazia.\n");}
                else{
                    SubString_String(&S);
                    if(sucess > 0){printf("\n Sub-string inserida na String Dinâmica com sucesso!\n");}
                }
                break;
            case 9:
                if((S.ini == NULL) && (S2.ini == NULL)){printf("\n As Strings 1 e 2 encontram-se vazias.\n");}
                else if(S.ini == NULL){printf("\n A String 1 encontra-se vazia.\n");}
                else if(S2.ini == NULL){printf("\n A String 2 encontra-se vazia.\n");}
                else{Menor_String(&S, &S2);}
                break;
            case 10:
                if((S.ini == NULL) && (S2.ini == NULL)){printf("\n As Strings 1 e 2 encontram-se vazias.\n");}
                else if(S.ini == NULL){printf("\n A String 1 encontra-se vazia.\n");}
                else if(S2.ini == NULL){printf("\n A String 2 encontra-se vazia.\n");}
                else{Igualdade_Strings(&S, &S2);}
                break;
            case 11:
                 if(S.ini == NULL){printf("\n A String encontra-se vazia.\n");}
                else{String_Padrao(&S);}
                break;
        }
        opcao = 0;
        system("pause");
    }
    return (0);
}

//Pedro Henrique Zago Costa - Estrutura de Dados I - 2020//
