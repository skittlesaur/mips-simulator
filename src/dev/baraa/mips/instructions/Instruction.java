package dev.baraa.mips.instructions;

import dev.baraa.mips.exceptions.CodeExceptions;
import dev.baraa.mips.units.Register;

import java.util.Arrays;

public class Instruction {

    private final String instruction;
    private String op;
    private Register rs;
    private Register rt;

    private final String[] rInstructions = {"add", "sub", "and", "or", "nor", "slt", "mult", "div"};
    private final String[] iInstructions = {"addi", "andi", "ori", "slti", "beq", "bne", "lw", "sw", "srl", "sll"};
    private final String[] jInstructions = {"j"};


    public Instruction(String instruction) {
        this.instruction = instruction;
    }

    public String[] splitInstruction() {
        return instruction.split("[,\\s]+");
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Register getRs() {
        return rs;
    }

    public void setRs(Register rs) {
        this.rs = rs;
    }

    public Register getRt() {
        return rt;
    }

    public void setRt(Register rt) {
        this.rt = rt;
    }

    public char getType() {
        String f = this.splitInstruction()[0];
        if (Arrays.asList(rInstructions).contains(f))
            return 'r';
        else if (Arrays.asList(iInstructions).contains(f))
            return 'i';
        else if (Arrays.asList(jInstructions).contains(f))
            return 'j';

        return '0';
    }

    public void perform() throws CodeExceptions {
    }
}
