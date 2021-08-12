//Pedro Henrique Zago Costa - Estrutura de Dados I - 2020//

#include <string.h>
#include <locale.h>

struct pilha{
    char livro[40];
    struct pilha *prox;
};

struct Descritor{
    struct pilha *fundo;
    struct pilha *topo;
};

void Inicializa_Pilha(struct Descritor *P){
    P->fundo = NULL;
    P->topo = NULL;
    return;
}

void Push(struct Descritor *P, char t[40]){
    struct pilha *aux;
    aux = P->topo;
    if(P->topo == NULL){
         struct pilha *Novo = (struct pilha*)malloc(sizeof(struct pilha));
            strcpy(Novo->livro, t), Novo->prox = NULL;
            P->fundo = Novo;
            P->topo = Novo;
    }
    else{
         struct pilha *Novo = (struct pilha*)malloc(sizeof(struct pilha));
            strcpy(Novo->livro, t), Novo->prox = NULL;
            aux->prox = Novo;
            P->topo = Novo;
    }
    return;
}

int Pop(struct Descritor *P){
    struct pilha *aux1, *aux2;
    aux1 = P->fundo;
    aux2 = P->topo;
    if(P->topo == NULL) {return(0);}
    else if(P->fundo == P->topo){
        free(aux1), free(aux2);
        P->fundo = NULL, P->topo = NULL;
        return(1);
    }
    else{
        while(aux1->prox != aux2 ){aux1 = aux1->prox;}
        free(aux2);
        P->topo = aux1;
        return(1);
    }
}

void verTopo(struct Descritor *P){
    setlocale(LC_ALL, "Portuguese");
    struct pilha *aux;
    aux = P->topo;
    if(aux == NULL) {printf(" \n A pilha está vazia. Não há nada no topo.\n\n");}
    else{
        printf("\n O livro no topo é: %s.\n", aux->livro);
        printf("=========================================\n\n");
    }
    return;
}

//Pedro Henrique Zago Costa - Estrutura de Dados I - 2020//
