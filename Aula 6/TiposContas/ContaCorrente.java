package TiposContas;

import TiposClientes.PessoaF;

public class ContaCorrente extends Conta {
    PessoaF pessoaF;

    public ContaCorrente(int numConta, int agencia, String senha, PessoaF pessoaF) {
        super(numConta, agencia, senha);
        this.pessoaF = pessoaF;
    }
    
    public PessoaF getPessoaF() {
        return pessoaF;
    }

    public void setPessoaF(PessoaF pessoaF) {
        this.pessoaF = pessoaF;
    }



    
}
