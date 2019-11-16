public class User {
  String nome;
  Double saldo;

  public User (String nome, Double saldo) {
    this.nome = nome;
    this.saldo = saldo;
  }

  public String getNome() {
    return nome;
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }
}