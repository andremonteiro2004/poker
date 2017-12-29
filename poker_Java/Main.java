package poker;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if (MPoker.Jogada.DOIS_PARES.ordinal() > MPoker.Jogada.FLUSH.ordinal()) 
		    System.out.print("ganhou");
		
		new JogarPoker().iniciaJogo();
				

	}

}
