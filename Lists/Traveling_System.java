package LinkedList;

/**
 * created by: Ahmed El said
 * 10.07.2021
 **/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Traveling_System{
//    public static void main(String[] args) {
//        LinkedList<String> cities = new LinkedList<String>();
//        cities.add("Cairo");
//        cities.add("Alexandria");
//        cities.add("Kafr El Shaikh");
//        cities.add("Banha");
//        cities.add("Damyita");
//        cities.add("Aswan");
//        print_list(cities);
//        addInOrder(cities , "Alexandria");
//        print_list(cities);
////        cities.add(1,"Mansoura");
////        print_list(cities);
////        cities.remove(1);
////        print_list(cities);
////        for (int i = 0; i < cities.size(); i++) {
////            System.out.println("Visiting ---->  "+cities.get(i));
////        }
//    }
//    public static void print_list(LinkedList<String> list){
//        Iterator<String> i = list.iterator();
//        while(i.hasNext()){
//            System.out.println("Visiting ---->  " + i.next());
//        }
//        System.out.println("______________________________________________");
//    }
//    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
//        ListIterator<String> stringListIterator = linkedList.listIterator();
//
//        while(stringListIterator.hasNext()) {
//            int comparison = stringListIterator.next().compareTo(newCity);
//            if(comparison == 0) {
//                // equal, do not add
//                System.out.println(newCity + " is already included as a destination");
//                return false;
//            } else if(comparison > 0) {
//                // new City should appear before this one
//                // Brisbane  -> Adelaide
//                stringListIterator.previous();
//                stringListIterator.add(newCity);
//                return true;
//            } else if(comparison < 0) {
//                // move on next city
//            }
//        }
//        stringListIterator.add(newCity);
//        return true;
//    }

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);

        addInOrder(placesToVisit, "Alice Springs");
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);
        visit(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("=========================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                // equal, do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if (comparison > 0) {
                // new City should appear before this one
                // Brisbane  -> Adelaide
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                // move on next city
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the itenerary");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;

                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;

                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu options");
    }
}
