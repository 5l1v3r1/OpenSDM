package opensdm.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import opensdm.logging.Logger;
import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class ConfigurationLoader {

    public void loadConfiguration() throws IOException {
        Logger.logInfo("Loading Configuration...");
        Logger.logDebug(this.toString());
        File configFile = new File("config.yml");

        if(!configFile.exists()) {
            Logger.logDebug("No config file found! Creating...");
            URL defaultConfigUrl = getClass().getResource("/default_config.yml");;
            FileUtils.copyURLToFile(defaultConfigUrl, configFile);
        }

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        mapper.readValue(configFile, Configuration.class);
        Logger.logInfo("Configuration loaded!");
    }

    // TODO

}
