import java.rmi.Remote;
import java.rmi.RemoteException;

interface Bank extends Remote {

  public String getName() throws RemoteException;

  public int getAccount(String token) throws RemoteException;

  public double makeWithdraw(String tokenId, String password, double value) throws RemoteException;

  public void makeDeposit(String tokenId, String password, double value) throws RemoteException;

  public boolean makeTransfer(String fromUser, String toUser, String password, double value) throws RemoteException;

  public void getSale(String tokenId) throws RemoteException;
}