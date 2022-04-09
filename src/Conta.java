abstract class Conta {
    String numConta;
    double saldo;
    String credito;

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


    public String getNumConta() {
        return numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCredito() {
        return credito;
    }
}
