import java.rmi.Naming;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client {

  public static void main(String[] args) {

    try {
      Bank bd = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService");
      bd.getAccount("5171 0511 6130 1176");
      ///bd.makeTransfer("5171 0511 6130 1176", "5581 7461 6024 0275", 100.00);
      // bd.makeDeposit("5171 0511 6130 1176", 200.00);
    
    
      //  Bank st = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService2");
    //  System.out.println(st.getName());



    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}