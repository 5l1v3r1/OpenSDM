package opensdm.devices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import opensdm.devices.device.SmartDevice;
import opensdm.logging.Logger;
import opensdm.util.YamlUtil;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
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

        File deviceYaml = new File("devices/" + smartDevice.getUuid());

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

    public void registerNewDevice(SmartDevice smartDevice, String ip) {
        smartDevice.setAddress(ip);
        getDeviceManager().getSmartDevices().add(smartDevice);
        saveSmartDevice(smartDevice);
    }

    public void loadDevices() {
        File devicesFolder = new File("devices/");

        if(!devicesFolder.exists()) {
            Logger.logInfo("Devices folder not found. Creating and skipping indexing...");

            devicesFolder.mkdir();

            return;
        }

        File[] files = devicesFolder.listFiles();

        int devicesLoaded = 0;

        for(File f : files) {
            SmartDevice smartDevice = null;

            try {
                smartDevice = YamlUtil.getYamlMapper().readValue(f, SmartDevice.class);
                getDeviceManager().getSmartDevices().add(smartDevice);
                devicesLoaded++;

                Logger.logDebug("Loaded SmartDevice \"" + smartDevice.getName() + "\" with UUID \"" + smartDevice.getUuid() + "\"");
            } catch (IOException e) {
                Logger.logError("Failed to load device \"" + smartDevice.getName() + "\" with UUID \"" + smartDevice.getUuid() + "\": " + e.getMessage());
            }
        }

        Logger.logInfo("Loaded " + devicesLoaded + " devices");
    }


    public void update() {
        for(SmartDevice sd : getDeviceManager().getSmartDevices()) {
            sd.update();
        }
    }

}
