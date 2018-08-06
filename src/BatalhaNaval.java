
import java.io.Console;
import java.util.Scanner;

public class BatalhaNaval {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		java.util.Random geradorNum = new java.util.Random();
		char[][] tabuleiroJogador = new char[11][11];
		char[][] tabuleiroComputador = new char[11][11];
		String linha = "---------------------------------------------";
		String posY = " ABCDEFGHIJ";
		String posX = " 0123456789";
		String posNavio = " ";
		String ganhador = "";
		int pontosJogador = 0;
		int pontosComputador = 0;

		//Atribuindo valores nas linhas e colunas do tabuleiro  
		for (int lin = 0; lin < tabuleiroJogador.length; lin++) {
			tabuleiroJogador[lin][0] = posY.charAt(lin);
			tabuleiroComputador[lin][0] = posY.charAt(lin);
		}	
		for (int col = 0; col < tabuleiroJogador.length; col++) {
			tabuleiroJogador[0][col] = posX.charAt(col);
			tabuleiroComputador[0][col] = posX.charAt(col);
		}
		for (int lin = 1; lin < tabuleiroJogador.length; lin++) {
			for (int col = 1; col < tabuleiroJogador.length; col++) {
				tabuleiroJogador[lin][col] = ' ';
				tabuleiroComputador[lin][col] = ' ';
			}
		}

		int qtdNavios = 1;
		while (qtdNavios <= 10) {
			//Imprimindo o tabuleiro
			System.out.println(linha);
			System.out.println("|                  JOGADOR                  |");
			System.out.println(linha + "\n" + linha);
			for (int lin =0; lin < tabuleiroJogador.length; lin++) {
				for (int col = 0; col < tabuleiroJogador.length; col++) {
					System.out.print("| " + tabuleiroJogador[lin][col] + " ");
				}
				System.out.println("|\n" + linha);
			}
			System.out.println("Posicione o " + qtdNavios + "º navio no tabuleiro: ");
			posNavio = teclado.nextLine();
			posNavio = posNavio.toUpperCase();

			if (posY.contains(posNavio.substring(0,1)) 
					&& posX.contains(posNavio.substring(1,2))) {

				for (int lin = 0; lin < tabuleiroJogador.length; lin++) {
					if (tabuleiroJogador[lin][0] == posNavio.charAt(0)) {
						for (int col = 0; col < tabuleiroJogador.length; col++) {
							if (tabuleiroJogador[0][col] == posNavio.charAt(1)) {
								if (tabuleiroJogador[lin][col] == ' ') {
									tabuleiroJogador[lin][col] = 'N';
									qtdNavios++;
								} else {
									System.out.println("Esta posição já foi escolhida !!!");
								}
							} 
						}
					}
				}
			} else {
				System.out.println("Esta posição não existe no tabuleiro!!!");
			}

		}
		//Posicionando navios no tabuleiro do computador
		qtdNavios = 1;
		while (qtdNavios <= 10) {
			int lin = geradorNum.nextInt(10);
			int col = geradorNum.nextInt(10);

			if (tabuleiroComputador[lin][col] == ' ') {
				tabuleiroComputador[lin][col] = 'N';
				qtdNavios++;
			}
		}
		System.out.println("   !!!!!!!!!!!!!!!  Iniciando o Jogo !!!!!!!!!!!!");
		do {
			//Imprimindo o tabuleiro
			System.out.println(linha);
			System.out.println("|          JOGADOR                " + pontosJogador + " pontos |");
			System.out.println(linha + "\n" + linha);
			for (int lin =0; lin < tabuleiroJogador.length; lin++) {
				for (int col = 0; col < tabuleiroJogador.length; col++) {
					System.out.print("| " + tabuleiroJogador[lin][col] + " ");
				}
				System.out.println("|\n" + linha);
			}

			System.out.println("Sua vez de jogar...\n" + "Posição: ");
			posNavio = teclado.nextLine();
			posNavio = posNavio.toUpperCase();

			if (posY.contains(posNavio.substring(0,1)) 
					&& posX.contains(posNavio.substring(1,1))) {

				int lin = posY.indexOf(posNavio.charAt(0));
				int col = posX.indexOf(posNavio.charAt(1));

				if (tabuleiroComputador[lin][col] == 'N') {
					tabuleiroComputador[lin][col] = '*';
					pontosJogador++;
					System.out.println("Computador: Você acertou um navio do inimigo!!!");
				} else if (tabuleiroComputador[lin][col] == ' ') {
					tabuleiroComputador[lin][col] = '-';
					System.out.println("Computador: Boa Tentativa! Mas você não acertou!!!");
				} else {
					System.out.println("Computador: Você ja fez esta tentativa antes!!!");
				}

			} else {
				System.out.println("Esta posição não exixte no tabuleiro!!!");
			}

			System.out.println("\n\nVez do computador jogar...");
			int l = 0;
			int c = 0;
			while (l == 0 || c == 0){
				l = geradorNum.nextInt(10);
				c = geradorNum.nextInt(10);
			}
			System.out.println("Posição: " + posY.charAt(l) + posX.charAt(c));

			if (tabuleiroJogador[l][c] == 'N') {
				tabuleiroJogador[l][c] = '*';
				pontosComputador++;
				System.out.println("Você: acertaram meu navio!!!");
			} else if (tabuleiroJogador[l][c] == ' ') {
				tabuleiroJogador[l][c] = '-';
				System.out.println("Você: Boa Tentativa! Mas não me acertou!!!");
			} else {
				System.out.println("Você: ja fez esta tentativa antes!!!");
			}

			if (pontosJogador == 10) {
				ganhador = "Você";
			} else if (pontosComputador == 10) {
				ganhador = "Computador";
			}

		} while (ganhador.isEmpty());

		System.out.println("\n!!! PARABÉNS, " + ganhador + " VENCEU A PARTIDA!!!");
		//Imprimindo o tabuleiro do JOGADOR e COMPUTADOR
		System.out.println(linha);
		System.out.println("|          JOGADOR                " + pontosJogador + "pontos |");
		System.out.println(linha + "\n" + linha);
		for (int lin =0; lin < tabuleiroJogador.length; lin++) {
			for (int col = 0; col < tabuleiroJogador.length; col++) {
				System.out.print("| " + tabuleiroJogador[lin][col] + " ");
			}
			System.out.println("|\n" + linha);
		}

		System.out.println(linha);
		System.out.println("|       COMPUTADOR                " + pontosComputador + "pontos |");
		System.out.println(linha + "\n" + linha);
		for (int lin =0; lin < tabuleiroComputador.length; lin++) {
			for (int col = 0; col < tabuleiroComputador.length; col++) {
				System.out.print("| " + tabuleiroComputador[lin][col] + " ");
			}
			System.out.println("|\n" + linha);
		}

		/*tabuleiroJogador[l][c] = posY.charAt(c);
		tabuleiroJogador[1][1] = Character.forDigit(i, 10);
		System.out.print(tabuleiroJogador[1][1] + "|" + tabuleiroJogador[1][2]);*/
	} 
}
