package de.mpomp;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Java Concurrency Output!\n");

        FadeController controller = new FadeController();
        controller.start();
    }
}
