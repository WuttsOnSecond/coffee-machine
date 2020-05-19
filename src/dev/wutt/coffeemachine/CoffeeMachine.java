package dev.wutt.coffeemachine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeMachine {

    private int water;
    private int milk;
    private int coffee;
    private int cups;
    private int money;

    static Scanner scan = new Scanner(System.in);

    public CoffeeMachine(int water, int milk, int coffee, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cups = cups;
        this.money = money;
    }

    public void display() {

        StringBuilder sb = new StringBuilder();
        // gets system dependent new line
        String newLine = System.lineSeparator();

        System.out.println("The coffee machine has:");
        sb.append(water + " of water" + newLine);
        sb.append(milk + " of milk" + newLine);
        sb.append(coffee + " of coffee beans" + newLine);
        sb.append(cups + " of disposable cups" + newLine);
        sb.append(money + " of money" + newLine);

        System.out.println(sb.toString());
    }

    void query(String input) {

        // determines action and calls corresponding method
        switch (input) {
            case "buy":
                buy();
                break;
            case "take":
                take();
                break;
            case "fill":
                fill();
                break;
            case "remaining":
                display();
                break;
            case "exit":
                System.exit(0);
            default: System.out.println("Invalid input.  Please enter buy, fill, or take");
        }
    }

    // buy method checks for required quantities then subtracts used materials
    void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - back:");
        int action = 0;

        try {
            action = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.  Please enter an integer.");
        }

        switch (action) {
            case 1:
                if (water >= 250 && coffee >= 16 && cups > 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                    money += 4;
                    water -= 250;
                    coffee -= 16;
                    cups -= 1;
                }

                else if (water < 250)
                    System.out.println("Sorry, not enough water!");
                else if (coffee < 16)
                    System.out.println("Sorry, not enough coffee!");
                else if (cups < 1)
                    System.out.println("Sorry, not enough cups!");

                break;

            case 2:
                if (water >= 350 && milk >= 75 && coffee >= 20 && cups > 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                    money += 7;
                    water -= 350;
                    milk -= 75;
                    coffee -= 20;
                    cups -= 1;
                }

                else if (water < 350)
                    System.out.println("Sorry, not enough water!");
                else if (milk < 75)
                    System.out.println("Sorry, not enough milk!");
                else if (coffee < 20)
                    System.out.println("Sorry, not enough coffee!");
                else if (cups < 1)
                    System.out.println("Sorry, not enough cups!");

                break;

            case 3:
                if (water >= 200 && milk >= 100 && coffee >= 12 && cups > 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                    money += 6;
                    water -= 200;
                    milk -= 100;
                    coffee -= 12;
                    cups -= 1;
                }

                else if (water < 200)
                    System.out.println("Sorry, not enough water!");
                else if (milk < 100)
                    System.out.println("Sorry, not enough milk!");
                else if (coffee < 12)
                    System.out.println("Sorry, not enough coffee!");
                else if (cups < 1)
                    System.out.println("Sorry, not enough cups!");

                break;

            case 4:
                break;
        }
    }

    // fill method handles restocking of machine
    void fill() {

        try {
            System.out.println("Write how many ml of water do you want to add:");
            water += scan.nextInt();

            System.out.println("Write how many ml of milk do you want to add:");
            milk += scan.nextInt();

            System.out.println("Write how many grams of coffee beans do you want to add:");
            coffee += scan.nextInt();

            System.out.println("Write how many disposable cups of coffee do you want to add:");
            cups += scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.  Please enter an integer.");
        }

    }

    // take method dispenses and resets money
    void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static void main(String[] args) {
        boolean run = true;
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);

        while (run) {

            System.out.println("Write action (remaining, buy, fill, take, exit):");
            machine.query(scan.next());

        }

        scan.close();

    }
}
