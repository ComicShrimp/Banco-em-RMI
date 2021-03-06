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

  // Construtores
  public User(String Nome, Double Saldo, String cardNumber, String password, String nomeBanco) {
    this.nome = Nome;
    this.saldo = Saldo;
    this.cardNumber = cardNumber;
    this.password = password;
    this.nomeBanco = nomeBanco;
  }

  public User() {

  }

  @Override
  public String toString() {
    System.out.println(this.nome);
    System.out.println(this.cardNumber);
    System.out.println(this.password);
    System.out.println(this.saldo); 
    return super.toString();
  }


  // Getter e Setters
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