import java.util.ArrayList;

public class CarrinhoCompras {
    Usuario usuario;
    ArrayList<Produtos> listaProdutos;

    CarrinhoCompras(Usuario usuario) {
        this.usuario = usuario;
        listaProdutos = new ArrayList<>();
    }

    void addProduto(Produtos produto) {
        listaProdutos.add(produto);
    }

    void removeProduto(Produtos produto) {
        listaProdutos.remove(produto);
    }

    double valorTotalCompra() {
        double valorT = 0;
        for (Produtos produto : listaProdutos) {
            valorT += produto.getQuant() * produto.getPreco();
        }
        return valorT;
    }
}