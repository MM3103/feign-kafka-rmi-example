package first.app.controller;

import first.app.feign.FoodXmlFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test._1_0.TestRequestType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@RestController
@RequestMapping("/feignXmlExample")
@RequiredArgsConstructor
public class FeignClientXmlExampleController {

    private final FoodXmlFeignClient foodXmlFeignClient;

    @GetMapping(value = "/getXmlExample")
    public TestRequestType getSalad() {
        return foodXmlFeignClient.getSalad();
    }

    @PostMapping(value = "/postXmlExample")
    public TestRequestType createFood(@RequestBody TestRequestType food) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(TestRequestType.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(food, stringWriter);
        String xmlRequest = stringWriter.toString();
        return foodXmlFeignClient.createFood(xmlRequest);
    }

}
