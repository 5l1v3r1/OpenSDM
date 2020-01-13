package opensdm.devices;

import opensdm.devices.device.SmartDevice;
import opensdm.util.YamlUtil;

import java.io.IOException;

public class DeviceParser {

    public SmartDevice parseDeviceFromYAML(String yaml) throws IOException {

        SmartDevice smartDevice = YamlUtil.getYamlMapper().readValue(yaml, SmartDevice.class);

        return smartDevice;
    }

}
