	
public class Conta_Corrente extends Conta {

	public Conta_Corrente(String numConta, double saldo,String numCartao) {
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
}