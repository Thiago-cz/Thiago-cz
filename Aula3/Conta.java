public class Conta {

    private double saldo;
    private int numConta;
    private String senha;
    private Titular titular;

    Conta(String senha, Titular titular) {
        this.senha = senha;
        this.titular = titular;
    }

    Conta(String senha, double saldo, Titular titular) {
        this.senha = senha;
        this.saldo = saldo;
        this.titular = titular;
    }
    Conta(){}

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean setSaldo(double saldo) {
        if (saldo > 0) {
            this.saldo = saldo;
            return true;
        }
        return false;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    boolean sacar(double valor, String senha) {
        if (this.saldo >= valor && valor > 0) {
            if(this.senha.equals(senha)){
                this.saldo -= valor;
                return true;
            }
        }
        return false;
    }

    boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    boolean transferir(Conta conta, double valor, String senha){
        if(this.sacar(valor, senha)) {
            conta.depositar(valor);
            return true;
        }
        return false;
    }

}
