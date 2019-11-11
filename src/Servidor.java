import java.rmi.Naming;
import java.rmi.registry.LocateRegistry; 
import java.rmi.Remote;

public class Servidor {
	public static void main (String[] args ) {
		
		try {
            System.setProperty("java.rmi.server.hostname", "192.168.1.107");
            LocateRegistry.createRegistry(1099);
			BancoVinteQuatro servidor = new BancoVinteQuatroService();
			Naming.rebind("servidorbanco", (Remote)servidor);
			System.out.println("Servidor no Ar");
			
		}catch (Exception e ) {
			e.printStackTrace();
		}
	}

}