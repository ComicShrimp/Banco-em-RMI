import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class Server2 {
  Server2() {
    try {
      System.setProperty("java.rmi.hostname", "127.0.0.1");
      LocateRegistry.createRegistry(1100);

      Bank bank2 = new Bank2Service();
      Naming.rebind("BancoService2", (Remote) bank2);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new Server();
  }
}