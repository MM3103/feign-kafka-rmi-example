package first.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test._1_0.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Конфигурация bean для ЕПГУ.
 */
@Configuration
public class XmlConfig {

    /**
     * @return ObjectFactory для ЕПГУ.
     */
    @Bean
    public ObjectFactory creatorObjectFactory() {
        return new ObjectFactory();
    }

    /**
     * @return JAXBContext для ЕПГУ.
     * @throws JAXBException
     */
    @Bean
    public JAXBContext creatorJaxbContext() throws JAXBException {
        return JAXBContext.newInstance(ObjectFactory.class);
    }

    /**
     * @return Marshaller для ЕПГУ.
     * @throws JAXBException
     */
    @Bean
    public Marshaller creatorMarshaller() throws JAXBException {
        JAXBContext jaxbContext = creatorJaxbContext();
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        return marshaller;
    }

    /**
     * @return Unmarshaller для ЕПГУ.
     * @throws JAXBException
     */
    @Bean
    public Unmarshaller creatorElkUnmarshaller() throws JAXBException {
        JAXBContext jaxbContext = creatorJaxbContext();
        return jaxbContext.createUnmarshaller();
    }
}
