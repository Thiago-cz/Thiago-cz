
import java.time.LocalDate;
import java.util.ArrayList;

public class Tese extends Publicacao {
    private LocalDate dataDefesa;
    private int numPag;
    private String instDefesa, resumo;

    public Tese(LocalDate dataPubli, String titulo, ArrayList<Publicacao> referencias, Autor autor,
            String resumo, LocalDate dataDefesa, int numPag, String instDefesa) {
        super(dataPubli, titulo, referencias, autor);

        this.dataDefesa = dataDefesa;
        this.numPag = numPag;
        this.instDefesa = instDefesa;
        this.resumo = resumo;
    }

    public LocalDate getDataDefesa() {
        return dataDefesa;
    }

    public void setDataDefesa(LocalDate dataDefesa) {
        this.dataDefesa = dataDefesa;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public String getInstDefesa() {
        return instDefesa;
    }

    public void setInstDefesa(String instDefesa) {
        this.instDefesa = instDefesa;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

}
