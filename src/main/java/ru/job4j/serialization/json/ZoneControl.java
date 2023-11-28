package ru.job4j.serialization.json;

import java.time.LocalDate;
import java.util.Objects;

public class ZoneControl {
    private String area;


    public ZoneControl(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

        return Objects.equals(area, that.area);
    }

    @Override
    public int hashCode() {
        return area != null ? area.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ZoneControl{"
                + "area='" + area + '\''
                + '}';
    }
}
