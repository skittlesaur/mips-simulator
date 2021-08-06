package dev.baraa.mips.graphics;

import dev.baraa.mips.Simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistersData extends JPanel {

    private final JLabel registersInfo;
    private char currentActive;

    public RegistersData() {

        this.setSize(Screen.calculateDimension(400, 715));
        this.setLocation(Screen.calculatePoint(1370, 300));
        this.setOpaque(true);
        this.setBackground(new Color(0xFCFCFC));
        this.setLayout(null);

        JLabel registersData = new JLabel("Registers Data", SwingConstants.CENTER);
        registersData.setLocation(Screen.calculatePoint(0, 60));
        registersData.setSize(Screen.calculateDimension(400, 35));
        registersData.setFont(Fonts.getBold().deriveFont(Fonts.fontSize(30)));
        registersData.setForeground(new Color(0x4F5965));
        this.add(registersData);

        JPanel registersButtons = new JPanel();
        registersButtons.setLocation(Screen.calculatePoint(0, 140));
        registersButtons.setSize(Screen.calculateDimension(400, 80));
        registersButtons.setLayout(new GridLayout(1, 4));
        registersButtons.setBackground(new Color(0xE2E2E2));

        RegisterButton sRegister = new RegisterButton("$s");
        sRegister.setActive();
        currentActive = 's';
        RegisterButton tRegister = new RegisterButton("$t");
        RegisterButton vRegister = new RegisterButton("$v");
        RegisterButton aRegister = new RegisterButton("$a");

        sRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sRegister.setActive();
                tRegister.setInactive();
                aRegister.setInactive();
                vRegister.setInactive();
                displayRegisters('s');
                currentActive = 's';
            }
        });

        tRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tRegister.setActive();
                sRegister.setInactive();
                aRegister.setInactive();
                vRegister.setInactive();
                displayRegisters('t');
                currentActive = 't';
            }
        });

        aRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aRegister.setActive();
                tRegister.setInactive();
                sRegister.setInactive();
                vRegister.setInactive();
                displayRegisters('a');
                currentActive = 'a';
            }
        });

        vRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vRegister.setActive();
                tRegister.setInactive();
                aRegister.setInactive();
                sRegister.setInactive();
                displayRegisters('v');
                currentActive = 'v';
            }
        });

        registersButtons.add(sRegister);
        registersButtons.add(tRegister);
        registersButtons.add(vRegister);
        registersButtons.add(aRegister);

        this.add(registersButtons);

        registersInfo = new JLabel();
        registersInfo.setSize(Screen.calculateDimension(400, 450));
        registersInfo.setLocation(Screen.calculatePoint(0, 240));
        registersInfo.setOpaque(false);
        registersInfo.setForeground(new Color(0x4F5965));
        registersInfo.setFont(Fonts.getRegular().deriveFont(Fonts.fontSize(30)));
        registersInfo.setHorizontalAlignment(SwingConstants.CENTER);
        registersInfo.setVerticalAlignment(SwingConstants.CENTER);

        this.add(registersInfo);

        displayRegisters('s');
    }

    public void displayRegisters(char type) {
        registersInfo.setText("<html>" + Simulator.getSimulator().getRegistersFile().registerData(type).replaceAll("\n", "<br>") + "</html>");
    }

    public void displayRegisters() {
        displayRegisters(currentActive);
    }

}
