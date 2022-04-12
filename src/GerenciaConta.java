
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

		public class GerenciaConta {
			public static void main(String[] args) {

				int resp;

				Scanner in = new Scanner(System.in);
				List<ContaCorrente> ListCC = new ArrayList<>();

				System.out.println("=====|SISTEMA BANCARIO|=====");
				do {
<<<<<<< Updated upstream
					ListCC.add(criarContaCorrent());
=======
					int i = 0;
					System.out.println("0-Encerrar APP \n" +
							           "1-Criar Conta Corrente | 2- Criar ContaEspecial \n" +
							           "3-Consultar Saldo     | 4-Sacar \n" +
							           "5-Buscar Conta |  6- Todas as contas" );

					int resp = in.nextInt();
					cont = resp;
>>>>>>> Stashed changes

					System.out.println("Deseja continuar adicionando");
					resp = in.nextInt();

				}while (resp == 1);

				System.out.println(ListCC.get(1).getNumConta());

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

		}
