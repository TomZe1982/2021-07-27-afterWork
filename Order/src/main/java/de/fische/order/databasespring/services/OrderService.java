package de.fische.order.databasespring.services;



import de.fische.order.databasespring.model.Order;
import de.fische.order.databasespring.model.Product;
import de.fische.order.databasespring.repositories.OrderDB;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderDB orderDB;

    public OrderService(OrderDB orderDB) {
        this.orderDB = orderDB;
    }

    public List<Order> getListOfAllOrders() {
        return this.orderDB.getOrderList();
    }


    public Optional<Order> getOrderById(String id) {
        return orderDB.getOrderById(id);
    }

    public Order createNewOrder(Order order) {
        String id = UUID.randomUUID().toString();
        Order newOrder = new Order(id,order.getOrder());
        orderDB.save(newOrder);
        return newOrder;

    }

    public Optional<Order> updateOrder(String id, List<Product> listOfProducts) {
        return orderDB.updateOrder(id, listOfProducts);

    }
}
