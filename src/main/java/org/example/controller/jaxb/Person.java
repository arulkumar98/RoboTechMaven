package org.example.controller.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
    @XmlElement(required = true)
    public String name;
    public String address;
    public String email;
    public String telephone;

    public Person() {
    }

    public Person(String name, String address, String email, String telephone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Customer " +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'';
    }
}
