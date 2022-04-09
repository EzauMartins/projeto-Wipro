abstract class Conta {
    String numConta;
    double saldo;
    String numCartao;

    public void infConta(){
        System.out.println("=======Dados da conta======="+"\n"+
                            "Numero Conta: "+numConta+"\n"+
                             "Saldo atual: "+saldo);
    }

    public abstract void saque(double value);

    public abstract void deposito(double value);


    public String getNumConta() {
        return numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumCartao() {
        return numCartao;
    }
}
