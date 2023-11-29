package ru.job4j.serialization.json;

import java.util.List;
import java.util.Objects;

public class GeneralInspector {

    private boolean isVacation;

    private int age;

    private List<String> subdivision;

    private ZoneControl zoneControl;

    public GeneralInspector() {
    }

    public GeneralInspector(boolean isVacation,
                            int age,
                            List<String> subdivision,
                            ZoneControl zoneControl) {
        this.isVacation = isVacation;
        this.age = age;
        this.subdivision = subdivision;
        this.zoneControl = zoneControl;
    }

    public boolean isVacation() {
        return isVacation;
    }

    public void setVacation(boolean vacation) {
        isVacation = vacation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(List<String> subdivision) {
        this.subdivision = subdivision;
    }

    public ZoneControl getZoneControl() {
        return zoneControl;
    }

    public void setZoneControl(ZoneControl zoneControl) {
        this.zoneControl = zoneControl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GeneralInspector that = (GeneralInspector) o;

        if (isVacation != that.isVacation) {
            return false;
        }
        if (age != that.age) {
            return false;
        }
        if (!Objects.equals(subdivision, that.subdivision)) {
            return false;
        }
        return Objects.equals(zoneControl, that.zoneControl);
    }

    @Override
    public int hashCode() {
        int result = (isVacation ? 1 : 0);
        result = 31 * result + age;
        result = 31 * result + (subdivision != null ? subdivision.hashCode() : 0);
        result = 31 * result + (zoneControl != null ? zoneControl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GeneralInspector{"
                + "isVacation=" + isVacation
                + ", age=" + age
                + ", subdivision=" + subdivision
                + ", zoneControl=" + zoneControl
                + '}';
    }
}
