package com.zhokhov.interview.util;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class Console {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREY = "\u001B[37m";

    public static String red(String s) {
        return ANSI_RED + s + ANSI_RESET;
    }

    public static String green(String s) {
        return ANSI_GREEN + s + ANSI_RESET;
    }

    public static String yellow(String s) {
        return ANSI_YELLOW + s + ANSI_RESET;
    }

    public static String blue(String s) {
        return ANSI_BLUE + s + ANSI_RESET;
    }

    public static String purple(String s) {
        return ANSI_PURPLE + s + ANSI_RESET;
    }

    public static String cyan(String s) {
        return ANSI_CYAN + s + ANSI_RESET;
    }

    public static String grey(String s) {
        return ANSI_GREY + s + ANSI_RESET;
    }

    public static void printRed(String s) {
        System.out.print(red(s));
    }

    public static void printGreen(String s) {
        System.out.print(green(s));
    }

    public static void printYellow(String s) {
        System.out.print(yellow(s));
    }

    public static void printBlue(String s) {
        System.out.print(blue(s));
    }

    public static void printPurple(String s) {
        System.out.print(purple(s));
    }

    public static void printCyan(String s) {
        System.out.print(cyan(s));
    }

    public static void printGrey(String s) {
        System.out.print(grey(s));
    }

    public static void printlnRed(String s) {
        System.out.println(red(s));
    }

    public static void printlnGreen(String s) {
        System.out.println(green(s));
    }

    public static void printlnYellow(String s) {
        System.out.println(yellow(s));
    }

    public static void printlnBlue(String s) {
        System.out.println(blue(s));
    }

    public static void printlnPurple(String s) {
        System.out.println(purple(s));
    }

    public static void printlnCyan(String s) {
        System.out.println(cyan(s));
    }

    public static void printlnGrey(String s) {
        System.out.println(grey(s));
    }


}
