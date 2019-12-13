package opensdm.config;

public class ConfigurationManager {

    private static Configuration config;

    public static void setConfiguration(Configuration config) {
        ConfigurationManager.config = config;
    }

    public static Configuration getConfiguration() {
        return config;
    }
}
