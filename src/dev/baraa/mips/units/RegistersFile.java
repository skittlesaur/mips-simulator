package dev.baraa.mips.units;

public class RegistersFile {

    private Register[] registers;

    public RegistersFile() {
        registers = new Register[32];
        for (int i = 0; i < registers.length; i++)
            registers[i] = new Register();
    }
}
