package Aula2;

public class Pilha {
    Celula topo = null;

    void push(String expressao) {
        Celula nova = new Celula(expressao, topo);
        this.topo = nova;
    }

    int sizePilha() {
        Celula p;
        int cont = 0;
        p = topo;
        while (p != null) {
            p = p.getAnterior();
            cont++;
        }
        return cont;
    }
}
