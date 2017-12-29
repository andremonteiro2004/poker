package poker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;

public class JogarPoker {
	
	private Jogador jogador1 = null;
	private Jogador jogador2 = null;
	
	private int empates = 0;
	
	public JogarPoker() {
		
	}
	
	
	public void iniciaJogo() {
		
		String nomejogador1 = "Jogador1";
		String nomejogador2 = "Jpgador2";
		
		jogador1 = new Jogador(nomejogador1);
		jogador2 = new Jogador(nomejogador2);
		
		this.carregaArquivo();
						
		
		
		this.avaliaJogadas();

		this.imprimeAvaliacaoJogadas();
		
		
	}
	
	
	public void carregaArquivo() {
		
		
		long startTime = System.currentTimeMillis();
		
		File file = new File("pokerM.txt");
		//RandomAccessFile file = new RandomAccessFile ("poker100M", "rw");
		//FileInputStream fis = null;
		FileReader fis = null;
 
		try {
			//fis = new FileInputStream(file);
			fis = new FileReader(file);
 			
				
			//BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			BufferedReader br = new BufferedReader(fis);
			
			
			 
			String cLinha = "";
			
			int nLinha = 0;
						
			while((cLinha = br.readLine())!= null)
			  {
				
				cLinha = cLinha.replaceAll(" ", "");		
			    this.carregaMaoPocker(cLinha);
			    nLinha = nLinha + 1;
			    
			  }
			
			
			br.close();
				
			
			long endTime = System.currentTimeMillis();
			
			System.out.println("Tempo para carregar o arquivo: "  +  (endTime - startTime) + " millisegundos");
						
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	
	public void carregaMaoPocker(String cLinha) {
		
		MPoker mao = null;
		
		String cMaoJ1 = cLinha.substring(0, 10); 
		mao = criaMaoPoker(cMaoJ1);
		mao.ordenarCartas();
		jogador1.getmaosPocker().add(mao);
				
		String cMaoJ2 = cLinha.substring(10, 20);;
		mao = criaMaoPoker(cMaoJ2);
		mao.ordenarCartas();
		jogador2.getmaosPocker().add(mao);
		
		
	}
	
	
	public MPoker criaMaoPoker(String cMaoPoker) {
	
		char cvalor;
		char cnaipe;
				
		cvalor = cMaoPoker.charAt(0);
		cnaipe = cMaoPoker.charAt(1);
		Carta carta1 = new Carta(cvalor,cnaipe);

		cvalor = cMaoPoker.charAt(2);
		cnaipe = cMaoPoker.charAt(3);
		Carta carta2 = new Carta(cvalor,cnaipe);
		
		cvalor = cMaoPoker.charAt(4);
		cnaipe = cMaoPoker.charAt(5);
		Carta carta3 = new Carta(cvalor,cnaipe);
		
		cvalor = cMaoPoker.charAt(6);
		cnaipe = cMaoPoker.charAt(7);
		Carta carta4 = new Carta(cvalor,cnaipe);
		
		cvalor = cMaoPoker.charAt(8);
		cnaipe = cMaoPoker.charAt(9);
		Carta carta5 = new Carta(cvalor,cnaipe);
		
		MPoker mao = new MPoker(carta1,carta2,carta3,carta4,carta5);
			
		return mao;
		
	}
	
	
	public void avaliaJogadas() {
		
		
		
		long startTime = System.currentTimeMillis();
		
		
		for (int x=0; x < this.jogador1.getmaosPocker().size();x++) {			
			MPoker maoJogador1 = this.jogador1.getmaosPocker().get(x);
			maoJogador1.avaliaJogada(null);			
			
			MPoker maoJogador2 = jogador2.getmaosPocker().get(x);
			maoJogador2.avaliaJogada(maoJogador1.getJogada());
			
			if (maoJogador1.getJogada().ordinal() > maoJogador2.getJogada().ordinal())
				jogador1.contabilizaVitoria(maoJogador1.getJogada());
			else if (maoJogador2.getJogada().ordinal() > maoJogador1.getJogada().ordinal())
				jogador2.contabilizaVitoria(maoJogador2.getJogada());
			
		
			else {
				
				this.empates = this.empates + 1;
				
				int J1maiorCarta1 = maoJogador1.getMaiorCartadaJogada().ordinal();
				int J1maiorCarta2 = maoJogador2.getMaiorCartadaJogada().ordinal();
				
				if (J1maiorCarta1 > J1maiorCarta2) 
					jogador1.contabilizaVitoria(maoJogador1.getJogada());
				if (J1maiorCarta2 > J1maiorCarta1) 
					jogador2.contabilizaVitoria(maoJogador2.getJogada());
									
			}
				
		}

		long endTime = System.currentTimeMillis();		
		System.out.println("Tempo Avaliando as Mãos de Poker:" + (endTime - startTime) + " millisegundos");
	}

	
	public void imprimeAvaliacaoJogadas() {
		
		String c = " \n Quantidade de Vitorias Jogador 1 :";
		
		
		

		c =  c + jogador1.getVitoriasPorJogada();
		
		
		
		System.out.println(c);
		
	}


}
