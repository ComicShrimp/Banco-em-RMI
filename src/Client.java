import java.rmi.Naming;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Client {

  static String state = null;
  static Bank selected = null;
  static int key = -1;

  public static void main(String[] args) {

    try {
      Bank bank1 = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService");
      Bank bank2 = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService2");
      Bank bank3 = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService3");
    inicio:
    while(true){  
      String n = JOptionPane.showInputDialog("Número do Cartão: ");
      if (bank1.getAccount(n) != -1) {
        state = n;
        selected = bank1;
      } else if (bank2.getAccount(n) != -1) {
        state = n;
        selected = bank2;
      } else if (bank3.getAccount(n) != -1) {
        state = n;
        selected = bank3;
      }
     
      while (key != 4) {
        if (selected != null) {
          Object[] options = { "Deposito", "Saque", "Extrato", "Transferência", "Encerrar Operação" };
          int menu = JOptionPane.showOptionDialog(null, "Qual operação você deseja", "Opção",
              JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
          switch (menu) {
          case 0: {
            String valor = JOptionPane.showInputDialog("Valor: ");
            String senha = JOptionPane.showInputDialog("Senha: ");
            selected.makeDeposit(state, senha, Double.valueOf(valor));
            break;
          }
          case 1: {
            String valor = JOptionPane.showInputDialog("Valor: ");
            String senha = JOptionPane.showInputDialog("Senha: ");
            selected.makeWithdraw(state, senha, Double.valueOf(valor));
            break;
          }
          case 2: {
            selected.getSale(state);
            break;
          }
          case 3: {
            String valor = JOptionPane.showInputDialog("Valor: ");
            String conta = JOptionPane.showInputDialog("Conta à receber: ");
            String senha = JOptionPane.showInputDialog("Senha: ");
            selected.makeTransfer(state, conta, senha, Double.valueOf(valor));
            break;
          }
          case 4: {
            state = null;
            selected = null;
            break inicio;
            
          }

          }

        } else {
          JOptionPane.showMessageDialog(null, "Inserir o cartão corretamente!", "", JOptionPane.ERROR_MESSAGE);
          break inicio;
        }
      }
    }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
