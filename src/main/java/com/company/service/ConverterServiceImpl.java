package com.company.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConverterServiceImpl implements ConverterService{

    @Override
    public String convert(String text, ArrayList<String[]> from, ArrayList<String[]> to) {

        StringBuilder convertedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            String currentCharStr;

            if ((text.charAt(i) == 'c' || text.charAt(i) == 'C') && i < text.length() - 1) {
                if (text.charAt(i + 1) == 'h') {
                    currentCharStr = (text.charAt(i) == 'c') ? "ch" : "Ch";
                    i++;
                } else {
                    currentCharStr = String.valueOf(text.charAt(i));
                }

            } else if ((text.charAt(i) == 'o' || text.charAt(i) == 'O') && i < text.length() - 1) {
                if (text.charAt(i + 1) == '\'') {
                    currentCharStr = (text.charAt(i) == 'o') ? "o'" : "O'";
                    i++;
                } else {
                    currentCharStr = String.valueOf(text.charAt(i));
                }

            } else if ((text.charAt(i) == 'g' || text.charAt(i) == 'G') && i < text.length() - 1) {
                if (text.charAt(i + 1) == '\'') {
                    currentCharStr = (text.charAt(i) == 'g') ? "g'" : "G'";
                    i++;
                } else {
                    currentCharStr = String.valueOf(text.charAt(i));
                }

            } else {
                currentCharStr = String.valueOf(text.charAt(i));
            }

            boolean isLower;
            int index;
            if (isLowerCase(currentCharStr)) {
                index = indexOf(from.get(1), currentCharStr);
                isLower = true;
            } else {
                index = indexOf(from.get(0), currentCharStr);
                isLower = false;
            }

            if (index != -1) {
                String convertedChar = (isLower) ? to.get(1)[index] : to.get(0)[index];

                switch (currentCharStr) {
                    case "s" -> {
                        if (i < text.length() - 1 && text.charAt(i + 1) == 'h') {
                            convertedChar = "ш";
                            i++;
                        }
                    }
                    case "S" -> {
                        if (i < text.length() - 1 && text.charAt(i + 1) == 'h') {
                            convertedChar = "Ш";
                            i++;
                        }
                    }
                }

                convertedText.append(convertedChar);
            } else {
                convertedText.append(currentCharStr);
            }
        }
        return convertedText.toString();
    }

    private boolean isLowerCase(String str) {
        return str.equals(str.toLowerCase());
    }

    private int indexOf(String[] array, String element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(element)) {
                return i;
            }
        }
        return -1;
    }
}
