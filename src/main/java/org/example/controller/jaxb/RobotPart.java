package org.example.controller.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RobotPart {
    @XmlElement
    public String name;
    public String description;
    public String supplier;
    public int weight;

    public RobotPart(String name, String description, String supplier, int weight) {
        this.name = name;
        this.description = description;
        this.supplier = supplier;
        this.weight = weight;
    }

    public RobotPart() {
    }
}
