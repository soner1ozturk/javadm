package com.myapp.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Cart {
    private List<Product> productList;

    public Cart(){
        this.productList = new ArrayList<>();
    }

    //Cart should support: addProduct, removeProduct, getTotal (sum of all prices), getItemCount,
    // and getMostExpensive (returns Optional<Product>)

    public void addProduct(Product product){
        productList.add(product);
    }
    public void removeProduct(Product product){
        for(Product productIn: productList){
            if (productIn.equals(product)){
                productList.remove(productIn);
            }
        }
    }
    public Double getTotal(){
        return productList.stream().mapToDouble(Product::getPrice).sum();
    }

    public Integer getItemCount(){
        return productList.size();
    }

    public Optional<Product> getMostExpensive(){
        return Optional.ofNullable(productList.stream().max(Comparator.comparing(Product::getPrice)).orElse(null));
    }

}
