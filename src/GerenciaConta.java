
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
						case 1:
							ListCC.add(criarContaCorrent());
							break;
						case 2:
							ListCE.add(criarContaEspecial());
						case 3:
							System.out.println("Index da conta a ser consultada:");
							i = in.nextInt();
							Consultarsaldo(ListCC,ListCE,i);
						case 4:

						case 5:
							System.out.println("Index da conta a ser consultada:");
							i = in.nextInt();
							BuscarConta(ListCC,i);
							break;
						case 6:
							ListarContas(ListCC);
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
					case 2:
						System.out.println("Saldo Conta Especial :"+listCE.get(i).getSaldo());

				}

			}

			public static void BuscarConta(List<ContaCorrente> listCC, int i){
				System.out.println("Conta encontrada - Numero CC :"+listCC.get(i).getNumConta());

			}

			public static void ListarContas(List<ContaCorrente> listCC){
				for(int i = 0; i < listCC.size(); i++){
					listCC.get(i).dadosConta();
					System.out.println("==============================\n");
				}
			}


		}
