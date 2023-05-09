package Aula2;

public class Celula {
    Celula anterior;
    String num;

    Celula(String num, Celula anterior){
        this.num = num;
        this.anterior = anterior;
    }

    public Celula getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }

    public String getNum(){
        return num;
    }

    public void setNum(String num){
        this.num = num;
    }
}
