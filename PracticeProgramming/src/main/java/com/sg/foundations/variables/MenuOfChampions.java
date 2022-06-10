package com.sg.foundations.variables;

public class MenuOfChampions {
    public static void main(String[] args) {
        String item1 = "Sloppy Joes";
        double price1 = 9.95;

        String item2 = "Flapjacks & Mash";
        double price2 = 11.95;

        String item3 = "Bacon & Eggs";
        double price3 = 9.95;

        System.out.println(")(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)\n");
        System.out.println("\t\tWELCOME TO TONY'S DINER!");
        System.out.println("\t\tToday's menu is...");
        System.out.println("\n)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)(*)\n");
        System.out.printf("$ %.2f\t\t%s\n", price1, item1);
        System.out.printf("$ %.2f\t\t%s\n", price2, item2);
        System.out.printf("$ %.2f\t\t%s\n", price3, item3);
    }
}
