package poker;

import poker.Carta.Naipe;
import poker.Carta.Valor;

public class Carta implements Comparable<Carta> {
	
	public enum Naipe {
	    PAUS, COPAS, OUROS, ESPADA 
	}
	
	public enum Valor {
		
	    DOIS, TRES, QUATRO, CINCO, SEIS, SETE, OITO, NOVE, DEZ, VALETE, DAMA, REI, AS
		
	}
	
	
	private Valor valor = null;
    private Naipe naipe = null;		
    
	public Carta(Valor v, Naipe n) {
		
		this.valor = v; 
		this.naipe = n;
		
		// TODO Auto-generated constructor stub
	}
	
	
	public Carta(char cv, char cn) {
		
		this.valor = this.getValorfromChar(cv); 
		this.naipe = this.getNaipefromChar(cn);
		
		// TODO Auto-generated constructor stub
	}


	public Valor getValor() {
		return valor;
	}

	public void setValor(Valor valor) {
		this.valor = valor;
	}

	public Naipe getNaipe() {
		return naipe;
	}

	public void setNaipe(Naipe naipe) {
		this.naipe = naipe;
	}
	
	
	
	public Naipe getNaipefromChar(char charnaipe) {
	
		switch (charnaipe) { 
		case 'C': return Naipe.PAUS;  // Club
		case 'H': return Naipe.COPAS; // Hearts
		case 'D': return Naipe.OUROS; // Diamonds
		case 'S': return Naipe.ESPADA; // Spades
		}
		
		return null;
	}
	
	
	public Valor getValorfromChar(char charvalor) {
		
		switch (charvalor) { 
		 
		case '2': return Valor.DOIS;
		case '3': return Valor.TRES; 
		case '4': return Valor.QUATRO;
		case '5': return Valor.CINCO;
		case '6': return Valor.SEIS;
		case '7': return Valor.SETE;
		case '8': return Valor.OITO;
		case '9': return Valor.NOVE;
		case 'T': return Valor.DEZ;
		case 'J': return Valor.VALETE;
		case 'Q': return Valor.DAMA;
		case 'K': return Valor.REI;
		case 'A': return Valor.AS;
		}
		
		return null;
	}


	@Override
	public int compareTo(Carta cartax) {
		
        if(this.valor.ordinal() > cartax.valor.ordinal()){		
            return 1;
	    }	
        if(this.valor.ordinal() < cartax.valor.ordinal()){	
	         return -1;
	    }	
	    return this.naipe.toString().compareToIgnoreCase(cartax.naipe.toString());
	
	}

	
}
	

