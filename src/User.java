import java.io.Serializable;


public class User implements Serializable {
  // Atributos
  private static final long serialVersionUID = 1L;
  private String cardNumber;
  private String nome;
  private Double saldo;
  private int id;
  private String password;
  private String nomeBanco;


  // Construtor tipo 1
  public User(String Nome, Double Saldo, String cardNumber, String password, String nomeBanco) {
    this.nome = Nome;
    this.saldo = Saldo;
    this.cardNumber = cardNumber;
    this.password = password;
    this.nomeBanco = nomeBanco;
  }

  public String getNomeBanco() {
    return nomeBanco;
  }

  public void setNomeBanco(String nomeBanco) {
    this.nomeBanco = nomeBanco;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public User() {

  }

  // Getter e Setters
  public String getCardNumber() {
    return cardNumber;
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