package opensdm.devices;

import opensdm.devices.device.SmartDevice;

import java.util.ArrayList;

public class DeviceManager {

    ArrayList<SmartDevice> smartDevices = new ArrayList();

    public void registerNewDevice(SmartDevice smartDevice) {
        this.smartDevices.add(smartDevice);
    }

    public void update() {
        for(SmartDevice sd : smartDevices) {
            sd.update();
        }
    }

}
