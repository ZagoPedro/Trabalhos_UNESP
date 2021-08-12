/*  ZagoPedro - 2021

      Compõem o meu trabalho:
      -> "Grafos.c" (ESTE ARQUIVO): programa escrito por mim em Linguagem C atendendo todas as especificações do trabalho.
      -> "Grafos.h": biblioteca de Estruturas de Dados e Funções, escrita por mim para Linguagem C. Este arquivo necessita desta biblioteca.
      -> "grafo.txt": arquivo de texto representando um Grafo não-orientado, utilizado por mim para testar este código.
      -> "digrafo.txt": arquivo de texto representando um Dígrafo, utilizado por mim para testar este código. */

#include <stdio.h>
#include <stdlib.h>
#include "Grafos.h"

int global_cont = 1;        // contador global de instruções para o registro de logs. //
char tipo;        // se "tipo" = 0: dígrafo.    se "tipo" = 1: grafo. //
char repres;        // se "repres" = 0: matriz de adjacência.    se "repres" = 1: lista de adjacência. //
char leitor[8];         // para ler o arquivo de instruções. //
FILE *f1, *f2, *f3;        // ponteiros de arquivo. //

char print_Menu1 (void) {        // menu de alterações. //
    char aux;
    system("cls");
    printf("\n Menu de Atualizacoes\n\n");
    if (tipo == '0') { printf(" Deseja fazer quais alteracoes no Digrafo?\n"); }
    else { printf(" Deseja fazer quais alteracoes no Grafo?\n"); }
    printf(" 1. Inserir Vertices.\n");
    if (tipo == '0') { printf(" 2. Inserir Arcos.\n"); }
    else { printf(" 2. Inserir Arestas.\n"); }
    printf(" 3. Remover Vertices.\n");
    if (tipo == '0') {printf(" 4. Remover Arcos.\n"); }
    else { printf(" 4. Remover Arestas.\n"); }
    printf(" 5. Nenhuma alteracao (encerrar).\n\n");
    printf(" Sua escolha:  ");
    fflush(stdin);
    scanf("%c", &aux);
    if ((aux != '1') && (aux != '2') && (aux != '3') && (aux != '4') && (aux != '5')) {
        printf("\n\n Por favor, insira uma entrada valida (1 a 5).\n");
        system("pause");
        aux = '0';
    }
    return aux;
}

char print_Menu2 (void) {        // menu de operações. //
    char aux;
    system("cls");
    printf("\n Menu de Operacoes\n\n");
    if (tipo == '0') { printf(" Deseja fazer quais operacoes no Digrafo?\n"); }
    else { printf(" Deseja fazer quais operacoes no Grafo?\n"); }
    printf(" 1. Verificar graus dos vertices.\n");
    printf(" 2. Verificar Ordem e Tamanho.\n");
    if (tipo == '0') { printf(" 3. Listar vertices e arcos.\n"); }
    else { printf(" 3. Listar vertices e arestas.\n"); }
    if (tipo == '0') { printf(" 4. Verificar numero de lacos.\n"); }
    else { printf(" 4. Verificar numero de lacos e arestas multiplas.\n"); }
    if (tipo == '0') { printf(" 5. Verificar caminho (Dijkstra).\n"); }
    else { printf(" 5. Busca (Profundidade e Largura).\n"); }
    if (tipo == '0') { printf(" 6. Busca (Profundidade e Largura).\n"); }
    else { printf(" 6. Nenhuma operacao (encerrar).\n\n"); }
    if (tipo == '0') { printf(" 7. Nenhuma operacao (encerrar).\n\n"); }
    printf(" Sua escolha:  ");
    fflush(stdin);
    scanf("%c", &aux);
    if (tipo == '0') {
        if ((aux != '1') && (aux != '2') && (aux != '3') && (aux != '4') && (aux != '5') && (aux != '6') && (aux != '7')) {
            printf("\n\n Por favor, insira uma entrada valida (1 a 7).\n");
            system("pause");
            aux = '0';
        }
    }
    else {
        if ((aux != '1') && (aux != '2') && (aux != '3') && (aux != '4') && (aux != '5') && (aux != '6')) {
            printf("\n\n Por favor, insira uma entrada valida (1 a 6).\n");
            system("pause");
            aux = '0';
        }
    }
    return aux;
}

int main (void) {
    char nome[15];        // para ler o nome do arquivo de instruções. //
    printf("\n TRABALHO PRATICO FINAL DE ESTRUTURAS DE DADOS 2 - PEDRO HENRIQUE ZAGO COSTA - 2021\n\n");
    printf("\n Primeiro, insira o nome do arquivo de instrucoes (nome.txt): ");
    gets(nome);
    f1 = fopen(nome, "r");        // abrindo o arquivo de instruções. //
    if (f1 == NULL) {
        printf("\n\n Erro ao abrir o arquivo de instrucoes.\n");
        return(1);
    }
    f2 = fopen("logs.txt", "w");        // abrindo o arquivo que escreverá os registros (logs). //
    fprintf(f2, "%d. Abertura do arquivo de instrucoes.\n\n", global_cont); global_cont++;

    struct Descritor D;
    int vertices, aux = 1, aux3;
    char aux1, aux2, aux4, aux5;
    Inicializacao (&D);
    tipo = fgetc(f1);        // verificando se é um Dígrafo ou Grafo. //
    if ((tipo != '0') && (tipo != '1')) {
        printf("\n Entrada invalida no arquivo de instrucoes.\n");
        printf(" Deve-se conter um '0' ou '1' na primeira linha do arquivo.\n");
        return(1);
    }
    fgetc(f1);
    vertices = (int)fgetc(f1) - 48;        // verificando o número de vértices. //
    fgetc(f1);
    while (aux <= vertices) {
        Insercao (&D, (char) aux + 48, '0', -1, '1');        // lendo vértices. //
        aux++;
    }
    aux = 0;
    while ( fgets(leitor, 8, f1) != NULL ) {
        aux1 = (char) leitor[0];
        aux2 = (char) leitor[2];
        if (leitor[4] == '0') { aux3 = ((int) leitor[5]) - 48; }
        else {
            aux3 = ((int) leitor[4] - 48);
            aux3 = (aux3 * 10) + (((int) leitor[5]) - 48);
        }
         Insercao (&D, aux2, aux1, aux3, '2');        // lendo vértices. //
    }
    fprintf(f2, "%d. Leitura de vertices.\n\n", global_cont); global_cont++;
    aux1 = '0', aux2 = '0';
    while (aux2 == '0') {
        while (aux1 == '0') { aux1 = print_Menu1(); }        // atualizações no dígrafo/grafo. //
        switch (aux1) {
        case '1':
            system("cls");
            printf("\n Atualizacao - Adicao de Vertice\n\n");
            printf(" Insira o novo vertice desejado:  ");
            fflush(stdin);
            scanf("%c", &aux4);
            aux4 = Adicionar_Vertice_Arco_Aresta(&D, '1', aux4, '0', -1);
            if (aux4 == '0') {
                printf("\n Nao foi possivel alocar este vertice, pois ja existe outro vertice com esta identificacao (numero).\n ");
                system("pause");
            }
            else {
                if (tipo == '0') { printf("\n Digrafo atualizado com sucesso!\n"); }
                else { printf("\n Grafo atualizado com sucesso!\n"); }
                system("pause");
                vertices++;
                fprintf(f2, "%d. Adicao de vertice.\n\n", global_cont); global_cont++;
            }
            aux1 = '0';
            break;
        case '2':
            system("cls");
            if (tipo == '0') { printf("\n Atualizacao - Adicao de Arco\n\n"); }
            else { printf("\n Atualizacao - Adicao de Aresta\n\n"); }
            if (tipo == '0') { printf(" Informe os dois vertices presentes no Digrafo, que se deseja formar um arco entre eles.\n"); }
            else { printf(" Informe os dois vertices presentes no Grafo, que se deseja formar uma aresta entre eles.\n"); }
            printf (" Informe o primeiro vertice:  ");
            fflush(stdin);
            scanf("%c", &aux4);
            printf ("\n Informe o segundo vertice:  ");
            fflush(stdin);
            scanf("%c", &aux5);
            printf("\n Agora informe o peso entre esses dois vertices:  ");
            fflush(stdin);
            scanf("%d", &aux3);
            aux4 = Adicionar_Vertice_Arco_Aresta(&D, '2', aux4, aux5, aux3);
            if (aux4 == '1') {
                if (tipo == '0') {
                    printf("\n Digrafo atualizado com sucesso!\n");
                    fprintf(f2, "%d. Adicao de arco.\n\n", global_cont); global_cont++;
                }
                else {
                    printf("\n Grafo atualizado com sucesso!\n");
                    fprintf(f2, "%d. Adicao de aresta.\n\n", global_cont); global_cont++;
                }
                system("pause");
            }
            aux1 = '0';
            break;
        case '3':
            system("cls");
            printf("\n Atualizacao - Remocao de Vertice\n\n");
            printf(" Insira o vertice (numero) que se deseja remover:  ");
            fflush(stdin);
            scanf("%c", &aux4);
            aux4 = Remover_Vertice_Arco_Aresta(&D, '1', aux4, '0');
            if (aux4 == '0') {
                printf("\n Nao foi possivel remover este vertice, pois ele nao existe.\n ");
                system("pause");
            }
            else {
                if (tipo == '0') { printf("\n Digrafo atualizado com sucesso!\n"); }
                else { printf("\n Grafo atualizado com sucesso!\n"); }
                system("pause");
                vertices--;
                fprintf(f2, "%d. Remocao de vertice.\n\n", global_cont); global_cont++;
            }
            aux1 = '0';
            break;
        case '4':
            system("cls");
            if (tipo == '0') { printf("\n Atualizacao - Remocao de Arco\n\n"); }
            else { printf("\n Atualizacao - Remocao de Aresta\n\n"); }
            if (tipo == '0') { printf(" Informe os dois vertices do Digrafo, que compoem o arco a ser removido.\n"); }
            else { printf(" Informe os dois vertices do Grafo, que compoem a aresta a ser removida.\n"); }
            printf (" Informe o primeiro vertice:  ");
            fflush(stdin);
            scanf("%c", &aux4);
            printf ("\n Informe o segundo vertice:  ");
            fflush(stdin);
            scanf("%c", &aux5);
            aux4 = Remover_Vertice_Arco_Aresta(&D, '2', aux4, aux5);
            if (aux4 == '1') {
                if (tipo == '0') {
                    printf("\n Digrafo atualizado com sucesso!\n");
                    fprintf(f2, "%d. Remocao de arco.\n\n", global_cont); global_cont++;
                }
                else {
                    printf("\n Grafo atualizado com sucesso!\n");
                    fprintf(f2, "%d. Remocao de aresta.\n\n", global_cont); global_cont++;
                }
                system("pause");
            }
            aux1 = '0';
            break;
        case '5':
            aux2 = '1';
            break;
        }
    }
    f3 = fopen("resultante.txt", "w");        // abrindo o arquivo que escreverá o grafo/dígrafo resultante. //
    if (tipo == '0') { fprintf(f3, "Digrafo Resultante:\n\n"); }
    else { fprintf(f3, "Grafo Resultante:\n\n"); }
    fprintf(f3, "numero de vertices: %d\n\n", vertices);
    if (tipo == '0') { fprintf(f3, "arcos:\n\n"); }
    else { fprintf(f3, "arestas:\n\n"); }        // fechando o arquivo do grafo/dígrafo resultante (por enquanto). //
    fclose(f3);
    PrintResultante(&D);
    aux1 = '0';
    while (aux1 == '0') {        // escolhendo representação por lista de adjacências ou matriz de adjacências. //
        system("cls");
        printf("\n Representacao\n\n");
        if (tipo == '0') { printf(" Deseja representar o Digrafo por:\n"); }
        else { printf(" Deseja representar o Grafo por:\n"); }
        printf(" 1. Lista de Adjacencias.\n");
        printf(" 2. Matriz de Adjacencias.\n");
        printf(" Sua opcao:  ");
        fflush(stdin);
        scanf("%c", &repres);
        if ((repres != '1') && (repres != '2')) {
            printf("\n\n Por favor, insira uma entrada valida (1 ou 2).\n");
            system("pause");
        }
        else { aux1 = '1'; }
    }
    int Matrix[vertices][vertices][2];
    int cont, cont2, vertice;
    if (repres == '2') {
            for (aux = 0; aux < vertices; aux++) {
                for (aux3 = 0; aux3 < vertices; aux3++) {
                    Matrix[aux][aux3][0] = 0;
                    Matrix[aux][aux3][1] = 0;
                }
            }
            aux = 0;
            struct Tupla valores;
            while (1) {
                valores = ReturnNumbers(&D, aux);
                aux++;
                if ((valores.a == -1) || (valores.b == -1)) { break; }
                else {
                    Matrix[valores.a][valores.b][0] = 1;
                    Matrix[valores.a][valores.b][1] = valores.peso;
                }
            }
    }
    fprintf(f2, "%d. Escolha de representacao computacional.\n\n", global_cont); global_cont++;
    aux1 = '0', aux2 = '0';
    while (aux2 == '0') {
        while (aux1 == '0') { aux1 = print_Menu2(); }        // operações no dígrafo/grafo. //
        switch (aux1) {
        case '1':
            if (repres == '1') { Graus(&D, tipo); }
            else {
                system("cls");
                if (tipo == '0') {
                    printf("\n Graus do Digrafo\n\n");
                    vertice = 0;
                    printf(" -> Graus de Entrada:\n");
                    while (vertice < vertices) {
                        cont = 0;
                        for (aux = 0; aux < vertices; aux++) {
                            for (aux3 = 0; aux3 < vertices; aux3++) {
                                if (aux3 == vertice) {
                                    if (Matrix[aux][aux3][0] == 1) { cont++; }
                                }
                            }
                        }
                        printf(" vertice %d: %d\n", vertice + 1, cont);
                        vertice++;
                    }
                    printf("\n=========================\n\n");
                    vertice = 0;
                    printf(" -> Graus de Saida:\n");
                    while (vertice < vertices) {
                        cont = 0;
                        for (aux = 0; aux < vertices; aux++) {
                            if (Matrix[vertice][aux][0] == 1) { cont++; }
                        }
                        printf(" vertice %d: %d\n", vertice + 1, cont);
                        vertice++;
                    }
                }
                else {
                    printf("\n Graus do Grafo\n\n");
                    vertice = 0;
                    while (vertice < vertices) {
                        cont = 0;
                        for (aux = 0; aux < vertices; aux++) {
                            for (aux3 = 0; aux3 < vertices; aux3++) {
                                if (aux == vertice) {
                                    if (Matrix[aux][aux3][0] == 1) { cont++; }
                                }
                                else if (aux3 == vertice) {
                                    if (Matrix[aux][aux3][0] == 1) { cont++; }
                                }
                            }
                        }
                        if (Matrix[vertice][vertice][0] == 1) { cont++; }
                        printf(" vertice %d: %d\n", vertice + 1, cont);
                        vertice++;
                    }
                }
                printf("\n=========================\n");
                system("pause");
            }
            fprintf(f2, "%d. Verificacao dos Graus dos vertices.\n\n", global_cont); global_cont++;
            aux1 = '0';
            break;
        case '2':
            if (repres == '1') { Ordem_Tamanho(&D, vertices, tipo); }
            else {
                system("cls");
                printf("\n Ordem e Tamanho\n\n");
                cont = 0;
                for (aux = 0; aux < vertices; aux++) {
                    for (aux3 = 0; aux3 < vertices; aux3++) {
                        if (Matrix[aux][aux3][0] == 1) { cont++; }
                    }
                }
                if (tipo == '0') {
                    printf(" -> Ordem do Digrafo: %d\n", vertices);
                    printf(" -> Tamanho do Digrafo: %d\n", cont);
                }
                else {
                    printf(" -> Ordem do Grafo: %d\n", vertices);
                    printf(" -> Tamanho do Grafo: %d\n", cont);
                }
                printf("\n==========================\n");
                system("pause");
            }
            fprintf(f2, "%d. Verificacao da Ordem e Tamanho.\n\n", global_cont); global_cont++;
            aux1 = '0';
            break;
        case '3':
            if (repres == '1') { Vertices_Arcos_Arestas(&D, tipo); }
            else {
                system("cls");
                if (tipo == '0') { printf("\n Vertices do Digrafo:\n\n"); }
                else { printf("\n Vertices do Grafo:\n\n"); }
                for (aux = 1; aux <= vertices; aux++) { printf(" -> %d\n", aux); }
                printf("\n=========================\n");
                if (tipo == '0') { printf("\n Arcos do Digrafo:\n\n"); }
                else { printf("\n Arestas do Grafo:\n\n"); }
                for (aux = 0; aux < vertices; aux++) {
                    for (aux3 = 0; aux3 < vertices; aux3++) {
                        if (Matrix[aux][aux3][0] == 1) {
                            if (tipo == '0') { printf(" %d -> %d (peso %d)\n", (aux + 1), (aux3 + 1), Matrix[aux][aux3][1]); }
                            else { printf(" %d - %d (peso %d)\n", (aux + 1), (aux3 + 1), Matrix[aux][aux3][1]); }
                        }
                    }
                }
                printf("\n==========================\n");
                system("pause");
            }
            if (tipo == '0') { fprintf(f2, "%d. Listagem de Vertices e Arcos.\n\n", global_cont); global_cont++; }
            else { fprintf(f2, "%d. Listagem de Vertices e Arestas.\n\n", global_cont); global_cont++; }
            aux1 = '0';
            break;
        case '4':
            if (repres == '1') { Lacos_Arestas_Multiplas(&D, tipo); }
            else {
                system("cls");
                if (tipo == '0') { printf("\n Verificando Lacos:\n\n"); }
                else { printf("\n Verificando Lacos e Arestas Multiplas:\n\n"); }
                cont = 0, cont2 = 0;
                for (aux = 0; aux < vertices; aux++) {
                    for (aux3 = 0; aux3 < vertices; aux3++) {
                        if (aux == aux3) {
                            if (Matrix[aux][aux3][0] == 1) {
                                cont++;
                                if (tipo == '0') { printf(" laco %d: %d -> %d\n", cont, (aux + 1), (aux + 1)); }
                                else { printf(" laco %d: %d - %d\n", cont, (aux + 1), (aux + 1)); }
                            }
                        }
                    }
                }
                if (cont == 0) {
                    if (tipo == '0') { printf(" Nao ha nenhum laco neste Digrafo.\n"); }
                    else { printf(" Nao ha nenhum laco neste Grafo.\n"); }
                }
                else { printf("\n==========================\n"); }
                if (tipo == '1') {
                    for (aux = 0; aux < vertices; aux++) {
                        for (aux3 = 0; aux3 < vertices; aux3++) {
                            if ((aux != aux3) && (Matrix[aux][aux3][0] == 1) && (Matrix[aux3][aux][0] == 1)) {
                                cont2++;
                                printf("\n aresta multipla: %d - %d", (aux + 1), (aux3 + 1), (aux3 + 1), (aux + 1));
                            }
                        }
                    }
                     if (cont2 == 0) {
                        printf("\n Nao ha arestas multiplas neste Grafo.\n");
                        printf("\n==========================\n");
                    }
                    else { printf("\n"); }
                }
                printf("\n Total de Lacos: %d\n", cont);
                if (tipo == '1') { printf("\n Total de Arestas Multiplas: %d pares.\n", (cont2/2)); }
                printf("\n==========================\n");
                system("pause");
            }
            if (tipo == '0') { fprintf(f2, "%d. Verificacao do numero de Lacos.\n\n", global_cont); global_cont++; }
            else { fprintf(f2, "%d. Verificacao do numero de arestas multiplas.\n\n", global_cont); global_cont++; }
            aux1 = '0';
            break;
        case '5':
            if (tipo == '0') { Caminho1(&D, vertices); }
            else { Profundidade_Largura(&D, vertices); }
            if (tipo == '0') { fprintf(f2, "%d. Verificacao de caminho (Dijkstra).\n\n", global_cont); global_cont++; }
            else { fprintf(f2, "%d. Busca por Profundidade e Largura.\n\n", global_cont); global_cont++; }
            aux1 = '0';
            break;
        case '6':
            if (tipo == '0') {
                Profundidade_Largura(&D, vertices);
                fprintf(f2, "%d. Busca por Profundidade e Largura.\n\n", global_cont); global_cont++;
                aux1 = '0';
            }
            else { aux2 = '1'; }
            break;
        case '7':
            aux2 = '1';
            break;
        }
    }

    fprintf(f2, "%d. Fechamento do arquivo de instrucoes.\n\n", global_cont); global_cont++;
    fclose(f1);        // fechando o arquivo de instrucoes. //
    fclose(f2);        // fechando o arquivo de registros (logs). //
    return(0);
}

//  ZagoPedro - 2021  //
