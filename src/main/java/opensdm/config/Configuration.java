package opensdm.config;


public class Configuration {

    public Configuration() {

    }

    public Configuration(String subnet, boolean showDebugMessages, int httpServerPort) {
        this.httpServerPort = httpServerPort;
        this.showDebugMessages = showDebugMessages;
        this.subnet = subnet;
    }

    private static Configuration configuration = new Configuration();

    public static Configuration getConfiguration() {
        return configuration;
    }


    private String subnet = "";
    private boolean showDebugMessages = false;
    private int httpServerPort = 80;


    public int getHttpServerPort() {
        return httpServerPort;
    }

    public void setHttpServerPort(int httpServerPort) {
        this.httpServerPort = httpServerPort;
    }

    public String getSubnet() {
        return subnet;
    }

    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    public boolean isShowDebugMessages() {
        return showDebugMessages;
    }

    public void setShowDebugMessages(boolean showDebugMessages) {
        this.showDebugMessages = showDebugMessages;
    }
}
