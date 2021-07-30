package intro;
import java.util.Scanner;
import java.lang.String;

		
public class tp1_oo {
	//Classe respon�vel pelas a��es relacionadas aos clientes
	public static class Clientes{
		static int quantidadeClientes;
		static String numeroDoCliente;
		static Scanner ler = new Scanner(System.in);
		static String[] nomeClientes = new String[100];
		static String[] enderecoClientes = new String[100];
		static String[] numerosClientes = new String[100];
		static int numerodeClientes=0;
		static boolean encontrou = false;
		//M�todo para criar os 10 clientes e seus dados ja carregados
		public static void clientesPreCadastrados() {
			for(int i = 0; i <10 ; ++i){
				nomeClientes[numerodeClientes] = "Cliente"+ i;
				enderecoClientes[numerodeClientes]="Endereco"+(i);
				numerosClientes[numerodeClientes]="N�mero"+(i);
				numerodeClientes=numerodeClientes+1;}
		}
		//M�todo respons�vel por cadastrar novos clientes
		public static void cadastrarCliente() {
			
			System.out.printf("Quantos clientes deseja cadastrar? \n");
			quantidadeClientes = ler.nextInt();
			System.out.printf("--------------- CADASTRO DE CLIENTE ----------------- \n");
			ler.nextLine();
			
			for(int i = 0; i < quantidadeClientes; ++i){
					System.out.printf("Insira o nome do cliente: \n");
					
					nomeClientes[numerodeClientes] = ler.nextLine();

					
					System.out.printf("Insira o endere�o do cliente: \n");
					
					enderecoClientes[numerodeClientes] = ler.nextLine();
					
					System.out.printf("Insira o telefone do cliente: \n");
					
					numerosClientes[numerodeClientes]= ler.nextLine();
					System.out.printf("Usu�rio cadastrado com sucesso!\n"); 
					
					numerodeClientes=numerodeClientes+1;
					
					}}
		//Procura o cliente, caso encontrado da a op��o de mudar dados cadastrados
		public static void procurarCliente() {
			char simounao;
			String nomeProcura;
			System.out.printf("Qual o nome que deseja procurar?\n");
			nomeProcura = ler.nextLine();
			
			
			for( int i = 0; i < numerodeClientes; ++i){
				//Dentre os cadastrados, se algum for igual, printa os seus dados
				if(nomeClientes[i].equals(nomeProcura)) {
					encontrou = true;
					System.out.printf("Nome: %s\n", nomeClientes[i]);
					System.out.printf("Endere�o: %s\n", enderecoClientes[i]);
					System.out.printf("N�mero: %s\n", numerosClientes[i]);
					System.out.printf("Deseja alterar os dados cadastrados?");
					simounao= ler.next().charAt(0);
					if(simounao=='s'|| simounao=='S') {
						System.out.printf("Nome: ");
						ler.nextLine();
						nomeClientes[i] = ler.nextLine();
						System.out.printf("Endere�o: ");
						enderecoClientes[i] = ler.nextLine();
						System.out.printf("N�mero: ");
						numerosClientes[i] = ler.nextLine();
					}
					}
				}
				if(encontrou==false) {
					System.out.printf("Cliente n�o encontrado!\n");
				}
			
		}
		// Esse m�todo mostra todos os clientes cadastrados para o cadastro de vendas
		public static String mostrarClientes() {
			String clienteVenda;
			for(int i=0; i<numerodeClientes;i++) {
				System.out.printf("%s\n",nomeClientes[i]);
			}
			do {
			System.out.printf("Selecione o cliente: \n");
			clienteVenda=ler.nextLine();
			//Verifica se o cliente digitado est� na lista
			for(int i=0; i<numerodeClientes;i++) {
				if(nomeClientes[i].equals(clienteVenda)) {
					encontrou = true;
			}}
			if(encontrou==false) {
				System.out.printf("Esse cliente n�o est� na lista\n");
			}	
			}while(encontrou==false);
				
			return clienteVenda;
			
		}}
	//Classe criada para realizar as a��es relacionadas aos produtos	
	public static class Produtos{
		static int quantidadeProdutos;
		static int numerodeProdutos=0;
		static String numeroDoCliente;
		static Scanner ler = new Scanner(System.in);
		static String[] nomeProdutos = new String[100];
		static String[] descricaoProdutos = new String[100];
		static Double[] valorProdutos = new Double[100];
		static Double[] porcentagem = new Double[100];
		static int[] quantidadeEstoque = new int[100];
	//cadastro dos 10 primeiros produtos
		public static void produtosPreCadastrados() {
			double porcentagemPraCadastro=0;
			for(int i = 0; i <10 ; ++i){
				porcentagemPraCadastro=porcentagemPraCadastro + 0.1;
				nomeProdutos[numerodeProdutos] = "Produto"+ i;
				descricaoProdutos[numerodeProdutos]="Descri��o"+(i);
				valorProdutos[numerodeProdutos]=i+1.5;
				porcentagem[numerodeProdutos]=porcentagemPraCadastro;
				quantidadeEstoque[numerodeProdutos]= i+ 1;
				
				numerodeProdutos=numerodeProdutos+1;}
		}
		
	//M�todo para cadastrar mais produtos	
	public static void cadastrarProdutos() {
		
		System.out.printf("--------------- CADASTRO DE PRODUTOS ----------------- \n");
		
		System.out.printf("Informe a quantidade de produtos que deseja cadastrar.\n");
		quantidadeProdutos=ler.nextInt();
		for(int i = 0; i < quantidadeProdutos; ++i){
			System.out.printf("Nome: \n");
			ler.nextLine();
			nomeProdutos[numerodeProdutos]=ler.nextLine();
			System.out.printf("Descri��o: \n");
			descricaoProdutos[numerodeProdutos]=ler.nextLine();
			System.out.printf("Valor: \n");
			valorProdutos[numerodeProdutos]=ler.nextDouble();
			System.out.printf("Porcentagem: \n");
			porcentagem[numerodeProdutos]=ler.nextDouble();
			System.out.printf("Quantidade no estoque: \n");
			quantidadeEstoque[numerodeProdutos]=ler.nextInt();
			numerodeProdutos=numerodeProdutos+1;
			System.out.printf("Produto cadastrado com sucesso!\n");}
		
	}
	//M�todo para buscar produtos, caso seja encontrado oferece a op��o de mudar os dados cadastrados
	public static void buscarProdutos() {
		char simounao;
		String produtoProcura;
		boolean encontrou=false;
		System.out.printf("Qual o nome do produto que deseja procurar?\n");
		
		produtoProcura = ler.nextLine();
		if(numerodeProdutos==0) {
			System.out.printf("Ainda n�o h� produtos cadastrados!\n");
		}
		for( int i = 0; i < numerodeProdutos; ++i){
			
			if(nomeProdutos[i].equals(produtoProcura)) {
				encontrou = true;
				System.out.printf("Nome: %s\n", nomeProdutos[i]);
				System.out.printf("Descri��o: %s\n", descricaoProdutos[i]);
				System.out.printf("Valor: %.2f\n", valorProdutos[i]);
				System.out.printf("Porcentagem: %.2f\n", porcentagem[i]);
				System.out.printf("Quantidade de estoque: %d\n", quantidadeEstoque[i]);
				System.out.printf("Deseja alterar os dados cadastrados?[s/n]");
				simounao= ler.next().charAt(0);
				if(simounao=='s'|| simounao=='S') {
					System.out.printf("Nome: ");
					ler.nextLine();
					nomeProdutos[i] = ler.nextLine();
					System.out.printf("Descri��o: ");
					descricaoProdutos[i] = ler.nextLine();
					System.out.printf("Porcentagem: ");
					porcentagem[i] = ler.nextDouble();
					System.out.printf("Valor de compra: ");
					valorProdutos[i] = ler.nextDouble();
					System.out.printf("Quantidade de estoque: ");
					quantidadeEstoque[i] = ler.nextInt();
				}
				}
				}
			
			if(encontrou==false) {
				System.out.printf("Produto n�o encontrado!\n");
			}
		
	}
		//Mostra os produtos cadastrado e a quantidade de estoque 
		public static void mostrarProdutos() {
			System.out.printf("Os produtos cadastrados s�o: \n");
			if(numerodeProdutos==0) {
				System.out.printf("Ainda n�o h� produtos cadastrados.\n");
			}
			else {
			for( int i = 0; i < numerodeProdutos; ++i){
				System.out.printf("%d.%s",i+1,nomeProdutos[i]);
				System.out.printf("- %d\n",quantidadeEstoque[i]);
			}
		}
	
	}
		//M�todo para cadastro de venda, chama o m�todo mostrarClientes que retorna qual cliente deseja comprar o produto
		public static void cadastrarVenda() {
			int opcao;
			String produtoVenda;
			String clienteVenda= Clientes.mostrarClientes();
			int vendidos;
			boolean encontrou=false;
			System.out.printf("Produtos: \n");
			//Printa na tela todos os produtos cadastrados
			for( int i = 0; i < numerodeProdutos; ++i){
				System.out.printf("%s\n",nomeProdutos[i]);
				
			}
			do {
			// Faz um peqqueno menu em que o usu�rio responde se ainda quer cadastrar produtos para o cliente, caso queira repete at� o usu�rio digitar o numero 1(nao)
			System.out.printf("Quer cadastrar produto para esse cliente?\n");	
			System.out.printf("1.Sim.\n");
			System.out.printf("2.N�o\n");
			opcao = ler.nextInt();
			switch(opcao){
			case 1:
			
			System.out.printf("Selecione o produto:\n");
			ler.nextLine();
			produtoVenda = ler.nextLine();
			System.out.printf("Quantos %s foram vendidos para %s?\n", produtoVenda, clienteVenda);
			vendidos=ler.nextInt();
			
			for(int i=0; i<numerodeProdutos;i++) {
				if(nomeProdutos[i].equals(produtoVenda)) {
					quantidadeEstoque[i]=quantidadeEstoque[i]-vendidos;
				
					encontrou = true;}}
				
			if(encontrou==false) {
				System.out.printf("Esse produto n�o est� na lista\n");
			}	
			if(encontrou==true) {
				System.out.printf("Venda cadastrada com sucesso!\n");
			}	
			break;
			case 2: 
				System.out.printf("Muito obrigada!");
				break;
			default:
				System.out.printf("Essa op��o n�o existe.");
			}
			}while(opcao==1);
			
			
		}}

		
	 
	public static void main(String[] args) {

		int escolha;

		Scanner ler = new Scanner(System.in);
		// Nas linhas seguintes, chama um m�todo para fazer o pr� cadastro dos clientes e dos produtos, juntamente com as outras informa��es
		Clientes.clientesPreCadastrados();
		Produtos.produtosPreCadastrados();
		// Menu com as op��es, so para de aparecer quando o usu�rio digitar o n�mero 7
		do {
			System.out.printf("-------------MENU------------- \n");
			System.out.printf("1.Cadastro de novo cliente; \n");
			System.out.printf("2.Busca por cliente; \n");
			System.out.printf("3.Cadastro de novo produto. \n");
			System.out.printf("4.Busca por produto\n");
			System.out.printf("5.Cadastro de venda\n");
			System.out.printf("6.Mostrar produtos em estoque\n");
			System.out.printf("7.Sair\n");
			escolha=ler.nextInt();
		//Em cada case, chama um m�todo para realizar as a��es, cada caso chama um m�todo criado anteriormente
		switch(escolha) {
		case 1: 
			Clientes.cadastrarCliente();
			System.out.printf("\n");
		break;
		case 2: 
			
			Clientes.procurarCliente();
			System.out.printf("\n");
			break;
		case 3:
			Produtos.cadastrarProdutos();
		break;
		case 4:
			Produtos.buscarProdutos();
			break;
		case 5:
			Produtos.cadastrarVenda();
			break;
		case 6:
			Produtos.mostrarProdutos();
			break;
		case 7:
			System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.printf("O programa chegou ao fim. Volte sempre!\n");
			break;
		default:
			System.out.printf("Essa op��o � inv�lida, por favor insira um n�mero do menu!\n");}
		}while(escolha != 7);
		 
}
}
