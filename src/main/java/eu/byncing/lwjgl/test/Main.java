package eu.byncing.lwjgl.test;

public class Main {

    public static void main(String[] args) {
        Display display = new Display("Lwjgl Test", 400, 400);
        display.show();
        display.start(() -> {
            //update part
            //rendering part
        });
    }
}