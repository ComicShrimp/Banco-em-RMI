import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class Server3 {
  Server3() {
    try {
      System.setProperty("java.rmi.hostname", "127.0.0.1");
      LocateRegistry.createRegistry(1101);

      Bank bank3 = new Bank3Service();
      Naming.rebind("BancoService3", (Remote) bank3);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new Server();
  }
}