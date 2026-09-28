package custom.framework.protocol;

import custom.framework.data_model.Invocation;
import custom.framework.data_model.URL;
import custom.protocol.http.HttpClient;
import custom.protocol.http.HttpServer;

public class HttpProtocol implements Protocol {

    private HttpServer server;
    private HttpClient client;

    @Override
    public void startServer(URL url) {
        if (server == null) server = new HttpServer();
        server.start(url.getHostname(), url.getPort());
    }

    @Override
    public String sendInvocation(URL url, Invocation invocation) {
        if (client == null) client = new HttpClient();
        return client.send(url.getHostname(), url.getPort(), invocation);
    }
}
