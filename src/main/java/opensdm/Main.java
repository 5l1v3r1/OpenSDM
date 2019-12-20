package opensdm;

import opensdm.config.ConfigurationLoader;
import opensdm.devices.*;
import opensdm.logging.Logger;
import opensdm.web.HttpServerManager;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) {
        try {
            Logger.initalizeLogger();
        } catch (IOException e) {
            System.err.println("Can't initalize logger!\n");
            e.printStackTrace();
        }

        Logger.logInfo("Starting up, please wait...");

        ConfigurationLoader confLoader = new ConfigurationLoader();
        try {
            confLoader.loadConfiguration();
        } catch (IOException | URISyntaxException e) {
            Logger.logError(e.getMessage());
        }

        HttpServerManager hsm = new HttpServerManager();
        hsm.registerApiEndpoints();
        hsm.startServer();

        DeviceIndexer deviceIndexer = new DeviceIndexer();
        deviceIndexer.indexDevices();
    }

}
