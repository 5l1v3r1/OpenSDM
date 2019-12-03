package opensdm.devices.device;

public class Control {

    ControlType ct;
    String name = "";
    Object value;

    public Control(ControlType ct, String name, String value) {
        this.ct = ct;
        this.name = name;
        this.value = value;
    }

    public Control(ControlType ct, String name, int value) {
        this.ct = ct;
        this.name = name;
        this.value = value;
    }

    public Control(ControlType ct, String name, boolean value) {
        this.ct = ct;
        this.name = name;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
