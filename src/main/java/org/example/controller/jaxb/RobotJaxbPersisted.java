package org.example.controller.jaxb;

import org.example.model.RobotPart;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class RobotJaxbPersisted {
    public void persistedRobot(RobotPart robotPart){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(RobotPart.class);
            Marshaller robotMarshaller = jaxbContext.createMarshaller();
            robotMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File file = new File("Robot Part.xml");
            robotMarshaller.marshal(robotPart, file);
            robotMarshaller.marshal(robotPart, System.out);

        } catch (JAXBException e) {
           e.printStackTrace();
        }
    }
}
