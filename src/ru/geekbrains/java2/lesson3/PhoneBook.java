package ru.geekbrains.java2.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//    2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
//    В этот телефонный справочник с помощью метода add() можно добавлять записи.
//    С помощью метода get() искать номер телефона по фамилии.
//    Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
//    тогда при запросе такой фамилии должны выводиться все телефоны.

public class PhoneBook {
    private HashMap<String,ArrayList<String>> book = new HashMap<>();

    public void add(String personName, String phoneNumber) {
        ArrayList<String> list = book.get(personName);
        if (list == null) list = new ArrayList<>();
        list.add(phoneNumber);
        book.put(personName,list);
    }

    public ArrayList<String> get (String personName) {
        ArrayList<String> phones = book.get(personName);
        if (phones == null) phones = new ArrayList<>();
        return phones;
    }
}
