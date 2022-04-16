public class ContaCorrente extends Conta {

	public ContaCorrente(String numConta, double saldo,String numCartao) {
	this.numConta = numConta;
	this.saldo = saldo;
	this.numCartao = numCartao;
	}

	@Override
	public void saque(double value) {
		        if (value > saldo){
		            System.out.println("Saldo Insuficiente");
		        }else{
		        	double tax = 7.0;
		            saldo -= value + tax;
		        }
		
	}

	@Override
	public void deposito(double value) {
		this.saldo =+ value;
		
	}


	@Override
	public String toString() {
		return " numConta: " +
	numConta + "\n saldo: " +
	saldo + "\n numCartao: " 
	+ numCartao ;
	}


	@Override
	public void dadosConta() {
		System.out.println("=======Dados da conta======="+"\n"+
				"Numero Conta: "+numConta+"\n"+
				"Saldo atual: "+saldo);
	}
	
	
}