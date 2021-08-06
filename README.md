# MIPS Simulator in Java

A basic MIPS assembly language emulator written in Java with a simple graphical user interface. This project replicates MIPS in the absence of register pipelining. However, I intend to include it in the future.

## Description
This project might be used as a basic MIPS code editor and executor. The graphical user interface contains a code editor, a registers display, and a few more useful functionalities. During execution, the program is read line by line without the usage of the registers pipeline - at least for the time being. Which I will add in the future while still retaining the line-by-line execution for run time comparison.

## Implemented Instruction Set
- Arithmetic Operations: `add`, `addi`, `sub`, `mult`, `div`
- Logic Operations: `and`, `andi`, `or`, `ori`, `nor`
- Shift Operations: `sll`, `srl`
- Word Operations: `lw`, `sw`
- Branching: `j`, `beq`, `bne`
- Comparison: `slt`, `slti`

## Notes
- MIPS's 32 registers are all included in the register file. Yet, only the values of the primary registers ($s, $t, $v, and $a) are presented in the GUI.
- The main memory is initially 256KB in size. This may be modified by using the memory constructor.
- Files that have been saved are kept in a folder named `saved` in the project file.

## To-do
[ ] Add register pipelining
[ ] Update memory settings through the GUI
[ ] Improve exceptions handling
