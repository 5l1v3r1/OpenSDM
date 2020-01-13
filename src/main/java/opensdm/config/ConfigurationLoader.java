package opensdm.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import opensdm.logging.Logger;
import opensdm.util.FileUtils;
import opensdm.util.YamlUtil;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class ConfigurationLoader {

    public void loadConfiguration() throws IOException, URISyntaxException {
        Logger.logInfo("Loading Configuration...");
        File configFile = new File("config.yml");

        if(!configFile.exists()) {
            Logger.logInfo("No config file found! Creating...");
            try {
                FileUtils.exportResource("/config.yml");
            } catch (Exception e) {
                Logger.logError(e.getMessage());
            }
        }

        ConfigurationManager.setConfiguration(YamlUtil.getYamlMapper().readValue(configFile, Configuration.class));
        Logger.logInfo("Configuration loaded!");
    }

}
