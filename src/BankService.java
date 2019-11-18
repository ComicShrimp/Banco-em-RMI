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
            User u = new User();
            u.setCardNumber(numbers[i]);
            u.setSale(100 * i);
            database.add(u);
        }
    }

    public boolean getAccount(String token) throws RemoteException {
        for (User u : database) {
            if (u.getCardNumber().equals(token)) {
                return true;
            }
        }

        return false;
    }

    public double makeWithdraw(String tokenId, double value) throws RemoteException {
        double takenOutValue = 0.0f;
        for (User u : database) {
            if (u.getCardNumber().equals(tokenId)) {

                if (u.getSale() < value) {
                    return 0.0f;
                } else {
                    takenOutValue = u.getSale() - value;
                    u.setSale((double) (u.getSale() - value));
                    return takenOutValue;
                }

            }
        }

        return takenOutValue;
    }

    public void makeDeposit(String tokenId, double value) throws RemoteException {
        for (User u : database) {
            if (u.getCardNumber().equals(tokenId)) {
                u.setSale(u.getSale() + value);
                break;
            }
        }
    }

    public boolean makeTransfer(String fromUser, String toUser, double value) throws RemoteException {
        int fi = null, ti = null;
        for (User u : database) {
            if (u.getCardNumber().equals(fromUser)) {
                fi = database.indexOf(u);
            }

            if (u.getCardNumber().equals(toUser)) {
                ti = database.indexOf(u);
            }
        }

        if (database.get(fi).getSale() < value) {
            return false;
        } else {
            database.get(fi).setSale(database.get(fi).getSale() - value);
            database.get(ti).setSale(database.get(ti).getSale() + value);
            return true;
        }

        return false;
    }

    public void getSale(String tokenId) throws RemoteException {
        for (User u : database) {
            if (u.getCardNumber().equals(tokenId)) {
                System.out.println(u.getSale());
                break;
            }
        }
    }

}