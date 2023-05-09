import java.util.ArrayList;

public class Biblioteca {
    private String nome, endereco;
    private ArrayList<Publicacao> conjuntoPubl = new ArrayList<>();
    private ArrayList<Cliente> usuarios = new ArrayList<>();

    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Publicacao> getConjuntoPubl() {
        return conjuntoPubl;
    }

    public void setConjuntoPubl(ArrayList<Publicacao> conjuntoPubl) {
        this.conjuntoPubl = conjuntoPubl;
    }

    public ArrayList<Cliente> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Cliente> usuarios) {
        this.usuarios = usuarios;
    }

}
