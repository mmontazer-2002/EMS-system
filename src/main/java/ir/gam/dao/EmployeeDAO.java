package ir.gam.dao;

import ir.gam.exception.EmployeePersistenceException;
import ir.gam.model.Employee;
import ir.gam.utility.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmployeeDAO {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDAO.class);

    //this method simply save an employee
    public void save(Employee employee) {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(employee);
            tx.commit();
            logger.info("Employee saved successfully. id={}", employee.getId());
        } catch (Exception e) {
            rollback(tx);
            logger.error("Error saving employee: {}", employee, e);
            throw new EmployeePersistenceException("Failed to save employee", e);
        }
    }

    //this method simply update an employee
    public void update(Employee employee) {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(employee);
            tx.commit();
            logger.info("Employee updated successfully. id={}", employee.getId());
        } catch (Exception e) {
            rollback(tx);
            logger.error("Error updating employee: {}", employee, e);
            throw new EmployeePersistenceException("Failed to update employee", e);
        }
    }

    //this method will simply delete and employee by the id
    public void delete(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee == null) {
                logger.warn("Employee not found for deletion. id={}", id);
                throw new EmployeePersistenceException("Employee not found with id: " + id);
            }
            session.delete(employee);
            tx.commit();
            logger.info("Employee deleted successfully. id={}", id);
        } catch (EmployeePersistenceException e) {
            rollback(tx);
            throw e;
        } catch (Exception e) {
            rollback(tx);
            logger.error("Error deleting employee. id={}", id, e);
            throw new EmployeePersistenceException("Failed to delete employee", e);
        }
    }

    //this method will simply return the employee info by the id
    public Employee getById(int id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, id);
            if (employee == null) {
                logger.warn("Employee not found. id={}", id);
                throw new EmployeePersistenceException("Employee not found with id: " + id);
            }
            logger.info("Employee fetched successfully. id={}", id);
            return employee;

        } catch (EmployeePersistenceException e) {
            throw e;
        } catch (Exception e) {
            logger.error("Error fetching employee. id={}", id, e);
            throw new EmployeePersistenceException("Failed to fetch employee", e);
        }
    }

    //this method will simply return the list of all the employees in the database
    public List<Employee> getAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
            logger.info("Fetched {} employees", employees.size());
            return employees;
        } catch (Exception e) {
            logger.error("Error fetching employee list", e);
            throw new EmployeePersistenceException("Failed to fetch employees", e);
        }
    }

    private void rollback(Transaction tx) {
        try {
            if (tx != null && tx.isActive()) {
                tx.rollback();
                logger.info("Transaction rolled back successfully");
            }
        } catch (Exception e) {
            logger.error("Error during transaction rollback", e);
        }
    }
}
