package org.example.controller.jaxb;

import org.example.model.RobotPart;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class RobotPartCatalogue {
    @XmlElement
    public List<RobotPart>parts = new ArrayList<>();

    private JAXBContext jaxbContext = null;
    private Marshaller marshaller = null;
    private Unmarshaller unmarshaller = null;
    private File storefile = null;

    public void RobotPartCatalogueJaxbPersister(String filename) throws JAXBException {
        jaxbContext = JAXBContext.newInstance(RobotPartCatalogue.class);

        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        unmarshaller = jaxbContext.createUnmarshaller();

        storefile = new File(filename);
    }

    public void serialiseCatalogue(RobotPartCatalogue catalogue) throws JAXBException {

        marshaller.marshal(catalogue, storefile);
        marshaller.marshal(catalogue, System.out);

    }

    public RobotPartCatalogue deserialiseCatalogue() throws JAXBException {

        return (RobotPartCatalogue) unmarshaller.unmarshal(storefile);

    }
}
