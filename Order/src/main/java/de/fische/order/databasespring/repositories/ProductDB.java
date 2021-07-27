package de.fische.order.databasespring.repositories;



import de.fische.order.databasespring.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDB {
    private List<Product> productList;

    public ProductDB(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
