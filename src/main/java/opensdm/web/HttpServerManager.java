package opensdm.web;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import opensdm.logging.Logger;
import opensdm.web.api.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerManager {

    HttpServer httpServer;
    int port = 80;

    public HttpServerManager() {
        try {
            httpServer = HttpServer.create(new InetSocketAddress(port), 0);
        } catch (IOException e) {
            Logger.logError(e.getMessage());
        }
    }

    public void registerEndpoint(String path, HttpHandler httpHandler) {
        httpServer.createContext(path, httpHandler);
        Logger.logDebug("Initialized API endpoint: " + path + "\t  -> " + httpHandler.getClass().getName());
    }

    public void registerApiEndpoints() {
        registerEndpoint("/api/getAllDevices", new GetAllDevicesHandler());
        registerEndpoint("/api/ping", new PingHandler());
        registerEndpoint("/api/indexDevices", new IndexDevicesHandler());
        registerEndpoint("/api", new ListEndpointsHandler());
        Logger.logInfo("All API endpoints initialized");
    }

    public void startServer() {
        httpServer.start();
        Logger.logInfo("Webserver started on port " + port + ". Api is at 'http://this.device:" + port + "/api/...'");
    }

    public void stopServer() {
        httpServer.stop(0);
    }

}
