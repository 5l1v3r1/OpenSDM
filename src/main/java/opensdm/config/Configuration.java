package opensdm.config;

import sun.security.krb5.Config;

public class Configuration {

    private static Configuration configuration = new Configuration();

    public static Configuration getConfiguration() {
        return configuration;
    }


    private String subnet = "";

}
