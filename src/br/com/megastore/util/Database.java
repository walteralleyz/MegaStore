package br.com.megastore.util;

import br.com.megastore.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Database {
    private static Database instance;

    List<Product> products;

    @Deprecated
    private Database() {
        products = new ArrayList<>();
    }

    public static Database getInstance() {
        if(instance == null)
            instance = new Database();

        return instance;
    }

    public void displayProducts() {
        products.forEach(System.out::println);
    }

    public void displaySections() {
        List<String> sections =  products.stream().map(Product::getSection).collect(Collectors.toList());
        sections.forEach(System.out::println);
    }

    public void addProduct(Product product) {
        assert product == null : "Product is not valid";

        product.setId(products.size());
        products.add(product);
    }

    public void deleteProduct(int index) {
        assert products.get(index) == null : "Product index is not valid";

        removeAndUpdateIndex(index);
    }

    private void removeAndUpdateIndex(int index) {
        try {
            products.remove(index);
        } catch (IndexOutOfBoundsException e) {
            String message = "|Product index is not valid|";
            System.out.printf("%s\n%s\n%s\n", "=".repeat(message.length()), message, "=".repeat(message.length()));
            return;
        }

        for(int i = 0; i < products.size(); i++) {
            products.get(i).setId(i);
        }
    }
}
