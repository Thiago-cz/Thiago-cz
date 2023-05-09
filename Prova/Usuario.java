public class Usuario{
    private String nome, telefone, cfp;

    public Usuario(String nome, String telefone, String cfp) {
        this.nome = nome;
        this.telefone = telefone;
        this.cfp = cfp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCfp() {
        return cfp;
    }

    public void setCfp(String cfp) {
        this.cfp = cfp;
    }

}
