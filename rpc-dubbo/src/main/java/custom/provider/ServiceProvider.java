package custom.provider;

import custom.framework.data_model.URL;
import custom.framework.factory.ProtocolFactory;
import custom.framework.protocol.Protocol;
import custom.register.LocalRegister;
import custom.register.RemoteRegister;

public class ServiceProvider {

    public static void main(String[] args) {
        LocalRegister.register(MyService.class.getName(), MyServiceImpl.class);

        URL url = new URL("localhost", 8080);
        RemoteRegister.register(MyService.class.getName(), url);

        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.startServer(url);
    }
}
