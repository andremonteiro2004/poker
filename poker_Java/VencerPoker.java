package poker;

public class VencerPoker {
	
	private int quantidade = 0;
	private MPoker.Jogada tipoJogada = MPoker.Jogada.NENHUMA;		

	
	
	public VencerPoker(MPoker.Jogada tipo) {
		
		this.tipoJogada = tipo;
		
	}



	public int getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	public MPoker.Jogada getTipoJogada() {
		return tipoJogada;
	}



	public void setTipoJogada(MPoker.Jogada tipoJogada) {
		this.tipoJogada = tipoJogada;
	}



}
