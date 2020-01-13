package opensdm.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import opensdm.logging.Logger;

public class JsonUtil {

    private static ObjectMapper jsonMapper = new ObjectMapper(new JsonFactory());

    public static void init() {
        jsonMapper.findAndRegisterModules();
        Logger.logInfo("JSON ObjectMapper initialized!");
    }

    public static ObjectMapper getJsonMapper() {
        return jsonMapper;
    }
}
