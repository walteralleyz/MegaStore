package br.com.megastore.product;

import java.math.BigDecimal;

public class Product {
    private Integer id;
    private String name;
    private String section;
    private BigDecimal price;

    public Product(String name, String section, Double price) {
        setName(name);
        setSection(section);
        setPrice(price);
    }

    private void setName(String name) {
        if(name == null)
            throw new IllegalArgumentException("Name is typo");

        this.name = name;
    }

    private void setSection(String section) {
        if(section == null)
            throw new IllegalArgumentException("Section is typo");

        this.section = section;
    }

    private void setPrice(Double price) {
        if(price == null || price < 0)
            throw new IllegalArgumentException("Price need to be positive");

        this.price = new BigDecimal(price);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    @Override
    public String toString() {
        return String.format(
            "\nId: %d\nName: %s\nSection: %s\nPrice: %.2f\n",
            id, name, section, price
        );
    }
}
