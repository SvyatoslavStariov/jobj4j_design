package ru.job4j.serialization.json;

import org.json.JSONPropertyIgnore;

import java.util.Objects;

public class ZoneControl {

    private String area;

    private GeneralInspector inspector;

    public ZoneControl() {
    }

    public ZoneControl(String area) {
        this.area = area;
    }

    public ZoneControl(String area, GeneralInspector inspector) {
        this.area = area;
        this.inspector = inspector;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


    @JSONPropertyIgnore
    public GeneralInspector getInspector() {
        return inspector;
    }

    public void setInspector(GeneralInspector inspector) {
        this.inspector = inspector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ZoneControl that = (ZoneControl) o;

        if (!Objects.equals(area, that.area)) {
            return false;
        }
        return Objects.equals(inspector, that.inspector);
    }

    @Override
    public int hashCode() {
        int result = area != null ? area.hashCode() : 0;
        result = 31 * result + (inspector != null ? inspector.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ZoneControl{"
                + "area='" + area + '\''
                + ", inspector=" + inspector
                + '}';
    }
}
