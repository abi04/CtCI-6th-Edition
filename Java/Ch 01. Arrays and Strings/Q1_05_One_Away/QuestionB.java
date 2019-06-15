package Q1_05_One_Away;

import CtCILibrary.AssortedMethods;

public class QuestionB {
    public static boolean oneEditAway(String first, String second) {
        /* Length checks. */
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        /* Get shorter and longer string.*/
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                /* Ensure that this is the first difference found.*/
                if (foundDifference) return false;
                foundDifference = true;
                if (s1.length() == s2.length()) { // On replace, move shorter pointer
                    index1++;
                }
            } else {
                index1++; // If matching, move shorter pointer
            }
            index2++; // Always move pointer for longer string
        }
        return true;
    }

    public static boolean myOneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) return false;

        String largerString = first.length() > second.length() ? first : second;
        String smallerString = first.length() < second.length() ? first : second;

        int largerIndex = 0;
        int smallerIndex = 0;

        boolean hasOneEditOccured = false;

        while (largerIndex < largerString.length() && smallerIndex < smallerString.length()) {

            char currentCharOfLargerString = largerString.charAt(largerIndex);
            char currentCharOfSmallerString = smallerString.charAt(smallerIndex);

            if (currentCharOfLargerString != currentCharOfSmallerString) {
                if (hasOneEditOccured)
                    return false;

                hasOneEditOccured = true;

                if (largerString.length() == smallerString.length()) {
                    smallerIndex++;
                }
            } else
                smallerIndex++;

            largerIndex++;
        }

        return true;

    }

    public static void main(String[] args) {
        String a = "palee";
        String b = "pale";
        boolean isOneEdit1 = oneEditAway(a, b);
        System.out.println(a + ", " + b + ": " + isOneEdit1);
        boolean check = isOneEdit1 == myOneEditAway(a, b);
        AssortedMethods.checkSolution(check);


        String c = "pale";
        String d = "pkle";
        boolean isOneEdit2 = oneEditAway(c, d);
        System.out.println(c + ", " + d + ": " + isOneEdit2);
        boolean secondCheck = isOneEdit2 == myOneEditAway(c, d);
        AssortedMethods.checkSolution(secondCheck);
    }

}
