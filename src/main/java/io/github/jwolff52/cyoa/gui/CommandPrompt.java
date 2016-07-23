package io.github.jwolff52.cyoa.gui;

import io.github.jwolff52.cyoa.Main;
import io.github.jwolff52.cyoa.ref.R;
import io.github.jwolff52.cyoa.util.CLogger;
import io.github.jwolff52.cyoa.util.DelayedActionUtil;
import io.github.jwolff52.cyoa.util.dialogue.HelpDialogue;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class CommandPrompt extends JFrame {
    private JTextArea displayArea;
    private JPanel mainPanel;
    private JTextField cmdArea;
    private JScrollPane cmdAreaScrollPane;
    private JScrollPane displayAreaScrollPane;
    private JSplitPane outerSplitPane;
    private JSplitPane innerSplitPane;
    private JPanel infoBarPanel;
    private JSplitPane infoBarSplitPane;
    private JPanel infoBarLeftPane;
    private JPanel infoBarRightPane;
    private JLabel healthLabel;
    private JLabel menuLabel;
    private JLabel inventoryLabel;
    private JLabel goldLabel;
    private JLabel healthValueLabel;
    private JLabel goldValueLabel;
    private JLabel characterLabel;

    private boolean inputAllowed, screenLocked;
    private String lastInput;

    public CommandPrompt(boolean inputAllowed) {
        setInputAllowed(inputAllowed);
        setScreenLocked(false);
        setLastInput("");
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            CLogger.logError(e);
        }
        this.setTitle(R.GAME_NAME);
        this.setContentPane(mainPanel);
        this.setSize(900, 450);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        displayArea.setBorder(null);
        displayAreaScrollPane.setBorder(null);
        cmdArea.setBorder(null);
        cmdAreaScrollPane.setBorder(null);
        infoBarLeftPane.setBackground(Color.BLACK);
        infoBarRightPane.setBackground(Color.BLACK);
        goldLabel.setForeground(cmdArea.getForeground());
        goldValueLabel.setForeground(cmdArea.getForeground());
        healthLabel.setForeground(cmdArea.getForeground());
        healthValueLabel.setForeground(cmdArea.getForeground());
        inventoryLabel.setForeground(cmdArea.getForeground());
        menuLabel.setForeground(cmdArea.getForeground());
        characterLabel.setForeground(cmdArea.getForeground());
        pack();

        cmdArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (isInputAllowed()) {
                        lastInput = cmdArea.getText();
                        if (!lastInput.equals("\n") && !isScreenLocked()) {
                            displayArea.append(lastInput + "\n");
                            cmdArea.setText("");
                        }
                        cmdArea.setText("");
                        Main.getGameThread().resume();
                    } else {
                        if (!lastInput.equals("")) {
                            DelayedActionUtil.setCmdText(cmdArea.getText());
                            cmdArea.setText("Please Wait");
                        }
                    }
                }
            }
        });

        this.setVisible(true);
    }

    public boolean isInputAllowed() {
        return inputAllowed;
    }

    public void setInputAllowed(boolean inputAllowed) {
        this.inputAllowed = inputAllowed;
    }

    public boolean isScreenLocked() {
        return screenLocked;
    }

    public void setScreenLocked(boolean screenLocked) {
        this.screenLocked = screenLocked;
    }

    public void setCmdText(String cmdText) {
        cmdArea.setText(cmdText);
        cmdArea.setCaretPosition(cmdArea.getText().length());
    }

    public void appendChar(char c) {
        displayArea.append(c + "");
        if (c == '.' || c == '!' || c == '?') {
            Main.getGameThread().sleep(425);
        }
    }

    public void appendChar(char c, String pauseCharacters) {
        displayArea.append(c + "");
        if ((c + "").matches(pauseCharacters)) {
            Main.getGameThread().sleep(425);
        }
    }

    public void appendLine(String line) {
        int lineLength = 0;
        int wordCount = 0;
        String[] splitLine = line.split(" ");
        for (String s : splitLine) {
            if (lineLength + wordCount + s.length() >= 85) {
                displayArea.append("\n");
                lineLength = 0;
                wordCount = 0;
            }
            for (char c : s.toCharArray()) {
                appendChar(c);
                lineLength++;
                Main.getGameThread().sleep(75);
            }
            wordCount++;
            appendChar(' ');
        }
        displayArea.append("\n");
    }

    public void appendLine(String line, String pauseCharacters) {
        int lineLength = 0;
        int wordCount = 0;
        String[] splitLine = line.split(" ");
        for (String s : splitLine) {
            if (lineLength + wordCount + s.length() >= 85) {
                displayArea.append("\n");
                lineLength = 0;
                wordCount = 0;
            }
            for (char c : s.toCharArray()) {
                appendChar(c, pauseCharacters);
                lineLength++;
                Main.getGameThread().sleep(75);
            }
            wordCount++;
            appendChar(' ');
        }
        displayArea.append("\n");
    }

    public void appendLines(String[] lines) {
        for (String line : lines) {
            appendLine(line);
        }
    }

    public void setLastInput(String lastInput) {
        this.lastInput = lastInput;
    }

    public String getLastInput() {
        return lastInput;
    }

    public void clearScreen() {
        displayArea.setText("");
    }

    public boolean isValidInput(String input, Object... args) {
        if (HelpDialogue.helpScreen(input)) return false;
        if (args.length > 0) {
            switch (((String) args[0]).toLowerCase()) {
                case "number":
                    int inputAsNumber;
                    try {
                        inputAsNumber = Integer.valueOf(input.substring(0, 1));
                    } catch (NumberFormatException e) {
                        return false;
                    }
                    if (inputAsNumber < (int) args[1] || inputAsNumber > (int) args[2]) {
                        return false;
                    }
                    break;
                case "alphanumeric":
                    return input.matches("[a-zA-Z0-9_ ]+");
            }
        }
        return !input.equalsIgnoreCase("\n");
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        mainPanel.setBackground(new Color(-12828863));
        mainPanel.setForeground(new Color(-12828863));
        mainPanel.setMinimumSize(new Dimension(700, 400));
        mainPanel.setPreferredSize(new Dimension(700, 400));
        outerSplitPane = new JSplitPane();
        outerSplitPane.setContinuousLayout(true);
        outerSplitPane.setDividerLocation(25);
        outerSplitPane.setDividerSize(0);
        outerSplitPane.setForeground(new Color(-12828863));
        outerSplitPane.setMinimumSize(new Dimension(700, 400));
        outerSplitPane.setOrientation(0);
        outerSplitPane.setPreferredSize(new Dimension(700, 400));
        mainPanel.add(outerSplitPane);
        infoBarPanel = new JPanel();
        infoBarPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        infoBarPanel.setForeground(new Color(-12828863));
        infoBarPanel.setMaximumSize(new Dimension(700, 25));
        infoBarPanel.setMinimumSize(new Dimension(700, 25));
        infoBarPanel.setOpaque(true);
        infoBarPanel.setPreferredSize(new Dimension(700, 25));
        outerSplitPane.setLeftComponent(infoBarPanel);
        infoBarSplitPane = new JSplitPane();
        infoBarSplitPane.setDividerLocation(350);
        infoBarSplitPane.setDividerSize(0);
        infoBarSplitPane.setMinimumSize(new Dimension(700, 25));
        infoBarSplitPane.setPreferredSize(new Dimension(700, 25));
        infoBarPanel.add(infoBarSplitPane);
        infoBarLeftPane = new JPanel();
        infoBarLeftPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        infoBarLeftPane.setMinimumSize(new Dimension(350, 25));
        infoBarLeftPane.setPreferredSize(new Dimension(350, 25));
        infoBarSplitPane.setLeftComponent(infoBarLeftPane);
        healthLabel = new JLabel();
        healthLabel.setText("Health:");
        infoBarLeftPane.add(healthLabel);
        healthValueLabel = new JLabel();
        healthValueLabel.setText("0");
        infoBarLeftPane.add(healthValueLabel);
        goldLabel = new JLabel();
        goldLabel.setText("Gold:");
        infoBarLeftPane.add(goldLabel);
        goldValueLabel = new JLabel();
        goldValueLabel.setText("0");
        infoBarLeftPane.add(goldValueLabel);
        infoBarRightPane = new JPanel();
        infoBarRightPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        infoBarRightPane.setMinimumSize(new Dimension(350, 25));
        infoBarRightPane.setPreferredSize(new Dimension(350, 25));
        infoBarSplitPane.setRightComponent(infoBarRightPane);
        characterLabel = new JLabel();
        characterLabel.setText("Character");
        infoBarRightPane.add(characterLabel);
        inventoryLabel = new JLabel();
        inventoryLabel.setText("Inventory");
        infoBarRightPane.add(inventoryLabel);
        menuLabel = new JLabel();
        menuLabel.setText("Menu");
        infoBarRightPane.add(menuLabel);
        innerSplitPane = new JSplitPane();
        innerSplitPane.setContinuousLayout(true);
        innerSplitPane.setDividerLocation(350);
        innerSplitPane.setDividerSize(0);
        innerSplitPane.setFocusable(false);
        innerSplitPane.setMinimumSize(new Dimension(700, 375));
        innerSplitPane.setOrientation(0);
        innerSplitPane.setPreferredSize(new Dimension(700, 375));
        outerSplitPane.setRightComponent(innerSplitPane);
        cmdAreaScrollPane = new JScrollPane();
        cmdAreaScrollPane.setHorizontalScrollBarPolicy(31);
        cmdAreaScrollPane.setVerticalScrollBarPolicy(21);
        innerSplitPane.setRightComponent(cmdAreaScrollPane);
        cmdArea = new JTextField();
        cmdArea.setAutoscrolls(false);
        cmdArea.setBackground(new Color(-16777216));
        cmdArea.setCaretColor(new Color(-8212805));
        cmdArea.setFont(new Font("Courier New", cmdArea.getFont().getStyle(), cmdArea.getFont().getSize()));
        cmdArea.setForeground(new Color(-8212805));
        cmdArea.setMinimumSize(new Dimension(700, 25));
        cmdArea.setPreferredSize(new Dimension(700, 25));
        cmdAreaScrollPane.setViewportView(cmdArea);
        displayAreaScrollPane = new JScrollPane();
        displayAreaScrollPane.setHorizontalScrollBarPolicy(31);
        displayAreaScrollPane.setMinimumSize(new Dimension(900, 350));
        displayAreaScrollPane.setVerticalScrollBarPolicy(21);
        innerSplitPane.setLeftComponent(displayAreaScrollPane);
        displayArea = new JTextArea();
        displayArea.setAutoscrolls(true);
        displayArea.setBackground(new Color(-16777216));
        displayArea.setCaretColor(new Color(-8212805));
        displayArea.setEditable(true);
        displayArea.setFocusable(false);
        displayArea.setFont(new Font("Courier New", displayArea.getFont().getStyle(), displayArea.getFont().getSize()));
        displayArea.setForeground(new Color(-8212805));
        displayArea.setMargin(new Insets(0, 0, 0, 0));
        displayArea.setMinimumSize(new Dimension(700, 350));
        displayArea.setPreferredSize(new Dimension(700, 350));
        displayAreaScrollPane.setViewportView(displayArea);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
