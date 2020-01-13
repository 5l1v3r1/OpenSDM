package opensdm.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import opensdm.logging.Logger;

public class YamlUtil {

    static ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

    public static void init() {
        yamlMapper.findAndRegisterModules();
        Logger.logInfo("Yaml mapper initialized");
    }

    public static ObjectMapper getYamlMapper() {
        return yamlMapper;
    }
}
