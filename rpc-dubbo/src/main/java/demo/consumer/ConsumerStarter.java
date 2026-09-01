package demo.consumer;

import demo.framework.data_model.Invocation;
import demo.framework.factory.ProxyFactory;
import demo.protocol.http.HttpClient;
import demo.provider.MyService;

public class ConsumerStarter {

    public static void main(String[] args) {
        getServiceWithProxy();
    }

    // ����HttpЭ�飬ͨ������ָ����"����Э��(��Ϣ)"����ȡ�������ṩ��ָ������Ľ��
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

    // ʹ�ö�̬������Ҫ���ڲ�ͬ��Э�����ã����õ�Զ�̲�ͬ�ķ���
    public static void getServiceWithProxy() {
        // �õ�ʵ����ָ���ӿڵĴ������
        MyService myService = ProxyFactory.getProxy(MyService.class);
        // ͨ�����������÷�����ʵ�ʻ���õ�InvocationHandler.invoke()����
        String result = myService.getServiceInfo("message01");
        System.out.println(result);
        System.out.println(myService.getServiceInfo("message02"));
    }
}
