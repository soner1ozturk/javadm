package com.myapp.demo;

import java.util.*;

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
        if (productList.contains(product)){
            productList.remove(product);
        }
    }
    public Double getTotal(){
        return productList.stream().mapToDouble(Product::getPrice).sum();
    }

    public Integer getItemCount(){
        return productList.size();
    }

    public Optional<Product> getMostExpensive(){
        return productList.stream()
                .max(Comparator.comparing(Product::getPrice));    }

}




//Suppose you have:
//
//Map<Long, User> users
//
//How would you:
//
//add a user
//get a user by ID
//remove a user
//
//Write the code.

public void addUser(Long id,User user){
    users.put(id,user)
}