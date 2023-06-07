package com.company.controller;

import com.company.form.RequestForm;
import com.company.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/converter")
public class ConverterController {
    @Autowired
    private ConverterService service;

    private final String[] kirillUpper = {"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О",
            "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Ъ", "Ы", "Ь", "Э", "Ю", "Я", "Ў", "Қ", "Ғ", "Ҳ", "Щ"};


    private final String[] kirillLower = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п",
            "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "ъ", "ы", "ь", "э", "ю", "я", "ў", "қ", "ғ", "ҳ", "щ"};

    private final String[] latinUpper = {"A", "B", "V", "G", "D", "E", "Yo", "J", "Z", "I", "Y", "K", "L", "M",
            "N", "O", "P", "R", "S", "T", "U", "F", "X", "S", "Ch", "Sh", "'", "Y", "'", "E", "Yu", "Ya", "O'", "Q", "G'", "H", "Sh"};


    private final String[] latinLower = {"a", "b", "v", "g", "d", "e", "yo", "j", "z", "i", "y", "k", "l", "m", "n", "o",
            "p", "r", "s", "t", "u", "f", "x", "s", "ch", "sh", "'", "y", "'", "e", "yu", "ya", "o'", "q", "g'", "h", "sh"};


    @PostMapping("/text")
    public ResponseEntity<String> convertWithText(@RequestBody RequestForm form) {
        ArrayList<String[]> from = new ArrayList<>();
        ArrayList<String[]> to = new ArrayList<>();

        if (form.getToLatin()) {
            from.add(kirillUpper);
            from.add(kirillLower);
            to.add(latinUpper);
            to.add(latinLower);
        } else {
            from.add(latinUpper);
            from.add(latinLower);
            to.add(kirillUpper);
            to.add(kirillLower);
        }

        return ResponseEntity.ok().body(service.convert(form.getText(), from, to));
    }
}
