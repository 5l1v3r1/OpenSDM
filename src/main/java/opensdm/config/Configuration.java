package opensdm.config;


public class Configuration {

    private static Configuration configuration = new Configuration();

    public static Configuration getConfiguration() {
        return configuration;
    }


    private String subnet = "";

    public String getSubnet() {
        return subnet;
    }
}
