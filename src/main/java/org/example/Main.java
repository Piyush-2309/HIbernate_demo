package org.example;

import org.example.entity.Certificates;
import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Employee e1 = new Employee();
        e1.setAge("21");
        e1.setName("Sai");

        Certificates c1 = new Certificates();
        c1.setTitle("Java Certifications");
        c1.setLink("https://java.com");
        c1.setE1(e1);

        Certificates c2 = new Certificates();
        c2.setTitle("PHP Certifications");
        c2.setLink("https://php.com");
        c2.setE1(e1);

        e1.getCertificates().add(c1);
        e1.getCertificates().add(c2);

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try
        {

            transaction = session.beginTransaction();
            session.persist(e1);
            transaction.commit();
            System.out.println("Saved Successfully");

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            session.close();
        }

//        EmployeeService service = new EmployeeService();
//        Employee entry = service.getEntry(5);
//        System.out.println(entry.getName());
//        List<Certificates> certificates = entry.getCertificates();
//        for(Certificates c : certificates)
//        {
//            System.out.println(c.getTitle());
//        }
//
//        List<Employee> entries = service.getEntriesWithSameName("Piyush");
//        for (Employee e : entries)
//        {
//            System.out.println(e.getName());
//            System.out.println(e.getAge());
//        }
//
//        List<Employee> entryByPagination = service.getEntryByPagination(2, 2);
//        for (Employee e : entryByPagination)
//        {
//            System.out.println(e.getName());
//            System.out.println(e.getAge());
//        }
    }
}
