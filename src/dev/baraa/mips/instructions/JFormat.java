package dev.baraa.mips.instructions;

public class JFormat extends Instruction {

    private String branch;

    public JFormat(String instruction) {
        super(instruction);
        getData();
    }

    private void getData() {
        String[] instruction = splitInstruction();
        this.setOp(instruction[0]);
        this.setBranch(instruction[1]);
    }

    public String performInstruction() {
        return this.getBranch();
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
