import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class Server {
  // Construtor do Server
  Server() {
    try {
      // Registra o servidor no rmi ("rmiregistry")
      System.setProperty("java.rmi.hostname", "127.0.0.1");
      LocateRegistry.createRegistry(1099);

      // Disponibiliza todos os 3 BankServices
      Bank bank1 = new BankService();
      Naming.rebind("BancoService", (Remote) bank1);

      Bank bank2 = new Bank2Service();
      Naming.rebind("BancoService2", (Remote) bank2);

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