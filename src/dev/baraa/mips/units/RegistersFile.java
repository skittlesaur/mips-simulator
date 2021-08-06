package dev.baraa.mips.units;

import java.util.HashMap;
import java.util.Map;

public class RegistersFile {

    private final HashMap<String, Register> registers;

    public RegistersFile() {
        registers = new HashMap<>();
        initializeRegisters();
    }

    private void initializeRegisters() {
        registers.put("$zero", new Register());
        registers.put("$at", new Register());

        for (int i = 2; i <= 3; i++)
            registers.put("$v" + (i - 2), new Register());

        for (int i = 4; i <= 7; i++)
            registers.put("$a" + (i - 4), new Register());

        for (int i = 8; i <= 15; i++)
            registers.put("$t" + (i - 8), new Register());

        for (int i = 16; i <= 23; i++)
            registers.put("$s" + (i - 16), new Register());

        for (int i = 24; i <= 25; i++)
            registers.put("$t" + (i - 16), new Register());

        for (int i = 26; i <= 27; i++)
            registers.put("$k" + (i - 26), new Register());

        registers.put("$gp", new Register());
        registers.put("$sp", new Register());
        registers.put("$fp", new Register());
        registers.put("$ra", new Register());
    }

    public Register getRegisterByName(String name) {
        name = name.equals("$0") ? "$zero" : name;
        return registers.get(name);
    }

    public String registerData(char type) {
        StringBuilder temp = new StringBuilder();

        if (type == 's')
            for (int i = 16; i <= 23; i++)
                temp.append("$s").append(i - 16).append(": ").append(String.format("0x%08X", registers.get("$s" + (i - 16)).getValue())).append("\n");
        else if (type == 't') {
            for (int i = 8; i <= 15; i++)
                temp.append("$t").append(i - 8).append(": ").append(String.format("0x%08X", registers.get("$t" + (i - 8)).getValue())).append("\n");
            for (int i = 24; i <= 25; i++)
                temp.append("$t").append(i - 16).append(": ").append(String.format("0x%08X", registers.get("$t" + (i - 16)).getValue())).append("\n");
        } else if (type == 'v')
            for (int i = 2; i <= 3; i++)
                temp.append("$v").append(i - 2).append(": ").append(String.format("0x%08X", registers.get("$v" + (i - 2)).getValue())).append("\n");
        else if (type == 'a')
            for (int i = 4; i <= 7; i++)
                temp.append("$a").append(i - 4).append(": ").append(String.format("0x%08X", registers.get("$a" + (i - 4)).getValue())).append("\n");

        return temp.toString();
    }

    public void resetAll() {
        for (Map.Entry<String, Register> r : registers.entrySet())
            r.getValue().clear();
    }

}
