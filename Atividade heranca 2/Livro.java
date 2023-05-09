import java.time.LocalDate;
import java.util.ArrayList;

public class Livro extends Publicacao {
    private int numEdicao;
    private String editora;
    private String isbn;

    public Livro(LocalDate dataPubli, String titulo, ArrayList<Publicacao> referencias, ArrayList<Autor> autores,
            int numEdicao, String editora, String isbn) {
        super(dataPubli, titulo, referencias, autores);
        this.numEdicao = numEdicao;
        this.editora = editora;
        this.isbn = isbn;
    }

    public int getNumEdicao() {
        return numEdicao;
    }

    public void setNumEdicao(int numEdicao) {
        this.numEdicao = numEdicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}
