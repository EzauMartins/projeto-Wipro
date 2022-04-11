
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

		public class GerenciaConta {
			public static void main(String[] args) {
				int cont;

				Scanner in = new Scanner(System.in);

				List<ContaCorrente> ListCC = new ArrayList<>();

				System.out.println("=====|SISTEMA BANCARIO|=====");

				do {
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
						case 5:
							BuscarConta(ListCC);
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


			public static void BuscarConta(List<ContaCorrente> listCC){
				System.out.println("Conta encontrada - Numero CC :"+listCC.get(0).getNumConta());


			}

			public static void ListarContas(List<ContaCorrente> listCC){
				for(int i = 0; i < listCC.size(); i++){
					listCC.get(i).dadosConta();
					System.out.println("==============================\n");
				}
			}


		}
