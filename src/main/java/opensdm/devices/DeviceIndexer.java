package opensdm.devices;

import opensdm.config.ConfigurationManager;
import opensdm.logging.Logger;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

public class DeviceIndexer {

    DeviceParser deviceParser = new DeviceParser();

    public void indexDevices() {
        Logger.logInfo("Indexing devices...");
        int devicesFound = 0;
        ArrayList<String> devicesToIndex = new ArrayList<>();

        for(int i = 0; i <= 255; i++) {
            boolean isSmartDevice = checkIp(ConfigurationManager.getConfiguration().getSubnet().replace("*", "") + i);

            if(isSmartDevice) {
                devicesFound++;
                Logger.logDebug("New device discovered at " + ConfigurationManager.getConfiguration().getSubnet().replace("*", "") + i);
                devicesToIndex.add(ConfigurationManager.getConfiguration().getSubnet().replace("*", "") + i);
            }
        }

        Logger.logInfo("Found " + devicesFound + " devices!");
        Logger.logInfo("Parsing devices...");

        for(String ip : devicesToIndex) {
            HttpGet request = new HttpGet("http://" + ip + "/deviceinfo");
            request.addHeader(HttpHeaders.USER_AGENT, "OpenSDM Indexer");

            HttpResponse httpResponse;

            try {
                httpResponse = httpClient.execute(request);
            } catch (IOException e) {
                Logger.logError("Error while trying to get SmartDevice information: " + e.getMessage());
                continue;
            }

            try {
                Logger.logDebug("Device at " + ip + " returned information: " + EntityUtils.toString(httpResponse.getEntity()));
            } catch (IOException e) {
                Logger.logError(e.getMessage());
            }

            try {
                DeviceManager.getDeviceManager().registerNewDevice(deviceParser.parseDeviceFromYAML(EntityUtils.toString(httpResponse.getEntity())), ip);
            } catch (IOException e) {
                Logger.logError("Critical Error while registering new device: " + e.getMessage());
            }
        }
    }

    private final CloseableHttpClient httpClient = HttpClients.createSystem();

    boolean checkIp(String ip) {
        if(ConfigurationManager.getConfiguration().isShowDeviceIndexerDebugMessages()) {
            Logger.logDebug("Checking IP " + ip);
        }

        boolean isSmartDevice = false;

        try {
            if (InetAddress.getByName(ip).isReachable(ConfigurationManager.getConfiguration().getDeviceTimeout())) {
                HttpGet request = new HttpGet("http://" + ip + "/whoareyou");
                request.addHeader(HttpHeaders.USER_AGENT, "OpenSDM Indexer");

                HttpResponse httpResponse = httpClient.execute(request);

                if (EntityUtils.toString(httpResponse.getEntity()) == "opensdm_smartdevice") {
                    isSmartDevice = true;
                }

                if(!isSmartDevice) {
                    Logger.logDebug("Device at " + ip + " is reachable but isn't an OpenSDM SmartDevice");
                }
            }
        } catch(IOException e) {
            Logger.logError(e.getMessage());
        }

        return isSmartDevice;
    }

}
