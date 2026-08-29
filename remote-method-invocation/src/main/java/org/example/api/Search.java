package org.example.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Search extends Remote {

    // Declaring the method prototype
    String query(String search) throws RemoteException;
}
