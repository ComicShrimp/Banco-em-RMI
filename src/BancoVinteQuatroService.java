import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BancoVinteQuatroService extends UnicastRemoteObject implements BancoVinteQuatro {
	
	/**
     *
     */
    private static final long serialVersionUID = 1L;

    
	public BancoVinteQuatroService() throws RemoteException {}
	
	
	public String getSessao(String idToken) throws RemoteException {
		if(idToken.equals("abcdefgh")){
            return "Usuário Logado!";
        }

        return "Usuário não encontrado!";
	}
	

}