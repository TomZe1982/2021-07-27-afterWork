package de.fische.order.databasespring.services;



import de.fische.order.databasespring.model.Order;
import de.fische.order.databasespring.repositories.OrderDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderDB orderDB;

    public List<Order> getListOfAllOrders() {
        return orderDB.getOrderList();
    }



}
