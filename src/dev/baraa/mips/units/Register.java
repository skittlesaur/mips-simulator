package dev.baraa.mips.units;

public class Register {

    private String name;
    private int value;

    public Register() {

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

    @Override
    public String toString() {
        return "Register{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
