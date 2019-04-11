package de.mpomp;

import java.util.Scanner;

public class InputHandler implements Runnable {
    private final ICallback<Integer> callback;

    InputHandler(ICallback<Integer> callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Scanner start. Enter a Integer.");
        for (int i = 0; i < 1000; i++) {
            if(sc.hasNextLine()) {
                try {
                    callback.result(Integer.parseInt(sc.nextLine()));
                } catch (NumberFormatException e){
                    System.out.println("Enter only a digit.!");
                }
            }
        }
        System.out.println("End scanner.");
    }
}
