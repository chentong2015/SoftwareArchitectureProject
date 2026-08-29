package client;

import api.Search;

import java.rmi.Naming;

// TODO. 客户端通过名称找到远程对象
public class ClientRequest {

    public static void main(String[] args) throws Exception {
        // lookup method to find reference of remote object
        Search objectFound1 = (Search) Naming.lookup("rmi://localhost:1901/name1");
        String response1 = objectFound1.query("Reflection in Java");
        System.out.println(response1);

        // 通过名称找到远程的另一个对象, 通过接口调用API
        Search objectFound2 = (Search) Naming.lookup("rmi://localhost:1901/name2");
        String response2 = objectFound2.query("Test search name");
        System.out.println(response2);
    }
}