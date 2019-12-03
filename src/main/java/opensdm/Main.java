package opensdm;

import opensdm.logging.Logger;
import opensdm.web.HttpServerManager;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Logger.initalizeLogger();
        } catch (IOException e) {
            System.err.println("Can't initalize logger!\n");
            e.printStackTrace();
        }

        Logger.logInfo("Starting up, please wait...");
        Logger.logInfo("Loading devices...");


        HttpServerManager hsm = new HttpServerManager();
        hsm.registerApiEndpoints();
        hsm.startServer();
    }

}
