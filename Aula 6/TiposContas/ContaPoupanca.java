package TiposContas;

import TiposClientes.PessoaF;

public class ContaPoupanca extends Conta{
    PessoaF pessoaF;
     private final double rendimento = 0.005;

    public ContaPoupanca(int numConta, int agencia, String senha, PessoaF pessoaF) {
        super(numConta, agencia, senha);
        this.pessoaF = pessoaF;

    }

    public void rendimentoMensal(){
        double valorRendido = getSaldo() * rendimento;
        setSaldo(getSaldo() + valorRendido);
    }
}
