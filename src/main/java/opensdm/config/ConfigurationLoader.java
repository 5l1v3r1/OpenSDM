package opensdm.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import opensdm.logging.Logger;
import opensdm.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class ConfigurationLoader {

    public void loadConfiguration() throws IOException, URISyntaxException {
        Logger.logInfo("Loading Configuration...");
        File configFile = new File("config.yml");

        if(!configFile.exists()) {
            Logger.logDebug("No config file found! Creating...");

            try {
                FileUtils.exportResource("/default_config.yml");
            } catch (Exception e) {
                Logger.logError(e.getMessage());

            }
        }

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        mapper.readValue(configFile, Configuration.class);
        Logger.logInfo("Configuration loaded!");
    }

}
