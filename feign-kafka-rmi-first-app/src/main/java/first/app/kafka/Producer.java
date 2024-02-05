package first.app.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import common.dto.FoodOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import proto.FoodProto;
import test._1_0.TestRequestType;

import javax.xml.bind.JAXB;
import java.io.StringWriter;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {

    @Value("${topic.json.name}")
    private String orderTopicJson;

    @Value("${topic.xml.name}")
    private String orderTopicXml;

    @Value("${topic.protobuf.name}")
    private String orderTopicProtoBuf;

    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaTemplate<String, byte[]> kafkaTemplateByteArray;

    public String sendMessageJson(FoodOrder foodOrder) throws JsonProcessingException {
        String orderAsMessage = objectMapper.writeValueAsString(foodOrder);
        kafkaTemplate.send(orderTopicJson, orderAsMessage);

        log.info("Создан новый заказ {}", orderAsMessage);

        return "Новый заказ отправлен на кухню";
    }

    public String sendMessageXml(TestRequestType testRequestType) {
        StringWriter content = new StringWriter();
        JAXB.marshal(testRequestType, content);
        String xmlString = content.toString().replace("\n", "");
        kafkaTemplate.send(orderTopicXml, xmlString);

        log.info("Создан новый заказ {}", xmlString);

        return "Новый заказ отправлен на кухню";
    }

    public String sendMessageProtobuf(FoodProto.FoodProtoBuf food) throws JsonProcessingException, InvalidProtocolBufferException {
        byte[] foodBytes = food.toByteArray();
        ProducerRecord<String, byte[]> record = new ProducerRecord<>(orderTopicProtoBuf, "key", foodBytes);
        kafkaTemplateByteArray.send(record);
        log.info("Создан новый заказ {}", food);
        return "Новый заказ отправлен на кухню";
    }
}
