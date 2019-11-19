import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class Server {
  Server() {
    try {
      Bank c = new BankService();
      Naming.rebind("BancoService", (Remote) c);
      Bank a = new BankService2();
      Naming.rebind("BancoService2", (Remote) a);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new Server();
  }
}