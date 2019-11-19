import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class BankService extends UnicastRemoteObject implements Bank {

  java.util.ArrayList<User> database = new ArrayList<>();
  String[] numbers = { "5581 7461 6024 0275", "5171 0511 6130 1176", "5484 2803 4769 6777", "5580 6278 6824 7815",
      "5314 4726 2902 1966" };

  private static final long serialVersionUID = 1L;

  String name = "BB";

  public BankService() throws RemoteException {

    for (int i = 0; i < 5; i++) {
      User newUser = new User();
      newUser.setCardNumber(numbers[i]);
      newUser.setSaldo(100.0 * i);
      database.add(newUser);
    }
  }

  public boolean getAccount(String token) throws RemoteException {
    for (User user : database) {
      if (user.getCardNumber().equals(token)) {
        return true;
      }
    }

    return false;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  public double makeWithdraw(String tokenId, double value) throws RemoteException {
    double takenOutValue = 0.0f;
    for (User user : database) {
      if (user.getCardNumber().equals(tokenId)) {

        if (user.getSaldo() < value) {
          return 0.0f;
        } else {
          takenOutValue = user.getSaldo() - value;
          user.setSaldo((double) (user.getSaldo() - value));
          return takenOutValue;
        }

      }
    }

    return takenOutValue;
  }

  public void makeDeposit(String tokenId, double value) throws RemoteException {
    for (User user : database) {
      if (user.getCardNumber().equals(tokenId)) {
        user.setSaldo(user.getSaldo() + value);
        break;
      }
    }
  }

  public boolean makeTransfer(String fromUser, String toUser, double value) throws RemoteException {
    int fi = 0, ti = 0;
    for (User user : database) {
      if (user.getCardNumber().equals(fromUser)) {
        fi = database.indexOf(user);
      }

      if (user.getCardNumber().equals(toUser)) {
        ti = database.indexOf(user);
      }
    }

    if (database.get(fi).getSaldo() < value) {
      return false;
    } else {
      database.get(fi).setSaldo(database.get(fi).getSaldo() - value);
      database.get(ti).setSaldo(database.get(ti).getSaldo() + value);
      return true;
    }
  }

  public void getSale(String tokenId) throws RemoteException {
    for (User user : database) {
      if (user.getCardNumber().equals(tokenId)) {
        System.out.println(user.getSaldo());
        break;
      }
    }
  }

}