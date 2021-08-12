//Pedro Henrique Zago Costa - Estrutura de Dados I - 2020//

#include <string.h>
#include <locale.h>

struct fila{
    char nome[10];
    struct fila *prox;
};

struct Descritor{
    struct fila *fim;
    struct fila *inicio;
};

void Inicializa_Fila(struct Descritor *F){
    F->fim = NULL;
    F->inicio = NULL;
    return;
}

void Entrar_Fila(struct Descritor *F, char n[10]){
    setlocale(LC_ALL, "Portuguese");
    struct fila *Novo = (struct fila*)malloc(sizeof(struct fila));
    if(F->fim == NULL){
        strcpy(Novo->nome, n), Novo->prox = NULL;
        F->fim = Novo;
        F->inicio = Novo;
    }
    else{
        strcpy(Novo->nome, n), Novo->prox = F->fim;
        F->fim = Novo;
    }
    printf("\n %s entrou na fila.\n", F->fim->nome);
    printf("=========================================\n\n");
    return;
}

void Sair_Fila(struct Descritor *F){
    setlocale(LC_ALL, "Portuguese");
    if(F->inicio == NULL){
        printf("\n Não há ninguém na fila. Ela está vazia.\n");
        printf("=========================================\n\n");
    }
    else{
        struct fila *aux1, *aux2;
        aux1 = F->fim;
        aux2 = F->inicio;
        if(F->inicio == F->fim){
            printf("\n %s saiu da fila.\n", F->inicio->nome);
            printf("=========================================\n\n");
            free(aux1);
            free(aux2);
            F->fim = NULL, F->inicio = NULL;
        }
        else{
            while(aux1->prox != aux2){
                aux1 = aux1->prox;
            }
            printf("\n %s saiu da fila.\n", F->inicio->nome);
            printf("=========================================\n\n");
            free(aux2);
            aux2 = NULL;
            F->inicio = aux1;
        }
    }
    return;
}

void verInicio(struct Descritor *F){
    setlocale(LC_ALL, "Portuguese");
    if(F->inicio == NULL){
        printf("\n Não há ninguém na fila. Ela está vazia.\n");
        printf("=========================================\n\n");
    }
    else{
        printf("\n Quem está no começo da fila é %s.\n", F->inicio->nome);
        printf("=========================================\n\n");
    }
    return;
}

void verFim(struct Descritor *F){
    setlocale(LC_ALL, "Portuguese");
    if(F->fim == NULL){
        printf("\n Não há ninguém na fila. Ela está vazia.\n");
        printf("=========================================\n\n");
    }
    else{
        printf("\n Quem está no final da fila é %s.\n", F->fim->nome);
        printf("=========================================\n\n");
    }
    return;
}

//Pedro Henrique Zago Costa - Estrutura de Dados I - 2020//
