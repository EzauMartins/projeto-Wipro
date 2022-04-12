import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

		public class GerenciaConta {

			public static void main(String[] args) {
				int cont;

				Scanner in = new Scanner(System.in);

				List<ContaCorrente> ListCC = new ArrayList<>();
				List<ContaEspecial> ListCE = new ArrayList<>();

				System.out.println("=====|SISTEMA BANCARIO|=====");

				do {
					int i = 0;
					System.out.println("0-Encerrar APP \n" +
							           "1-Criar Conta Corrent | 2- 	Criar ContaEspecial \n" +
							           "3-Consultar Saldo     | 4-	Sacar \n" +
							           "5-Buscar Conta |  6- Todas as contas" );

					int resp = in.nextInt();
					cont = resp;

					switch (resp){
						case 0:
							break;
						case 1:
							ListCC.add(criarContaCorrent());
							break;
						case 2:
							ListCE.add(criarContaEspecial());
							break;
						case 3:
							System.out.println("Index da conta a ser consultada:");
							i = in.nextInt();
							Consultarsaldo(ListCC,ListCE,i);
							break;
						case 4:
							Saque(ListCC,ListCE);
							break;
						case 5:
							BuscarConta(ListCC,ListCE);
							break;
						case 6:
							ListarContas(ListCC,ListCE);
							break;
						default:
							System.out.println("valor invalido");;
					}

				}while (!(cont == 0));

				System.out.println("Sistema Encerrado");

			}

			public static ContaCorrente criarContaCorrent() {

				Scanner in = new Scanner(System.in);
				System.out.println("Digitar : NUMERO CONTA");
				String inCC = in.next();
				System.out.println("Digitar : SALDO INICIAL");
				double inSaldo = in.nextDouble();
				System.out.println("Digitar : NUMERO CREDITO");
				String inCredito = in.next();

				ContaCorrente CC = new ContaCorrente(inCC, inSaldo,inCredito);
				return CC;
			}

			public static ContaEspecial criarContaEspecial() {

				Scanner in = new Scanner(System.in);
				System.out.println("Digitar : NUMERO CONTA");
				String inCC = in.next();
				System.out.println("Digitar : SALDO INICIAL");
				double inSaldo = in.nextDouble();
				System.out.println("Digitar : LIMITE INICIAL");
				double inLimite = in.nextDouble();
				System.out.println("Digitar : NUMERO CARTÃO");
				String inNumCartão = in.next();

				ContaEspecial CE = new ContaEspecial(inCC, inSaldo, inLimite ,inNumCartão);
				return CE;
			}


			public static void Consultarsaldo(List<ContaCorrente> listCC,List<ContaEspecial> listCE, int i){
				Scanner in = new Scanner(System.in);
				System.out.println("=Tipo da conta= \n"+
								"[1]Corrente - [2]Especial");
				int tipo = in.nextInt();
				switch (tipo){
					case 1:
						System.out.println("Saldo Conta Corrente :"+listCC.get(i).getSaldo());
						break;
					case 2:
						System.out.println("Saldo Conta Especial :"+listCE.get(i).getSaldo());
						break;
				}
			}

			public static void Saque(List<ContaCorrente> listCC,List<ContaEspecial> listCE){
				Scanner in = new Scanner(System.in);
				System.out.println("============================");
				System.out.println("Informe index da conta");
				int index = in.nextInt();
				System.out.println("Valor do saque:");
				double value = in.nextDouble();
				System.out.println("=Tipo da conta= \n"+
						"[1]Corrente - [2]Especial");
				int tipo = in.nextInt();
				switch (tipo){
					case 1:
						listCC.get(index).saque(value);
						break;
					case 2:
						listCE.get(index).saque(value);
						break;
				}

			}

			public static void BuscarConta(List<ContaCorrente> listCC,List<ContaEspecial> listCE){

				Scanner in = new Scanner(System.in);
				System.out.println("============================");
				System.out.println("=Tipo da conta= \n"+
						"[1]Corrente - [2]Especial");
				int tipo = in.nextInt();
				System.out.println("Informe index da conta");
				int index = in.nextInt();
				System.out.println("================================");
				switch (tipo){
					case 1:
						System.out.println("Conta encontrada - Numero CC :"+listCC.get(index).getNumConta()+"\n"+
								"Saldo"+listCC.get(index).getSaldo()+"\n"+
								"Cartão"+listCC.get(index).getNumCartao());
						break;
					case 2:
						System.out.println("Conta encontrada - Numero CE :"+listCE.get(index).getNumConta()+"\n"+
								"Saldo"+listCE.get(index).getSaldo()+"\n"+
								"Cartão"+listCE.get(index).getNumCartao()+"\n"+
								"Limite Adicional"+listCE.get(index).getLimiteAdicional());
						break;
					default:
						System.out.println("Conta inexistente");
				}
				System.out.println("================================");

			}
			public static void ListarContas(List<ContaCorrente> listCC,List<ContaEspecial> listCE){
				System.out.println("======CONTA CORRENTE======");
				for(int i = 0; i < listCC.size(); i++){
					listCC.get(i).dadosConta();
					System.out.println("==============================\n");
				}

				System.out.println("======CONTA ESPECIAL======");
				for(int i = 0; i < listCE.size(); i++){
					listCC.get(i).dadosConta();
					System.out.println("==============================\n");
				}
			}



		}
