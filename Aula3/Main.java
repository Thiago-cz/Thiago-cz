

public class Main {
    public static void main(String[] args) {
        Titular t1 = new Titular("Joao", "111.222.333-54", "Rua 1, Bairro 2, Morrinhos, GO", "123456-8" );   
  
        Conta a = new Conta("a1b2c3", t1);
        a.depositar(500);
        System.out.println(a.getSaldo());
    }
}