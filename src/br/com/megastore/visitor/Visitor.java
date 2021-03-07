package br.com.megastore.visitor;

import br.com.megastore.presentation.Presentation;
import br.com.megastore.util.Database;
import br.com.megastore.util.Input;
import br.com.megastore.util.MessageFormatter;

public class Visitor implements Presentation {
    private Database database;

    public Visitor() {
        database = Database.getInstance();
    }

    @Override
    public void showMenu(Input input) {
        MessageFormatter formatter = MessageFormatter.getInstance();
        int option;

        formatter
            .writeLine("========MENU========").newLine()
            .writeLine("0 - Product List   |").newLine()
            .writeLine("1 - Section List   |").newLine()
            .writeLine("3 - Back to Menu   |").newLine()
            .writeLine("====================")
            .printMessage();

        option = input.asInteger("Type your option:");

        if(option == 0) printProductList();
        else if(option == 1) printSectionList();
    }

    public void printProductList() {
        database.displayProducts();
    }

    public void printSectionList() {
        database.displaySections();
    }
}
