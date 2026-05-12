package ir.gam;

import ir.gam.dao.EmployeeDAO;
import ir.gam.model.Employee;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setName("test");
        e.setEmail("mmontazer1831@gmail.com");
        e.setDepartment("backend");
        e.setSalary(BigDecimal.valueOf(25000000));

        new EmployeeDAO().save(e);
    }
}
