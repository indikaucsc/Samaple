package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Order> orders = Arrays.asList(
                new Order(Arrays.asList(
                        new Product("Laptop", 1200.00, "Electronics"),
                        new Product("Headphones", 200.00, "Electronics"),
                        new Product("Coffee Machine", 150.00, "Home Appliances")
                )),
                new Order(Arrays.asList(
                        new Product("TV", 800.00, "Electronics"),
                        new Product("Blender", 100.00, "Home Appliances"),
                        new Product("Mixer", 120.00, "Home Appliances")
                )),
                new Order(Arrays.asList(
                        new Product("Smartphone", 700.00, "Electronics"),
                        new Product("Toaster", 50.00, "Home Appliances"),
                        new Product("Laptop", 1200.00, "Electronics")
                ))
        );

        // 1. Compute the total revenue generated from all orders
        double totalRevenue = orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println("Total Revenue: " + totalRevenue);

        List<Product> products =  orders.stream().flatMap(order -> order.getProducts().stream()).toList();

        Map<String, Optional<Product>> mostExpensiveByCategory = orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));

        System.out.println("Most Expensive by Category:");
        mostExpensiveByCategory.forEach((category, product) ->
                System.out.println(category + ": " + product.orElse(null).getName())
        );

        // 3. List all unique product names across all orders, sorted alphabetically
        List<String> uniqueProductNames = orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Unique Product Names: " + uniqueProductNames);
    }
}