package opensdm.web;

import opensdm.config.ConfigurationManager;

import java.util.HashMap;
import java.util.Map;

public class HttpServerHelper {

    public static Map<String, String> queryToMap(String query) {
        Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0], entry[1]);
            }else{
                result.put(entry[0], "");
            }
        }
        return result;
    }

    public static boolean checkAPIKey(String query) {
        return HttpServerHelper.queryToMap(query).get("apiKey") == ConfigurationManager.getConfiguration().getMasterKey();
    }

}
