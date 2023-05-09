class Conta{
  private Titular titular;
  private String nroConta, senha;
  private int banco;
  private double saldo;

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Conta(Titular titular, String nroConta, String senha, double saldoInicial){
    this.titular = titular;
    this.nroConta = nroConta;
    this.senha = senha;
    this.saldo = saldoInicial;
  }

  public Conta(Titular titular, String nroConta, String senha){
    this.titular = titular;
    this.nroConta = nroConta;
    this.senha = senha;
    this.banco = 1;
    this.saldo = 0.0;
  }

  public Titular getTitular() {
    return this.titular;
  }

  public void setTitular(Titular titular) {
    this.titular = titular;
  }

  public String getNroConta() {
    return this.nroConta;
  }

  public void setNroConta(String nroConta) {
    this.nroConta = nroConta;
  }

  public String getAgencia() {
    return this.senha;
  }

  public void setAgencia(String senha) {
    this.senha = senha;
  }

  public int getBanco() {
    return this.banco;
  }

  public void setBanco(int banco) {
    this.banco = banco;
  }

  public double getSaldo(){
    return this.saldo;
  }
  
  boolean sacar(double valor){
    if(valor > 0 && saldo >= valor){
      saldo = saldo - valor;
      return true;
    }
    return false;
  }

  boolean depositar(double valor){
    if(valor > 0 ){
      saldo = saldo + valor;
      return true;
    }
    return false;
  }
  
  boolean transferir(double valor, Conta contaDeposito){
    if(this.sacar(valor)){
      contaDeposito.depositar(valor);
      return true;
    }
    return false;
  }
  
}