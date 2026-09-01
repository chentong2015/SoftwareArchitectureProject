package demo.provider;

import demo.framework.data_model.URL;
import demo.framework.factory.ProtocolFactory;
import demo.framework.protocol.Protocol;
import demo.register.LocalRegister;
import demo.register.RemoteRegister;

public class ServiceProvider {

    public static void main(String[] args) {
        // 1. ����ע�� {������: ʵ����}
        LocalRegister.register(MyService.class.getName(), MyServiceImpl.class);

        // 2. Զ��ע������ע�� {������: List<URL>}
        URL url = new URL("localhost", 8080); // ����ʹ�ñ�����ַ
        RemoteRegister.register(MyService.class.getName(), url);

        // 3. ������ͬЭ���µ�Server�����ṩ��, ͨ������ģʽ��̬����
        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.startServer(url);
    }
}
