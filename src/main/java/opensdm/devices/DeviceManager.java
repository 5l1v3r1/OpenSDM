package opensdm.devices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import opensdm.devices.device.SmartDevice;
import opensdm.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DeviceManager {

    private static DeviceManager deviceManager = new DeviceManager();

    public static DeviceManager getDeviceManager() {
        return deviceManager;
    }


    ArrayList<SmartDevice> smartDevices = new ArrayList();

    public ArrayList<SmartDevice> getSmartDevices() {
        return smartDevices;
    }

    private void saveSmartDevice(SmartDevice smartDevice) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));

        File deviceYaml = new File("devices/" + smartDevice.getId());

        try {
            deviceYaml.createNewFile();
        } catch (IOException e) {
            Logger.logError(e.getMessage());
        }

        try {
            mapper.writeValue(deviceYaml, smartDevice);
        } catch (IOException e) {
            Logger.logError(e.getMessage());
        }
    }

    public void registerNewDevice(SmartDevice smartDevice) {
        getDeviceManager().getSmartDevices().add(smartDevice);
        saveSmartDevice(smartDevice);
    }

    public void autoRegisterNewDevice(String address) {

    }

    public void update() {
        for(SmartDevice sd : getDeviceManager().getSmartDevices()) {
            sd.update();
        }
    }

}
