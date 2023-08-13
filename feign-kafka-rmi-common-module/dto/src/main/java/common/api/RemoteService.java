package common.api;

import common.dto.FoodOrder;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteService extends Remote {
    Integer setCostFoodOrder(FoodOrder foodOrder) throws RemoteException, NotBoundException;
}
