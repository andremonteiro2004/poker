package poker;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	
	private String nome = "";	
	private List<MPoker> maosPocker = null;
	
	private VencerPoker[] vitorias = new VencerPoker[10];
	private int vitorias_total = 0;
	
		
	public Jogador(String nome) {
		
		
		this.nome = nome;
		
		this.maosPocker = new ArrayList<MPoker>();
		
		vitorias = new VencerPoker[11];		
		vitorias[0] = new VencerPoker(MPoker.Jogada.NENHUMA);
		vitorias[1] = new VencerPoker(MPoker.Jogada.CARTA_ALTA);
		vitorias[2] = new VencerPoker(MPoker.Jogada.UM_PAR);
		vitorias[3] = new VencerPoker(MPoker.Jogada.DOIS_PARES);
		vitorias[4] = new VencerPoker(MPoker.Jogada.TRINCA);
		vitorias[5] = new VencerPoker(MPoker.Jogada.STRAIGHT);
		vitorias[6] = new VencerPoker(MPoker.Jogada.FLUSH);
		vitorias[7] = new VencerPoker(MPoker.Jogada.FULL_HOUSE);
		vitorias[8] = new VencerPoker(MPoker.Jogada.QUADRA.QUADRA);
		vitorias[9] = new VencerPoker(MPoker.Jogada.STRAIGHT_FLUSH);
		vitorias[10] = new VencerPoker(MPoker.Jogada.ROYAL_FLUSH);
	}
	
	
	public void contabilizaVitoria(MPoker.Jogada tipoJogada) {
	
		VencerPoker vit = this.vitorias[tipoJogada.ordinal()];				
		vit.setQuantidade(vit.getQuantidade() + 1);
		
		this.vitorias_total++;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<MPoker> getmaosPocker() {
		return maosPocker;
	}

	public void setJogadas(List<MPoker> maosPocker) {
		this.maosPocker = maosPocker;
	}
	

	public String getVitoriasPorJogada() {
		
		String c = this.vitorias_total + "\n";	
				
		return c;
	}
	


}
