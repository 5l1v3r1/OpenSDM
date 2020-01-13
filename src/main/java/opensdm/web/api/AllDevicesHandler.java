package opensdm.web.api;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import opensdm.devices.DeviceManager;
import opensdm.devices.device.SmartDevice;
import opensdm.logging.Logger;
import opensdm.util.JsonUtil;
import opensdm.web.HttpServerHelper;

import java.io.IOException;
import java.io.OutputStream;

public class AllDevicesHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange h) throws IOException {
        Logger.logDebug("New Requst: /api/allDevices");

        if(!HttpServerHelper.checkAPIKey(h.getRequestURI().getQuery())) {
            String response = "Unauthenticated!";
            h.sendResponseHeaders(401, response.length());
            OutputStream os = h.getResponseBody();
            os.write(response.getBytes());
            os.close();
            return;
        }


        String sJson = JsonUtil.getJsonMapper().writeValueAsString(DeviceManager.getDeviceManager().getSmartDevices());

        h.sendResponseHeaders(200, sJson.length());
        OutputStream os = h.getResponseBody();
        os.write(sJson.getBytes());
        os.close();
    }

}
