package org.example.view;

import org.example.controller.jdbc.crud.Read;
import org.example.model.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrintCustomer {

    public void printCustomer(){
        Read read = new Read();
        ArrayList<Person> people = read.getData();

        for (Person person : people) {
            System.out.println(person);
            System.out.println();
        }

    }
}
