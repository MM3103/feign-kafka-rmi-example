package first.app.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.InvalidProtocolBufferException;
import common.dto.FoodOrder;
import test._1_0.TestRequestType;

/**
 * Сервис ждя работы с кафкой.
 */
public interface FoodOrderKafkaService {

    /**
     * Метод для заказа еды.
     *
     * @param foodOrder сущность заказа.
     */
    String createFoodOrderJson(FoodOrder foodOrder) throws JsonProcessingException;

    /**
     * Метод для заказа еды.
     *
     * @param testRequestType заказ еды в формате xml.
     */
    String createFoodOrderXml(TestRequestType testRequestType);


    /**
     * Метод для заказа еды через protobuf.
     */
    String createFoodOrderProtobuf() throws JsonProcessingException, InvalidProtocolBufferException;
}
