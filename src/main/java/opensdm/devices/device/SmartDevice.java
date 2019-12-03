package opensdm.devices.device;

public class SmartDevice {

    private Control[] controls;
    private String name = "";
    private String address = "";

    public SmartDevice(Control[] controls, String name, String address) {
        this.controls = controls;
        this.name = name;
        this.address = address;
    }

    public void update() {

    }

}
