
public class UsuarioComum extends Cliente {
    private Publicacao publicacaoEmpres = null;

    public Publicacao getPublicacaoEmpres() {
        return publicacaoEmpres;
    }

    public void setPublicacaoEmpres(Publicacao publicacaoEmpres) {
        this.publicacaoEmpres = publicacaoEmpres;
    }

    public UsuarioComum(String nome, String telefone, String cpf, String email) {
        super(nome, telefone, cpf, email);
    }

    public boolean solicitarEmpre(Publicacao publicacao) {
        if (publicacao.isStatusEmprestimo() == false) {
            this.setPossuiEmprestimo(true);
            publicacao.setStatusEmprestimo(true);
            this.publicacaoEmpres = publicacao;
            return true;
        } else
            return false;
    }

    public boolean finalizarEmprest(Publicacao publicacao) {
        if (isPossuiEmprestimo() == true && publicacaoEmpres.equals(publicacao)) {
            publicacao.setStatusEmprestimo(false);
            setPossuiEmprestimo(false);
            this.publicacaoEmpres = null;
            return true;
        } else
            return false;

    }

}
