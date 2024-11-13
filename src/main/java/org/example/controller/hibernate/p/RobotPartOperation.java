package org.example.controller.hibernate.p;

import org.example.controller.hibernate.connection.HibernateConnection;
import org.example.model.RobotPart;
import org.hibernate.Session;

import java.util.List;

public class RobotPartOperation {
    public  RobotPartOperation(){}

    public void addPart(RobotPart newPart){
        updatePart(newPart);
    }

    private void updatePart(RobotPart newPart){
        Session session = HibernateConnection.openSession();
        session.beginTransaction();
        session.persist(newPart);
        session.getTransaction().commit();
        session.close();
    }

    public void removeAPart(RobotPart part){
        Session session = HibernateConnection.openSession();
        session.beginTransaction();
        session.remove(part);
        session.getTransaction().commit();
        session.close();
    }

    public List<RobotPart> listCustomer(){
        Session session = HibernateConnection.openSession();
        session.beginTransaction();
        List<RobotPart> partList = (List<RobotPart>) session.createQuery("from RobotPart").list();
        session.getTransaction().commit();
        session.close();
        return partList;
    }

}
