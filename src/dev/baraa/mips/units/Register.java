package dev.baraa.mips.units;

public class Register {

    private int value;

    public Register() {
        this.value = 0;
    }

    public void clear() {
        this.value = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
