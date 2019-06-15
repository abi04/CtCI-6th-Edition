package Q1_04_Palindrome_Permutation;

import CtCILibrary.AssortedMethods;

import java.util.HashSet;

public class QuestionA {
    public static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = Common.buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    public static boolean myIsPermutationOfPalindrome(String phrase) {
        HashSet<Character> charSet = new HashSet<>();

        for (Character c : phrase.toLowerCase().toCharArray()) {
            if (charSet.contains(c))
                charSet.remove(c);
            else if(c != ' ')
                charSet.add(c);
        }
        return charSet.size() <= 1;
    }

    public static void main(String[] args) {
        String pali = "Rats live on no evil star";
        System.out.println(isPermutationOfPalindrome(pali));

        boolean check = isPermutationOfPalindrome(pali) == myIsPermutationOfPalindrome(pali);
        AssortedMethods.checkSolution(check);
    }


}
