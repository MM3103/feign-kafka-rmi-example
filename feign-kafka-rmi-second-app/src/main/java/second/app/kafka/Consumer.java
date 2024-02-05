package second.app.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.dto.FoodOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import proto.FoodProto;
import test._1_0.TestRequestType;

import javax.xml.bind.JAXB;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Slf4j
@Component
@RequiredArgsConstructor
public class Consumer {

    private static final String orderTopicJson = "${topic.json.name}";
    private static final String orderTopicXml = "${topic.xml.name}";
    private static final String orderTopicProtobuf = "${topic.protobuf.name}";

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = orderTopicJson, groupId = "string-group-id", containerFactory = "stringKafkaListenerContainerFactory")
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("Получен заказ {}", message);

        FoodOrder foodOrder = objectMapper.readValue(message, FoodOrder.class);

        log.info("Получен новый заказ: Закуска: " + foodOrder.getSnack().getName() +
                ", суп: " + foodOrder.getSoup().getName() +
                ", основное блюдо: " + foodOrder.getEntree().getName() +
                ", десерт: " + foodOrder.getDessert().getName());
    }

    @KafkaListener(topics = orderTopicXml, groupId = "string-group-id", containerFactory = "stringKafkaListenerContainerFactory")
    public void consumeMessageXml(String message) throws IOException {
        log.info("Получен заказ {}", message);

        TestRequestType testRequestType = JAXB.unmarshal(IOUtils.toInputStream(message, String.valueOf(StandardCharsets.UTF_8)), TestRequestType.class);

        log.info("Получен новый заказ" + testRequestType.getFoodName());
    }

    @KafkaListener(topics = orderTopicProtobuf, groupId = "byte-array-group-id", containerFactory = "byteArrayKafkaListenerContainerFactory")
    public void consumeMessageProtobuf(byte[] bytes) throws IOException {
        FoodProto.FoodProtoBuf food1 = FoodProto.FoodProtoBuf.parseFrom(bytes);

        log.info("Получен заказ {}", food1.toString());

        log.info("Получен новый заказ" + food1.getName());
    }

}
