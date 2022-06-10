/*
1) WAP to calculate how many times particular word is getting repeated in a paragraph of your choice.
2) WAP to find number of vowels in a string.
 */

import java.util.Scanner;

import static java.lang.System.out;

public class Lab3 {
    public static String[] getWords(String txt) {
        return txt.split(" ");
    }

    public static int wordCount(String[] words, String target) {
        int count = 0;
        for (String w:words) {
            if (w.matches("\\w+[.?!,]")) {
                w = w.substring(0,w.length()-1);
            }
            if (w.equalsIgnoreCase(target)) {
                count++;
            }
        }
        return count;
    }

    public static int vowelCount(String[] words) {
        int count = 0;
        for (String w:words) {
            if (w.matches("\\w*[aeiouAEIOU]\\w*")) {
                char[] word = w.toCharArray();
                for (int i = 0; i < w.length(); i++) {
                    if (word[i]=='A'||word[i]=='E'||word[i]=='I'
                    ||word[i]=='O'||word[i]=='U'||word[i]=='a'
                    ||word[i]=='e'||word[i]=='i'||word[i]=='o'
                    ||word[i]=='u') {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int vowelCount(String word) {
        int count = 0;
        char[] w = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (w[i]=='A'||w[i]=='E'||w[i]=='I'
                    ||w[i]=='O'||w[i]=='U'||w[i]=='a'
                    ||w[i]=='e'||w[i]=='i'||w[i]=='o'
                    ||w[i]=='u') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        out.print("Enter text here: ");
        String usrTxt = in.nextLine();
        out.print("What word do you want to find? ");
        String target = in.nextLine();

        in.close();

        String[] words = getWords(usrTxt);
        out.println(wordCount(words, target));
        out.println(vowelCount(words));
        out.println(vowelCount("Error"));
    }
}
