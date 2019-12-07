package opensdm.config;


public class Configuration {

    private static Configuration configuration = new Configuration();

    public static Configuration getConfiguration() {
        return configuration;
    }


    private String subnet = "";
    private boolean showDebugMessages = false;

    public boolean isShowDebugMessages() {
        return showDebugMessages;
    }

    public String getSubnet() {
        return subnet;
    }
}
