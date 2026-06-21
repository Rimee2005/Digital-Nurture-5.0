// Exercise 1: Singleton Pattern


public class Main {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application Started");
        logger2.log("Singleton Pattern Implemented");

        System.out.println("Both objects are same: " + (logger1 == logger2));
    }
}