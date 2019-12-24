package opensdm.web.api;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import opensdm.logging.Logger;
import opensdm.devices.DeviceIndexer;
import opensdm.web.HttpServerHelper;

import java.io.IOException;
import java.io.OutputStream;

public class IndexDevicesHandler implements HttpHandler {

    DeviceIndexer deviceIndexer = new DeviceIndexer();

    @Override
    public void handle(HttpExchange h) throws IOException {
        Logger.logDebug("New Requst: /api/indexDevices");

        if(!HttpServerHelper.checkAPIKey(h.getRequestURI().getQuery())) {
            String response = "wrong apiKey";
            h.sendResponseHeaders(200, response.length());
            OutputStream os = h.getResponseBody();
            os.write(response.getBytes());
            os.close();
            return;
        }

        deviceIndexer.indexDevices();
    }

}
