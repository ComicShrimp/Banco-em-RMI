import java.rmi.Naming;
import javax.swing.JOptionPane;

public class Client {

  static String state = null;
  static Bank selected = null;
  static int key = -1;

  public static void main(String[] args) {

    try {

      // Requisita todos os Bancos com qual existe o "convênio"
      Bank bank1 = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService");
      Bank bank2 = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService2");
      Bank bank3 = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService3");
      String nomeBanco = "";

      // Irá Executar o Programa em Loop
      inicio: while (true) {

        // Irá Exibir a Caixa de Dialogo até o momento em que o numero do cartão estiver
        // correto
        boolean existe = false;
        while (!existe) {
          // REcebe o numero do cartão
          String n = JOptionPane.showInputDialog("Número do Cartão: ");

          // Faz a pesquisa em todos os bancos para ver a existência do usuario
          if (bank1.getAccount(n) != -1) {
            state = n;
            selected = bank1;
            existe = true;
            nomeBanco = bank1.getName();
          } else if (bank2.getAccount(n) != -1) {
            state = n;
            selected = bank2;
            existe = true;
            nomeBanco = bank2.getName();
          } else if (bank3.getAccount(n) != -1) {
            state = n;
            selected = bank3;
            existe = true;
            nomeBanco = bank3.getName();
          }
        }

        // Enquanto a Operação não for finalizada irá aparecer as opções
        operacoes: while (key != 4) {

          // Caso nada seja selecionado, ou seja, janela for fechada, o programa encerra
          if (selected != null) {
            // lista de Opções
            Object[] options = { "Deposito", "Saque", "Extrato", "Transferência", "Encerrar Operação" };

            // Recebe a opção selecionada
            int menu = JOptionPane.showOptionDialog(null, "Qual operação você deseja Realizar ?",
                "Bem Vindo ao " + nomeBanco, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
                options[0]);

            // Realiza a operação de acordo com a opção selecionada
            switch (menu) {
            // Deposito
            case 0: {
              String valor = JOptionPane.showInputDialog("Valor: ");
              String senha = JOptionPane.showInputDialog("Senha: ");
              selected.makeDeposit(state, senha, Double.valueOf(valor));
              break;
            }
            // Saque
            case 1: {
              String valor = JOptionPane.showInputDialog("Valor: ");
              String senha = JOptionPane.showInputDialog("Senha: ");
              selected.makeWithdraw(state, senha, Double.valueOf(valor));
              break;
            }
            // Extrato
            case 2: {
              selected.getSale(state);
              break;
            }
            // Trasferência
            case 3: {
              String valor = JOptionPane.showInputDialog("Valor: ");
              String conta = JOptionPane.showInputDialog("Conta à receber: ");
              String senha = JOptionPane.showInputDialog("Senha: ");
              selected.makeTransfer(state, conta, senha, Double.valueOf(valor));
              break;
            }
            // Encerrar Operação
            case 4: {
              state = null;
              selected = null;
              break operacoes;
            }
            default: {
              break inicio;
            }

            }

          } else {
            // Encerra o Programa
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
