package com.harium.hci.espeak;

import java.io.IOException;

/**
 * Reference: http://espeak.sourceforge.net/commands.html
 */
public class Espeak {

    private Voice voice;

    public Espeak() {
        this(new Voice());
    }

    public Espeak(Voice voice) {
        this.voice = voice;
    }

    /**
     * Create a new espeak process
     *
     * @param text - the text to speak
     */
    public void speak(String text) {
        execute("espeak",
                "-v", voice.name + voice.variant,
                "-p", Integer.toString(voice.pitch),
                "-a", Integer.toString(voice.amplitude),
                "-s", Integer.toString(voice.speed),
                "-g", Integer.toString(voice.gap),
                text);
    }

    private static void execute(final String ... command) {
        new Thread(new Runnable() {
            public void run() {
                ProcessBuilder b = new ProcessBuilder(command);
                try {
                    Process process = b.start();
                    process.waitFor();
                    process.destroy();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "espeak").start();
    }

}
