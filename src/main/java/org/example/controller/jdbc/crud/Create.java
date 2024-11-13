package org.example.controller.jdbc.crud;

import org.example.controller.jdbc.connection.ConnectionJdbc;
import org.example.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class Create {
    private static final Logger log = LoggerFactory.getLogger(Create.class);

    public void createPerson(Person person) {
        Connection jdbcConnection = ConnectionJdbc.getConnection();
        try {
            // checking for duplicate
            PreparedStatement checkStmt = jdbcConnection.prepareStatement(
                    "SELECT COUNT(*) FROM person WHERE email = ?");
            checkStmt.setString(1, person.getEmail());
            ResultSet rs = checkStmt.executeQuery();

            //if person is existing then return
            if (rs.next() && rs.getInt(1) > 0){
                log.warn("Person with email '{}' already exists",person);
                return;
            }

            // create person in database
            PreparedStatement smt = jdbcConnection.prepareStatement(
                    "INSERT INTO person(Name,Address,Telephone,email) values(?,?,?,?)",
                    Statement.NO_GENERATED_KEYS);
            smt.setString(1, person.getName());
            smt.setString(2, person.getAddress());
            smt.setString(3, person.getTelephone());
            smt.setString(4, person.getEmail());
            int rowAffected = smt.executeUpdate();

            if (rowAffected > 0){
                log.info("Person created successfully: {}",person);
            }else {
                log.warn("No Person was created {}",person);
            }

        } catch (SQLException e) {
            log.error("Error in Create a person in create class", e);
        }

    }
}
