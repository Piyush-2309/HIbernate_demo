package org.example;

import org.example.entity.employee;
import org.example.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        employee e1 = new employee();
        e1.setAge("20");
        e1.setName("Pratik");

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

    }
}
