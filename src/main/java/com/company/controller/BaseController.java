//package com.company.controller;
//
//import com.company.form.RequestForm;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/test")
//public class BaseController {
//
//    private final String[] kirill = {"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О",
//            "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Ъ", "Ы", "Ь", "Э", "Ю", "Я", "Ў", "Қ", "Ғ", "Ҳ", "Щ",
//            "а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п",
//            "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "ъ", "ы", "ь", "э", "ю", "я", "ў", "қ", "ғ", "ҳ", "щ"};
//
//    private final String[] latin = {"A", "B", "V", "G", "D", "E", "Yo", "J", "Z", "I", "Y", "K", "L", "M",
//            "N", "O", "P", "R", "S", "T", "U", "F", "X", "S", "Ch", "Sh", "'", "Y", "'", "E", "Yu", "Ya", "O'", "Q", "G'", "H", "Sh",
//            "a", "b", "v", "g", "d", "e", "yo", "j", "z", "i", "y", "k", "l", "m", "n", "o",
//            "p", "r", "s", "t", "u", "f", "x", "s", "ch", "sh", "'", "y", "'", "e", "yu", "ya", "o'", "q", "g'", "h", "sh"};
//
//
//    @PostMapping("/text")
//    public ResponseEntity<String> convertWithText(@RequestBody RequestForm form) {
//        String[] fromAlphabet;
//        String[] toAlphabet;
//
//        if (form.getToLatin()) {
//            toAlphabet = latin;
//            fromAlphabet = kirill;
//        } else {
//            toAlphabet = kirill;
//            fromAlphabet = latin;
//        }
//        // Convert
//        String convertedText = convert(form.getText(), fromAlphabet, toAlphabet);
//
//        return ResponseEntity.ok().body(convertedText);
//    }
//
//    private String convert(String text, String[] fromAlphabet, String[] toAlphabet) {
//
//        StringBuilder convertedText = new StringBuilder();
//
//        for (int i = 0; i < text.length(); i++) {
//            String currentCharStr = "";
//            if (text.charAt(i) == 'c' || text.charAt(i) == 'C') {
//                if (text.charAt(i + 1) == 'h') {
//                    currentCharStr = (text.charAt(i) == 'c') ? "ch" : "Ch";
//                    i++;
//                }
//            } else {
//                currentCharStr = String.valueOf(text.charAt(i));
//            }
//
//            int index = indexOf(fromAlphabet, currentCharStr);
//
//            if (index != -1) {
//                String convertedChar = toAlphabet[index];
//
//                if (isLowerCase(currentCharStr)) {
//                    convertedChar = convertedChar.toLowerCase();
//                }
//
//                switch (currentCharStr) {
//                    case "s" -> {
//                        if (i < text.length() - 1 && text.charAt(i + 1) == 'h') {
//                            convertedChar = "ш";
//                            i++;
//                        }
//                    }
//                    case "S" -> {
//                        if (i < text.length() - 1 && text.charAt(i + 1) == 'h') {
//                            convertedChar = "Ш";
//                            i++;
//                        }
//                    }
//                }
//
//
//                convertedText.append(convertedChar);
//            } else {
//                convertedText.append(currentCharStr);
//            }
//        }
//        return convertedText.toString();
//    }
//
//    private boolean isLowerCase(String str) {
//        return str.equals(str.toLowerCase());
//    }
//
//    private int indexOf(String[] array, String element) {
//        for (int i = 0; i < array.length; i++) {
//            if (array[i].equalsIgnoreCase(element)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//}
//
//
////    @PostMapping("/file/{from}")
////    public ResponseEntity<String> convertWithFile(@PathVariable String from ,File file) {
////        try {
////
////            String text = readTextFromFile(file);
////
////            if (from == )
////            String convertedText = convert(text, kirill, latin, true);
////
////            // Write to file
////            String outputFile = "output.txt";
////            writeTextToFile(convertedText, outputFile);
////
////        } catch (IOException e) {
////            throw new RuntimeException(e.getMessage());
////        }
////
////        return null;
////
////    }
//
////
////    private String readTextFromFile(File file) throws IOException {
////        StringBuilder text = new StringBuilder();
////        BufferedReader reader = new BufferedReader(new FileReader(file));
////
////        String line;
////        while ((line = reader.readLine()) != null) {
////            text.append(line).append("\n");
////        }
////
////        reader.close();
////
////        return text.toString();
////    }
////
////    private void writeTextToFile(String text, String filePath) throws IOException {
////
////        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
////
////        writer.write(text);
////
////        writer.close();
////    }
