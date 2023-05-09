package Aula2;
import javax.swing.JOptionPane;

public class NumCartao {
    private String numCartao;
    StringBuffer numVerificado = new StringBuffer();
    // "4539 3195 0343 6467" numero valido !!!!
    String digitosValidos = " 0123456789";

    public String getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }

    void receberNumCartao() {
        String setNumCartao = JOptionPane.showInputDialog(null, "Insira o numero do cartao!!!!");
        setNumCartao(setNumCartao);
    }

    void imprimirValidade() {
        if (verificarNum()) {
            JOptionPane.showMessageDialog(null, "Esse numero de cartao eh valido!!!!!");
        } else {
            JOptionPane.showMessageDialog(null, "Esse numero de cartao nao eh valido!!!!!");
        }

    }

    boolean digitosValidos(String num, String digitosVal) {
        int j = 0;
        for (int i = 0; i <= num.length() - 1; i++) {
            j = i + 1;

            if (i == num.length() - 1) {
                j = i;
            }

            if (digitosVal.contains(num.substring(i, j))) {
            } else {
                return false;
            }
        }

        return true;
    }

    boolean verificarNum() {
        receberNumCartao();
        if (!digitosValidos(numCartao, digitosValidos)) {
            return false;
        }
        numVerificado.append(getNumCartao().replaceAll(" ", ""));
        System.out.println(numVerificado);
        int somaNum = 0;

        for (int i = numVerificado.length() - 1; i >= 0; i--) {

            int num = Character.getNumericValue(numVerificado.charAt(i));

            if (i % 2 == 0) {
                num = num * 2;
                if (num > 9) {
                    num = num - 9;
                    numVerificado.replace(i, i, String.valueOf(num));
                } else {
                    numVerificado.replace(i, i, String.valueOf(num));
                }
            }
            somaNum += num;
        }

        if (somaNum % 10 == 0) {
            return true;
        }
        return false;
    }

}
