package opensdm.web.api;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import opensdm.logging.Logger;

import java.io.IOException;
import java.io.OutputStream;

public class PingHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange h) throws IOException {
        Logger.logDebug("New Requst: /api/ping");
        String response = "pong";
        h.sendResponseHeaders(200, response.length());
        OutputStream os = h.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
