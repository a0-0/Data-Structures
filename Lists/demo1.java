package Linked_Lists;
/***
 *
 * created by: Ahmed ELsaid A.I.A
 *
 * 14.06.2021
 *
 *  the differance between ArrayList && Class && LinkedList
 *
 ***/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

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
        options(countries);

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

    private static void options(LinkedList Visit) {
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<String> cities = Visit.listIterator();
        if (Visit.isEmpty()) {
            System.out.println("No Cities in iterator");
            return;
        } else System.out.println("now visiting: " + cities.next());
        printmenu();
        while (!quit) {
            int cases = input.nextInt();
            input.nextLine();
            switch (cases) {
                case 0:
                    System.out.println("Holiday over");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (cities.hasNext()) {
                            cities.next();
                        }
                        forward = true;
                    }
                    if (cities.hasNext()) {

                        System.out.println("now visiting: " + cities.next());
                    } else System.out.println("Reach the end.");
                    forward = false;
                    break;
                case 2:
                    if (forward) {
                        if (cities.hasPrevious()) {
                            cities.previous();
                        }
                        forward = false;
                    }
                    if (cities.hasPrevious()) {
                        System.out.println("now visiting: " + cities.previous());
                    } else System.out.println("we are in the start");
                    forward = true;
                    break;
                case 3:
                    printmenu();
                    break;
            }

        }
    }

    private static void printmenu() {
        System.out.println("Available actions: \npress");
        System.out.println("0 - to quit.\n" +
                "1 - go to the next city.\n" +
                "2 - go to previous city.\n" +
                "3 - print menu options.");
    }
}
