package ir.gam.dao;

import ir.gam.model.Employee;
import ir.gam.utility.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDAO {

    public void save(Employee emp) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(emp);

        tx.commit();
        session.close();
    }
}
