import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class BankService extends UnicastRemoteObject implements Bank {

  java.util.ArrayList<User> database = new ArrayList<>();
  String[] numbers = { "5581 7461 6024 0275", "5171 0511 6130 1176", "5484 2803 4769 6777", "5580 6278 6824 7815",
      "5314 4726 2902 1966" };

  private static final long serialVersionUID = 1L;

  public BankService() throws RemoteException {

    for (int i = 0; i < 5; i++) {
      User newUser = new User(numbers[i], 100 * i);
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

  public double makeWithdraw(String tokenId, double value) throws RemoteException {
    double takenOutValue = 0.0f;
    for (User user : database) {
      if (user.getCardNumber().equals(tokenId)) {

        if (user.getSale() < value) {
          return 0.0f;
        } else {
          takenOutValue = user.getSale() - value;
          user.setSale((double) (user.getSale() - value));
          return takenOutValue;
        }

      }
    }

    return takenOutValue;
  }

  public void makeDeposit(String tokenId, double value) throws RemoteException {
    for (User user : database) {
      if (user.getCardNumber().equals(tokenId)) {
        user.setSale(user.getSale() + value);
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

    if (database.get(fi).getSale() < value) {
      return false;
    } else {
      database.get(fi).setSale(database.get(fi).getSale() - value);
      database.get(ti).setSale(database.get(ti).getSale() + value);
      return true;
    }
  }

  public void getSale(String tokenId) throws RemoteException {
    for (User user : database) {
      if (user.getCardNumber().equals(tokenId)) {
        System.out.println(user.getSale());
        break;
      }
    }
  }

}