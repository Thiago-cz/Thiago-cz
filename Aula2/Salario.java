package Aula2;

import javax.swing.JOptionPane;

public class Salario {
    private float salarioBruto, salarioLiquido;
    private int faltas, produtosVendidos;
    private String nome;

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public void setProdutosVendidos(int produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    Salario(Double salarioBruto, int faltas, int produtosVendidos, String nome) {
        this.salarioBruto = salarioBruto;
        this.faltas = faltas;
        this.produtosVendidos = produtosVendidos;
        this.nome = nome;
    }

    Salario() {};

    public void recerberDados() {
        setNome(JOptionPane.showInputDialog(null, "Insira o nome do funcionario!!!!"));

        setFaltas(
                Integer.parseInt(
                        JOptionPane.showInputDialog(null, "Insira o total de faltas no mes!!!")));

        setProdutosVendidos(
                Integer.parseInt(
                        JOptionPane.showInputDialog(null, "Insira o total de produtos vendidos no mes!!!")));

        setSalarioBruto(
                Integer.parseInt(
                        JOptionPane.showInputDialog(null, "Insira o salario bruto do mes!!!!")));

    }

    boolean verificarFalta(int faltas) {
        if (faltas > 5) {
            return true;
        }
        return false;
    }

    int bonusProduto(int produtos) {
        if (produtos <= 20) {
            produtos = produtos * 10;
            return produtos;
        }
        produtos = produtos * 13;
        return produtos;
    }

    double salarioLiquido() {
        salarioLiquido = salarioBruto;

        if (verificarFalta(this.faltas)) {
            salarioLiquido = salarioBruto * (float) 0.85;
            salarioLiquido += bonusProduto(this.produtosVendidos);
        }
        salarioLiquido += bonusProduto(this.produtosVendidos);
        return Math.round(salarioLiquido) ;
    }

    void imprimirSal() {
        System.out.println("O Salario liquido do " + this.nome + " eh de: " + salarioLiquido());
    }
}
