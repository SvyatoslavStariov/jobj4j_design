package ru.job4j.ood.srp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employees")
public class Employees {

    private List<Employee> employee;

    public Employees() {
    }

    public Employees(List<Employee> employee) {
        this.employee = employee;
    }


    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
