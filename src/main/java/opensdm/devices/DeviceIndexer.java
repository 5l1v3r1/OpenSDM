package opensdm.devices;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.InetAddress;

public class DeviceIndexer {

    public void indexDevices() {

    }

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    boolean checkIp(String ip) throws IOException {
        boolean isSmartDevice = false;
        if (InetAddress.getByName(ip).isReachable(2000)) {
            HttpGet request = new HttpGet("http://" + ip + "/whoareyou");
            request.addHeader(HttpHeaders.USER_AGENT, "OpenSDM");
            if (EntityUtils.toString(httpClient.execute(request).getEntity()) == "opensdm_smartdevice") {
                isSmartDevice = true;
            }
        }
        return isSmartDevice;
    }

}
