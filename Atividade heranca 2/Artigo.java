
import java.time.LocalDate;
import java.util.ArrayList;

public class Artigo extends Publicacao {
    private String resumo;

    public Artigo(LocalDate dataPubli, String titulo, ArrayList<Publicacao> referencias,
            ArrayList<Autor> autores, String resumo) {

        super(dataPubli, titulo, referencias, autores);
        this.resumo = resumo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
}
