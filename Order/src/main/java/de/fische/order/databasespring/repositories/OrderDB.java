package de.fische.order.databasespring.repositories;



import de.fische.order.databasespring.model.Order;
import de.fische.order.databasespring.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
}
