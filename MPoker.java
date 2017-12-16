package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MPoker {
	
static public enum Jogada {
		
		NENHUMA, CARTA_ALTA, UM_PAR, DOIS_PARES, TRINCA, STRAIGHT, FLUSH, FULL_HOUSE, QUADRA, STRAIGHT_FLUSH, ROYAL_FLUSH
	}

	private List<Carta> cartas = null;
	private Jogada jogada = Jogada.NENHUMA;
	
	private Carta.Valor maiorCartadaJogada = null;
	
	
	public MPoker(Carta carta1,Carta carta2,Carta carta3,Carta carta4,Carta carta5) {
	
	
		this.cartas = new ArrayList<Carta>(5);
		
		this.cartas.add(0, carta1);
		this.cartas.add(1, carta2);
		this.cartas.add(2, carta3);
		this.cartas.add(3, carta4);
		this.cartas.add(4, carta5);
			
	}
	
	
	public void ordenarCartas() {
		
		Collections.sort(this.cartas);
		
	}

	
	
	
	public Jogada avaliaJogada(Jogada jogadadoOponente) {
		
		this.setJogada(Jogada.NENHUMA);
		this.maiorCartadaJogada = this.getCartaValor(4);
		
		
		
		
		if ((this.getCartaOrdem(4) - this.getCartaOrdem(0)) == 4) {
			this.setJogada(Jogada.STRAIGHT);
						
			if (this.saodoMesmoNaipe())
			{				
			
				this.setJogada(Jogada.STRAIGHT_FLUSH);
				
				if (this.getCartaValor(0).equals(Carta.Valor.DEZ))
				{
			
					this.setJogada(Jogada.ROYAL_FLUSH);				 				
				}
				
			}
			
		
			this.maiorCartadaJogada = this.getCartaValor(4);
			return this.jogada;
		}
		
		
		if (this.saodoMesmoNaipe()) {
			this.setJogada(Jogada.FLUSH);			
			
			this.maiorCartadaJogada = this.getCartaValor(4);
			return this.jogada;
		}
				
		
		
		if ( (this.getCartaValor(0) == this.getCartaValor(3)) || (this.getCartaValor(1) == this.getCartaValor(4))) {
			
			this.maiorCartadaJogada = this.getCartaValor(3);
			
			if (this.getCartaValor(1) == this.getCartaValor(4))
				this.maiorCartadaJogada = this.getCartaValor(4);
			
			this.setJogada(Jogada.QUADRA);			 
			return this.jogada;
		}

		

		boolean lTrincaInicio = false;
		boolean lTrincaMeio = false;
		boolean lTrincaFim = false;
				
		
	
		lTrincaInicio = (this.getCartaValor(0) == this.getCartaValor(2)); 
		
		if (!lTrincaInicio) {
		
			
			lTrincaMeio = (this.getCartaValor(1) == this.getCartaValor(3));
			
			if (!lTrincaMeio)			
     			
	    		lTrincaFim = (this.getCartaValor(2) == this.getCartaValor(4));
		}
   		
		
		if (lTrincaInicio || lTrincaMeio || lTrincaFim) {
			
			this.setJogada(Jogada.TRINCA);
			
		}
				
		
		
		if (lTrincaInicio) {
			
			this.maiorCartadaJogada = this.getCartaValor(2);
			
			if (this.getCartaValor(3) == this.getCartaValor(4))				
			    this.setJogada(Jogada.FULL_HOUSE);
			
	  
		} else if (lTrincaFim) {
			
			    this.maiorCartadaJogada = this.getCartaValor(3);
			
				if (this.getCartaValor(0) == this.getCartaValor(1))				
				    this.setJogada(Jogada.FULL_HOUSE);
				
		
		} else if (lTrincaFim) {
			
		    this.maiorCartadaJogada = this.getCartaValor(4);
		}
	
		
		if (this.jogada != Jogada.NENHUMA)			
		   return this.jogada;
		
		
		boolean lPar1 = (this.getCartaValor(0) == this.getCartaValor(1));		
		boolean lPar2 = (this.getCartaValor(1) == this.getCartaValor(2));		
		boolean lPar3 = (this.getCartaValor(2) == this.getCartaValor(3));
		boolean lPar4 = (this.getCartaValor(3) == this.getCartaValor(4));
		
		
		if (lPar1 || lPar2 || lPar3 || lPar4) {
			
			
			this.setJogada(Jogada.UM_PAR);
			
			this.maiorCartadaJogada = this.getCartaValor(1);
			if (lPar2)
			    this.maiorCartadaJogada = this.getCartaValor(2);
			else if (lPar3)
				this.maiorCartadaJogada = this.getCartaValor(3);
			else if (lPar4)
				this.maiorCartadaJogada = this.getCartaValor(4);
			
			
			if (lPar1 && lPar3)
				this.setJogada(Jogada.DOIS_PARES);
			else {
				if (lPar1 && lPar4)
					this.setJogada(Jogada.DOIS_PARES);
				else if (lPar2 && lPar4)
					this.setJogada(Jogada.DOIS_PARES);
			}
			

			return this.jogada;
		}
		    
	
		return this.jogada;
		
	}
	
	
	public Carta.Naipe getCartaNaipe(int ncarta) {
		
		return this.cartas.get(ncarta).getNaipe();
	}
	
	public Carta.Valor getCartaValor(int ncarta) {
		
		return this.cartas.get(ncarta).getValor();
	}
	
	public int getCartaOrdem(int ncarta) {
		
		return this.cartas.get(ncarta).getValor().ordinal();
	}
	
	
	public boolean saodoMesmoNaipe() {
		
		Carta.Naipe naipe = null;
		
		for (Carta mycarta : this.cartas) {
			
			if (naipe == null)			
			    naipe = mycarta.getNaipe();
			else if (naipe != mycarta.getNaipe())
				return false;
		}
		
		return true;
	}

	

	public List<Carta> getCartas() {
		return cartas;
	}

		
	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public String toString() {
		
		String c = "";
		for (Carta mycarta : this.cartas) {
			
			c = c + "(" + mycarta.getValor().toString() + " de " + mycarta.getNaipe().toString() + ") ";  
			
		}
		
		return c;
	}


	public Jogada getJogada() {
		return jogada;
	}


	public void setJogada(Jogada jogada) {
		this.jogada = jogada;
	}


	public Carta.Valor getMaiorCartadaJogada() {
		return maiorCartadaJogada;
	}


	public void setMaiorCartadaJogada(Carta.Valor maiorCartadaJogada) {
		this.maiorCartadaJogada = maiorCartadaJogada;
	}
	



}
