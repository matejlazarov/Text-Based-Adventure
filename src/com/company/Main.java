package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class Main {

    JFrame myWindow;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, healthPotionLabel, healthPotionLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, healthPotion, goblinHP, mageHP, orb, potionSellerZborenje;
    String weapon, position;

    titleScreenHandler tsHandler = new titleScreenHandler();
    choiceHandler chHandler = new choiceHandler();

    public static void main(String[] args) {
        new Main();

    }

    public Main() {

        myWindow = new JFrame();
        myWindow.setSize(800, 600);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.getContentPane().setBackground(Color.black);
        myWindow.setLayout(null);
        myWindow.setVisible(true);
        con = myWindow.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);

        titleNameLabel = new JLabel("QUEST");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        startButtonPanel.add(startButton);

        con.add(startButtonPanel);
        con.add(titleNamePanel);

        titleNamePanel.add(titleNameLabel);

    }

    public void createGameScreen() {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choiceButtonPanel.add(choice1);
        choice1.setFocusPainted(false);
        choice1.addActionListener(chHandler);
        choice1.setActionCommand("c1");

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choiceButtonPanel.add(choice2);
        choice2.setFocusPainted(false);
        choice2.addActionListener(chHandler);
        choice2.setActionCommand("c2");

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choiceButtonPanel.add(choice3);
        choice3.setFocusPainted(false);
        choice3.addActionListener(chHandler);
        choice3.setActionCommand("c3");

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choiceButtonPanel.add(choice4);
        choice4.setFocusPainted(false);
        choice4.addActionListener(chHandler);
        choice4.setActionCommand("c4");

        playerPanel = new JPanel();
        playerPanel.setBounds(90, 15, 700, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);

        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        healthPotionLabel = new JLabel("Potions: ");
        healthPotionLabel.setFont(normalFont);
        healthPotionLabel.setForeground(Color.white);
        playerPanel.add(healthPotionLabel);

        healthPotionLabelName = new JLabel();
        healthPotionLabelName.setFont(normalFont);
        healthPotionLabelName.setForeground(Color.white);
        playerPanel.add(healthPotionLabelName);

        playerSetup();
    }

    public void playerSetup() {
        playerHP = 15;
        goblinHP = 15;
        mageHP = 30;
        healthPotion = 1;
        weapon = "Knife";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);
        healthPotionLabelName.setText("" + healthPotion);
        orb = 0;
        potionSellerZborenje = 0;

        towerGate();
    }

    public void heal() {
        if (healthPotion == 1) {
            if (playerHP <= 10) {
                playerHP = playerHP + 5;
                hpLabelNumber.setText("" + playerHP);
            } else
                playerHP = playerHP + (15 - playerHP);
            hpLabelNumber.setText("" + playerHP);
            healthPotion = 0;
            healthPotionLabelName.setText("0");
        }
    }

    public void towerGate() {
        position = "towerGate";
        mainTextArea.setText("You're in front of the tower,\nbut, a mage is blocking your way.\n\nWhat will you do?");
        choice1.setText("Talk");
        choice2.setText("Attack");
        choice3.setText("Run");
        choice4.setText("Drink potion");
    }

    public void zboriV() {
        position = "zboriMage";
        if (orb == 0) {
            mainTextArea.setText("Mage: A goblin has stolen the Orb.\nIf you get it back, I shall let you enter.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        } else {
            position = "kraj";
            mainTextArea.setText("Mage: You may enter.\n\nEND.");
            choice1.setText("");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }

    public void Begaj() {
        position = "Village";
        mainTextArea.setText("You're in the village.\n\nWhat will you do?");
        choice1.setText("Go to the tower.");
        choice2.setText("Go to the forest.");
        choice3.setText("Go to the potion seller");
        choice4.setText("Drink potion ");
    }

    public void kajPotionSeller() {
        position = "potionSeller";
        mainTextArea.setText("You're at the potion seller.\n\nWhat will you do?");
        choice1.setText("Talk");
        choice2.setText("Take potion");
        choice3.setText("Leave");
        choice4.setText("Drink potion");
        potionSellerZborenje++;
    }

    public void Forest() {
        if (goblinHP > 0) {
            position = "uForest";
            mainTextArea.setText("You're in the forest and encounter a goblin.\n\nWhat will you do?");
            choice1.setText("Fight");
            choice2.setText("Run");
            choice3.setText("Drink potion");
            choice4.setText("");
        } else {
            position = "uForestPobeden";
            mainTextArea.setText("You're in the forest,\nbut there's nothing here.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }

    public void zboriL() {
        if (potionSellerZborenje != 3) {
            position = "zboriPotionSeller";
            mainTextArea.setText("You tried to talk, but he's fast asleep.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
            potionSellerZborenje++;
        } else {
            position = "zboriPotionSellerBuden";
            mainTextArea.setText("You woke up the potion seller.\n\n He gives you a sword.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
            weapon = "Sword";
            weaponLabelName.setText("Sword");
        }
    }

    public void takePotion() {
        if (healthPotion == 0) {
            healthPotion++;
            healthPotionLabelName.setText("" + healthPotion);
        } else if (healthPotion > 0) {
            position = "zimaPotion";
            mainTextArea.setText("You can't carry more than one potion.");
            choice1.setText(">");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
    }

    public void napadMage() {
        if (weapon == "Knife") {
            mainTextArea.setText("Mage: Be a bit more careful next time.\n\nThe mage struck you with lightning.");
            playerHP = playerHP - 10;
            hpLabelNumber.setText("" + playerHP);
        } else {
            position = "tepackaMage";
            mainTextArea.setText("Mage HP: " + mageHP + "\n\nWhat will you do?");
            choice1.setText("Attack");
            choice2.setText("Drink potion");
            choice3.setText("");
            choice4.setText("");
        }
    }

    public void napadGoblin() {
        position = "tepackaGoblin";
        mainTextArea.setText("Goblin HP: " + goblinHP + "\n\nWhat will you do?");
        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("Drink potion");
        choice4.setText("");
    }

    public void vasoNapad() {
        position = "napad";

        int vasoDMG = 0;
        if (weapon == "Knife") {
            vasoDMG = new java.util.Random().nextInt(3);
        } else
            vasoDMG = new java.util.Random().nextInt(20);
        if (vasoDMG == 0) {
            mainTextArea.setText("You attacked, but missed.");
        } else {
            mainTextArea.setText("You attacked, and lowered his HP by " + vasoDMG + " points.");
        }

        goblinHP = goblinHP - vasoDMG;

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void vasoNapadMage() {
        position = "napadMage";

        int vasoDMG = 0;
        if (weapon == "Knife") {
            vasoDMG = new java.util.Random().nextInt(3);
        } else
            vasoDMG = new java.util.Random().nextInt(20);
        if (vasoDMG == 0) {
            mainTextArea.setText("You attacked, but missed.");
        } else {
            mainTextArea.setText("You attacked, and lowered his HP by " + vasoDMG + " points.");
        }

        mageHP = mageHP - vasoDMG;

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }
    public void mageNapad() {
        position = "magenapad";

        int mageDMG = 0;

        mageDMG = new java.util.Random().nextInt(10);

        if (mageDMG == 0) {
            mainTextArea.setText("The mage cast a spell on you, but missed.");
        } else {
            mainTextArea.setText("The mage cast a spell on you.\nYour HP was lowered by " + mageDMG + " points.");
        }
        playerHP = playerHP - mageDMG;

        hpLabelNumber.setText("" + playerHP);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }
    public void goblinNapad() {
        position = "goblinnapad";

        int goblinDMG = 0;

        goblinDMG = new java.util.Random().nextInt(5);

        if (goblinDMG == 0) {
            mainTextArea.setText("The goblin attacked, but missed.");
        } else {
            mainTextArea.setText("The goblin attacked, and lowered your HP by " + goblinDMG + ".");
        }
        playerHP = playerHP - goblinDMG;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void win() {
        position = "win";

        mainTextArea.setText("You defeated the goblin, and took back the orb!");
        orb = 1;

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void winMage() {
        position = "winMage";

        mainTextArea.setText("You defeated the mage, and entered the tower!\n\nEND.");

        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void lose() {
        position = "loss";

        mainTextArea.setText("You died!");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public class titleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }

    public class choiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (position) {
                case "towerGate":
                    switch (yourChoice) {
                        case "c1":
                            zboriV();
                            break;
                        case "c2":
                            napadMage();
                            if (playerHP < 1) {
                                lose();
                            }
                            break;
                        case "c3":
                            Begaj();
                            break;
                        case "c4":
                            heal();
                            break;
                    }
                    break;

                case "zboriMage":
                    switch (yourChoice) {
                        case "c1":
                            towerGate();
                            break;
                    }
                    break;

                case "tepackaMage":
                    switch (yourChoice) {
                        case "c1":
                            vasoNapadMage();
                            break;
                        case "c2":
                            heal();
                            break;
                    }
                    break;

                case "napadMage":
                    switch (yourChoice) {
                        case "c1":
                            if (mageHP < 1) {
                                winMage();
                            } else {
                                mageNapad();
                            }
                            break;
                    }
                    break;
                case "magenapad":
                    switch (yourChoice) {
                        case "c1":
                            if (playerHP < 1) {
                                lose();
                            } else {
                                napadMage();
                            }

                            break;
                    }
                    break;

                case "Village":
                    switch (yourChoice) {
                        case "c1":
                            towerGate();
                            break;
                        case "c2":
                            Forest();
                            break;
                        case "c3":
                            kajPotionSeller();
                            break;
                        case "c4":
                            heal();
                            break;
                    }
                    break;
                case "potionSeller":
                    switch (yourChoice) {
                        case "c1":
                            zboriL();
                            break;
                        case "c2":
                            takePotion();
                            break;
                        case "c3":
                            Begaj();
                            break;
                        case "c4":
                            heal();
                            break;
                    }
                    break;
                case "zboriPotionSeller":
                    switch (yourChoice) {
                        case "c1":
                            kajPotionSeller();
                            break;
                    }
                    break;
                case "zboriPotionSellerBuden":
                    switch (yourChoice) {
                        case "c1":
                            kajPotionSeller();
                            break;
                    }
                    break;

                case "zimaPotion":
                    switch (yourChoice) {
                        case "c1":
                            kajPotionSeller();
                            break;
                    }
                    break;
                case "uForest":
                    switch (yourChoice) {
                        case "c1":
                            napadGoblin();
                            break;
                        case "c2":
                            Begaj();
                            break;
                        case "c3":
                            heal();
                            break;
                    }
                    break;
                case "uForestPobeden":
                    switch (yourChoice) {
                        case "c1":
                            Begaj();
                            break;
                    }
                    break;
                case "tepackaGoblin":
                    switch (yourChoice) {
                        case "c1":
                            vasoNapad();
                            break;
                        case "c2":
                            Begaj();
                            break;
                        case "c3":
                            heal();
                            break;
                    }
                    break;
                case "napad":
                    switch (yourChoice) {
                        case "c1":
                            if (goblinHP < 1) {
                                win();
                            } else {
                                goblinNapad();
                            }
                            break;
                    }
                    break;
                case "goblinnapad":
                    switch (yourChoice) {
                        case "c1":
                            if (playerHP < 1) {
                                lose();
                            } else {
                                napadGoblin();
                            }

                            break;
                    }
                    break;

                case "win":
                    switch (yourChoice) {
                        case "c1":
                            Begaj();
                    }

            }

        }
    }
}