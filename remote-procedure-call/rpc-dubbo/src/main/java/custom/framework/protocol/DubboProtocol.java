package custom.framework.protocol;

import custom.framework.data_model.Invocation;
import custom.framework.data_model.URL;
import custom.protocol.dubbo.NettyClient;
import custom.protocol.dubbo.NettyServer;

// 具体协议的实现
public class DubboProtocol implements Protocol {

    // TODO: 避免Netty Server的多次启动和Netty Client的多次连接
    private NettyServer server;
    private NettyClient client;

    @Override
    public void startServer(URL url) {
        if (server == null) server = new NettyServer();
        server.start(url.getPort());
    }

    @Override
    public String sendInvocation(URL url, Invocation invocation) {
        if (client == null) client = new NettyClient();
        return client.send(url.getHostname(), url.getPort(), invocation);
    }
}
