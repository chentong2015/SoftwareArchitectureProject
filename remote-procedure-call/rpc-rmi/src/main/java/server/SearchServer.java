package server;

import api.Search;
import api.SearchQuery;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

// TODO. 服务端版绑定特定名称的远程对象
public class SearchServer {

    public static void main(String[] args) throws Exception {
        // rmi registry within the server JVM with port 1900
        LocateRegistry.createRegistry(1901);

        // Binds the remote object by the name
        Search obj1 = new SearchQuery("search-object-1");
        Naming.rebind("rmi://localhost:1901/name1", obj1);

        Search obj2 = new SearchQuery("search-object-2");
        Naming.rebind("rmi://localhost:1901/name2", obj2);

        System.out.println("RMI registry finished, listen to request.. ");
    }
}