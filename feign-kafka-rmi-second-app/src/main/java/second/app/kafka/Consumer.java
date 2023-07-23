package second.app.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.dto.FoodOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class Consumer {

    private static final String orderTopic = "${topic.name}";

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("Получен заказ {}", message);

        FoodOrder foodOrder = objectMapper.readValue(message, FoodOrder.class);

        log.info("Получен новый заказ: Закуска: " + foodOrder.getSnack().getName() +
                ", суп: " + foodOrder.getSoup().getName() +
                ", основное блюдо: " + foodOrder.getEntree().getName() +
                ", десерт: " + foodOrder.getDessert().getName());
    }

}
