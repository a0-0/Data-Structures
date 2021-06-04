package Linked_Lists;
/***
 *
 * created by: Ahmed ELsaid A.I.A
 *
 * 04.06.2021
 *
 *  the differance between ArrayList && Class && LinkedList
 *
 ***/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

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

    public static void printLinkedList(LinkedList<String> array) {
        Iterator<String> i = array.iterator();
        while (i.hasNext()) {
            System.out.println("the next place is: " + i.next());
        }
        System.out.println("===================================");
    }
}
