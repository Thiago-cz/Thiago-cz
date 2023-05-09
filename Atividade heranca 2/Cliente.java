import java.util.ArrayList;

public abstract class Cliente {
    private String nome, telefone, cpf, email;
    private ArrayList<Publicacao> listaEmprestimo;
    private boolean tipoUsuario = false;

    public Cliente(String nome, String telefone, String cpf, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
    }

    public ArrayList<Publicacao> getListaEmprestimo() {
        return listaEmprestimo;
    }

    public void setListaEmprestimo(ArrayList<Publicacao> listaEmprestimo) {
        this.listaEmprestimo = listaEmprestimo;
    }

    private boolean possuiEmprestimo = false;
    private boolean especial = false;

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public void solicitarEmprestimo(Publicacao publi) {
        this.listaEmprestimo.add(publi);
    }

    public void finalizarEmprestimo(Publicacao publi) {
        this.listaEmprestimo.remove(publi);
    }

    public boolean isPossuiEmprestimo() {
        return possuiEmprestimo;
    }

    public void setPossuiEmprestimo(boolean possuiEmprestimo) {
        this.possuiEmprestimo = possuiEmprestimo;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
