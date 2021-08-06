package dev.baraa.mips.units;

import dev.baraa.mips.exceptions.MemoryOutOfBoundsException;

public class Memory {

    private final int[] dataMemory;

    public Memory(int size) {
        dataMemory = new int[size];
    }

    public Memory() {
        this(100);
    }

    public int readMemory(int index) throws MemoryOutOfBoundsException {
        if (index / 4 > dataMemory.length)
            throw new MemoryOutOfBoundsException("Block " + index / 4 + " is out of bounds");
        return dataMemory[index / 4];
    }

    public void write(int index, int value) throws MemoryOutOfBoundsException {
        if (index / 4 > dataMemory.length)
            throw new MemoryOutOfBoundsException("Block " + index / 4 + " is out of bounds");
        dataMemory[index / 4] = value;
    }
}
