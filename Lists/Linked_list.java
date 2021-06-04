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
        intList.add(1, 2);
        printArrayList(intList);
    }

    public static void printArrayList(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println((i + 1) + ": " + array.get(i));
        }
    }
}
