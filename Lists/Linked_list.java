package Linked_Lists;
/***
 *
 * created by: Ahmed ELsaid A.I.A
 *
 * 06.06.2021
 *
 *  the differance between ArrayList && Class && LinkedList
 *
 ***/

import java.util.*;

class customer {
    private String name;
    private double balance;

    public customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

public class Linked_list {
    public static void main(String[] args) {
        customer customer = new customer("Ahmed", 23.12);
        // the 2nd class effects in the first class
        customer anotherCustomer;
        anotherCustomer = customer;
        // it's actually update for the first class
        anotherCustomer.setBalance(12.2);
        System.out.println("Balance for customer " +
                customer.getName() + " is " + customer.getBalance());


        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(3);
        intList.add(4);
        printArrayList(intList);
        // adding a new index in  ArrayList
        intList.add(1, 2);
        printArrayList(intList);
// output
//        1: 1
//        2: 3
//        3: 4

//        1: 1
//        2: 2
//        3: 3
//        4: 4
    }

    // printing ArrayList
    public static void printArrayList(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println((i + 1) + ": " + array.get(i));
        }
    }
}

// second compare
class demo {
    public static void main(String[] args) {
        LinkedList<String> placeToVisit = new LinkedList<String>();
        addInOrder(placeToVisit, "Sydney");
        addInOrder(placeToVisit, "Brisbane");
        addInOrder(placeToVisit, "Perth");
        addInOrder(placeToVisit, "Adelaide");
        addInOrder(placeToVisit, "Canberra");
        addInOrder(placeToVisit, "Darwin");
        addInOrder(placeToVisit, "Egypt");
        printLinkedList(placeToVisit);
        addInOrder(placeToVisit, "USA");
        addInOrder(placeToVisit, "Samara");
        printLinkedList(placeToVisit);
        visit(placeToVisit);
        // add in order but more esaly
//                Collections.sort(countries, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Collator.getInstance().compare(o1, o2);
//            }
//        });
//        printLinkedList(countries);
//



//        placeToVisit.add("Sydney");
//        placeToVisit.add("Melbourne");
//        placeToVisit.add("Brisbane");
//        placeToVisit.add("Perth");
//        placeToVisit.add("Canberra");
//        placeToVisit.add("Adelaide");
//        placeToVisit.add("Darwin");
//        printLinkedList(placeToVisit);
//        placeToVisit.add(2,"Egypt");
//        printLinkedList(placeToVisit);
//        placeToVisit.remove(4);
//        printLinkedList(placeToVisit);
    }

    public static boolean addInOrder(LinkedList<String> array, String newCity) {
        ListIterator<String> stringListIterator = array.listIterator();
        while (stringListIterator.hasNext()) {
            int compirition = stringListIterator.next().compareTo(newCity);
            if (compirition == 0) {
                // equal , don't add
                System.out.println(newCity + " is already included as a destination.");
                return false;
            } else if (compirition > 0) {
                // new city should appear before this one.
                // Brisbane --> Adelaide
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (compirition < 0) {
                // move on next city
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();
        if (cities.isEmpty()) {
            System.out.println("No cities in itenerary.");
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        while (!quit) {
            int action = input.nextInt();
            switch (action) {
                case 0:
                    System.out.println("Holiday over");
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
                    } else System.out.println("Rechange the end of list");
                    break;
                case 2:
                    if (goingForward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward=false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("now visiting " + listIterator.previous());
                    } else System.out.println("we are in the start of the list.");
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions: \npress");
        System.out.println("0 - to quit.\n" +
                "1 - go to the next city.\n" +
                "2 - go to previous city.\n" +
                "3 - print menu options.");
    }

    public static void printLinkedList(LinkedList<String> array) {
        Iterator<String> i = array.iterator();
        while (i.hasNext()) {
            System.out.println("the next place is: " + i.next());
        }
        System.out.println("===================================");
    }
}
