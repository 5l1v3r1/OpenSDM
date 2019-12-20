package opensdm.devices;

import opensdm.config.ConfigurationManager;
import opensdm.logging.Logger;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

public class DeviceIndexer {

    public void indexDevices() throws IOException {
        Logger.logInfo("Indexing devices...");
        int devicesFound = 0;
        ArrayList<String> devicesToIndex = new ArrayList<>();

        for(int i = 0; i <= 255; i++) {
            if(checkIp(ConfigurationManager.getConfiguration().getSubnet().replace("*", "") + i)) {
                devicesFound++;
                Logger.logDebug("New device discovered at " + ConfigurationManager.getConfiguration().getSubnet().replace("*", "") + i);
                devicesToIndex.add(ConfigurationManager.getConfiguration().getSubnet().replace("*", "") + i);
            }
        }

        Logger.logInfo("Found " + devicesFound + " devices!");
    }

    private final CloseableHttpClient httpClient = HttpClients.createSystem();

    boolean checkIp(String ip) throws IOException {
        Logger.logDebug("Checking IP " + ip);
        boolean isSmartDevice = false;
        if (InetAddress.getByName(ip).isReachable(ConfigurationManager.getConfiguration().getDeviceTimeout())) {
            /**HttpGet request = new HttpGet("http://" + ip + "/whoareyou");
            request.addHeader(HttpHeaders.USER_AGENT, "OpenSDM Indexer");

            HttpResponse httpResponse = httpClient.execute(request);

            if (EntityUtils.toString(httpResponse.getEntity()) == "opensdm_smartdevice") {
                isSmartDevice = true;
            }**/
        }
        return isSmartDevice;
    }

}
