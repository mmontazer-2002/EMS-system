package ir.gam.action;

import com.opensymphony.xwork2.ActionSupport;
import ir.gam.dao.EmployeeDAO;
import ir.gam.model.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeAction extends ActionSupport {
    private Employee employee;

    public String save() {

        EmployeeDAO dao = new EmployeeDAO();
        dao.save(employee);

        return "success";
    }

}
