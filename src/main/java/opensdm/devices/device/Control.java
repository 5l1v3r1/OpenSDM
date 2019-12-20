package opensdm.devices.device;

public class Control {

    private String name = "";
    private String type = "";
    private String color = "";
    private int max = 0;
    private int min = 0;
    private Object value = null;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
