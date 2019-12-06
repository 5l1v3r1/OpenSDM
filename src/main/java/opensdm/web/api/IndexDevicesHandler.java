package opensdm.web.api;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import opensdm.devices.DeviceIndexer;
import opensdm.logging.Logger;

public class IndexDevicesHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange h) {
        Logger.logDebug("New Requst: /api/indexDevices");
    }

}
