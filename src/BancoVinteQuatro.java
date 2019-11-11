import java.rmi.Remote;
import java.rmi.RemoteException;

interface BancoVinteQuatro extends Remote {
    
    public String getSessao(String idToken) throws RemoteException;
	

}