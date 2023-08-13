package second.app.rmi;

import common.api.RemoteService;
import common.dto.FoodOrder;
import lombok.extern.slf4j.Slf4j;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;;

@Slf4j
public class RemoteServiceImpl extends UnicastRemoteObject implements RemoteService {

    public RemoteServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public Integer setCostFoodOrder(FoodOrder foodOrder) throws RemoteException {
        log.info("Вызван rmi метод подсчета стоимости заказа:" + foodOrder.toString());
        Integer cost = foodOrder.getSnack().getCost() + foodOrder.getDessert().getCost() + foodOrder.getEntree().getCost()
                + foodOrder.getSoup().getCost();
        log.info("Стоимость заказа:" + cost);
        return cost;
    }
}
