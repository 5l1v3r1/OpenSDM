package opensdm.web;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import opensdm.logging.Logger;
import opensdm.web.api.GetAllDevicesHandler;
import opensdm.web.api.IndexDevicesHandler;
import opensdm.web.api.PingHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerManager {

    HttpServer httpServer;

    public HttpServerManager() {
        try {
            httpServer = HttpServer.create(new InetSocketAddress(80), 0);
        } catch (IOException e) {
            Logger.logError(e.getMessage());
        }
    }

    public void registerEndpoint(String path, HttpHandler httpHandler) {
        httpServer.createContext(path, httpHandler);
    }

    public void registerApiEndpoints() {
        registerEndpoint("/api/getAllDevices", new GetAllDevicesHandler());
        registerEndpoint("/api/ping", new PingHandler());
        registerEndpoint("/api/indexDevices", new IndexDevicesHandler());
    }

    public void startServer() {
        httpServer.start();
    }

}
