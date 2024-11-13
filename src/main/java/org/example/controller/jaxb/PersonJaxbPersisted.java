package org.example.controller.jaxb;
import org.example.model.Person;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

@XmlRootElement
public class  PersonJaxbPersisted {
    public void persistPerson(Person person) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File file = new File("Store.xml");
            jaxbMarshaller.marshal(person, file);
            jaxbMarshaller.marshal(person, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
            // Handle JAXBException as needed, e.g., log error, throw runtime exception, etc.
        }
    }
}
