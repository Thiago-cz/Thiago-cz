package TiposContas;

import TiposClientes.PessoaF;

public class ContaEspecial extends Conta {
    double chequeEspecial = 2000.0;
    PessoaF titular;

    public ContaEspecial(int numConta, int agencia, String senha, PessoaF pessoaF) {
        super(numConta, agencia, senha);
        this.titular = pessoaF;
    }

    public PessoaF getTitular() {
        return titular;
    }

    public double getChequeEspecial() {
        return this.chequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor >= chequeEspecial + getSaldo()) {
            if (valor >= getSaldo()) {
                setSaldo(valor - getSaldo());
                return true;
            } else {
                double descCheque = getSaldo() - valor;
                setSaldo(getSaldo() - valor);
                chequeEspecial -= descCheque;
                return true;
            }
        } else
            return false;
    }

}
