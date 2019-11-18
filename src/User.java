import java.io.Serializable;

public class User implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String cardNumber;
    private double sale;

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

=======
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
>>>>>>> 2abe046e6493b2e4ab50fdb25048a26b6e4e7755
}