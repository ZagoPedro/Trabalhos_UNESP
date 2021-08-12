// Pedro Henrique Zago Costa - 2020 - TAD (.h) //

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 15

struct Aluno{    // cada aluno ser� armazenado em um n� desses //
    int chave;
    char nome[35];
    int RA;
};

struct Aluno *Tabela_Hash[MAX];    // Tabela Hash: basicamente um vetor de structs do tipo Aluno //

void Inicializa_Tabela_Hash (){    // fun��o de Inicializa��o da Tabela Hash //
    int aux = 0;
    for(aux; aux < MAX; aux++) {Tabela_Hash[aux] = NULL;}    // inicialmente, cada um dos 15 n�s da Tabela Hash apontam para NULL (est�o vazios)
    return;                                                                                   // as posi��es 0 � 9 ser�o a �rea "normal" da Tabela Hash, j� as posi��es 10 � 14 ser�o a �rea de Overflow //
}

int Operacao_de_Hash (int *chave){    // fun��o de Opera��o de Hash (ou fun��o de Hashing) //
    int r = 0, aux = *chave;
    while(aux > 0){
        r = (r * 2) + ((aux % 10) * 9);    // a Chave ser� transformada. Chaves diferentes (muito provavelmente) gerar�o valores distintos
        aux = aux/10;                            // pegaremos o resto da divis�o do valor resultante por 10, o que nos dar� um n�mero no intervalo [0, 9], que ser� o seu destino na Tabela Hash //
    }
    r = r % 10;
    return(r);
}

int Insere_Aluno (char nome[], int *RA, int *chave, int *pos){    // fun��o de Inser��o de Aluno na Tabela Hash //
    int r = *pos;
    struct Aluno *Novo = (struct Aluno*)malloc(sizeof(struct Aluno));    // alocando um novo n� do tipo struct Aluno //
    Novo->chave = *chave;
    strcpy(Novo->nome, nome);    // copiando dados //
    Novo->RA = *RA;
    if (Tabela_Hash[r] == NULL){    // armazenado o novo aluno numa posi��o da Tabela Hash definida pela fun��o de Hashing anteriormente //
            Tabela_Hash[r] = Novo;
            return(1);
    }
    else{
        for(r = 10; r < MAX; r++){
            if(Tabela_Hash[r] == NULL){    // se j� houver outro aluno l� (Colis�o), � necess�rio fazer o tratamento de colis�es
                Tabela_Hash[r] = Novo;       // o novo aluno ser� redirecionado para a �rea de Overflow da Tabela Hash, onde ser� armazenado na primeira posi��o dispon�vel //
                return(1);
            }
        }
    }
    return(0);    // se a �rea de Overflow j� estiver cheia, n�o ser� poss�vel armazen�-lo //
}

int Pesquisa_Aluno (int *chave, int *pos){    // fun��o de Pesquisa de Aluno na Tabela Hash
    int r = *pos;                                                 // ela tamb�m remove o aluno, caso o usu�rio deseja //
    int aux = *chave;
    char option;
    if(Tabela_Hash[r] != NULL){
        if(Tabela_Hash[r]->chave == aux){    // a busca � extremamente eficiente. 2 opera��es j� s�o o suficiente para encontrar o aluno (se ele existir) //
            printf(" Aluno Encontrado!\n\n");
            printf("===================\n");
            printf(" Nome: %s\n", Tabela_Hash[r]->nome);
            printf(" RA: %d\n", Tabela_Hash[r]->RA);
            printf(" Chave: %d\n", Tabela_Hash[r]->chave);
            printf("===================\n");
            system("pause");
            printf("\n\n Deseja remover este aluno? Digite 1 para sim ou qualquer outra tecla para n�o: ");
            fflush(stdin);
            scanf("%c", &option);
            if(option == (char)49){
                free (Tabela_Hash[r]);
                Tabela_Hash[r] = NULL;
                printf("\n\n Aluno removido com sucesso.\n");
                system("pause");
                return(2);
            }
            return(1);
        }
    }
    else{
        for(r = 10; r < MAX; r++){
            if(Tabela_Hash[r] != NULL){
                if(Tabela_Hash[r]->chave == aux){    // busca de aluno da �rea de Overflow. � menos eficiente, mas � imposs�vel impedir que colis�es ocorram //
                    printf(" Aluno Encontrado!\n\n");
                    printf("===================\n");
                    printf(" Nome: %s\n", Tabela_Hash[r]->nome);
                    printf(" RA: %d\n", Tabela_Hash[r]->RA);
                    printf(" Chave: %d\n", Tabela_Hash[r]->chave);
                    printf("===================\n");
                    system("pause");
                    printf("\n\n Deseja remover este aluno? Digite 1 para sim ou qualquer outra tecla para n�o: ");
                    fflush(stdin);
                    scanf("%c", &option);
                    if(option == (char)49){
                        free (Tabela_Hash[r]);
                        Tabela_Hash[r] = NULL;
                        printf("\n\n Aluno removido com sucesso.\n");
                        system("pause");
                        return(2);
                    }
                    return(1);
                }
            }
        }
    }
    return(0);    // caso o aluno n�o seja encontrado (busca de um aluno inexistente) //
}

int Espaco_Disponivel (){    // fun��o que Calcula o espa�o dispon�vel na Tabela Hash
    int aux = 0, r = 0;             // coloquei ela como um extra, para ajudar o usu�rio a n�o se perder na quantidade de alunos armazenados //
    for(aux; aux < MAX; aux++){
        if(Tabela_Hash[aux] == NULL) {r++;}
    }
    return(r);
}

// Pedro Henrique Zago Costa - 2020 //
