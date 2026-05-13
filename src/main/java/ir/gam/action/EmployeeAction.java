package ir.gam.action;

import com.opensymphony.xwork2.ActionSupport;
import ir.gam.dao.EmployeeDAO;
import ir.gam.model.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeAction extends ActionSupport {
    private Employee employee;
    private int id;
    private List<Employee> employees;

    EmployeeDAO dao = new EmployeeDAO();

    public String save() {
        EmployeeDAO dao = new EmployeeDAO();
        dao.save(employee);

        return "success";
    }

    public String list(){
        employees = dao.getAll();
        return "list";
    }

    public String delete (){
        dao.delete(id);
        return "success";
    }




}
