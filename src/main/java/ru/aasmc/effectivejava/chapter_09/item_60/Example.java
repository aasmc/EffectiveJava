package ru.aasmc.effectivejava.chapter_09.item_60;

import java.math.BigDecimal;
import java.net.PortUnreachableException;

public class Example {
    public static void flawedExample() {
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought");
        System.out.println("Change: $" + funds);
    }

    public static void correctExample() {
        final BigDecimal TEN_CENTS = new BigDecimal(".10");

        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS;
             funds.compareTo(price) >= 0;
             price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought");
        System.out.println("Change: $" + funds);
    }

    public static void betterExample() {
        int itemsBought = 0;
        int funds = 100; // in cents
        for (int price = 10; funds >= price; price += 10) {
            funds -= price;
            ++itemsBought;
        }
        System.out.println(itemsBought + " items bought");
        System.out.println("Change: $" + funds);
    }

    public static void main(String[] args) {
        System.out.println("Flawed:");
        flawedExample();
        System.out.println("Correct:");
        correctExample();
        System.out.println("Better:");
        betterExample();
    }
}