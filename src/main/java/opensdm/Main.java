package opensdm;

import opensdm.config.ConfigurationLoader;
import opensdm.logging.Logger;
import opensdm.web.HttpServerManager;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    private static HttpServerManager hsm = new HttpServerManager();

    public static void main(String[] args) {
        try {
            Logger.initalizeLogger();
        } catch (IOException e) {
            System.err.println("Can't initalize logger!\n");
            e.printStackTrace();
        }

        Logger.logInfo("Starting up, please wait...");
        Logger.logInfo("Loading configuration...");

        ConfigurationLoader confLoader = new ConfigurationLoader();
        try {
            confLoader.loadConfiguration();
        } catch (IOException | URISyntaxException e) {
            Logger.logError(e.getMessage());
        }

        hsm.registerApiEndpoints();
        hsm.startServer();


    }

    public static void exit(int status) {
        hsm.startServer();
        System.exit(status);
    }

}
