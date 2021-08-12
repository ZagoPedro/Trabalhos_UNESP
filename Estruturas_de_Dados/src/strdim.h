//Pedro Henrique Zago Costa - Estrutura de Dados I - 2020//

#include <locale.h>

#define TRUE 1
#define FALSE 0

int sucess = 0;  // "sucess" verificará o sucesso da função "SubString_String()" //

struct strdim{                  // Estrutura de Dado String Dinâmica //
    char c;
    struct strdim *prox;
};

struct Descritor{           // Estrututa de Dado Descritor //
    struct strdim *ini;
};


void Inicializa_String(struct Descritor *S){   // Inicialização da String Dinâmica, é a primeira função a ser executada //
    S->ini = NULL;
    return;
}

void Reinicializa_String(struct Descritor *S){   // Reinicializar String //
    struct strdim *aux1, *aux2;
    aux1 = S->ini;
    while(S->ini->prox != NULL){
        aux2 = aux1, aux1 = aux1->prox;
        if(aux1->prox == NULL){               // Liberação de Nós //
            aux2->prox = NULL;
            free(aux1);
            aux1 = S->ini;
        }
    }
    S->ini = NULL;  // Mais uma vez, a String estará vazia //
    return;
}

void Imprime_String(struct Descritor *S){   // Imprimir String //
   struct strdim *aux;
    aux = S->ini;
    while(aux != NULL){
        printf("%c", aux->c);
        aux = aux->prox;
    }
    return;
}

void Tamanho_String(struct Descritor *S){   // Ver tamanho de uma String //
    struct strdim *aux;
    aux = S->ini;
    int cont = 0;
    while(aux != NULL){
        cont ++;
        aux = aux->prox;
    }
    printf("\n A String tem %d caracteres.\n", cont);
    return;
}

void Insere_Char_String(struct Descritor *S, char a){   // Inserir caractere em uma String  //
    struct strdim *aux ;
    aux = S->ini;
    while(TRUE){
        if(S->ini == NULL){                                                                                       // Caso seja o primeiro caractere inserido na String //
            struct strdim *Novo = (struct strdim*)malloc(sizeof(struct strdim));
            Novo->c = a, Novo->prox = NULL;
            S->ini = Novo;
            break;
        }
        if(aux->prox == NULL){                                                                               // Caso não seja o primeiro caractere inserido na String //
            struct strdim *Novo = (struct strdim*)malloc(sizeof(struct strdim));
            Novo->c = a, Novo->prox = NULL;
            aux->prox = Novo;
            break;
        }
        else{aux = aux->prox;}
    }
    return;
}

void Copia_String_String2(struct Descritor *S, struct Descritor *S2){   // Copia a String para a String 2 //
    struct strdim *aux;
    aux = S->ini;
    while(aux != NULL){
        Insere_Char_String(S2, aux->c);
        aux = aux->prox;
    }
    printf("\n Resultado: String2 = \"");
    Imprime_String(S2);
    printf("\"");
    return;
}

void Concatena_Strings(struct Descritor *S, struct Descritor *S2, struct Descritor *S3){   // Concatena a String e a String 2 e coloca o resultado na String 3 //
    struct strdim *aux1, *aux2;
    aux1 = S->ini, aux2 = S2->ini;
     while(aux1 != NULL){                      // Passando a String para String 3 //
        Insere_Char_String(S3, aux1->c);
        aux1 = aux1->prox;
    }
     while(aux2 != NULL){                      // Passando a String 2 para String 3, uma vez que a String já foi copiada para String 2 //
        Insere_Char_String(S3, aux2->c);
        aux2 = aux2->prox;
    }
    printf("\n Resultado: String3 = \"");
    Imprime_String(S3);
    printf("\"");
    return;
}

void Remove_Char_String(struct Descritor *S, int b){   // Remove uma quantidade de caracteres da String //
    struct strdim *aux1, *aux2;
    aux1 = S->ini, aux2 = aux1;
    while((b > 0) && (aux1 != NULL)){
        if(aux1->prox == NULL){             // Se a quantidade de caracteres removidos da String for maior ou igual ao número total de caracteres dela, então a String é esvaziada (reiniciada) //
                if(S->ini->prox == NULL){
                    S->ini = NULL;
                    break;
                }
                aux2->prox = NULL;  // Remoção de caractere (nó) //
                free(aux1);
                aux1 = S->ini;
                b--;
        }
        else{
                aux2 = aux1,  aux1 = aux1->prox;
        }
    }
    return;
}

void SubString_String(struct Descritor *S){   // Insere uma sub-string na String //
    setlocale(LC_ALL, "portuguese");
    struct strdim *aux;
    aux = S->ini;
    char sString[20];     //Sub-string que será alocada dentro da String //
    int i, j = 0, k = 0;
    for(i = 0; i < 20; i++){sString[i] = '\0';}
    printf("\n Insira a sub-string que deseja inserir na String: ");
    fflush(stdin);
    gets(sString);
    printf("\n Agora insira a partir de que posição deseja inserir a sub-string na String\n (vamos considerar que a primeira posição é a posição 0): ");
    fflush(stdin);
    scanf("%d", &i);
    if(i < 0){
        printf("\n\n %d não é um valor válido.\n",i);
        sucess = 0;
        return;
    }
    while(aux != NULL){
        if(j == i){
            while(sString[k] != '\0'){k++;}
            while(aux != NULL){
                sString[k] = aux->c;
                aux = aux->prox;
                k++, j++;
            }
             if(i == 0){Remove_Char_String(S, (j+1)-i);}  // Repare que essa função impossibilita de inserir a sub-string após o final da String //
             else{Remove_Char_String(S, j-i);}               // Estou apenas seguindo a orientação do item 9 do enunciado da Atividade Prática //
             aux = S->ini, i=0;
             while(sString[i] != '\0'){
                Insere_Char_String(S, sString[i]);
                i++;
                sucess++;
             }
             return;
        }
        aux = aux->prox;
        j++;
    }
    printf("\n Você inseriu uma posição além do fim da String, assim, não foi possível alocar a Sub-string.");
    printf("\n Sugestão: utilize a opção 06: concatenar Strings.\n");
    sucess = 0;
    return;
}

int Menor_String(struct Descritor *S, struct Descritor *S2){   // Verifica qual a maior entre String e String 2 //
    setlocale(LC_ALL, "portuguese");
    struct strdim *aux1, *aux2;
    aux1 = S->ini, aux2 = S2->ini;
    while((aux1 != NULL) && (aux2 != NULL)){
        if((aux1->prox == NULL) && (aux2->prox != NULL)){
            printf("\n Sim, a String é menor que a String 2.\n");
            return(TRUE);
        }
        else if((aux1->prox != NULL) && (aux2->prox == NULL)){
            printf("\n Não, a String é maior que a String 2.\n");
            return(FALSE);
        }
        else if((aux1->prox == NULL) && (aux2->prox == NULL)){
            printf("\n Não, as Strings tem o mesmo tamanho.\n");
            return(FALSE);
        }
        aux1 = aux1->prox;
        aux2 = aux2->prox;
    }
}

int Igualdade_Strings(struct Descritor *S, struct Descritor *S2){   // Verifica se String e String 2 são iguais //
    setlocale(LC_ALL, "portuguese");
    struct strdim *aux1, *aux2;
    aux1 = S->ini, aux2 = S2->ini;
    while((aux1 != NULL) && (aux2 != NULL)){
        if(aux1->c != aux2->c){break;}
        if((aux1->prox == NULL) && (aux2->prox == NULL)){
            printf("\n Sim, as Strings são iguais.\n");
            return(TRUE);
        }
        aux1 = aux1->prox, aux2 = aux2 -> prox;
    }
    printf("\n Não, as Strings não são iguais.\n");
    return(FALSE);
}

void String_Padrao(struct Descritor *S){   // Verifica se há (e onde) uma string padrão dentro da String //
    setlocale(LC_ALL, "portuguese");
    struct strdim *aux;
    aux = S->ini;
    char SPadrao[20];                 // String Padrão que será procurada dentro da String //
    int i, j = 0, pos = 99;
    for(i = 0; i < 20; i++){SPadrao[i] = '\0';}
    printf("\n Insira a String Padrão que deseja verificar existência: ");
    fflush(stdin);
    gets(SPadrao);
    i = 0;
    while(aux != NULL){
        if(aux->c == SPadrao[i]){
            if(pos == 99){pos = j;}
            i++;
            if(SPadrao[i] == '\0'){
                printf("\n\n A String Padrão ");
                printf("\"%s\" ", SPadrao);
                printf("encontra-se na String Dinâmica. Ela inicia-se na posição %d.\n",pos);
                printf(" (Considerando que a primeira posição é a posição 0.)\n");
                return;
            }
        }
        else{
            if(i > 0){i = 0;}
            if(pos != 99){pos = 99;}
            if(aux->c == SPadrao[i]){
                if(pos == 99){pos = j;}
                i++;
            }
        }
        aux = aux->prox;
        j++;
    }
    printf("\n\n Não existe uma String Padrão ");
    printf("\"%s\" ", SPadrao);
    printf("na String Dinâmica.\n");
    return;
}

//Pedro Henrique Zago Costa - Estrutura de Dados I - 2020//
