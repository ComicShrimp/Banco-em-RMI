package Example;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class CalculadoraServer {
  CalculadoraServer() {
    try {
      System.setProperty("java.rmi.server.hostname", "192.168.1.107");
      LocateRegistry.createRegistry(1099);
      Calculadora c = new CalculadoraImple();
      System.out.println("Object Received");
      Naming.bind("CalculadoraService", (Remote) c);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new CalculadoraServer();
  }
}