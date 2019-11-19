package BancoRMI;

import java.rmi.Naming;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client {

  public static void main(String[] args) {

    try {
      Bank bd = (Bank) Naming.lookup("//127.0.0.1:1099/BancoService");
      boolean b = bd.getAccount("5314 4726 2902 1966");
      if (b) {
        while (true) {
          System.out.println("Bem Vindo Fulano");
          System.out.println("5314 4726 2902 1966");
          System.out.println("Escolha a operação que deseja realizar: ");
          int op;
          System.out.println("1 - Saque");
          System.out.println("2 - Depósito");
          System.out.println("3 - Extrato");
          System.out.println("0 - Sair");
          Scanner reader = new Scanner(System.in);
          op = reader.nextInt();
          switch (op) {
          case 1:
            System.out.println();
            bd.makeWithdraw("5314 4726 2902 1966", 15);
            System.out.println();
            reader.nextLine();
            break;
          case 2:
            System.out.println();
            bd.makeDeposit("5314 4726 2902 1966", 15);
            reader.nextLine();
            break;
          case 3:
            System.out.println();
            bd.getSale("5314 4726 2902 1966");
            reader.nextLine();
            break;
          }

        }
      } else {
        System.out.println("Insira o cartão corretamente!");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
