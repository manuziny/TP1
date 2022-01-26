import java.util.Scanner;
import java.util.Random;

public class TP1 {


    public static void main(String[] args){

        //Declaração de variáveis.
        int opcoes, escolha = 0, quantidadeTemas = 5, jogarNovamente;
		String[][]  temasPalavras = new String[50][50];
        Scanner ler = new Scanner(System.in);
		int [] quantidadePalavras = new int[50];

		//Chamada das funções de povoamente do código:
		temasJaCadastrados(temasPalavras);
		palavrasJaCadastradas(temasPalavras);
		qntdPalavrasIniciada(quantidadePalavras);


            do{
                imprimirMenu();
                opcoes = ler.nextInt();
                
                switch (opcoes) {
                    case 1: 
                        
						do{
							imprimeCasoUm();
                        	escolha = ler.nextInt();
							
							switch(escolha){ //Alternativas internas do caso 1.
								case 1:
									quantidadeTemas = cadastroTemas(temasPalavras,quantidadeTemas);
									break;
								
								case 2:
									quantidadeTemas = excluiTemas(temasPalavras, quantidadeTemas, quantidadePalavras);
									break;

								case 3:
									buscaTemas(temasPalavras, quantidadeTemas);
									break;	
								
								case 4:
									break;
									
							}
                        
						}while(escolha != 4);

                        break;

					case 2:
						
						do{
							imprimeCasoDois();
							escolha = ler.nextInt();

							switch(escolha){ //Alternativas internas do caso 2.
								case 1:
									quantidadePalavras[cadastroPalavras(temasPalavras, quantidadeTemas, quantidadePalavras)]++;
									break;
								case 2:
									quantidadePalavras[excluiPalavras(temasPalavras, quantidadeTemas, quantidadePalavras)]--;
									break;
								case 3:
									buscaPalavras(temasPalavras, quantidadeTemas, quantidadePalavras);
									break;
								case 4:
									listagemPalavras(quantidadeTemas, temasPalavras, quantidadePalavras);
									break;
								case 5:
									break;
							}
	
						}while(escolha != 5);
						
						break;

					case 3:
						do{
							imprimeCasoTres();
							escolha = ler.nextInt();

							switch (escolha){ //Alternativas internas do caso 3.
								case 1:
									do{ //laço para jogar novamente.
										jogar(temasPalavras, quantidadePalavras, quantidadeTemas);
										System.out.println("\nDeseja jogar novamente? \n1) Sim \n2) Nao");
										jogarNovamente = ler.nextInt();
									}while(jogarNovamente == 1);
									break;
							
								default:
									break;
							}
							
						}while(escolha != 2);
						
						break;

					default:
						break;
                }

            }while(opcoes != 4);
        
    }

	//povoamento de temas.
	public static void temasJaCadastrados(String[][] temasPalavras){
		temasPalavras[1][0] = "Animais";
		temasPalavras[2][0] = "Carros";
		temasPalavras[3][0] = "Arvores";
		temasPalavras[4][0] = "Nomes";
		temasPalavras[5][0] = "Cidades";
	}

	//inicialização das palavras nos temas, atribuindo valor.
	public static void qntdPalavrasIniciada(int quantidadePalavras[]){
		for(int i = 0; i <= 5; i++){
			quantidadePalavras[i] = 10;
		}
	}

	//palavras cadastradas nos temas.
	public static void palavrasJaCadastradas(String[][] temasPalavras){
		for(int i = 1; i <= 10; i++){
			temasPalavras[1][i] = "Macaco"+ i;
		}

		for(int i = 1; i <= 10; i++){
			temasPalavras[2][i] = "Fusca"+ i;
		}

		for(int i = 1; i <= 10; i++){
			temasPalavras[3][i] = "Pinho"+ i;
		}

		for(int i = 1; i <= 10; i++){
			temasPalavras[4][i] = "Arthur"+ i;
		}

		for(int i = 1; i <= 10; i++){
			temasPalavras[5][i] = "Pindamanhagaba"+ i;
		}


	}

	//Impressão do menu principal ao usuário.
    public static void imprimirMenu(){
        System.out.println("\nSeja bem vindo!");
        System.out.print("\n1) Gerenciar temas");
        System.out.print("\n2) Gerenciar Palavras");
        System.out.print("\n3) Jogar");
        System.out.print("\n4) Sair");
        System.out.print("\n");
    }

	//Impressão das alternativas do caso um ao usuário.
    public static void imprimeCasoUm(){ 
        System.out.println("\nGerenciar temas");
        System.out.println("(1) Cadastro de temas");
        System.out.println("(2) Exclusão");
        System.out.println("(3) Busca");
		System.out.println("(4) Voltar ao menu principal");
    }

	//Impressão das alternativas do caso dois ao usuário.
	public static void imprimeCasoDois(){
		System.out.println("\nGerenciar palavras");
		System.out.println("(1) Cadastro de Palavras");
        System.out.println("(2) Exclusão");
        System.out.println("(3) Busca");
		System.out.println("(4) Listagem de palavras");
		System.out.println("(5) Voltar ao menu principal");
	}

	//Impressão das alternativas do caso três ao usuário.
	public static void imprimeCasoTres(){
		System.out.println("\n1) Iniciar o jogo");
		System.out.println("2) Voltar ao menu principal");
	}

	//método para cadastrar os temasPalavras no programa.
    public static int cadastroTemas(String[][] temasPalavras, int quantidadeTemas ){
		Scanner ler = new Scanner(System.in);
		String verificaTema;
		System.out.println("\nInsira o nome do tema: "); 
		verificaTema = ler.nextLine();
		
		//laço para verificar se há temasPalavras com nomes iguais, casou houver, há a solicitação de um novo tema.
		for(int j = 0; j < quantidadeTemas; j++){
			while(verificaTema.equalsIgnoreCase(temasPalavras[j][0])){
				System.out.println("\nEsse tema já existe. Digite outro tema: ");
				verificaTema = ler.nextLine();
			}
		}

		quantidadeTemas++;
		temasPalavras[quantidadeTemas][0] = verificaTema;
		return quantidadeTemas;

    }

	//método para excluir os temasPalavras cadastrados desde que não tenham palavras.
	public static int excluiTemas(String[][] temasPalavras, int quantidadeTemas, int quantidadePalavras []){
		Scanner ler = new Scanner(System.in);
		String tema;

		System.out.println("\nDigite o tema que deseja excluir: ");
		tema = ler.nextLine();

		for(int i = 0; i <= quantidadeTemas; i++){ //exclusão do tema.
			if(tema.equalsIgnoreCase(temasPalavras[i][0])){
				if(temasPalavras[i][1] == null){
					for(int cont = 0; cont < quantidadeTemas; cont++){
						temasPalavras[i][0] = temasPalavras[i+1][0];
					}
				}else{ //impede se houver palavras.
					System.out.println("\nNão foi possível excluir o tema. Verifique se existem palavras cadastradas nesse tema");
					return quantidadeTemas;
				}
			}
		}
		
		quantidadeTemas--;
		return quantidadeTemas;
	}

	//método para busca de temasPalavras dentro do programa.
	public static void buscaTemas(String[][] temasPalavras, int quantidadeTemas){
		Scanner ler = new Scanner(System.in);
		String tema;
		int busca = 0;

		System.out.println("\nDigite o tema que deseja pesquisar: "); 
		tema = ler.nextLine();

		for(int i = 0; i <= quantidadeTemas; i++){ //printa o tema.
			if(tema.equalsIgnoreCase(temasPalavras[i][0])){
				System.out.println("\nEsse foi o nome pesquisado: " + temasPalavras[i][0]);
				busca = 0;
				break;
			}else{
				busca++;
			}
		}

		if(busca != 0){ //condicional para caso o tema não existir.
			busca = 0;
			System.out.println("\nTema não encontrado!");
		}
	}
	
	//método para cadastrar as palavras em um determinado tema.
	public static int cadastroPalavras(String[][] temasPalavras, int quantidadeTemas, int quantidadePalavras[]){
		Scanner ler = new Scanner(System.in);
		String palavra = new String();
		String verificaTema;
		int j = 0;
		int i = 0;
		int retornaTema = 0;
		int retornaPalavra = 0;

		System.out.println("\nInsira o nome do tema que deseja adicionar a palavra: "); 
		verificaTema = ler.nextLine();
		
		for(i = 0; i <= quantidadeTemas; i++){ //Verficação se o tema existe, caso exista insere-se a palavra.
			if(verificaTema.equalsIgnoreCase(temasPalavras[i][0])){
				retornaTema = i;
				retornaPalavra = quantidadePalavras[i] + 1;
				System.out.println("\nDigite a palavra que deseja cadastrar: ");
				palavra = ler.nextLine();

				for(j = 0; j <= quantidadePalavras[i]; j++){ //Verifica se há uma palavra igual e se houver pede outra palavra.
					while(palavra.equalsIgnoreCase(temasPalavras[i][j])){
						System.out.println("\nEsse palavra já existe. Digite outra palavra: ");
						palavra = ler.nextLine();
					}
				}
				 
			}
		}

		temasPalavras[retornaTema][retornaPalavra] = palavra;
		return retornaTema;
    }
	
	//método para excluir palavras em um tema, caso ele exista.
	public static int excluiPalavras(String[][] temasPalavras, int quantidadeTemas, int quantidadePalavras[]){
		Scanner ler = new Scanner(System.in);
		String tema;
		String palavra;
		int i = 0;
		int retornaTema = 0;
		int perdido = 0;

		System.out.println("\nDigite o tema que deseja excluir a palavra: ");
		tema = ler.nextLine();

		for(i = 0; i <= quantidadeTemas; i++){ //Verificação se o tema existe.
			if(tema.equalsIgnoreCase(temasPalavras[i][0])){
				retornaTema = i;
				System.out.println("\nDigite a palavra que deseja excluir: ");
				palavra = ler.nextLine();

				for(int cont = 1; cont <= quantidadePalavras[i]; cont++){ //exclusão da palavra.
					if(palavra.equalsIgnoreCase(temasPalavras[i][cont])){
						temasPalavras[i][cont] = null;
						for(int j = cont; j <= quantidadePalavras[i]; j++){
							temasPalavras[retornaTema][j] = temasPalavras[retornaTema][j+1];
						}
						perdido = 0;
					}else{
						perdido++;
					}
				}
			}
		}
		if(perdido != 0){ //verificacao para caso a palavra não exista.
			System.out.println("\nPalavra não encontrada!");
		}
		return retornaTema;
	}

	//método para buscar a palavra, caso exista, printa-se a palavra e o tema no qual está inserida.
	public static void buscaPalavras(String[][] temasPalavras, int quantidadeTemas, int quantidadePalavras[]){
		Scanner ler = new Scanner(System.in);
		String palavra;
		int busca = 0, i = 0, j = 0;

		System.out.println("\nDigite a palavra que deseja pesquisar: ");
		palavra = ler.nextLine();

		for(i = 0; i <= quantidadeTemas; i++){ //verificacao se a palavra existe.
			for(j = 0; j <= quantidadePalavras[i]; j++){
				if(palavra.equalsIgnoreCase(temasPalavras[i][j])){
					System.out.println("\nPalavra encontrada no tema: " + temasPalavras[i][0] + ", " + temasPalavras[i][j]);
					busca = 0;
					break;
				}else{
					busca++;
				}
			}
			if(busca == 0){
				break;
			}
		}

		if(busca != 0){ //condicional para caso a palavra não existir.
			busca = 0;
			System.out.println("\nPalavra não encontrada!");
		}
	}

	//método de impressão de todas as palavras contidas em um determinado tema.
	public static void listagemPalavras(int quantidadeTemas, String temasPalavras[][], int quantidadePalavras[]){
		Scanner ler = new Scanner(System.in);
		String tema;
		int buscaPalavra = 0, i = 0, j = 0, buscaTema = 0;

		System.out.println("\nDigite o tema que deseja listar as palavras: ");
		tema = ler.nextLine();

		for(i = 0; i <= quantidadeTemas; i++){ //verifica a existencia do tema.
			if(tema.equalsIgnoreCase(temasPalavras[i][0])){
				buscaTema = 0;
				for(j = 1; j <= quantidadePalavras[i]; j++){
					System.out.println("\n" + temasPalavras[i][j]);
					buscaPalavra = 1;
				}
				break;
				
			}else{
				buscaTema++;
			}
		}

		if(buscaTema != 0){ //condicional para caso o tema nao existir.
			buscaTema = 0;
			System.out.println("\nTema não encontrado!");
			return;
		}

		else if(buscaPalavra == 0){ //condicional para caso o tema não tenha palavras.
			System.out.println("\nPalavras não encontradas!");
		}
	}

	//método para jogar o jogo.
	public static void jogar(String temasPalavras[][], int quantidadePalavras[], int quantidadeTemas){
		Random palavraJogada = new Random();
		String tema, palavra = "20";
		char digito;
		char [] letrasDigitadas = new char[50];
		char [] digitoPalavra = new char[50];
		Scanner ler = new Scanner(System.in);
		int i = 0, j = 0, buscaTema = 0, erro = 0, certo = 0, cont = 0, tamanhoPalavra = 0, palavraUsada = 0;

		System.out.println("\nSelecione o tema em que deseja jogar: ");
		System.out.println("Lembre-se que você tem apenas 5 erros :)");
		tema = ler.nextLine();

		for(i = 0; i <= quantidadeTemas; i++){
			buscaTema = 1;
			if(tema.equalsIgnoreCase(temasPalavras[i][0])){
				if(quantidadePalavras[i] == 0){ //condicional para caso o tema não tenha palavras.
					System.out.println("\nO tema não tem palavras");
					return;
				}
				palavraUsada = palavraJogada.nextInt(quantidadePalavras[i]); //aleatoriza as palavras num tema.
				if(palavraUsada == 0){
					palavraUsada++;
				}
				
				palavra = temasPalavras[i][palavraUsada]; //atribuição da palavra no tema selecionado.
				buscaTema = 0;
				break;
			}else{
				buscaTema++;
			}	
		}

		if(buscaTema == 0){ //verificacao se o tema existe.
			palavra = palavra.toLowerCase();
			digitoPalavra = palavra.toCharArray();
			
			do{ //laco de repeticao para jogar o jogo da forca, contabilizando as palavras e contando acertos e erros.
				System.out.println("\nEscolha uma letra: ");
				digito = ler.next().charAt(0);

				for (i = 0; i <= cont; i++){
					if(digito == letrasDigitadas[i]){ 
						while(digito == letrasDigitadas[i]){ //impede letras repetidas.
							System.out.println("\nLetra já digitada. Digite novamente: ");
							digito = ler.next().charAt(0);
						}
						break;
					}
				}  

				letrasDigitadas[cont] = digito;
				cont++;
				tamanhoPalavra = palavra.length();
				
				if(palavra.contains(Character.toString(digito)) == false){ //contabiliza o erro e avisa o usuário.
					erro++;
					System.out.println("\nVocê errou!");
				}

				for(j = 0; j < tamanhoPalavra; j++){ 
					if(digito == digitoPalavra[j]){ //contabiliza o acerto e avisa o usuário.
						certo++;
						System.out.println("\nVocê acertou!");
					}
				}

				if(erro > 5){ //caso os erros sejam maiores que 5 notifica a perda da partida.
					System.out.println("Você perdeu!");
					break;
				}

			}while(certo < tamanhoPalavra);
			if(certo == tamanhoPalavra){ //felicitacoes por ter ganho o jogo caso os acertos sejam do tamanho da palavra previamente sorteada.
				System.out.println("Parabéns! Você acertou a palavra!");
			}
			
		}else{ //impressao caso o tema não exista.
			System.out.println("\nTema não encontrado!");
		}
	}
}

	