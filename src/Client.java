import java.rmi.Naming;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client {

  public static void main(String[] args) {

    try {
<<<<<<< HEAD
      Bank bd = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService");
      bd.getAccount("5171 0511 6130 1176");
      ///bd.makeTransfer("5171 0511 6130 1176", "5581 7461 6024 0275", 100.00);
       bd.makeWithdraw("5171 0511 6130 1176", "1234567",200.00);
    
    
      //  Bank st = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService2");
    //  System.out.println(st.getName());
=======
      Bank bank1 = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService");

      Bank bank2 = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService2");
>>>>>>> d5d283b5f9ca9b8581eca5f18c564fab8b669cd8

      Bank bank3 = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService3");

      /// bd.makeTransfer("5171 0511 6130 1176", "5581 7461 6024 0275", 100.00);
      // bd.makeDeposit("5171 0511 6130 1176", 200.00);

      // Bank st = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService2");
      // System.out.println(st.getName());

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
