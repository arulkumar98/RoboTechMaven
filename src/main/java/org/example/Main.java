package org.example;


import org.example.controller.hibernate.p.PersonOperations;

import org.example.controller.hibernate.p.RobotPartOperation;
import org.example.model.Person;
import org.example.model.RobotPart;

public class Main {
    public static void main(String[] args) {
//       PersonOperations personOperations = new PersonOperations();
//       PersonOperations operations = new PersonOperations();
//        System.out.println(operations.listCustomer());

//        RobotPart robotPart = new RobotPart();
//        robotPart.name = "weather sensor";
//        robotPart.description = "It help to check the weather";
//        robotPart.supplier = "Weather company";
//        robotPart.weight = 30;
//
//        robotPartOperation.addPart(robotPart);
        RobotPartOperation robotPartOperation = new RobotPartOperation();
        System.out.println(robotPartOperation.listCustomer());
    }

}
