public class Dama {

	public static void main(String[] args) {
		//Atributos
		String linha = "----";
		char[][] tabuleiro = new char[8][];
		char pecaBranca = 'O';
		char pecaVermelha = 'X';

		//atribuindo 8 colunas em cada linha do tabuleiro
		for (int i = 0; i < tabuleiro.length; i++) {
			tabuleiro[i] = new char[8];
		}

		for (int i = 0; i < tabuleiro.length; i++) {

			for (int aux = 0; aux < tabuleiro.length; aux++) {
				System.out.print(linha);
			}
			System.out.println("-");
			System.out.print("|");
			for (int aux = 0; aux < tabuleiro.length; aux++) {
				
				if ((i == 0 && aux % 2 == 1) || (i == 1 && aux % 2 == 0)) {
					tabuleiro[i][aux] = pecaBranca;
					System.out.print(" " + tabuleiro[i][aux] + " |");
				} else if ((i == 6 && aux % 2 == 1) || (i == 7 && aux % 2 == 0)) {
					tabuleiro[i][aux] = pecaVermelha;
					System.out.print(" " + tabuleiro[i][aux] + " |");
				} else {
					tabuleiro[i][aux] = ' ';
					System.out.print(" " + tabuleiro[i][aux] + " |");
				}
			}
			System.out.println();
		}
		for (int aux = 0; aux < tabuleiro.length; aux++) {
			System.out.print(linha);
		}
		System.out.print("-");
	}
}
