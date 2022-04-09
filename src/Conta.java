abstract class Conta {
    int numConta;
    double saldo = 5;
    double Credito;

    public void infConta(){
        System.out.println("=======Dados da conta======="+"\n"+
                            "Numero Conta: "+numConta+"\n"+
                             "Saldo atual: "+saldo);
    }

    public void saque(double value){
        if (value > saldo){
            System.out.println("Saldo Insuficiente");
        }else{
            saldo -= value;
        }
    }

    public void deposito(){
    }


    public int getNumConta() {
        return numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getCredito() {
        return Credito;
    }
}
