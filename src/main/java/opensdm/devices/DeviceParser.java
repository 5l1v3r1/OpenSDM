package opensdm.devices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import opensdm.devices.device.SmartDevice;

import java.io.IOException;

public class DeviceParser {

    public SmartDevice parseDeviceFromYAML(String yaml) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        mapper.findAndRegisterModules();

        SmartDevice smartDevice = mapper.readValue(yaml, SmartDevice.class);


        return null;
    }

}
