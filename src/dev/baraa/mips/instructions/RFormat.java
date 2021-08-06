package dev.baraa.mips.instructions;

import dev.baraa.mips.Simulator;
import dev.baraa.mips.exceptions.UnknownInstructionException;
import dev.baraa.mips.units.Register;

public class RFormat extends Instruction {

    private Register rd;
    private String funct;

    public RFormat(String instruction) throws UnknownInstructionException {
        super(instruction);
        getData();
    }

    @Override
    public void perform() {

        switch (this.getFunct()) {
            case "add" -> this.add();
            case "sub" -> this.sub();
            case "and" -> this.and();
            case "or" -> this.or();
            case "nor" -> this.nor();
            case "slt" -> this.slt();
            case "div" -> this.div();
            case "mult" -> this.mult();
        }
    }

    private void mult() {
        this.getRd().setValue(this.getRs().getValue() * this.getRt().getValue());
    }

    private void div() {
        this.getRd().setValue(this.getRs().getValue() / this.getRt().getValue());
    }

    private void slt() {
        this.getRd().setValue((this.getRs().getValue() < this.getRt().getValue()) ? 1 : 0);
    }

    private void nor() {
        this.getRd().setValue(~(this.getRs().getValue() | this.getRt().getValue()));
    }

    private void or() {
        this.getRd().setValue(this.getRs().getValue() | this.getRt().getValue());
    }

    private void and() {
        this.getRd().setValue(this.getRs().getValue() & this.getRt().getValue());
    }

    private void sub() {
        this.getRd().setValue(this.getRs().getValue() - this.getRt().getValue());
    }

    private void add() {
        this.getRd().setValue(this.getRs().getValue() + this.getRt().getValue());
    }


    private void getData() throws UnknownInstructionException {
        String[] instruction = splitInstruction();
        if (instruction.length > 4)
            throw new UnknownInstructionException("Unknown Instruction Formatting");
        this.setOp("");
        this.setFunct(instruction[0].toLowerCase());
        this.setRd(Simulator.getSimulator().getRegistersFile().getRegisterByName(instruction[1]));
        this.setRs(Simulator.getSimulator().getRegistersFile().getRegisterByName(instruction[2]));
        this.setRt(Simulator.getSimulator().getRegistersFile().getRegisterByName(instruction[3]));
    }

    public Register getRd() {
        return rd;
    }

    public void setRd(Register rd) {
        this.rd = rd;
    }

    public String getFunct() {
        return funct;
    }

    public void setFunct(String funct) {
        this.funct = funct;
    }
}
