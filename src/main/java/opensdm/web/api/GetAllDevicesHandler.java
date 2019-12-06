package opensdm.web.api;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import opensdm.logging.Logger;

import java.io.IOException;

public class GetAllDevicesHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange h) throws IOException {
        Logger.logDebug("New Requst: /api/getAllDevices");

    }

}
