package Q1_02_Check_Permutation;

import CtCILibrary.AssortedMethods;

import java.util.Arrays;

public class QuestionA {
    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public static boolean permutation(String s, String t) {
        return sort(s).equals(sort(t));
    }

    public static String mysort(String word) {
        char[] stringTocharArray = word.toCharArray();
        Arrays.sort(stringTocharArray);
        return new String(stringTocharArray);
    }

    public static boolean myPermutation(String word1, String word2) {
        return mysort(word1).equals(mysort(word2));
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
            boolean check = permutation(word1, word2) == myPermutation(word1, word2);
            AssortedMethods.checkSolution(check);

        }
    }
}
