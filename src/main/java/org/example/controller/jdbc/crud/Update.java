package org.example.controller.jdbc.crud;

import org.example.controller.jdbc.connection.ConnectionJdbc;
import org.example.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    private static final Logger log = LoggerFactory.getLogger(Update.class);

    public void updatePerson(Person person){
        Connection con = ConnectionJdbc.getConnection();
        try {
            PreparedStatement updateSmt = con.prepareStatement(
                    "UPDATE person set Name=?, Address=?, Telephone=?, WHERE email=?");
            updateSmt.setString(1, person.getName());
            updateSmt.setString(2, person.getAddress());
            updateSmt.setString(3, person.getTelephone());
            updateSmt.setString(4, person.getEmail());

            int rowsAffected = updateSmt.executeUpdate();
            if (rowsAffected > 0) {
                log.info("Person with email '{}' was updated successfully.", person.getEmail());
            } else {
                log.warn("No person found with email '{}'. No update performed.", person.getEmail());
            }


        }catch (SQLException e){
            log.error("Error in updatePerson function in Update class");
        }
    }
}
