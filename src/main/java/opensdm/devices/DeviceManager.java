package opensdm.devices;

import opensdm.devices.device.Control;
import opensdm.devices.device.ControlType;
import opensdm.devices.device.SmartDevice;

public class DeviceManager {

    public void registerDevices() {
        SmartDevice s = new SmartDevice(new Control[]{
                new Control(ControlType.BUTTON),
                new Control(ControlType.SLIDER)
        });
    }
}
