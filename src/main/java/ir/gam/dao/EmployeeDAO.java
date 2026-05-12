package ir.gam.dao;

import ir.gam.model.Employee;
import ir.gam.utility.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAO {

    //this method simply save an employee
    public void save(Employee employee) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(employee);

        tx.commit();
        session.close();
    }

    //this method simply update an employee
    public void update (Employee employee){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(employee);
        tx.commit();
        session.close();
    }

    //this method will simply delete and employee by the id
    public void delete(int id){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = session.get(Employee.class, id);
        if(emp != null){
            session.delete(emp);
        }

        tx.commit();
        session.close();
    }

    //this method will simply return the employee info by the id
    public Employee getById(int id){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    //this method will simply return the list of all the employees in the database
    public List<Employee> getAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Employee> list = session.createQuery("from Employee", Employee.class).list();

        session.close();
        return list;
    }



}
