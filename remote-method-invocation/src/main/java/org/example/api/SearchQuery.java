package org.example.api;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// To implement the remote interface, the class should extend to UnicastRemoteObject
public class SearchQuery extends UnicastRemoteObject implements Search {

    private String name;

    public SearchQuery(String name) throws RemoteException {
        super();
        this.name = name;
    }

    // Implementation of the query interface
    public String query(String search) throws RemoteException {
        String result;
        if (search.equals("Reflection in Java")) {
            result = "Found by " + name;
        } else {
            result = "Not Found " + name;
        }
        return result;
    }
}