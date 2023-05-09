
import java.util.ArrayList;

public class UsuarioEspecial extends Cliente {
    private ArrayList<Publicacao> listaEmprestimo = new ArrayList<>();

    public ArrayList<Publicacao> getListaEmprestimo() {
        return listaEmprestimo;
    }

    public void setListaEmprestimo(ArrayList<Publicacao> listaEmprestimo) {
        this.listaEmprestimo = listaEmprestimo;
    }

    public UsuarioEspecial(String nome, String telefone, String cpf, String email) {
        super(nome, telefone, cpf, email);
    }

    public boolean solicitarEmpre(Publicacao publicacao) {
        if (publicacao.isStatusEmprestimo() == false) {
            this.setPossuiEmprestimo(true);
            publicacao.setStatusEmprestimo(true);
            this.listaEmprestimo.add(publicacao);
            return true;
        } else
            return false;
    }

    public boolean finalizarEmprest(Publicacao publicacao) {
        if (publicacao.isStatusEmprestimo() == true) {

            for (Publicacao p : listaEmprestimo) {
                if (p.equals(publicacao)) {
                    publicacao.setStatusEmprestimo(false);
                    listaEmprestimo.remove(publicacao);
                    if (listaEmprestimo.size() == 0)
                        setPossuiEmprestimo(false);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

}
