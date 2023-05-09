public class Main {
    public static void main(String[] args) {
        Produtos maca = new Produtos("Maca", 1.5);
        Produtos pera = new Produtos("Pera", 2.4);
        Produtos martelo = new Produtos("Martelo", 6, 30.6);
        Produtos molho = new Produtos("Molho de tomate", 0.9);

        Usuario joao = new Usuario("Joao", "(64)99356-9000", "722.455.988-00");

        CarrinhoCompras carrJoao = new CarrinhoCompras(joao);
        carrJoao.addProduto(maca);
        carrJoao.addProduto(molho);
        pera.setQuant(3);
        carrJoao.addProduto(pera);
        carrJoao.addProduto(martelo);

        System.out.println(carrJoao.valorTotalCompra());
        
        carrJoao.removeProduto(molho);
        carrJoao.removeProduto(martelo);

        System.out.println(carrJoao.valorTotalCompra());
    }   
}
