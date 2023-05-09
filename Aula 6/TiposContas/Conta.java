package TiposContas;

public abstract class Conta {
    private int numConta, agencia;
    private double saldo;
    private String senha;

    Conta(int numConta, int agencia, String senha) {
        this.numConta = numConta;
        this.agencia = agencia;
        this.senha = senha;
    }

    public int getNumConta() {
        return numConta;
    }

    public int getAgencia() {
        return agencia;
    }

    protected void setSaldo(double valor){
        saldo = valor;
    }
    
    public double getSaldo(){
        return saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean sacar(double valor){
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }
        return false;
    };

    public boolean depositar(double valor){
        if(valor > 0){
            saldo += valor;
            return true;
        }
        return false;
    };

    public boolean transferir(Conta contaDestino, double valor){
        if(sacar(valor)){
            contaDestino.saldo += valor;
            return true;
        }
        return false;
    };

}
