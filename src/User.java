import java.io.Serializable;

public class User implements Serializable {
  // Atributos
  private static final long serialVersionUID = 1L;
  private String cardNumber;
  private double sale;
  String nome;
  Double saldo;

  // Construtor tipo 1
  public User(String Nome, Double Saldo) {
    this.nome = Nome;
    this.saldo = Saldo;
  }

  // Construtor Tipo 2
  public User(String CardNumber, double Sale) {
    this.cardNumber = CardNumber;
    this.sale = Sale;
  }

  public User() {

  }

  // Getter e Setters
  public String getCardNumber() {
    return cardNumber;
  }

  public double getSale() {
    return sale;
  }

  public void setSale(double sale) {
    this.sale = sale;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
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