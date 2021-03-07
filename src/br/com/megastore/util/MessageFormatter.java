package br.com.megastore.util;

public class MessageFormatter {
    public static MessageFormatter instance;

    public StringBuilder message;

    @Deprecated
    private MessageFormatter() {
        message = new StringBuilder();
    }

    public static MessageFormatter getInstance() {
        if(instance == null)
            instance = new MessageFormatter();

        return instance;
    }

    public MessageFormatter writeLine(String line) {
        message.append(line);
        return this;
    }

    public MessageFormatter newLine() {
        message.append("\n");
        return this;
    }

    public String getMessage() {
        String temp = message.toString();
        message = new StringBuilder();

        return temp;
    }

    public void printMessage() {
        System.out.println(getMessage());
    }

}
