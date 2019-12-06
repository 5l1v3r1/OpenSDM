package opensdm.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import opensdm.logging.Logger;
import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ConfigurationLoader {

    public void loadConfiguration() throws IOException, URISyntaxException {
        Logger.logInfo("Loading Configuration...");
        File configFile = new File("config.yml");

        if(!configFile.exists()) {
            Logger.logDebug("No config file found! Creating...");

            // I'm sorry...
            String hardcodedConfig = "subnet: 192.168.1.*\n";

            BufferedWriter bw = new BufferedWriter(new FileWriter(configFile));
            bw.write(hardcodedConfig);
        }

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        mapper.readValue(configFile, Configuration.class);
        Logger.logInfo("Configuration loaded!");
    }

    // TODO

}
