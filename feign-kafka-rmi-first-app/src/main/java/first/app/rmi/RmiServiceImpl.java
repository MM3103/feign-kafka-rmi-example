package first.app.rmi;

import common.api.RemoteService;
import common.dto.FoodOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@Service
@Slf4j
public class RmiServiceImpl implements RemoteService {

    @Override
    public Integer setCostFoodOrder(FoodOrder foodOrder) {
        Integer result = null;
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RemoteService remoteService = (RemoteService) registry.lookup("RemoteService");

            result = remoteService.setCostFoodOrder(foodOrder);

            log.info("Ваш заказ будет стоить: " + result);

        } catch (RemoteException | NotBoundException e) {
            log.error("Не удалось рассчитать стоимость заказа", e);
        }
        return result;
    }

}
