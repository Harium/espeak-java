package com.harium.hci.espeak;

public class Voice {

    String name = "default";

    String code = "f3";

    // Range from 0 ~ 99
    int pitch = 50;

    // Range from 0 ~ 200
    int amplitude = 100;

    // Recommended range from 80 ~ 500
    int speed = 175;

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
        this.pitch = pitch;
    }

    public int getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(int amplitude) {
        this.amplitude = amplitude;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
