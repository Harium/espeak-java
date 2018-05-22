package com.harium.hci.espeak;

import java.io.IOException;

/**
 * Reference: http://espeak.sourceforge.net/commands.html
 */
public class Espeak {

    private Voice voice;
    private String language;

    public Espeak() {
        this(new Voice(), "en");
    }

    public Espeak(Voice voice) {
        this(voice, "en");
    }

    public Espeak(String language) {
        this();
        this.language = language;
    }

    public Espeak(Voice voice, String language) {
        this.voice = voice;
        this.language = language;
    }

    /**
     * Create a new espeak process
     *
     * @param text - the text to speak
     */
    public void speak(String text) {
        execute("espeak", "-vaf+" + voice.code,
                "-p", Integer.toString(voice.pitch),
                "-a", Integer.toString(voice.amplitude),
                "-s", Integer.toString(voice.speed),
                "-l", language,
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
        }).start();
    }

}
