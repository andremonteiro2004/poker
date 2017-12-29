#include <stdio.h>
#include <stdlib.h>



typedef struct Carta {
    char Naipe;
    int Valor;
}carta;

//método que valida uma carta entre seus valores possíveis
/*int validaCarta(carta c) {
    int resultado = 0;

    if(carta.Naipe == 'C' || carta.Naipe == 'O' || carta.Naipe == 'P' || carta.Naipe == 'E') {
        resultado = 1;
        //if(Carta.Valor >= 2 | Carta.Valor <= 9 || Carta.Valor)
    }



    return resultado;
}*/
//método que recebe duas cartas e compara para ver qual a que tem valor mais alto
/*void comparaCarta(carta c1, carta c2){
    if(validaCarta(c1) && validaCarta(c2)) {

    }

}*/

void selecionaJogador(FILE *ch) {

}

void leArquivo() {
    char url[]="pokerK.txt";
	char ch;
	FILE *arq;
	char[20] Cartas, CartasP1, CartasP2;
	int count = 0;

	arq = fopen(url, "r");
	if(arq == NULL)
	    printf("Erro, nao foi possivel abrir o arquivo\n");
	else

	    while( (ch=fgetc(arq))!= EOF ) {
            while( ((ch=fgetc(arq))!= 'P1' | ch!='P2') ) {
                if(ch!= ' ') {
                    Cartas[count] = ch;
                    count++;
                }
            }if(ch == 'P1'){
                CartasP1 = Cartas;
            }else {
                CartasP2 = Cartas;
            }
        }


    fclose(arq);
}

int main()
{
    leArquivo();
    return 0;
}
