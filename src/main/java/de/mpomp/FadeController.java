package de.mpomp;

public class FadeController implements ICallback<Integer>{
    // A volatile variable would guarantee every reading thread will get the most recent written value. Not needed here.

    private FadeHandler fade;

    void start(){
        fade = new FadeHandler(0);

        Thread inputThread = new Thread(new InputHandler(this));
        inputThread.start();

        Thread fadeThread = new Thread(fade);
        fadeThread.start();
    }

    @Override
    public void result(Integer value) {
        fade.setValue(value);
    }
}

