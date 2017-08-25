package project.printers;

public class ExceptionConsolePrinter {

    public static void print(Throwable exception) {
        System.out.println("[ERROR]: " + exception.getMessage());
        System.out.println("Please, contact administrator for detailed information.");
    }
}
