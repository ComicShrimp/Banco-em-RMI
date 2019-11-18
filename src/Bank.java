import java.rmi.Remote; 
import java.rmi.RemoteException; 

interface Bank extends Remote{ 

    
    public boolean getAccount(String token) throws RemoteException;
    public double makeWithdraw(String tokenId, double value) throws RemoteException;
    public void makeDeposit(String tokenId, double value) throws RemoteException;
    public boolean makeTransfer(String fromUser, String toUser, double value) throws RemoteException;
    public void getSale(String tokenId) throws RemoteException;
}