package custom.consumer;

import custom.framework.data_model.Invocation;
import custom.framework.factory.ProxyFactory;
import custom.protocol.http.HttpClient;
import custom.provider.MyService;

public class ConsumerStarter {

    public static void main(String[] args) {
        getServiceWithProxy();
    }

    public static void testGetService() {
        Invocation invocation = new Invocation();
        invocation.setInterfaceName(MyService.class.getName());
        invocation.setMethodName("getServiceInfo");
        invocation.setParamTypes(new Class[]{String.class});
        invocation.setParamValues(new Object[]{"consumer infos"});
        HttpClient client = new HttpClient();
        String result = client.send("localhost", 8080, invocation);
        System.out.println(result);
    }

    public static void getServiceWithProxy() {
        MyService myService = ProxyFactory.getProxy(MyService.class);
        String result = myService.getServiceInfo("message01");
        System.out.println(result);
        System.out.println(myService.getServiceInfo("message02"));
    }
}
