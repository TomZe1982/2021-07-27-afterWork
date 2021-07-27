package de.fische.order.databasespring.model;

import java.util.List;
import java.util.Objects;

public class Order {

    private String id;
    private List<Product> order;

    public Order(String id, List<Product> order) {
        this.id = id;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getOrder() {
        return order;
    }

    public void setOrder(List<Product> order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order1 = (Order) o;
        return Objects.equals(id, order1.id) && Objects.equals(order, order1.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order);
    }
}
