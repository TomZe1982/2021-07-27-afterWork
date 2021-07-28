package de.fische.order.databasespring.controller;



import de.fische.order.databasespring.model.Order;
import de.fische.order.databasespring.model.Product;
import de.fische.order.databasespring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("{id}")
    public Order getOrderById(@PathVariable String id){
        return orderService.getOrderById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public Order createNewOrder(@RequestBody Order order){
        return orderService.createNewOrder(order);
    }

    @PutMapping("{id}")
    public Order updateOrder(@PathVariable String id, @RequestBody  List<Product> listOfProducts)  {
        return orderService.updateOrder(id, listOfProducts).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
