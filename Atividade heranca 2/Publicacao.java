
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Publicacao {
    private LocalDate dataPubli;
    private String titulo;
    private ArrayList<Publicacao> referencias = new ArrayList<>();
    private ArrayList<Autor> autores = new ArrayList<>();
    private double valorMulta;
    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    private boolean statusEmprestimo = false; // false = Nao Emprestado
                                              // true = emprestado

    public Publicacao(LocalDate dataPubli, String titulo, ArrayList<Publicacao> referencias, ArrayList<Autor> autores) {
        this.dataPubli = dataPubli;
        this.titulo = titulo;
        this.referencias = referencias;
        this.autores = autores;
    }

    public Publicacao(LocalDate dataPubli, String titulo, ArrayList<Publicacao> referencias, Autor autor) {
        this.dataPubli = dataPubli;
        this.titulo = titulo;
        this.referencias = referencias;
        this.autores.add(autor);
    }

    public LocalDate getDataPubli() {
        return dataPubli;
    }

    public void setDataPubli(LocalDate dataPubli) {
        this.dataPubli = dataPubli;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Publicacao> getReferencias() {
        return referencias;
    }

    public void setReferencias(ArrayList<Publicacao> referencias) {
        this.referencias = referencias;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public boolean isStatusEmprestimo() {
        return statusEmprestimo;
    }

    public void setStatusEmprestimo(boolean statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
    }

}
