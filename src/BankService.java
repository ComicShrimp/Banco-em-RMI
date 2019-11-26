import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.IOException;

public class BankService extends UnicastRemoteObject implements Bank {

  ArrayList<User> database = new ArrayList<>();
  private static final String FILE_HEADER = "Name,CardNumber,Password,BankName,Saldo";

  private static final long serialVersionUID = 1L;

  String name = "Banco do Brasil";

  public BankService() throws RemoteException {
    File baseDados = new File("../src/bases/Banco1.csv");

    String[] campos = {};
    try {
      Scanner leitor = new Scanner(baseDados);

      leitor.nextLine();

      while (leitor.hasNext()) {
        String l = leitor.nextLine();
        campos = l.split(",");
        User user = new User();
        user.setNome(String.valueOf(campos[0]));
        user.setCardNumber(String.valueOf(campos[1]));
        user.setPassword(String.valueOf(campos[2]));
        user.setNomeBanco(String.valueOf(campos[3]));
        user.setSaldo(Double.valueOf(campos[4]));
        database.add(user);
      }

      leitor.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public int getAccount(String token) throws RemoteException {

    for (User u : database) {
      if (u.getCardNumber().equals(token)) {
        return database.indexOf(u);
      }
    }
    JOptionPane.showMessageDialog(null, "Inserir o cartão corretamente!", "Conta não encontrada!",
        JOptionPane.ERROR_MESSAGE);

    return -1;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  public void writeCsv() {
    FileWriter fileWriter = null;

    try {
      fileWriter = new FileWriter("../src/bases/Banco1.csv");
      fileWriter.append(FILE_HEADER.toString());
      fileWriter.append("\n");

      for (User u : database) {
        fileWriter.append(u.getNome());
        fileWriter.append(",");
        fileWriter.append(u.getCardNumber());
        fileWriter.append(",");
        fileWriter.append(u.getPassword());
        fileWriter.append(",");
        fileWriter.append(u.getNomeBanco());
        fileWriter.append(",");
        fileWriter.append(String.valueOf(u.getSaldo()));
        fileWriter.append("\n");
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        fileWriter.flush();
        fileWriter.close();
      } catch (IOException e) {
        System.out.println("Error while flushing/closing fileWriter !!!");
        e.printStackTrace();
      }

    }
  }

  public double makeWithdraw(String tokenId, String password, double value) throws RemoteException {
    double takenOutValue = 0.0f;
    for (User user : database) {
      if (user.getCardNumber().equals(tokenId)) {

        if (user.getSaldo() < value) {
          JOptionPane.showMessageDialog(null, "Saldo insuficiente!", "", JOptionPane.ERROR_MESSAGE);
          return 0.0f;
        } else {
          if (user.getPassword().equals(password)) {
            takenOutValue = user.getSaldo() - value;
            user.setSaldo((double) (user.getSaldo() - value));
            writeCsv();
            return takenOutValue;
          } else {
            JOptionPane.showMessageDialog(null, "Senha Incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
          }

        }

      }
    }

    return 0.0f;
  }

  public void makeDeposit(String tokenId, String password, double value) throws RemoteException {
    for (User user : database) {
      if (user.getCardNumber().equals(tokenId)) {
        if (user.getPassword().equals(password)) {
          user.setSaldo(user.getSaldo() + value);
          writeCsv();
          break;
        } else {
          JOptionPane.showMessageDialog(null, "Senha Incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
        }

      }
    }
  }

  public boolean makeTransfer(String fromUser, String toUser, String password, double value) throws RemoteException {
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
      JOptionPane.showMessageDialog(null, "Saldo insuficiente para realizar a transferência!", "",
          JOptionPane.ERROR_MESSAGE);
      return false;
    } else {
      if (database.get(fi).getPassword().equals(password)) {
        database.get(fi).setSaldo(database.get(fi).getSaldo() - value);
        database.get(ti).setSaldo(database.get(ti).getSaldo() + value);
        writeCsv();
        JOptionPane.showMessageDialog(null, "Transferência Realizada com sucesso!", "", JOptionPane.OK_OPTION);
        return true;
      } else {
        JOptionPane.showMessageDialog(null, "Senha Incorreta", "Erro", JOptionPane.ERROR_MESSAGE);
        return false;
      }

    }

  }

  public void getSale(String tokenId) throws RemoteException {
    for (User user : database) {
      if (user.getCardNumber().equals(tokenId)) {
        String msg = "Nome: " + user.getNome() + "\nNúmero do Cartão: " + user.getCardNumber() + "\nSaldo: R$"
            + String.valueOf(user.getSaldo());
        JOptionPane.showMessageDialog(null, msg);
        break;
      }
    }
  }

}