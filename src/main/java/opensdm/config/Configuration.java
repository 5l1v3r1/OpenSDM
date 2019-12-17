package opensdm.config;


public class Configuration {

    private String subnet = "";
    private int deviceTimeout = 200;
    private int deviceRequestTimeout = 1000;

    private boolean showDebugMessages = false;

    private int httpServerPort = 80;

    public int getHttpServerPort() {
        return httpServerPort;
    }

    public int getDeviceTimeout() {
        return deviceTimeout;
    }

    public String getSubnet() {
        return subnet;
    }

    public boolean isShowDebugMessages() {
        return showDebugMessages;
    }

    public int getDeviceRequestTimeout() {
        return deviceRequestTimeout;
    }
}
