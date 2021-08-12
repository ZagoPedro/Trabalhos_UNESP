/*  ZagoPedro - 2021

      Comp�em o meu trabalho:
      -> "Grafos.c": programa escrito por mim em Linguagem C atendendo todas as especifica��es do trabalho.
      -> "Grafos.h" (ESTE ARQUIVO): biblioteca de Estruturas de Dados e Fun��es escrita por mim para Linguagem C. O "Grafos.c" necessita desta biblioteca.
      -> "grafo.txt": arquivo de texto representando um Grafo n�o-orientado, utilizado por mim para testar o c�digo.
      -> "digrafo.txt": arquivo de texto representando um D�grafo, utilizado por mim para testar o c�digo. */

#include <stdio.h>
#include <stdlib.h>

FILE *fH;
char Vertices[16];
int Tempos[16][2], tempo = 0;        // vari�veis auxiliares para a Busca em Grafo. //
int Larguras[16], inicio = 0;

struct grafo {        // Estrutura de Dados Grafo em Lista de Adjac�ncia. //
    char c;
    struct grafo *baixo;
    struct grafo *direita;
    int peso;
};

struct Descritor {        // Descritor que aponta para o in�cio da Lista de Adjac�ncia. //
    struct grafo *ini;
};

struct Tupla {       // Estrutura auxiliar (para o caso de Matrizes). //
    int a;
    int b;
    int peso;
};

void Inicializacao (struct Descritor *G) {        // Inicializando a estrutura. Esta � a primeira fun��o a ser executada. //
    G->ini = NULL;
}

void PrintResultante (struct Descritor *G) {        // Escrevendo os arcos/arestas no arquivo resultante. //
    fH = fopen("resultante.txt", "a");
    struct grafo *aux1;
    struct grafo *aux2;
    int cont;
    if (fH == NULL) {
        printf("\n\n Erro ao abrir o arquivo resultante.\n");
        system("pause");
    }
    else {
        aux1 = G->ini;
        while (aux1 != NULL) {
            cont = 0;
            aux2 = aux1->direita;
            while (1) {
                if (aux2 == NULL) {
                    if (cont == 0) { fprintf(fH, "%c\n", aux1->c); }
                    break;
                }
                else {
                    if (aux2->c == 'e') { fprintf(fH, "%c\n", aux1->c); }
                    else if (aux2->peso < 10) { fprintf(fH, "%c %c 0%d\n", aux1->c, aux2->c, aux2->peso); }
                    else { fprintf(fH, "%c %c %d\n", aux1->c, aux2->c, aux2->peso); }
                    cont++;
                }
                aux2 = aux2->direita;
            }
            aux1 = aux1->baixo;
        }
    }
    fclose(fH);
    return;
}

struct Tupla ReturnNumbers(struct Descritor *G, int number) {       // Fun��o auxiliar (para o caso de Matrizes). //
    struct Tupla res;
    struct grafo *aux1;
    struct grafo *aux2;
    int cont = 0;
    aux1 = G->ini;
    while (1) {
        aux2 = aux1->direita;
        while (aux2 != NULL) {
            if (cont == number) {
                res.a = ((int) aux1->c) - 49;
                res.b = ((int) aux2->c) - 49;
                res.peso = aux2->peso;
                return res;
            }
            cont++, aux2 = aux2->direita;
        }
        if (aux1->baixo == NULL) {
            res.a = -1;
            res.b = -1;
            res.peso = 0;
            break;
        }
        else { aux1 = aux1->baixo; }
    }
    return res;
};

void Insercao (struct Descritor *G, char c, char a, int peso, char opcao) {        // Inserindo v�rtices na Lista. //
    struct grafo *aux1;
    struct grafo *aux2;
    aux1 = G->ini;
    while (1) {
        if (opcao == '1') {        // V�rtice de sa�da. //
            if (G->ini == NULL) {
                struct grafo *Novo = (struct grafo*)malloc(sizeof(struct grafo));
                Novo->c = c, Novo->baixo = NULL, Novo->direita = NULL, Novo->peso = peso;
                G->ini = Novo;
                break;
            }
            else if (aux1->baixo == NULL) {
                struct grafo *Novo = (struct grafo*)malloc(sizeof(struct grafo));
                Novo->c = c, Novo->baixo = NULL, Novo->direita = NULL, Novo->peso = peso;
                aux1->baixo = Novo;
                break;
            }
            else {aux1 = aux1->baixo;}
        }
        else {        // V�rtice de chegada. //
            while (aux1->c != a) { aux1 = aux1->baixo; }
            aux2 = aux1->direita;
            while(1) {
                if (aux2 == NULL) {
                    struct grafo *Novo = (struct grafo*)malloc(sizeof(struct grafo));
                    Novo->c = c, Novo->baixo = NULL, Novo->direita = NULL, Novo->peso = peso;
                    aux1->direita = Novo;
                    break;
                }
                else { aux1 = aux1->direita; aux2 = aux1->direita;}
            }
            break;
        }
    }
    return;
}

char Adicionar_Vertice_Arco_Aresta (struct Descritor *G, char opcao, char c, char a, int peso) {
    char res = '0', i = '0', j = '0';
    struct grafo *aux1;
    struct grafo *aux2;
    aux1 = G->ini;
    if (opcao == '1') {        // Opc�o 1: Adicionando V�rtices no Grafo ou D�grafo. //
        while(1) {
            if (aux1->c == c) { break; }
            else if (aux1->baixo == NULL) {
                struct grafo *Novo = (struct grafo*)malloc(sizeof(struct grafo));
                Novo->c = c, Novo->baixo = NULL, Novo->direita = NULL, Novo->peso = -1;
                aux1->baixo = Novo;
                res = '1';
                break;
            }
            else { aux1 = aux1->baixo; }
        }
    }
    else {        // Op��o 2: Adicionando Arcos no D�grafo ou Arestas no Grafo. //
        while (aux1 != NULL) {
            if (aux1->c == c) { i = '1'; }
            if (aux1->c == a) { j = '1'; }
            aux1 = aux1->baixo;
        }
        if ((i == '0') && (j == '0')) {
            printf ("\n Nao foi possivel criar o arco/aresta, pois nao existe vertice '%c' nem vertice '%c'.\n", c, a);
            system("pause");
        }
        else if (i == '0') {
            printf ("\n Nao foi possivel criar o arco/aresta, pois nao existe o vertice '%c'.\n", c);
            system("pause");
        }
        else if (j == '0') {
            printf ("\n Nao foi possivel criar o arco/aresta, pois nao existe o vertice '%c'.\n", a);
            system("pause");
        }
        else if (peso < 0) {
            printf ("\n Nao foi possivel criar o arco/aresta, pois o valor do peso nao e valido (ele deve ser maior ou igual a 0).");
            system("pause");
        }
        else {
            aux1 = G->ini;
            while (aux1->c != c) { aux1 = aux1->baixo; }
            aux2 = aux1->direita;
            while (1) {
                if (aux2 == NULL) {
                    struct grafo *Novo = (struct grafo*)malloc(sizeof(struct grafo));
                    Novo->c = a, Novo->baixo = NULL, Novo->direita = NULL, Novo->peso = peso;
                    aux1->direita = Novo;
                    res = '1';
                    break;
                }
                else if (aux2->c == a) {
                    printf("\n Nao foi possivel criar o arco/aresta, pois na verdade ela ja existe.\n");
                    system("pause");
                    break;
                }
                else { aux1 = aux1->direita; aux2 = aux1->direita; }
            }
        }
    }
    return res;
}

char Remover_Vertice_Arco_Aresta (struct Descritor *G, char opcao, char c, char a) {
    char res = '0';
    struct grafo *aux0;
    struct grafo *aux1;
    struct grafo *aux2;
    struct grafo *aux3;
    aux1 = G->ini;
    if (opcao == '1') {        // Op��o 1: Removendo V�rtices do D�grafo ou Grafo. //
        while (1) {
            if (aux1 == NULL) { break; }
            else if (aux1-> c == c) { res = '1'; break; }
            aux1 = aux1->baixo;
        }
        if ( res == '1' ) {
            aux1 = G->ini;
            while (aux1->c != c) { aux0 = aux1; aux1 = aux1->baixo; }
            if (aux1 == G->ini) { G->ini = aux1->baixo; }
            else {
                aux2 = aux1->baixo;
                aux0->baixo = aux2;
            }
            aux2 = aux1->direita;
            while (1) {
                if (aux2 == NULL) { free(aux2); break; }
                aux3 = aux2->direita;
                aux2->c = NULL, aux2->direita = NULL, aux2->peso = NULL;
                free(aux2);
                aux2 = aux3;
                free(aux3);
            }
            aux1->c = NULL, aux1->direita = NULL, aux1->peso = NULL;
            free(aux1);
            aux1 = G->ini;
            while (aux1 != NULL) {
                aux0 = aux1, aux2 = aux1->direita;
                while (1) {
                    if (aux2 == NULL) { break; }
                    else if (aux2->c == c) {
                        aux3 = aux2->direita;
                        aux0->direita = aux3;
                        aux2->c = NULL, aux2->direita = NULL, aux2->peso = NULL;
                        free(aux2);
                        break;
                    }
                    else { aux0 = aux0->direita, aux2 = aux2->direita; }
                }
                aux1 = aux1->baixo;
            }
        }
    }
    else {        // Op��o 2: Removendo Arcos do D�grafo ou Arestas do Grafo. //
        while (1) {
            if (aux1 == NULL) {
                printf("\n Nao foi possivel remover o arco/aresta, pois nao existe o vertice '%c'.\n", c);
                system("pause");
                break;
            }
            else if (aux1->c == c) {
                aux2 = aux1->direita;
                while (1) {
                    if (aux2 == NULL) {
                        printf("\n Nao foi possivel remover o arco/aresta, pois ou '%c' nao existe, ou, nao existe uma ligacao entre ele e '%c'.\n", a, c);
                        system("pause");
                        break;
                    }
                    else if (aux2->c == a) {
                        aux3 = aux2->direita;
                        if (aux3 == NULL) {
                            aux2->c = NULL, aux2->direita = NULL, aux2->peso = NULL;
                            free(aux2), free(aux3);
                            aux1->direita = NULL;
                        }
                        else {
                            aux2->c = NULL, aux2->direita = NULL, aux2->peso = NULL;
                            free(aux2);
                            aux1->direita = aux3;
                            free(aux3);
                        }
                        res = '1';
                        break;
                    }
                    else { aux1 = aux1->direita; aux2 = aux1->direita; }
                }
                break;
            }
            else { aux1 = aux1->baixo; }
        }
    }
    return res;
}

void Graus (struct Descritor *G, char opcao) {
    struct grafo *aux1;
    struct grafo *aux2;
    struct grafo *aux3;
    int cont;
    char aux;
    system("cls");
    if (opcao == '0') {
         printf("\n Graus do Digrafo\n\n");
         aux1 = G->ini;
         printf(" -> Graus de Entrada:\n");        // calculando os Graus de Entrada do D�grafo. //
         while (aux1 != NULL) {
            cont = 0;
            aux = aux1->c;
            aux2 = G->ini;
            while (aux2 != NULL) {
                aux3 = aux2->direita;
                while (aux3 != NULL) {
                    if (aux3->c == aux) { cont++; }
                    aux3 = aux3->direita;
                }
                aux2 = aux2->baixo;
            }
            printf(" vertice %c: %d\n", aux1->c, cont);
            aux1 = aux1->baixo;
         }
         printf("\n=========================\n\n");
         aux1 = G->ini;
         printf(" -> Graus de Saida:\n");        // calculando os Graus de Sa�da do D�grafo. //
         while (aux1 != NULL) {
            cont = 0;
            aux2 = aux1->direita;
            while (aux2 != NULL) {
                cont++;
                aux2 = aux2->direita;
            }
            printf(" vertice %c: %d\n", aux1->c, cont);
            aux1 = aux1->baixo;
         }
         printf("\n=========================\n");
         system("pause");
    }
    else {
         printf("\n Graus do Grafo\n\n");        // calculando os Graus do Grafo. //
         aux1 = G->ini;
         while (aux1 != NULL) {
            cont = 0;
            aux = aux1->c;
            aux2 = aux1->direita;
            while (aux2 != NULL) {
                cont++;
                aux2 = aux2->direita;
            }
            aux2 = G->ini;
            while (aux2 != NULL) {
                aux3 = aux2->direita;
                while (aux3 != NULL) {
                    if (aux3->c == aux) { cont++; }
                    aux3 = aux3->direita;
                }
                aux2 = aux2->baixo;
            }
            printf(" vertice %c: %d\n", aux1->c, cont);
            aux1 = aux1->baixo;
         }
         printf("\n=========================\n");
         system("pause");
    }
    return;
}

void Ordem_Tamanho (struct Descritor *G, int ordem, char opcao) {
    struct grafo *aux1;
    struct grafo *aux2;
    int cont = 0;
    system("cls");
    printf("\n Ordem e Tamanho\n\n");        // calculando o tamanho do D�grafo/Grafo. //
    aux1 = G->ini;
    while (aux1!= NULL) {
        aux2 = aux1->direita;
        while (aux2 != NULL) {
            cont++;
            aux2 = aux2->direita;
        }
        aux1 = aux1->baixo;
    }
    if (opcao == '0') {
        printf(" -> Ordem do Digrafo: %d\n", ordem);
        printf(" -> Tamanho do Digrafo: %d\n", cont);
    }
    else {
        printf(" -> Ordem do Grafo: %d\n", ordem);
        printf(" -> Tamanho do Grafo: %d\n", cont);
    }
    printf("\n==========================\n");
    system("pause");
    return;
}

void Vertices_Arcos_Arestas (struct Descritor *G, char opcao) {
    struct grafo *aux1;
    struct grafo *aux2;
    char i, j;
    system("cls");
    if (opcao == '0') { printf("\n Vertices do Digrafo:\n\n"); }        // imprimindo os v�rtices do D�grafo/Grafo. //
    else { printf("\n Vertices do Grafo:\n\n"); }
    aux1 = G->ini;
    if (aux1 != NULL) {
        i = aux1->c;
        aux2 = aux1->baixo;
        while (aux2 != NULL) {
            j = aux2->c;
            if (i != j) { printf(" -> %c\n", i); i = j; }
            if (aux2->baixo == NULL) { printf(" -> %c\n", aux2->c); }
            aux2 = aux2->baixo;
        }
    }
    printf("\n=========================\n");
    if (opcao == '0') { printf("\n Arcos do Digrafo:\n\n"); }        // imprimindo os Arcos do D�grafo ou as Arestas do Grafo, e seus pesos. //
    else { printf("\n Arestas do Grafo:\n\n"); }
    while (aux1 != NULL) {
        aux2 = aux1->direita;
        while (aux2 != NULL) {
            if (opcao == '0') { printf(" %c -> %c (peso %d)\n", aux1->c, aux2->c, aux2->peso); }
            else { printf(" %c - %c (peso %d)\n", aux1->c, aux2->c, aux2->peso); }
            aux2 = aux2->direita;
        }
        aux1 = aux1->baixo;
    }
    printf("\n==========================\n");
    system("pause");
    return;
}

void Lacos_Arestas_Multiplas (struct Descritor *G, char opcao) {
    struct grafo *aux1;
    struct grafo *aux2;
    struct grafo *aux3;
    struct grafo *aux4;
    char i, j;
    int cont1 = 0, cont2 = 0;
    system("cls");
    if (opcao == '0') { printf("\n Verificando Lacos:\n\n"); }        // verificando La�os. //
    else { printf("\n Verificando Lacos e Arestas Multiplas:\n\n"); }
    aux1 = G->ini;
    aux3 = G->ini;
    while (aux1 != NULL) {
        i = aux1->c;
        aux2 = aux1->direita;
        while (aux2 != NULL) {
            j = aux2->c;
            if (i == j) {
                cont1++;
                if (opcao == '0') { printf(" laco %d: %c -> %c\n", cont1, i, i); }
                else { printf(" laco %d: %c - %c\n", cont1, i, i); }
            }
            aux2 = aux2->direita;
        }
        aux1 = aux1->baixo;
    }
    if (cont1 == 0) {
        if (opcao == '0') { printf(" Nao ha nenhum laco neste Digrafo.\n"); }
        else { printf(" Nao ha nenhum laco neste Grafo.\n"); }
    }
    else { printf("\n==========================\n"); }
    if (opcao == '1') {        // verificando Arestas M�ltiplas (no caso de Grafo). //
        aux1 = G->ini;
        while (aux1 != NULL) {
            i = aux1->c;
            aux2 = aux1->direita;
            while (aux2 != NULL) {
                j = aux2->c;
                while (aux3 != NULL) {
                    aux4 = aux3->direita;
                    while (aux4 != NULL) {
                        if ((i != j) && (aux3->c == j) && (aux4->c == i)) {
                            cont2++;
                            printf("\n aresta multipla: %c - %c", i, j);
                        }
                        aux4 = aux4->direita;
                    }
                    aux3 = aux3->baixo;
                }
                aux2 = aux2->direita;
                aux3 = G->ini;
            }
            aux1 = aux1->baixo;
        }
        if (cont2 == 0) {
            printf("\n Nao ha arestas multiplas neste Grafo.\n");
            printf("\n==========================\n");
        }
        else { printf("\n"); }
    }
    printf("\n Total de Lacos: %d\n", cont1);
    if (opcao == '1') { printf("\n Total de Arestas Multiplas: %d pares.\n", (cont2/2)); }
    printf("\n==========================\n");
    system("pause");
    return;
}

int Caminho2 (char busca, struct grafo *aux1, int tamanho, int peso, int control) {        // encontra o caminho mais curto entre um v�rtice e a raiz de seu D�grafo, recursivamente. //
    struct grafo *aux2;
    int Aux_Matrix[tamanho];
    int i, j, k;
    char l;
    for (i = 0; i < tamanho; i++) { Aux_Matrix[i] = -1; }
    i = 0;
    aux2 = aux1->direita;
    while (aux2 != NULL) {
        Aux_Matrix[i] = aux2->peso;
        i++;
        aux2 = aux2->direita;
    }
    for (i = 0; i < (tamanho - 1); i++) {        // os caminhos que partem do v�rtice atual s�o organizados em um Array (vetor), em ordem crescente de peso. //
        for (j = (i + 1); j < tamanho; j++) {
            if (Aux_Matrix[j] == (-1)) { break; }
            if (Aux_Matrix[j] < Aux_Matrix[i]) {
                k = Aux_Matrix[i];
                Aux_Matrix[i] = Aux_Matrix[j];
                Aux_Matrix[j] = k;
            }
        }
        if (Aux_Matrix[i] == (-1)) { break; }
    }
    i = 0;
    while (Aux_Matrix[i] != (-1)) {        // seguindo o caminho com menor peso, verificamos se ele nos leva para o v�rtice desejado. //
        aux2 = aux1->direita;
        while (aux2->peso != Aux_Matrix[i]) { aux2 = aux2->direita; }
        if (aux2->c == busca) {
            printf(" 1 -> %c: menor caminho com peso %d\n", busca, (peso + aux2->peso));        // se SIM, imprimimos e retornamos. //
            return(1);
        }
        else {        // se N�O, vemos se esse novo v�rtice nos levar� para o desejado, recursivamente. //
            control++;
            j = aux2->peso, l = aux2->c;
            if ((l != '1') && (l != aux1->c) && (control < tamanho - 1))  {
                aux2 = aux1->baixo;
                while (aux2->c != l) { aux2 = aux2->baixo; }
                k = Caminho2(busca, aux2, tamanho, (peso + j), control);
                if (k == 1) { return(1); }
            }
        }
        i++;        // se o caminho mais curto n�o nos levou para o v�rtice desejado, devemos voltar e pegar o pr�ximo caminho mais curto. //
        control = 1;
    }
    return(0);        // caso n�o seja poss�vel chegar no v�rtice desejado a partir da raiz. //
}

void Caminho1 (struct Descritor *G, int tamanho) {        // para cada v�rtice (n�o raiz) de um D�grafo, essa fun��o chama a fun��o Caminho2() para encontrar o caminho mais curto //
    struct grafo *aux1;                                                        // at� o v�rtice, a partir da raiz. //
    struct grafo *aux2;
    int resp;
    system("cls");
    printf("\n Verificando caminhos (Dijkstra):\n\n");
    printf(" Caminhos:\n");
    aux1 = G->ini;
    aux2 = aux1->baixo;
    while (aux2 != NULL) {
        resp = Caminho2(aux2->c, aux1, tamanho, 0, 1);
        if (resp == 0) { printf(" Nao e possivel chegar ao vertice %c a partir do vertice inicial.\n", aux1->c); }
        aux2 = aux2->baixo;
    }
    printf("\n==================================\n");
    system("pause");
    return;
}

void Aux_Profundidade (struct grafo *aux0, struct grafo *aux1, int tamanho) {        // faz a Busca em Profundidade, recursivamente. //
    struct grafo *aux2;
    struct grafo *aux3;
    static j = 1;
    int i, cont = 0;
    if (tempo == 0) {
        for (i = 0; i < tamanho; i++) {
            Vertices[i] = 'b';        // 'b': branco, 'c': cinza, 'p': preto. //
            Tempos[i][0] = 0;
            Tempos[i][1] = 0;
        }
    }
    i = ((int) aux1->c) - 49;
    if (Vertices[i] == 'b') {        // para cada v�rtice encontrado: //
        Vertices[i] = 'c';
        tempo++;
        Tempos[i][0] = tempo;        // � registrado o tempo de descoberta. //
        aux2 = aux1->direita;
        fprintf(fH, "tempo %d: descoberta do vertice %c.\n", tempo, aux1->c);
        while (aux2 != NULL) {
            if (Vertices[((int) aux2->c) - 49] == 'b') { cont++; }  // e procuramos os v�rtices brancos adjacentes. //
            aux2 = aux2->direita;
        }
        if (cont == 0) {        // caso n�o h� mais nenhum v�rtice branco adjacente, � registrado o seu tempo de finaliza��o. //
            Vertices[i] = 'p';
            tempo++;
            Tempos[i][1] = tempo;
            j++;
            fprintf(fH, "tempo %d: finalizacao do vertice %c.\n", tempo, aux1->c);
        }
        else {
            aux2 = aux1->direita;
            while (aux2 != NULL) {
                if (Vertices[((int) aux2->c) - 49] == 'b') {
                    aux3 = aux0->baixo;
                    while (aux3->c != aux2->c) { aux3 = aux3->baixo; }        // e o processo continua recursivamente. //
                    Aux_Profundidade(aux0, aux3, tamanho);
                }
                aux2 = aux2->direita;
                if (aux2 == NULL) {
                    Vertices[i] = 'p';
                    tempo++;
                    Tempos[i][1] = tempo;
                    j++;
                    fprintf(fH, "tempo %d: finalizacao do vertice %c.\n", tempo, aux1->c);
                }
            }
        }
    }
    if (Tempos[0][1] != 0) {        // caso n�o seja poss�vel alcan�ar todos os v�rtices a partir do v�rtice raiz, � necess�rio encontrar uma nova raiz e come�ar de novo. //
        for (i = 0; i < tamanho; i++) {
            if (Vertices[i] == 'b') {
                aux1 = aux0->baixo;
                while (aux1->c != ((char) i + 49)) { aux1 = aux1->baixo; }
                Aux_Profundidade(aux1, aux1, tamanho);
            }
        }
    }
    return;
}

void Aux_Largura (struct grafo *aux0, struct grafo *aux1, int tamanho, char caso) {        // faz a Busca em Largura, recursivamente. //
    struct grafo *aux2;
    struct grafo *aux3;
    int i, k, cont = 0;
    static int j;
    if (inicio == 0) {
        inicio++;
        if (caso == '0') {
            for (i = 0; i < tamanho; i++) {
                Vertices[i] = 'b';        // 'b': branco, 'c': cinza, 'p': preto. //
                Larguras[i] = (-1);
            }
        }
        Larguras[((int) aux0->c) - 49] = 0;        // a dist�ncia da raiz at� ela mesma � sempre 0. //
        aux2 = aux1->direita;
        while (aux2 != NULL) {
            cont++;
            aux2 = aux2->direita;
        }
        j = cont; cont = 0;
    }
    i = ((int) aux1->c) - 49;
    if (Vertices[i] == 'b') {        // para cada v�rtice encontrado: //
        fprintf(fH, "Descoberta do vertice %c. Distancia dele ate a origem: %d.\n", aux1->c, Larguras[i]);
        Vertices[i] = 'c';
        aux2 = aux1->direita;
        while (aux2 != NULL) {
            if (Vertices[((int) aux2->c) - 49] == 'b')  { cont++; }
            k = ((int) aux2->c) - 49;
            if (Larguras[k] == (-1)) { Larguras[k] = Larguras[i] + 1; }        // a partir dele, cada um dos seus v�rtices adjacentes tem dist�ncia igual � sua + 1. //
            aux2 = aux2->direita;                                                             // no entanto, tamb�m verificamos se esses "filhos" ainda s�o brancos, pois se n�o forem, significa que j� foram //
        }                                                                                                  // visitados antes, logo, t�m dist�ncia igual ou menor do que a sua. //
        if (cont == 0) {
            Vertices[i] = 'p';
            fprintf(fH, "Finalizacao do vertice %c.\n", aux1->c);
        }
        else {
            aux2 = aux1->direita;
            while (aux2 != NULL) {
                k = ((int) aux2->c) - 49;
                if (Vertices[k] == 'b') {
                    aux3 = aux0->baixo;
                    while (aux3->c != aux2->c) { aux3 = aux3->baixo; }
                    Aux_Largura(aux0, aux3, tamanho, '0');        // e o processo continua recursivamente. //
                }
                aux2 = aux2->direita;
            }
            if (aux2 == NULL) {
                Vertices[i] = 'p';
                fprintf(fH, "Finalizacao do vertice %c.\n", aux1->c);
            }
        }
    }
    cont = 0;
    for (i = 0; i < tamanho; i++) { if ((Vertices[i] != 'b') && (Larguras[i] != (-1))) { cont++; } }
    if (cont == (j + 1)) {        // caso n�o seja poss�vel alcan�ar todos os v�rtices a partir do v�rtice raiz, � necess�rio encontrar uma nova raiz e come�ar de novo. //
        for (i = 0; i < tamanho; i++) {
            if (Larguras[i] == (-1)) {
                inicio = 0;
                aux1 = aux0->baixo;
                while (aux1->c != ((char) i + 49)) { aux1 = aux1->baixo; }
                Aux_Largura(aux1, aux1, tamanho, '1');
            }
        }
    }
    return;
}

void Profundidade_Largura (struct Descritor *G, int tamanho) {        // Esta � a fun��o controladora da Busca em Grafos. Ela chama as fun��es de Busca em Profundidade e Busca //
    struct grafo *aux1;                                                                            // em Largura, al�m de abrir o arquivo de texto onde a tabela ser� escrita. //
    aux1 = G->ini;
    int i, aux = 0, cont;
    system("cls");
    printf("\n Busca por Profundidade:\n\n");
    fH = fopen("Profundidade_Largura.txt", "w");
    fprintf(fH, "Busca em Profundidade:\n\n");
    Aux_Profundidade(aux1, aux1, tamanho);
    for (i = 0; i < tamanho; i++) {
        printf(" vertice %d:\n", (i + 1));
        printf(" instante da descoberta: %d\n", Tempos[i][0]);
        printf(" instante da finalizacao: %d\n\n", Tempos[i][1]);
    }
    fprintf(fH, "\nBusca em Largura:\n\n");
    printf("==========================\n");
    printf(" Busca por Largura:\n\n");
    Aux_Largura(aux1, aux1, tamanho, '0');
    while (aux < tamanho) {
        cont = 0;
        for (i = 0; i < tamanho; i++) {
            if (Larguras[i] == aux) { printf(" distancia %d: vertice %d\n", aux, (i + 1)), cont++; }
        }
        if ((cont != 0) && (aux != (tamanho - 1))) { printf("\n"); }
        aux++;
    }
    printf("\n==========================\n");
    fprintf(fH, "\n");
    fclose(fH);
    system("pause");
    return;
}

//  ZagoPedro - 2021  //
