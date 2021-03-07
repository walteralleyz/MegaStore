package br.com.megastore;

import br.com.megastore.presentation.Presentation;
import br.com.megastore.presentation.PresentationType;
import br.com.megastore.util.Input;
import br.com.megastore.util.MessageFormatter;

public class MegaStore {
    public static void main(String[] args) {
        Input input = Input.getInstance();
        int option;
        Presentation presentation;
        MessageFormatter formatter = MessageFormatter.getInstance();

        formatter
            .writeLine("========MENU========").newLine()
            .writeLine("0 - Visitor        |").newLine()
            .writeLine("1 - Admin          |").newLine()
            .writeLine("any key - Quit     |").newLine()
            .writeLine("====================").newLine()
            .printMessage();

        try {
            option = input.asInteger("Type your option:");
            presentation = PresentationType.values()[option].getPresentation();
        } catch (Exception e) {
            System.out.println("Quiting...");
            return;
        }

        presentation.showMenu(input);

        main(args);

    }
}
