//Pedro Henrique Zago Costa - Estrutura de Dados I - 2020//

#include <locale.h>

#define TRUE 1
#define FALSE 0

int sucess = 0;  // "sucess" verificar� o sucesso da fun��o "SubString_String()" //

struct strdim{                  // Estrutura de Dado String Din�mica //
    char c;
    struct strdim *prox;
};

struct Descritor{           // Estrututa de Dado Descritor //
    struct strdim *ini;
};


void Inicializa_String(struct Descritor *S){   // Inicializa��o da String Din�mica, � a primeira fun��o a ser executada //
    S->ini = NULL;
    return;
}

void Reinicializa_String(struct Descritor *S){   // Reinicializar String //
    struct strdim *aux1, *aux2;
    aux1 = S->ini;
    while(S->ini->prox != NULL){
        aux2 = aux1, aux1 = aux1->prox;
        if(aux1->prox == NULL){               // Libera��o de N�s //
            aux2->prox = NULL;
            free(aux1);
            aux1 = S->ini;
        }
    }
    S->ini = NULL;  // Mais uma vez, a String estar� vazia //
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
        if(aux->prox == NULL){                                                                               // Caso n�o seja o primeiro caractere inserido na String //
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
     while(aux2 != NULL){                      // Passando a String 2 para String 3, uma vez que a String j� foi copiada para String 2 //
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
        if(aux1->prox == NULL){             // Se a quantidade de caracteres removidos da String for maior ou igual ao n�mero total de caracteres dela, ent�o a String � esvaziada (reiniciada) //
                if(S->ini->prox == NULL){
                    S->ini = NULL;
                    break;
                }
                aux2->prox = NULL;  // Remo��o de caractere (n�) //
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
    char sString[20];     //Sub-string que ser� alocada dentro da String //
    int i, j = 0, k = 0;
    for(i = 0; i < 20; i++){sString[i] = '\0';}
    printf("\n Insira a sub-string que deseja inserir na String: ");
    fflush(stdin);
    gets(sString);
    printf("\n Agora insira a partir de que posi��o deseja inserir a sub-string na String\n (vamos considerar que a primeira posi��o � a posi��o 0): ");
    fflush(stdin);
    scanf("%d", &i);
    if(i < 0){
        printf("\n\n %d n�o � um valor v�lido.\n",i);
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
             if(i == 0){Remove_Char_String(S, (j+1)-i);}  // Repare que essa fun��o impossibilita de inserir a sub-string ap�s o final da String //
             else{Remove_Char_String(S, j-i);}               // Estou apenas seguindo a orienta��o do item 9 do enunciado da Atividade Pr�tica //
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
    printf("\n Voc� inseriu uma posi��o al�m do fim da String, assim, n�o foi poss�vel alocar a Sub-string.");
    printf("\n Sugest�o: utilize a op��o 06: concatenar Strings.\n");
    sucess = 0;
    return;
}

int Menor_String(struct Descritor *S, struct Descritor *S2){   // Verifica qual a maior entre String e String 2 //
    setlocale(LC_ALL, "portuguese");
    struct strdim *aux1, *aux2;
    aux1 = S->ini, aux2 = S2->ini;
    while((aux1 != NULL) && (aux2 != NULL)){
        if((aux1->prox == NULL) && (aux2->prox != NULL)){
            printf("\n Sim, a String � menor que a String 2.\n");
            return(TRUE);
        }
        else if((aux1->prox != NULL) && (aux2->prox == NULL)){
            printf("\n N�o, a String � maior que a String 2.\n");
            return(FALSE);
        }
        else if((aux1->prox == NULL) && (aux2->prox == NULL)){
            printf("\n N�o, as Strings tem o mesmo tamanho.\n");
            return(FALSE);
        }
        aux1 = aux1->prox;
        aux2 = aux2->prox;
    }
}

int Igualdade_Strings(struct Descritor *S, struct Descritor *S2){   // Verifica se String e String 2 s�o iguais //
    setlocale(LC_ALL, "portuguese");
    struct strdim *aux1, *aux2;
    aux1 = S->ini, aux2 = S2->ini;
    while((aux1 != NULL) && (aux2 != NULL)){
        if(aux1->c != aux2->c){break;}
        if((aux1->prox == NULL) && (aux2->prox == NULL)){
            printf("\n Sim, as Strings s�o iguais.\n");
            return(TRUE);
        }
        aux1 = aux1->prox, aux2 = aux2 -> prox;
    }
    printf("\n N�o, as Strings n�o s�o iguais.\n");
    return(FALSE);
}

void String_Padrao(struct Descritor *S){   // Verifica se h� (e onde) uma string padr�o dentro da String //
    setlocale(LC_ALL, "portuguese");
    struct strdim *aux;
    aux = S->ini;
    char SPadrao[20];                 // String Padr�o que ser� procurada dentro da String //
    int i, j = 0, pos = 99;
    for(i = 0; i < 20; i++){SPadrao[i] = '\0';}
    printf("\n Insira a String Padr�o que deseja verificar exist�ncia: ");
    fflush(stdin);
    gets(SPadrao);
    i = 0;
    while(aux != NULL){
        if(aux->c == SPadrao[i]){
            if(pos == 99){pos = j;}
            i++;
            if(SPadrao[i] == '\0'){
                printf("\n\n A String Padr�o ");
                printf("\"%s\" ", SPadrao);
                printf("encontra-se na String Din�mica. Ela inicia-se na posi��o %d.\n",pos);
                printf(" (Considerando que a primeira posi��o � a posi��o 0.)\n");
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
    printf("\n\n N�o existe uma String Padr�o ");
    printf("\"%s\" ", SPadrao);
    printf("na String Din�mica.\n");
    return;
}

//Pedro Henrique Zago Costa - Estrutura de Dados I - 2020//
