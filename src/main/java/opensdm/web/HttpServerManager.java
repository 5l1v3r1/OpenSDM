package opensdm.web;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import opensdm.config.ConfigurationManager;
import opensdm.logging.Logger;
import opensdm.web.api.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class HttpServerManager {

    HttpServer httpServer;

    public HttpServerManager() {
        try {
            httpServer = HttpServer.create(new InetSocketAddress(ConfigurationManager.getConfiguration().getHttpServerPort()), 0);
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

    public void startServer() throws UnknownHostException {
        httpServer.start();
        Logger.logInfo("Webserver started on port " + ConfigurationManager.getConfiguration().getHttpServerPort() + ". Api is at 'http://" + InetAddress.getLocalHost().getHostAddress() + ":" + ConfigurationManager.getConfiguration().getHttpServerPort() + "/api/...'");
    }

    public void stopServer() {
        httpServer.stop(0);
    }

}
