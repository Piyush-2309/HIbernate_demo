package org.example.service;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.entity.Employee;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import javax.security.auth.login.CredentialException;
import java.util.List;

public class EmployeeService {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    // Save Entry
    public void save(Employee employee)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    // Get Entry by ID
    public Employee getEntry(int id)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Employee employee = session.find(Employee.class, id);
            transaction.commit();
            return employee;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    // Update Entry
    public Employee updateEntry(Employee employee, int id)
    {
        try
        {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Employee oldEmployee = session.find(Employee.class, id);
            oldEmployee.setAge(employee.getAge());
            oldEmployee.setName(employee.getName());
            Employee updatedEmployee = session.merge(oldEmployee);
            transaction.commit();
            return oldEmployee;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    // Employees with same name using criteria api --> important ---->> used for dynamic queries
    public List<Employee> getEntriesWithSameName(String name)
    {
        try
        {
            Session session = sessionFactory.openSession();
            HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> root = query.from(Employee.class);
            query.select(root).where(criteriaBuilder.equal(root.get("name"), name));
            List<Employee> resultList = session.createQuery(query).getResultList();
            return resultList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
