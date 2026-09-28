package api;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Define the remote interface
// extends the interface java.rmi.Remote and declares a set of remote methods.
public interface Search extends Remote {


    String query(String search) throws RemoteException;
}
