package opensdm.web.api.devices;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import opensdm.logging.Logger;
import opensdm.web.HttpServerHelper;

import java.io.IOException;
import java.io.OutputStream;

public class SendDataHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange h) throws IOException { //TODO
        Logger.logDebug("New Requst: /api/devices/sendData");

        if(!HttpServerHelper.checkAPIKey(h.getRequestURI().getQuery())) {
            String response = "Unauthenticated!";
            h.sendResponseHeaders(401, response.length());
            OutputStream os = h.getResponseBody();
            os.write(response.getBytes());
            os.close();
            return;
        }

    }

}
