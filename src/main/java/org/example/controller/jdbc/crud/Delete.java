package org.example.controller.jdbc.crud;

import org.example.controller.jdbc.connection.ConnectionJdbc;
import org.example.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    private static final Logger log = LoggerFactory.getLogger(Delete.class);

    public void deletePerson(Person person){
        Connection connection = ConnectionJdbc.getConnection();
        try {
            PreparedStatement deleteSmt = connection.prepareStatement("delete person where email=?");
        }catch (SQLException e){
            log.error("Error when deleting a person");
        }
    }
}
