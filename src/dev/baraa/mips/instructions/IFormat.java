package dev.baraa.mips.instructions;

import dev.baraa.mips.Simulator;
import dev.baraa.mips.exceptions.MemoryOutOfBoundsException;

public class IFormat extends Instruction {

    private int immediate;
    private String branch;

    public IFormat(String instruction) {
        super(instruction);
        getData();
    }

    public String performInstruction() throws MemoryOutOfBoundsException {
        switch (this.getOp()) {
            case "beq" -> {
                return (this.beq()) ? this.getBranch() : null;
            }
            case "bne" -> {
                return (this.bne()) ? this.getBranch() : null;
            }
            default -> {
                perform();
                return null;
            }
        }
    }

    private boolean bne() {
        return this.getRt().getValue() != this.getRs().getValue();
    }

    private boolean beq() {
        return this.getRt().getValue() == this.getRs().getValue();
    }

    @Override
    public void perform() throws MemoryOutOfBoundsException {
        switch (this.getOp()) {
            case "addi" -> this.addi();
            case "andi" -> this.andi();
            case "ori" -> this.ori();
            case "slti" -> this.slti();
            case "lw" -> this.lw();
            case "sw" -> this.sw();
            case "srl" -> this.srl();
            case "sll" -> this.sll();
        }
    }

    private void sll() {
        this.getRt().setValue(this.getRs().getValue() << this.getImmediate());
    }

    private void srl() {
        this.getRt().setValue(this.getRs().getValue() >> this.getImmediate());
    }

    private void sw() throws MemoryOutOfBoundsException {
        int data = this.getRt().getValue();
        int index = this.getRs().getValue() + this.getImmediate();
        Simulator.getSimulator().getMemory().write(index, data);
    }

    private void lw() throws MemoryOutOfBoundsException {
        int data = Simulator.getSimulator().getMemory().readMemory(this.getRs().getValue() + this.getImmediate());
        this.getRt().setValue(data);
    }

    private void slti() {
        this.getRt().setValue((this.getRs().getValue() < this.getImmediate()) ? 1 : 0);
    }

    private void ori() {
        this.getRt().setValue(this.getRs().getValue() | this.getImmediate());
    }

    private void andi() {
        this.getRt().setValue(this.getRs().getValue() & this.getImmediate());
    }

    private void addi() {
        this.getRt().setValue(this.getRs().getValue() + this.getImmediate());
    }

    private void getData() {
        String[] instruction = splitInstruction();
        this.setOp(instruction[0]);
        this.setRt(Simulator.getSimulator().getRegistersFile().getRegisterByName(instruction[1]));

        switch (instruction[0].toLowerCase()) {
            case "beq", "bne" -> {
                this.setRs(Simulator.getSimulator().getRegistersFile().getRegisterByName(instruction[2]));
                this.setBranch(instruction[3]);
            }
            case "lw", "sw" -> {
                if (!instruction[2].contains(")"))
                    instruction[2] = modifyInstruction(instruction);
                String[] temp = instruction[2].replaceAll("\\)*[ ]*", "").split("\\(");
                this.setImmediate(Integer.parseInt(temp[0]));
                this.setRs(Simulator.getSimulator().getRegistersFile().getRegisterByName(temp[1]));
            }
            default -> {
                this.setRs(Simulator.getSimulator().getRegistersFile().getRegisterByName(instruction[2]));
                this.setImmediate(Integer.parseInt(instruction[3]));
            }
        }
    }

    private String modifyInstruction(String[] instruction) {
        return modifyInstruction(instruction, 2, "");
    }

    private String modifyInstruction(String[] instruction, int i, String s) {
        if (s.contains(")"))
            return s;

        s += instruction[i];
        return modifyInstruction(instruction, i + 1, s);
    }

    public int getImmediate() {
        return immediate;
    }

    public void setImmediate(int immediate) {
        this.immediate = immediate;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
