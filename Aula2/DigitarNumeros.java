package Aula2;

import javax.swing.JOptionPane;

public class DigitarNumeros {
    Pilha pilha = new Pilha();
    int maiorNum = 0, menorNum = 0, mediaNum;
    String digitosValidos = "-0123456789";
    NumCartao verificarDigito = new NumCartao();

    public float mediaNum(int num) {
        if(num == 0) {
            return 0;
        }
        float resultado = num / pilha.sizePilha();
        return (float) resultado;
    }

    public void verficarNumeros() {
        int numConvertido = 0;
        boolean chavePilha = true;

        while (numConvertido != -1) {
            String num = JOptionPane.showInputDialog(null, "Insira numeros!!!!!" + "\nSe quiser sair digite  -1 ");

            if(verificarDigito.digitosValidos(num, digitosValidos)) { 
                numConvertido = Integer.parseInt(num);
            }else {
                JOptionPane.showMessageDialog(null, "Digite apenas numeros!!!!!");
                continue;
            }    
            if(numConvertido == -1){
                break;
            }
            pilha.push(num);

            if (chavePilha) {
                maiorNum = numConvertido;
                menorNum = numConvertido;
                chavePilha = false;
            } else {
                if (numConvertido > maiorNum) {
                    maiorNum = numConvertido;
                }
                if (numConvertido < menorNum) {
                    menorNum = numConvertido;
                }

            }
            mediaNum += numConvertido;

        }
        System.out.println("A quantidade de numeros digitados foi: " + pilha.sizePilha());
        System.out.println("O maior numero digitado foi: " + maiorNum);
        System.out.println("O menor numero digitado foi: " + menorNum);
        System.out.println("A media dos numeros digitados foi: " + mediaNum(mediaNum));

    }

}
