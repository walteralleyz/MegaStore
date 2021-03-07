package br.com.megastore.admin;

import br.com.megastore.presentation.Presentation;
import br.com.megastore.product.Product;
import br.com.megastore.util.Database;
import br.com.megastore.util.Input;
import br.com.megastore.util.MessageFormatter;

public class Admin implements Presentation {
    private Database database;
    private MessageFormatter formatter;

    public Admin() {
        database = Database.getInstance();
        formatter = MessageFormatter.getInstance();
    }

    @Override
    public void showMenu(Input input) {
        int option;

        formatter
            .writeLine("========ADMIN=======").newLine()
            .writeLine("0 - Add Product    |").newLine()
            .writeLine("1 - Delete Product |").newLine()
            .writeLine("2 - Back to Menu   |").newLine()
            .writeLine("====================")
            .printMessage();

        option = input.asInteger("Type your option:");

        if(option == 0) newProduct(input);
        else if(option == 1) deleteProduct(input);
    }

    public void newProduct(Input input) {
        String name = input.asString("Enter the product name:");
        String section = input.asString("Enter the product section:");
        Double price = input.asDouble("Enter the product price:");

        database.addProduct(new Product(name, section, price));
    }

    public void deleteProduct(Input input) {
        int index = input.asInteger("Enter the product index:");

        database.deleteProduct(index);
    }
}
