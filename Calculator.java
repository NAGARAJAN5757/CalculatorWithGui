import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    //initializing all required components
    JFrame frame;
    JTextField textField;
    JTextField firstOperandField;
    JTextField operatorField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton;
    JButton dotButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    //setting font for the calculator
    Font calcFont = new Font("Helvetica", Font.BOLD, 24);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        //initialising JFrame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        frame.setTitle("Calculator");
        frame.setResizable(false);


        //setting title icon
        ImageIcon icon = new ImageIcon("calc-icon.png");
        frame.setIconImage(icon.getImage());

        //setting input field
        textField = new JTextField();
        textField.setBounds(50, 75, 300, 50);
        textField.setFont(calcFont);
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        firstOperandField = new JTextField();
        firstOperandField.setBounds(50, 20, 240, 50);
        firstOperandField.setFont(calcFont);
        firstOperandField.setEditable(false);


        operatorField = new JTextField();
        operatorField.setBounds(300, 20, 50, 50);
        operatorField.setFont(calcFont);
        operatorField.setEditable(false);
        operatorField.setHorizontalAlignment(SwingConstants.CENTER);

        //setting up buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        dotButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = dotButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 5; i++) {
            functionButtons[i].setBackground(Color.YELLOW);
        }

        equButton.setBackground(Color.GREEN);
        delButton.setBackground(Color.RED);
        clrButton.setBackground(Color.RED);
        negButton.setBackground(Color.BLUE);

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(calcFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(calcFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.PINK);
        }


        negButton.setBounds(50, 430, 90, 50);
        delButton.setBounds(150, 430, 90, 50);
        clrButton.setBounds(250, 430, 90, 50);

        panel = new JPanel();
        panel.setBounds(50, 150, 300, 250);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(dotButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(negButton);
        panel.add(delButton);
        panel.add(clrButton);

        //adding components to frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.add(firstOperandField);
        frame.add(operatorField);

        //making frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    //actions for user inputs
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                if (operatorField.getText().isEmpty() && !firstOperandField.getText().isEmpty())
                    firstOperandField.setText("");
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == dotButton) {
            if (textField.getText().equals(".")) return;
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            if (!firstOperandField.getText().isEmpty()) {
                num1 = Double.parseDouble(firstOperandField.getText());
                operator = '+';
                operatorField.setText(String.valueOf(operator));
            }
            if (textField.getText().isEmpty()) return;
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
            if (Math.ceil(num1) == num1) firstOperandField.setText(String.valueOf((int) num1));
            else firstOperandField.setText(String.valueOf(num1));
            operatorField.setText(String.valueOf(operator));
        }
        if (e.getSource() == subButton) {
            if (!firstOperandField.getText().isEmpty()) {
                num1 = Double.parseDouble(firstOperandField.getText());
                operator = '-';
                operatorField.setText(String.valueOf(operator));
            }
            if (textField.getText().isEmpty()) return;
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
            if (Math.ceil(num1) == num1) firstOperandField.setText(String.valueOf((int) num1));
            else firstOperandField.setText(String.valueOf(num1));
            operatorField.setText(String.valueOf(operator));
        }
        if (e.getSource() == mulButton) {
            if (!firstOperandField.getText().isEmpty()) {
                num1 = Double.parseDouble(firstOperandField.getText());
                operator = '*';
                operatorField.setText(String.valueOf(operator));
            }
            if (textField.getText().isEmpty()) return;
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
            if (Math.ceil(num1) == num1) firstOperandField.setText(String.valueOf((int) num1));
            else firstOperandField.setText(String.valueOf(num1));
            operatorField.setText(String.valueOf(operator));
        }

        if (e.getSource() == divButton) {
            if (!firstOperandField.getText().isEmpty()) {
                num1 = Double.parseDouble(firstOperandField.getText());
                operator = '/';
                operatorField.setText(String.valueOf(operator));
            }
            if (textField.getText().isEmpty()) return;
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
            if (Math.ceil(num1) == num1) firstOperandField.setText(String.valueOf((int) num1));
            else firstOperandField.setText(String.valueOf(num1));
            operatorField.setText(String.valueOf(operator));
        }
        if (e.getSource() == equButton) {
            if (operatorField.getText().isEmpty()) return;
            if (operatorField.getText().equals("/") && textField.getText().equals("0")) {
                textField.setText("");
                JOptionPane.showMessageDialog(frame,"Any number divided by zero is infinity","Alert",JOptionPane.WARNING_MESSAGE);

                return;
            }
            if (textField.getText().isEmpty() || textField.getText().equals(".")) return;
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            if (Math.ceil(result) == result) firstOperandField.setText(String.valueOf((int) result));
            else firstOperandField.setText(String.valueOf(result));
            textField.setText("");
            operatorField.setText("");
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            if (operatorField.getText().isEmpty()) firstOperandField.setText("");
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            if (textField.getText().isEmpty() && !firstOperandField.getText().isEmpty()) {
                double temp = -1 * Double.parseDouble(firstOperandField.getText());
                if (Math.ceil(temp) == temp) firstOperandField.setText(String.valueOf((int) temp));
                else firstOperandField.setText(String.valueOf(temp));
            }
            if (textField.getText().isEmpty()) return;
            double temp = -1 * Double.parseDouble(textField.getText());
            if (Math.ceil(temp) == temp) textField.setText(String.valueOf((int) temp));
            else textField.setText(String.valueOf(temp));
        }
    }
}