package TiposClientes;

public class PessoaF extends Cliente {
    private String cpf, rg, nomeMae;

    public PessoaF(String nome, String telefone, String endereco, String cpf, String rg,
            String nomeMae) {
        super(nome, telefone, endereco);
        this.cpf = cpf;
        this.rg = rg;
        this.nomeMae = nomeMae;
    }
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

}
