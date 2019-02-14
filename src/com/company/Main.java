package com.company;

import java.io.*;
import java.util.*;
import java.text.*;

class comp implements Comparator<bankAccount>
{
    public int compare(bankAccount b1, bankAccount b2)
    {
        return (b1.balance < b2.balance) ? 1 : -1;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        NumberFormat fmt = NumberFormat.getNumberInstance();
        fmt.setMinimumFractionDigits(2);
        fmt.setMaximumFractionDigits(2);
        String name;
        ArrayList aryLst = new ArrayList();
        do {
            Scanner kbReader = new Scanner(System.in);
            System.out
                    .print("Please enter the name to whom the account belongs. (\"Exit\" to abort) ");
            name = kbReader.nextLine();
            if (!name.equalsIgnoreCase("EXIT")) {
                System.out.print("Please enter the amount of the deposit. ");
                double amount = kbReader.nextDouble();
                System.out.println(" "); // gives an eye pleasing blank line
                // between accounts
                bankAccount theAccount = new bankAccount(name, amount);
                aryLst.add(theAccount);
            }
        } while (!name.equalsIgnoreCase("EXIT"));

        // Search aryLst and print out the name and amount of the largest bank
        // account
        /*bankAccount ba = (bankAccount) iter.previous();
        ListIterator iter = aryList.listIterator();
        double maxBalance = ba.balance; // set last account as the winner so far
        String maxName = ba.name;
        while (iter.hasPrevious()) {
            ba = (bankAccount) iter.previous();
            if (ba.name.compareTo(maxName) < 0) {
                // We have a new winner, chicken dinner
                maxBalance = ba.balance;
                maxName = ba.name;
            }
        }*/

        Collections.sort(aryLst, new comp());

        bankAccount highest = (bankAccount)aryLst.get(0);

        /*System.out.println(" ");
        System.out.println("The account with the largest balance belongs to "
                + maxName + ".");
        System.out.println("The amount is $" + fmt.format(maxBalance) + ".");*/

        System.out.println(" ");
        System.out.println("The account with the largest balance belongs to "
                + highest.name + ".");
        System.out.println("The amount is $" + fmt.format(highest.balance) + ".");

    }
}
