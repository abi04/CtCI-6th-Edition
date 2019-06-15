package Q1_02_Check_Permutation;

import CtCILibrary.AssortedMethods;

import java.util.HashMap;

public class QuestionB {

    interface MyPermutation {
        boolean permutation(String s, String t);
    }

    static class SolutionA implements MyPermutation {

        @Override
        public boolean permutation(String s, String t) {
            if (s.length() != t.length()) return false;

            HashMap<Character, Integer> charCountSet = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                charCountSet.put(currentChar, charCountSet.getOrDefault(currentChar, 0) + 1);
            }

            for (int i = 0; i < t.length(); i++) {
                char currentChar = t.charAt(i);

                if (!charCountSet.containsKey(currentChar)) return false;

                charCountSet.put(currentChar, charCountSet.get(currentChar) - 1);

                if (charCountSet.get(currentChar) == 0)
                    charCountSet.remove(currentChar);
            }

            return charCountSet.size() == 0;
        }
    }

    static class SolutionB implements MyPermutation {

        @Override
        public boolean permutation(String s, String t) {
            if (s.length() != t.length()) return false;

            int[] charArray = new int[128];

            for (int i = 0; i < s.length(); i++) {
                charArray[s.charAt(i)]++;
            }

            for (int i = 0; i < t.length(); i++) {
                charArray[t.charAt(i)]--;
                if (charArray[t.charAt(i)] < 0) return false;
            }
            return true;
        }

    }

    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) return false; // Permutations must be same length

        int[] letters = new int[128]; // Assumption: ASCII
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) {
                return false;
            }
        }

        return true; // letters array has no negative values, and therefore no positive values either
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);

            SolutionA solutionA = new SolutionA();
            SolutionB solutionB = new SolutionB();
            boolean A = permutation(word1, word2) == solutionA.permutation(word1, word2);
            boolean B = permutation(word1, word2) == solutionB.permutation(word1, word2);
            AssortedMethods.checkSolution(A);
            AssortedMethods.checkSolution(B);
        }
    }
}
