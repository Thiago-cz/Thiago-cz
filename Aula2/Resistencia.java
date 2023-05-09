package Aula2;

import javax.swing.JOptionPane;

public class Resistencia {
    String[] cores = { "PRETO", "MARROM", "VERMELHO", "LARANJA", "AMARELO", "VERDE", "AZUL", "VIOLETA", "CINZA",
            "BRANCO" };
    String[] resistencias = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    StringBuffer resFinal = new StringBuffer();
    StringBuffer coresFinal = new StringBuffer();

    String receberCor() {
        String cor = JOptionPane.showInputDialog(null, "Insira a cor que deseja!!!" + "\nSe deseja sair digite SAIR");
        return cor.toUpperCase();
    }

    public boolean digitosAceitos(String cor, String[] array) {
        for (String corArray : array) {
            if (corArray.equals(cor)) {
                return true;
            }
        }
        return false;
    }

    String verificarResistencia() {
        boolean chave = true;

        while (chave) {
            String cor = receberCor();

            if ("SAIR".equals(cor)) {
                break;
            }

            if (digitosAceitos(cor, this.cores)) {
                for (int i = 0; i < cores.length - 1; i++) {
                    if (cores[i].equals(cor)) {
                        resFinal.append(resistencias[i]);
                    }
                }
                coresFinal.append("-" + cor);

            } else {
                JOptionPane.showMessageDialog(null, "Essa cor nao existe ou foi digitada incorretamente!!!!");
                continue;
            }

        }
        coresFinal.insert(0, resFinal.substring(0, 2));
        return coresFinal.toString();

    }
}
