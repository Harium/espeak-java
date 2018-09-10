package com.harium.hci.espeak;

public class Voice {

    String name = "default";

    // Range from 0 ~ 99
    int pitch = 50;

    // Range from 0 ~ 200
    int amplitude = 100;

    // Recommended range from 80 ~ 500
    int speed = 175;

    // in 10th of mS
    int gap = 0;

    String variant = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPitch() {
        return pitch;
    }

    public void setPitch(int pitch) {
        if (pitch < 0 || pitch > 99) {
            throw new IllegalArgumentException("The pitch must be be between 0 and 99");
        }
        this.pitch = pitch;
    }

    public int getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(int amplitude) {
        if (amplitude < 0 || amplitude > 200) {
            throw new IllegalArgumentException("The amplitude must be be between 0 and 200");
        }
        this.amplitude = amplitude;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed < 1) {
            throw new IllegalArgumentException("The speed must be above 0");
        }
        this.speed = speed;
    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        if (gap < 0) {
            throw new IllegalArgumentException("The gap between word must be positive number");
        }
        this.gap = gap;
    }

    public String getVaiant() {
        return variant;
    }

    public void setVariant(boolean isMale, int index) {
        if (isMale && (index < 1 || index > 7)) {
            throw new IllegalArgumentException("The variant index for male must be between 1 and 7");
        }
        if (!isMale && (index < 1 || index > 4)) {
            throw new IllegalArgumentException("The variant index for female must be between 1 and 4");
        }

        variant = "+" + (isMale?"m":"f") + Integer.toString(index);
    }

    public void setCroakVariant() {
        variant = "+croak";
    }

    public void setWhisperVariant() {
        variant = "+whisper";
    }

    public void removeVariant() {
        variant = "";
    }
}
