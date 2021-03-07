package br.com.megastore.util;

import java.util.Scanner;

public class Input {
    private static Input instance;
    private Scanner scanner;

    @Deprecated
    private Input() {
        scanner = new Scanner(System.in);
    }

    public static Input getInstance() {
        if(instance == null) instance = new Input();
        return instance;
    }

    public String asString(String message) {
        System.out.println(message);

        return scanner.nextLine();
    }

    public Integer asInteger(String message) {
        return Integer.parseInt(asString(message));
    }

    public Double asDouble(String message) {
        return Double.parseDouble(asString(message));
    }
}
