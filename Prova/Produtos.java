public class Produtos {
    private String nome;
    private int quant = 1;
    private double preco;

    public Produtos(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Produtos(String nome, int quant, double preco) {
        this.nome = nome;
        if (quant >= 1)
            this.quant = quant;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
