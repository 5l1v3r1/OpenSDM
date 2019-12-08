package opensdm.config;


public class Configuration {

    private static Configuration configuration = new Configuration();

    public static Configuration getConfiguration() {
        return configuration;
    }


    public String subnet = "";
    public boolean showDebugMessages = false;
    public boolean log = true;

}
