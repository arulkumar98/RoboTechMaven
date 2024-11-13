package org.example.controller.hibernate.p;

import org.example.controller.hibernate.connection.HibernateConnection;
import org.example.model.Person;
import org.hibernate.Session;

import java.util.List;

public class PersonOperations {
    public PersonOperations() {
    }

    //add a customer
    public void createCustomer(Person newCustomer){
        updateCustomer(newCustomer);
    }

    private void updateCustomer(Person newCustomer) {
        Session session = HibernateConnection.openSession();
        session.beginTransaction();
        session.persist(newCustomer);
        session.getTransaction().commit();
        session.close();
    }

    //delete a customer
    public void deleteCustomer(Person aCustomer){
        Session session = HibernateConnection.openSession();
        session.beginTransaction();
        session.remove(aCustomer);
        session.getTransaction().commit();
        session.close();
    }

    //Create sql like query
    public List<Person>listCustomer(){
        Session session = HibernateConnection.openSession();
        session.beginTransaction();
        List<Person> personList = (List<Person>) session.createQuery("from Person").list();
        session.getTransaction().commit();
        session.close();
        return personList;
    }
}
