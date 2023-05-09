import java.time.LocalDate;
import java.time.Period;

public class Emprestimo {
    private Cliente usuario;

    public Emprestimo(Cliente usuario, Publicacao publicacao) {

 }

    public Cliente getUsuario() {
        return usuario;
    }

    public void setUsuario(Cliente usuario) {
        this.usuario = usuario;
    }

    private Publicacao publicacao;
    private LocalDate dataInicio, dataTermino;
    private int qtdRenovacao = 3;

    public boolean finalizarEmprest(UsuarioComum user, LocalDate dataEntrega) {
        if (this.publicacao.isStatusEmprestimo() == true
                && user.getPublicacaoEmpres().equals(this.publicacao)) {
            if (dataTermino.isAfter(dataEntrega)) {
                System.out.println("Multa de : " + calcularMulta(dataEntrega));
            }
            user.setPossuiEmprestimo(false);
            user.setPublicacaoEmpres(null);
            System.out.println("Deu certo");
            return true;
        } else
            return false;
    }

    public boolean finalizarEmprest(UsuarioEspecial user, LocalDate dataEntrega) {
        if (this.publicacao.isStatusEmprestimo() == true
                && user.getListaEmprestimo().contains(this.publicacao)) {
            if (dataTermino.isAfter(dataEntrega)) {
                System.out.println("Multa de : " + calcularMulta(dataEntrega));
            }
            user.getListaEmprestimo().remove(this.publicacao);
            this.publicacao.setStatusEmprestimo(false);
            System.out.println("Deu certo");
            return true;
        } else
            return false;

    }

    public boolean solicitarEmprest(UsuarioComum user) {
        if (this.publicacao.isStatusEmprestimo() == false && user.isPossuiEmprestimo() == false) {
            this.publicacao.setStatusEmprestimo(true);
            user.setPossuiEmprestimo(true);
            user.setPublicacaoEmpres(this.publicacao);
            dataInicio = LocalDate.now();
            dataTermino = dataInicio.plusDays(7);
            System.out.println("Deu certo");
            return true;
        } else
            return false;
    }

    public boolean solicitarEmprest(UsuarioEspecial user) {
        if (this.publicacao.isStatusEmprestimo() == false) {
            this.publicacao.setStatusEmprestimo(true);
            user.setPossuiEmprestimo(true);
            user.getListaEmprestimo().add(this.publicacao);
            dataInicio = LocalDate.now();
            dataTermino = dataInicio.plusDays(7);
            System.out.println("Deu certo");
            return true;
        } else
            return false;
    }

    public boolean renovarEmprest(UsuarioComum user, LocalDate dataRenovacao) {
        if (this.publicacao.isStatusEmprestimo() == true &&
                user.getPublicacaoEmpres().equals(this.publicacao) && qtdRenovacao <= 3) {
            if (dataTermino.isAfter(dataRenovacao)) {
                dataTermino = dataTermino.plusDays(7);
                qtdRenovacao -= 1;
                System.out.println("Deu certo");
                return true;
            } else {
                System.out.println("Multa de : " + calcularMulta(dataRenovacao));
                return false;
            }
        }
        return false;
    }

    public boolean renovarEmprest(UsuarioEspecial user, LocalDate dataEntrega) {
        if (this.publicacao.isStatusEmprestimo() == true && user.getListaEmprestimo().contains(this.publicacao)
                && qtdRenovacao <= 3) {
            if (dataTermino.isAfter(dataEntrega) || dataTermino.isEqual(dataEntrega)) {
                dataTermino = dataTermino.plusDays(7);
                qtdRenovacao -= 1;
                System.out.println("Deu certo");
                return true;
            }
            System.out.println("Multa de : " + calcularMulta(dataEntrega));
        }
        return false;
    }

    double calcularMulta(LocalDate dataEntrega) {
        Period diferenca = Period.between(dataEntrega, dataTermino);

        return diferenca.getDays() * this.publicacao.getValorMulta();

    }

}
