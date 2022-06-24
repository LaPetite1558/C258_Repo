package com.sg.classroster.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    private final Scanner in = new Scanner(System.in);

    public UserIOConsoleImpl() {
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        return in.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        String input = "";
        int n = 0;
        while (input.isEmpty() || input.matches("\\D+")) {
            try {
                System.out.print(prompt + " ");
                input = in.nextLine();
                n = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                print("You did not enter an integer.");
            }
        } // loop until user inputs integer
        return n;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        String input = "";
        int n = min;
        do {
            try {
                System.out.print(prompt + " ");
                input = in.nextLine();
                n = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                print("You did not enter an integer.");
            } finally {
                if (n > max || n < min) {
                    print(n + " is not between "
                            + min + " and " + max);
                }
            }
        } while (input.isEmpty() ||
                input.matches("\\D+") ||
                (n > max || n < min)); // loop until user inputs an integer between min and max
        return n;
    }

    @Override
    public double readDouble(String prompt) {
        String input = "";
        double n = 0;
        while (input.isEmpty() || input.matches("[A-Za-z]+")) {
            try {
                System.out.print(prompt + " ");
                input = in.nextLine();
                n = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                print("You did not enter a double.");
            }
        } // loop until user inputs double
        return n;
    } // not tested yet

    @Override
    public double readDouble(String prompt, double min, double max) {
        String input = "";
        double n = min;
        do {
            try {
                System.out.print(prompt + " ");
                input = in.nextLine();
                n = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                print("You did not enter a double.");
            } finally {
                if (n > max || n < min) {
                    print(n + " is not between "
                            + min + " and " + max);
                }
            }
        } while (input.isEmpty() ||
                input.matches("[A-Za-z]+") ||
                (n > max || n < min)); // loop until user inputs a double between min and max
        return n;
    } // not tested yet

    @Override
    public float readFloat(String prompt) {
        String input = "";
        float n = 0;
        while (input.isEmpty() || input.matches("[A-Za-z]+")) {
            try {
                System.out.print(prompt + " ");
                input = in.nextLine();
                n = Float.parseFloat(input);
            } catch (NumberFormatException e) {
                print("You did not enter a float.");
            }
        } // loop until user inputs float
        return n;
    } // not tested yet

    @Override
    public float readFloat(String prompt, float min, float max) {
        String input = "";
        float n = min;
        do {
            try {
                System.out.print(prompt + " ");
                input = in.nextLine();
                n = Float.parseFloat(input);
            } catch (NumberFormatException e) {
                print("You did not enter a float.");
            } finally {
                if (n > max || n < min) {
                    print(n + " is not between "
                            + min + " and " + max);
                }
            }
        } while (input.isEmpty() ||
                input.matches("[A-Za-z]+") ||
                (n > max || n < min)); // loop until user inputs a float between min and max
        return n;
    } // not tested yet

    @Override
    public long readLong(String prompt) {
        String input = "";
        long n = 0;
        while (input.isEmpty() || input.matches("\\D+")) {
            try {
                System.out.print(prompt + " ");
                input = in.nextLine();
                n = Long.parseLong(input);
            } catch (NumberFormatException e) {
                print("You did not enter a long.");
            }
        } // loop until user inputs long
        return n;
    } // not tested yet

    @Override
    public long readLong(String prompt, long min, long max) {
        String input = "";
        long n = min;
        do {
            try {
                System.out.print(prompt + " ");
                input = in.nextLine();
                n = Long.parseLong(input);
            } catch (NumberFormatException e) {
                print("You did not enter a long.");
            } finally {
                if (n > max || n < min) {
                    print(n + " is not between "
                            + min + " and " + max);
                }
            }
        } while (input.isEmpty() ||
                input.matches("\\D+") ||
                (n > max || n < min)); // loop until user inputs a float between min and max
        return n;
    } // not tested yet
}
