package TiposContas;

import TiposClientes.PessoaJ;

public class ContaEmpresarial extends Conta {
    private PessoaJ titular;
    private double chequeEspecial = 2000.0;

    public ContaEmpresarial(int numConta, int agencia, String senha, PessoaJ pessoaJ) {
        super(numConta, agencia, senha);
        this.titular = pessoaJ;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor >= (getSaldo() + chequeEspecial)) {
            if (valor > getSaldo()) {
                double descontarCheque = valor - getSaldo();
                chequeEspecial -= descontarCheque;
                setSaldo(valor - getSaldo());
                return true;
            }
            return false;
        }
        return false;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public PessoaJ getTitular() {
        return titular;
    }



}
