package com.harium.hci.espeak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reference: http://espeak.sourceforge.net/commands.html
 */
public class Espeak {

    public static final String COMMAND_ESPEAK = "espeak";
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
        execute(COMMAND_ESPEAK,
                "-v", buildVariant(voice),
                "-p", Integer.toString(voice.getPitch()),
                "-a", Integer.toString(voice.getAmplitude()),
                "-s", Integer.toString(voice.getSpeed()),
                "-g", Integer.toString(voice.getGap()),
                text);
    }

    private String buildVariant(Voice voice) {
        StringBuilder builder = new StringBuilder();
        if (voice.getName() != null && !voice.getName().isEmpty()) {
            builder.append(voice.getName());
        }

        if (voice.getVariant() != null && !voice.getVariant().isEmpty()) {
            builder.append("+");
            builder.append(voice.getVariant());
        }

        return builder.toString();
    }

    private static void execute(final String ... command) {
        String threadName = "espeak";

        new Thread(new Runnable() {
            public void run() {
                ProcessBuilder b = new ProcessBuilder(command);
                b.redirectErrorStream(true);
                try {
                    Process process = b.start();

                    readErrors(process);
                    process.waitFor();
                    process.destroy();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            private void readErrors(Process process) throws IOException {
                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    System.err.println(line);
                }
            }
        }, threadName).start();
    }

}
