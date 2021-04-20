package ru.gb.gui;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CalcActionListener implements ActionListener {
    private final JTextField inputField;

    public CalcActionListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = inputField.getText();
        String[] splittedValues;
        double sum = 0.0;

        /*ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");*/

        Parser myParser = new Parser();
        try {
            sum = myParser.evaluate(text.toString());
        } catch (ParserException parserException) {
            parserException.printStackTrace();
        }

        /*try {
            sum = (int) scriptEngine.eval(text.toString());
        } catch (ScriptException scriptException) {
            scriptException.printStackTrace();
        }*/

        /*if (text.contains("+")) {
            splittedValues = text.split("\\+");
            sum = Integer.parseInt(splittedValues[0]) + Integer.parseInt(splittedValues[1]);
        } else if (text.contains("-")) {
            splittedValues = text.split("-");
            sum = Integer.parseInt(splittedValues[0]) - Integer.parseInt(splittedValues[1]);
        }   else if (text.contains("*")) {
            splittedValues = text.split("\\*");
            sum = Integer.parseInt(splittedValues[0]) * Integer.parseInt(splittedValues[1]);
        } else if (text.contains("/")) {
            splittedValues = text.split("/");
            sum = Integer.parseInt(splittedValues[0]) / Integer.parseInt(splittedValues[1]);
        } else {
            sum = Integer.parseInt(text.toString());
        }*/

        if ("sqrt".equals(e.getActionCommand())){
            sum = Math.sqrt(sum);
        }

        DecimalFormat f = null;
        if (sum % 1 == 0) {
            DecimalFormatSymbols s = new DecimalFormatSymbols();
            s.setDecimalSeparator('.');
            f = new DecimalFormat("#,###", s);
        }

        inputField.setText(String.valueOf((sum % 1 == 0 ? f.format(sum) : sum)));
    }
}
