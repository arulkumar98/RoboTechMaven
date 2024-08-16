package org.example.controller.jdbc.curd;

import org.example.controller.jdbc.connection.ConnectionJdbc;
import org.example.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Read {
    private static final Logger log = LoggerFactory.getLogger(Read.class);
    ArrayList<Person> personArrayList = new ArrayList<>();

    public ArrayList<Person> getData() {
        try {
            Connection connection = ConnectionJdbc.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");

            while (resultSet.next()) {
                Person person = new Person();
                person.name = resultSet.getString("Name");
                person.address = resultSet.getString("Address");
                person.telephone = resultSet.getString("Telephone");
                person.email = resultSet.getString("Email");
                personArrayList.add(person);
            }

        } catch (SQLException e) {
            log.error("error in read class",e);
        }
        return personArrayList;
    }
}
