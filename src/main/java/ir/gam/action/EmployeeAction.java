package ir.gam.action;

import com.opensymphony.xwork2.ActionSupport;
import ir.gam.dao.EmployeeDAO;
import ir.gam.exception.EmployeePersistenceException;
import ir.gam.model.Employee;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Getter
@Setter
public class EmployeeAction extends ActionSupport {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeAction.class);
    private final EmployeeDAO dao = new EmployeeDAO();

    private Employee employee;
    private int id;
    private List<Employee> employees;

    //the action method for saving the new employee
    public String save() {
        try {
            dao.save(employee);
            logger.info("Employee saved successfully");
            return SUCCESS;

        } catch (EmployeePersistenceException e) {
            logger.error("Error saving employee", e);
            addActionError("Unable to save employee");
            return ERROR;
        }
    }

    //the action method for getting the list of the employees
    public String list() {
        try {
            employees = dao.getAll();
            logger.info("Employee list fetched successfully");
            return SUCCESS;
        } catch (EmployeePersistenceException e) {
            logger.error("Error fetching employee list", e);
            addActionError("Unable to load employees");
            return ERROR;
        }
    }

    //the action method for deleting an employees
    public String delete() {
        try {
            dao.delete(id);
            logger.info("Employee deleted successfully. id={}", id);
            return SUCCESS;
        } catch (EmployeePersistenceException e) {
            logger.error("Error deleting employee id={}", id, e);
            addActionError("Unable to delete employee");
            return ERROR;
        }
    }

    //the action method for retrieving the employees data in the UI
    public String retrieves() {
        try {
            employee = dao.getById(id);
            if (employee == null) {
                addActionError("Employee not found");
                return ERROR;
            }
            logger.info("Employee loaded for editing. id={}", id);
            return SUCCESS;
        } catch (EmployeePersistenceException e) {
            logger.error("Error loading employee id={}", id, e);
            addActionError("Unable to load employee");
            return ERROR;
        }
    }

    //the action method for updating the data of an employee
    public String update() {
        try {
            dao.update(employee);
            logger.info("Employee updated successfully. id={}", employee.getId());
            return SUCCESS;
        } catch (Exception e) {
            logger.error("Error updating employee", e);
            addActionError("Unable to update employee");
            return ERROR;
        }
    }
}
