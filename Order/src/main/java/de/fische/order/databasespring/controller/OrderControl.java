package de.fische.order.databasespring.controller;



import de.fische.order.databasespring.model.Order;
import de.fische.order.databasespring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderControl {

    private final OrderService orderService;

    @Autowired
    public OrderControl(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getListOfAllOrders(){
        return orderService.getListOfAllOrders();
    }
}
