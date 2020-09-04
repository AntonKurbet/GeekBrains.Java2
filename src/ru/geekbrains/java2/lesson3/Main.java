package ru.geekbrains.java2.lesson3;

import java.util.*;


public class Main {
//    1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//    Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).

    private static HashSet<String> getUnique(String[] words) {
        HashSet<String> result = new HashSet<>();
        Collections.addAll(result, words);
        return result;
    }

    //    Посчитать сколько раз встречается каждое слово.
//    private static int countOccurs(LinkedList<String> words, String s) {
//        int index = words.indexOf(s);
//        if (index == -1) return 0;
//        if (index == words.size() - 1) return 1;
//        int result = 0;
//        while (words.listIterator(index++).next().equals(s)) result++;
//        return result;
//    }

//    private static int countOccurs(ArrayList<String> words, String s) {
//        return words.lastIndexOf(s) - words.indexOf(s) + 1;
//    }

    public static void main(String[] args) {
        String text = "Two reference types are the same compile-time type if they have the same binary name " +
                "When two reference types are the same, they are sometimes said to be the same class or the same " +
                "interface.";

        String[] words = text.toLowerCase().replace(".","").replace(",","").split(" ");
        System.out.println(Arrays.toString(words));
        System.out.printf("There are %d words\n", words.length);

        HashSet<String> uniqWord = getUnique(words);
        System.out.println(uniqWord);
        System.out.printf("%d words are unique\n",uniqWord.size());


        //ArrayList<String> sortedWords = new ArrayList<>(Arrays.asList(words));
        //LinkedList<String> sortedWords = new LinkedList<>(Arrays.asList(words));
//        int totalWords = 0;
//        sortedWords.sort(String.CASE_INSENSITIVE_ORDER);
//        for (String s : uniqWord) {
//            int c = countOccurs(sortedWords,s);
//            System.out.printf("the word '%s' occurs %d times\n",s,c);
//            totalWords += c;
//        }
//        System.out.printf("Total: %d\n", totalWords);

        HashMap<String,Integer> wordsMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int n = wordsMap.getOrDefault(words[i],0);
            wordsMap.put(words[i],++n);
        }
        System.out.println(wordsMap);

        String[] names = {"Ivanov","Petrov","Vasiliev"};
        PhoneBook myPhones = new PhoneBook();
        myPhones.add(names[0],"+79101234567");
        myPhones.add(names[0],"+79101234578");
        myPhones.add(names[1],"+79101234590");
        myPhones.add(names[2],"+79101235678");
        myPhones.add(names[2],"+79101235679");
        myPhones.add(names[2],"+79101235680");

        for (int i = 0; i < names.length; i++) {
            System.out.printf("%s phone(s) is %s\n",names[i],myPhones.get(names[i]));
        }

        System.out.println("Kurbet phone is " + myPhones.get("Kurbet"));

        System.out.println("+79101234567 is " + myPhones.getName("+79101234567") + " phone");
    }
}
