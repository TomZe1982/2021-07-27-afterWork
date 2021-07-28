package de.fische.order.databasespring.repositories;


import de.fische.order.databasespring.model.Order;
import de.fische.order.databasespring.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderDB {
    private List<Order> orderList;

    public OrderDB() {
        this.orderList = new ArrayList<>(List.of(
                new Order("1", List.of(
                        new Product("1", "beer")
                ))
        ));
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }


    public Optional<Order> getOrderById(String id) {

        for (Order order : orderList) {
            if (order.getId().equals(id)) {
                return Optional.of(order);
            }

        }
        return Optional.empty();
    }


    public Order save(Order order) {
       for (Order existingOrder : orderList) {
            if (existingOrder.getId().equals(order.getId())) {
                existingOrder.setOrder(order.getOrder());
                return existingOrder;
            }
        }
        orderList.add(order);
        return order;
    }

    public Optional<Order> updateOrder(String id, List<Product> listOfProducts) {
        Optional<Order>fetchedOrderOptional = getOrderById(id);
        if(fetchedOrderOptional.isEmpty()){
            return Optional.empty();
        }
        Order fetchedOrder = fetchedOrderOptional.get();
        List<Product> existingProducts = fetchedOrder.getOrder();
        for (Product product : listOfProducts) {
            existingProducts.add(product);
        }
        return Optional.of(fetchedOrder);
    }

}