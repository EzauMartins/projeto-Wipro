import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


		public class GerenciaConta {

			public static void main(String[] args) {
				int cont;

				Scanner in = new Scanner(System.in);

				List<ContaCorrente> ListCC = new ArrayList<>();
				List<ContaEspecial> ListCE = new ArrayList<>();

				System.out.println("=====|SISTEMA BANCARIO|=====");

				do {
					String error = "================== \n"+
									"Conta inexistente \n"+
									"================== \n";

					int index;
					int tipo;
					System.out.println("[0]-Encerrar APP \n" +
							"[1]-Criar Conta Corrente | [2]- Criar ContaEspecial \n" +
							"[3]-Consultar Saldo      | [4]- Sacar \n" +
							"[5]-Depositar  		  | [6]- Buscar Conta \n" +
							"[7]-Listar contas");

					int resp = in.nextInt();
					cont = resp;

					switch (resp) {
						case 0:
							break;

						case 1:		// ADICIONAR CONTA CORRENTE
							ListCC.add(criarContaCorrent(ListCC));
							break;

						case 2:   // ADICIONAR CONTA ESPECIAL
							ListCE.add(criarContaEspecial(ListCE));
							break;

						case 3:   // CONSULTAR SALDO
							tipo = tipoConta();
							try {
								 index = (int) Check(ListCE, ListCC,tipo);
							}catch (NullPointerException e){
								System.out.println(error);
								break;
							}
							Consultarsaldo(ListCC, ListCE , index, tipo);
							break;

						case 4:  // SACAR
							tipo = tipoConta();
							try {
								index = (int) Check(ListCE, ListCC,tipo);
							}catch (NullPointerException e){
								System.out.println(error);
								break;
							}
							Saque(ListCC, ListCE,index, tipo);
							break;
						case 5:
							deposito(ListCE, ListCC);
							break;
						case 6:
							tipo = tipoConta();
							try {
								index = (int) Check(ListCE, ListCC,tipo);
							}catch (NullPointerException e){
								System.out.println(error);
								break;
							}
							BuscarConta(ListCC, ListCE,index,tipo);
							break;
						case 7:

							ListarContas(ListCC, ListCE);
							break;
						default:
							System.out.println("Valor inválido");
					}

				} while (!(cont == 0));

				System.out.println("====Sistema Encerrado==== \n" +
						"Copyright © 2022 - TROPA DE PEDREIROS");

			}

			public static ContaCorrente criarContaCorrent(List<ContaCorrente> listCC) {

				Scanner in = new Scanner(System.in);
				boolean check = true;
				Random aleatorio = new Random();
								String inCC;

				do {
					System.out.println("Digitar  NUMERO CONTA");
					inCC = in.next();

					for (int i = 0; i < listCC.size(); i++) {
						if (listCC.get(i).getNumConta().equals(inCC)) {
							System.out.println("===================!!\n" +
									"Conta já existente \n" +
									"Digite novamente\n" +
									"===================!!");
							check = false;
						} else {
							check = true;
						}
					}
				} while (!check);

				System.out.println("Digitar : SALDO INICIAL");
				double inSaldo = in.nextDouble();
				System.out.println("Digitar : NUMERO CREDITO");
				String inCredito = in.next();

				ContaCorrente CC = new ContaCorrente(inCC, inSaldo, inCredito);
				return CC;
			}

			public static ContaEspecial criarContaEspecial(List<ContaEspecial> listCE) {

				Scanner in = new Scanner(System.in);
				boolean check = true;
				String inCE;

				do {
					System.out.println("Digitar  NUMERO CONTA");
					inCE = in.next();

					for (int i = 0; i < listCE.size(); i++) {
						if (listCE.get(i).getNumConta().equals(inCE)) {
							System.out.println("===================!!\n" +
									"Conta já existente \n" +
									"Digite novamente\n" +
									"===================!!");
							check = false;
						} else {
							check = true;
						}
					}
				} while (!check);
				System.out.println("Digitar : SALDO INICIAL");
				double inSaldo = in.nextDouble();
				System.out.println("Digitar : LIMITE INICIAL");
				double inLimite = in.nextDouble();
				System.out.println("Digitar : NUMERO CARTÃO");
				String inNumCartão = in.next();

				ContaEspecial CE = new ContaEspecial(inCE, inSaldo, inLimite, inNumCartão);
				return CE;
			}


			public static void Consultarsaldo(List<ContaCorrente> listCC, List<ContaEspecial> listCE , int index, int tipo) {
				switch (tipo) {
					case 1:
						System.out.println("Saldo Conta Corrente :" + listCC.get(index).getSaldo() + "R$");
						break;
					case 2:
						System.out.println("Saldo Conta Especial :" + listCE.get(index).getSaldo() + "R$");
						break;
				}
			}

			public static void Saque(List<ContaCorrente> listCC, List<ContaEspecial> listCE, int index,int tipo) {
				Scanner in = new Scanner(System.in);
				System.out.println("============================");
				System.out.println("Valor do saque:");
				double value = in.nextDouble();
				switch (tipo) {
					case 1:
						listCC.get(index).saque(value);
						break;
					case 2:
						listCE.get(index).saque(value);
						break;
				}

			}

			public static void BuscarConta(List<ContaCorrente> listCC, List<ContaEspecial> listCE, int index,int tipo) {

				System.out.println("================================");
				switch (tipo) {
					case 1:
						System.out.println("Conta encontrada - Numero CC :" + listCC.get(index).getNumConta() + "\n" +
								"Saldo" + listCC.get(index).getSaldo() + "\n" +
								"Cartão" + listCC.get(index).getNumCartao());
						break;
					case 2:
						System.out.println("Conta encontrada - Numero CE :" + listCE.get(index).getNumConta() + "\n" +
								"Saldo" + listCE.get(index).getSaldo() + "\n" +
								"Cartão" + listCE.get(index).getNumCartao() + "\n" +
								"Limite Adicional" + listCE.get(index).getLimiteAdicional());
						break;
				}
				System.out.println("================================");

			}

			public static void ListarContas(List<ContaCorrente> listCC, List<ContaEspecial> listCE) {

				if (listCC.isEmpty() && listCE.isEmpty()){
					System.out.println("Nenhuma Conta Cadastrada");
				}else {

					System.out.println("======CONTA CORRENTE======");
					for (int i = 0; i < listCC.size(); i++) {
						listCC.get(i).dadosConta();
						System.out.println("==============================\n");
					}

					System.out.println("======CONTA ESPECIAL======");
					for (int i = 0; i < listCE.size(); i++) {
						listCC.get(i).dadosConta();
						System.out.println("==============================\n");
					}
				}
			}

			public static void deposito(List<ContaEspecial> listCE, List<ContaCorrente> listCC) {

				Scanner in = new Scanner(System.in);

				if (listCC.isEmpty() && listCC.isEmpty()) {
					System.out.println("================================\n" +
							"==Não existe conta cadastrada==\n" +
							"================================\n");
				} else {

					System.out.printf("Em qual tipo de conta deseja depositar?\n" +
							"1-Conta Corrente\n" +
							"2-Conta Especial\n");
					int op = in.nextInt();

					if (op == 1) {
						System.out.println("Qual Conta deseja depositar?");
						for (int i = 0; i < listCC.size(); i++) {
							System.out.println(listCC);
						}
						System.out.println("Em qual deseja adicionar?");
						int indexOf = in.nextInt();
						System.out.println("Qual o valor do deposito?");
						Double value = in.nextDouble();
						listCC.get(indexOf).deposito(value);
					}
					if (op == 2) {
						System.out.println("Qual Conta deseja depositar?");
							for (int i = 0; i < listCE.size(); i++) {
								System.out.println(i + " : " + listCE.toString());
							}
						System.out.println("Em qual deseja adicionar?");
							int indexOf = in.nextInt();

						System.out.println("Qual o valor do deposito?");
							Double value = in.nextDouble();

						listCE.get(indexOf).deposito(value);

					}
				}
			}

			public static Object Check(List<ContaEspecial> listCE, List<ContaCorrente> listCC, int tipo) {
				Scanner in = new Scanner(System.in);

				System.out.println("Informe sua conta.");
				String inCC = in.next();

				switch (tipo){
					case 1:
						for (int i = 0; i < listCC.size(); i++) {
							if (listCC.get(i).getNumConta().equals(inCC)) {
								return i;
							}
						}
					break;
					case 2:
						for (int i = 0; i < listCE.size(); i++) {
							if (listCE.get(i).getNumConta().equals(inCC)) {
								return i;
							}
						}
				}

				return null;
			}
			public static int tipoConta(){
				Scanner in = new Scanner(System.in);
				boolean check = true;
				int tipo;
				do {
					System.out.println("Informe tipo Conta \n" +
							"|1|Conta Corrente - |2| Conta Especial");
					tipo = in.nextInt();
					if (tipo == 1 || tipo == 2){
						check = false;
					}else {
						System.out.println("================= \n"+
											"tipo inexistente \n"+
											"================= ");
					}

				}while (check);

				return tipo;
			}

		}