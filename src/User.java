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

}