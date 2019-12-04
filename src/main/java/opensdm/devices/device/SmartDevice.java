package opensdm.devices.device;

public class SmartDevice {

    private Control[] controls;
    private String name = "";
    private String address = "";
    private String id = "";

    public Control[] getControls() {
        return controls;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public SmartDevice(Control[] controls, String name, String address, String id) {
        this.controls = controls;
        this.name = name;
        this.address = address;
        this.id = id;
    }

    public void update() {

    }

}
