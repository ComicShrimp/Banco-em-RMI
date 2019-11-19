import java.rmi.Naming;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client {

  public static void main(String[] args) {

    try {
      Bank bank1 = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService");
      Bank bank2 = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService2");
      Bank bank3 = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService3");
      
      
      Tela t = new Tela();


    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
