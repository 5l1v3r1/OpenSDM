package opensdm.devices.device;

import java.util.List;

public class SmartDevice {

    private List<Control> controls;
    private String name = "";
    private String location = "";
    private String uuid = "";
    private String icon = "";

    private String address = "";


    public List<Control> getControls() {
        return controls;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    public String getIcon() {
        return icon;
    }

    public void update() {

    }

}
