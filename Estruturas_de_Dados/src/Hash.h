// Pedro Henrique Zago Costa - 2020 - TAD (.h) //

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 15

struct Aluno{    // cada aluno será armazenado em um nó desses //
    int chave;
    char nome[35];
    int RA;
};

struct Aluno *Tabela_Hash[MAX];    // Tabela Hash: basicamente um vetor de structs do tipo Aluno //

void Inicializa_Tabela_Hash (){    // função de Inicialização da Tabela Hash //
    int aux = 0;
    for(aux; aux < MAX; aux++) {Tabela_Hash[aux] = NULL;}    // inicialmente, cada um dos 15 nós da Tabela Hash apontam para NULL (estão vazios)
    return;                                                                                   // as posições 0 à 9 serão a área "normal" da Tabela Hash, já as posições 10 à 14 serão a àrea de Overflow //
}

int Operacao_de_Hash (int *chave){    // função de Operação de Hash (ou função de Hashing) //
    int r = 0, aux = *chave;
    while(aux > 0){
        r = (r * 2) + ((aux % 10) * 9);    // a Chave será transformada. Chaves diferentes (muito provavelmente) gerarão valores distintos
        aux = aux/10;                            // pegaremos o resto da divisão do valor resultante por 10, o que nos dará um número no intervalo [0, 9], que será o seu destino na Tabela Hash //
    }
    r = r % 10;
    return(r);
}

int Insere_Aluno (char nome[], int *RA, int *chave, int *pos){    // função de Inserção de Aluno na Tabela Hash //
    int r = *pos;
    struct Aluno *Novo = (struct Aluno*)malloc(sizeof(struct Aluno));    // alocando um novo nó do tipo struct Aluno //
    Novo->chave = *chave;
    strcpy(Novo->nome, nome);    // copiando dados //
    Novo->RA = *RA;
    if (Tabela_Hash[r] == NULL){    // armazenado o novo aluno numa posição da Tabela Hash definida pela função de Hashing anteriormente //
            Tabela_Hash[r] = Novo;
            return(1);
    }
    else{
        for(r = 10; r < MAX; r++){
            if(Tabela_Hash[r] == NULL){    // se já houver outro aluno lá (Colisão), é necessário fazer o tratamento de colisões
                Tabela_Hash[r] = Novo;       // o novo aluno será redirecionado para a área de Overflow da Tabela Hash, onde será armazenado na primeira posição disponível //
                return(1);
            }
        }
    }
    return(0);    // se a área de Overflow já estiver cheia, não será possível armazená-lo //
}

int Pesquisa_Aluno (int *chave, int *pos){    // função de Pesquisa de Aluno na Tabela Hash
    int r = *pos;                                                 // ela também remove o aluno, caso o usuário deseja //
    int aux = *chave;
    char option;
    if(Tabela_Hash[r] != NULL){
        if(Tabela_Hash[r]->chave == aux){    // a busca é extremamente eficiente. 2 operações já são o suficiente para encontrar o aluno (se ele existir) //
            printf(" Aluno Encontrado!\n\n");
            printf("===================\n");
            printf(" Nome: %s\n", Tabela_Hash[r]->nome);
            printf(" RA: %d\n", Tabela_Hash[r]->RA);
            printf(" Chave: %d\n", Tabela_Hash[r]->chave);
            printf("===================\n");
            system("pause");
            printf("\n\n Deseja remover este aluno? Digite 1 para sim ou qualquer outra tecla para não: ");
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
                if(Tabela_Hash[r]->chave == aux){    // busca de aluno da área de Overflow. É menos eficiente, mas é impossível impedir que colisões ocorram //
                    printf(" Aluno Encontrado!\n\n");
                    printf("===================\n");
                    printf(" Nome: %s\n", Tabela_Hash[r]->nome);
                    printf(" RA: %d\n", Tabela_Hash[r]->RA);
                    printf(" Chave: %d\n", Tabela_Hash[r]->chave);
                    printf("===================\n");
                    system("pause");
                    printf("\n\n Deseja remover este aluno? Digite 1 para sim ou qualquer outra tecla para não: ");
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
    return(0);    // caso o aluno não seja encontrado (busca de um aluno inexistente) //
}

int Espaco_Disponivel (){    // função que Calcula o espaço disponível na Tabela Hash
    int aux = 0, r = 0;             // coloquei ela como um extra, para ajudar o usuário a não se perder na quantidade de alunos armazenados //
    for(aux; aux < MAX; aux++){
        if(Tabela_Hash[aux] == NULL) {r++;}
    }
    return(r);
}

// Pedro Henrique Zago Costa - 2020 //
