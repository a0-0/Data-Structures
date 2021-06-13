package Linked_Lists;
/***
 *
 * created by: Ahmed ELsaid A.I.A
 *
 * 13.06.2021
 *
 *  the differance between ArrayList && Class && LinkedList
 *
 ***/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class demo1 {
    public static void main(String[] args) {
        LinkedList<String> countries = new LinkedList<String>();
        countries.add("Egypt");
        countries.add("Syria");
        countries.add("Sudan");
        countries.add("Russia");
        countries.add("German");
        countries.add("USA");
        countries.add("Tunisia");
        printLinkedList(countries);
        countries.add(2, "Yemen");
        printLinkedList(countries);
        countries.remove(5);
        printLinkedList(countries);
        addInOrder(countries, "vubai");
        printLinkedList(countries);

//        Collections.sort(countries, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Collator.getInstance().compare(o1, o2);
//            }
//        });
//        printLinkedList(countries);
//
//
    }

    private static void printLinkedList(LinkedList<String> link) {
        Iterator<String> i = link.iterator();
        while (i.hasNext()) {
            System.out.println("now visiting: " + i.next());
        }
        System.out.println("===============================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            System.out.println(comparison);
            if (comparison == 0) {
                System.out.println(newCity + "Is already included as destination");
                return false;
            } else if (comparison > 0) {
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                // move to new country
            }
        }
        stringListIterator.add(newCity);
        return true;
    }
}
