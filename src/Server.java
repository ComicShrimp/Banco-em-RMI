
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry; 

public class Server  
{ 
    Server() 
    { 
        try
        { 
           	System.setProperty("java.rmi.server.hostname", "127.0.0.1");
           	LocateRegistry.createRegistry(1099);
           	Bank c = new BankService();
           	Naming.rebind("BancoService",(Remote)c);
        
        }catch (Exception e){
            e.printStackTrace();	
        } 
    } 
    public static void main(String[] args)  
    { 
        new Server(); 
    } 
}   