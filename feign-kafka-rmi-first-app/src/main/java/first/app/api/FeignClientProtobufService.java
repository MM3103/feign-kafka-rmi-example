package first.app.api;

import proto.FoodProto;

/**
 * Сервис для работы с feign client.
 */
public interface FeignClientProtobufService {

    FoodProto.FoodProtoBuf getSalad();

    FoodProto.FoodProtoBuf createFood();
}
