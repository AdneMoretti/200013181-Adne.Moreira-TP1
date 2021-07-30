package intro;
import java.util.Scanner;
import java.lang.String;

		
public class tp1_oo {
	//Classe responável pelas ações relacionadas aos clientes
	public static class Clientes{
		static int quantidadeClientes;
		static String numeroDoCliente;
		static Scanner ler = new Scanner(System.in);
		static String[] nomeClientes = new String[100];
		static String[] enderecoClientes = new String[100];
		static String[] numerosClientes = new String[100];
		static int numerodeClientes=0;
		static boolean encontrou = false;
		//Método para criar os 10 clientes e seus dados ja carregados
		public static void clientesPreCadastrados() {
			for(int i = 0; i <10 ; ++i){
				nomeClientes[numerodeClientes] = "Cliente"+ i;
				enderecoClientes[numerodeClientes]="Endereco"+(i);
				numerosClientes[numerodeClientes]="Número"+(i);
				numerodeClientes=numerodeClientes+1;}
		}
		//Método responsável por cadastrar novos clientes
		public static void cadastrarCliente() {
			
			System.out.printf("Quantos clientes deseja cadastrar? \n");
			quantidadeClientes = ler.nextInt();
			System.out.printf("--------------- CADASTRO DE CLIENTE ----------------- \n");
			ler.nextLine();
			
			for(int i = 0; i < quantidadeClientes; ++i){
					System.out.printf("Insira o nome do cliente: \n");
					
					nomeClientes[numerodeClientes] = ler.nextLine();

					
					System.out.printf("Insira o endereço do cliente: \n");
					
					enderecoClientes[numerodeClientes] = ler.nextLine();
					
					System.out.printf("Insira o telefone do cliente: \n");
					
					numerosClientes[numerodeClientes]= ler.nextLine();
					System.out.printf("Usuário cadastrado com sucesso!\n"); 
					
					numerodeClientes=numerodeClientes+1;
					
					}}
		//Procura o cliente, caso encontrado da a opção de mudar dados cadastrados
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
					System.out.printf("Endereço: %s\n", enderecoClientes[i]);
					System.out.printf("Número: %s\n", numerosClientes[i]);
					System.out.printf("Deseja alterar os dados cadastrados?");
					simounao= ler.next().charAt(0);
					if(simounao=='s'|| simounao=='S') {
						System.out.printf("Nome: ");
						ler.nextLine();
						nomeClientes[i] = ler.nextLine();
						System.out.printf("Endereço: ");
						enderecoClientes[i] = ler.nextLine();
						System.out.printf("Número: ");
						numerosClientes[i] = ler.nextLine();
					}
					}
				}
				if(encontrou==false) {
					System.out.printf("Cliente não encontrado!\n");
				}
			
		}
		// Esse método mostra todos os clientes cadastrados para o cadastro de vendas
		public static String mostrarClientes() {
			String clienteVenda;
			for(int i=0; i<numerodeClientes;i++) {
				System.out.printf("%s\n",nomeClientes[i]);
			}
			do {
			System.out.printf("Selecione o cliente: \n");
			clienteVenda=ler.nextLine();
			//Verifica se o cliente digitado está na lista
			for(int i=0; i<numerodeClientes;i++) {
				if(nomeClientes[i].equals(clienteVenda)) {
					encontrou = true;
			}}
			if(encontrou==false) {
				System.out.printf("Esse cliente não está na lista\n");
			}	
			}while(encontrou==false);
				
			return clienteVenda;
			
		}}
	//Classe criada para realizar as ações relacionadas aos produtos	
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
				descricaoProdutos[numerodeProdutos]="Descrição"+(i);
				valorProdutos[numerodeProdutos]=i+1.5;
				porcentagem[numerodeProdutos]=porcentagemPraCadastro;
				quantidadeEstoque[numerodeProdutos]= i+ 1;
				
				numerodeProdutos=numerodeProdutos+1;}
		}
		
	//Método para cadastrar mais produtos	
	public static void cadastrarProdutos() {
		
		System.out.printf("--------------- CADASTRO DE PRODUTOS ----------------- \n");
		
		System.out.printf("Informe a quantidade de produtos que deseja cadastrar.\n");
		quantidadeProdutos=ler.nextInt();
		for(int i = 0; i < quantidadeProdutos; ++i){
			System.out.printf("Nome: \n");
			ler.nextLine();
			nomeProdutos[numerodeProdutos]=ler.nextLine();
			System.out.printf("Descrição: \n");
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
	//Método para buscar produtos, caso seja encontrado oferece a opção de mudar os dados cadastrados
	public static void buscarProdutos() {
		char simounao;
		String produtoProcura;
		boolean encontrou=false;
		System.out.printf("Qual o nome do produto que deseja procurar?\n");
		
		produtoProcura = ler.nextLine();
		if(numerodeProdutos==0) {
			System.out.printf("Ainda não há produtos cadastrados!\n");
		}
		for( int i = 0; i < numerodeProdutos; ++i){
			
			if(nomeProdutos[i].equals(produtoProcura)) {
				encontrou = true;
				System.out.printf("Nome: %s\n", nomeProdutos[i]);
				System.out.printf("Descrição: %s\n", descricaoProdutos[i]);
				System.out.printf("Valor: %.2f\n", valorProdutos[i]);
				System.out.printf("Porcentagem: %.2f\n", porcentagem[i]);
				System.out.printf("Quantidade de estoque: %d\n", quantidadeEstoque[i]);
				System.out.printf("Deseja alterar os dados cadastrados?[s/n]");
				simounao= ler.next().charAt(0);
				if(simounao=='s'|| simounao=='S') {
					System.out.printf("Nome: ");
					ler.nextLine();
					nomeProdutos[i] = ler.nextLine();
					System.out.printf("Descrição: ");
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
				System.out.printf("Produto não encontrado!\n");
			}
		
	}
		//Mostra os produtos cadastrado e a quantidade de estoque 
		public static void mostrarProdutos() {
			System.out.printf("Os produtos cadastrados são: \n");
			if(numerodeProdutos==0) {
				System.out.printf("Ainda não há produtos cadastrados.\n");
			}
			else {
			for( int i = 0; i < numerodeProdutos; ++i){
				System.out.printf("%d.%s",i+1,nomeProdutos[i]);
				System.out.printf("- %d\n",quantidadeEstoque[i]);
			}
		}
	
	}
		//Método para cadastro de venda, chama o método mostrarClientes que retorna qual cliente deseja comprar o produto
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
			// Faz um peqqueno menu em que o usuário responde se ainda quer cadastrar produtos para o cliente, caso queira repete até o usuário digitar o numero 1(nao)
			System.out.printf("Quer cadastrar produto para esse cliente?\n");	
			System.out.printf("1.Sim.\n");
			System.out.printf("2.Não\n");
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
				System.out.printf("Esse produto não está na lista\n");
			}	
			if(encontrou==true) {
				System.out.printf("Venda cadastrada com sucesso!\n");
			}	
			break;
			case 2: 
				System.out.printf("Muito obrigada!");
				break;
			default:
				System.out.printf("Essa opção não existe.");
			}
			}while(opcao==1);
			
			
		}}

		
	 
	public static void main(String[] args) {

		int escolha;

		Scanner ler = new Scanner(System.in);
		// Nas linhas seguintes, chama um método para fazer o pré cadastro dos clientes e dos produtos, juntamente com as outras informações
		Clientes.clientesPreCadastrados();
		Produtos.produtosPreCadastrados();
		// Menu com as opções, so para de aparecer quando o usuário digitar o número 7
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
		//Em cada case, chama um método para realizar as ações, cada caso chama um método criado anteriormente
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
			System.out.printf("Essa opção é inválida, por favor insira um número do menu!\n");}
		}while(escolha != 7);
		 
}
}
