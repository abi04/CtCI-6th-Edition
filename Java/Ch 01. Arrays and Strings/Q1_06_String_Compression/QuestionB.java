package Q1_06_String_Compression;

import CtCILibrary.AssortedMethods;

public class QuestionB {
  public static String compress(String str) {
    StringBuilder compressed = new StringBuilder();
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
      countConsecutive++;

      /* If next character is different than current, append this char to result.*/
      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressed.append(str.charAt(i));
        compressed.append(countConsecutive);
        countConsecutive = 0;
      }
    }
    return compressed.length() < str.length() ? compressed.toString() : str;
  }

  public static String myCompress(String str) {
    if (str.length() < 2) return str;
    StringBuilder stringBuilder = new StringBuilder();
    int countConsecutive = 0;

    for (int i = 0; i < str.length(); i++) {
      //
      countConsecutive++;

      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        stringBuilder.append(str.charAt(i)).append(countConsecutive);
        countConsecutive = 0;
      }
    }

    return stringBuilder.toString().length() < str.length() ? stringBuilder.toString() : str;
  }

  public static void main(String[] args) {
    String str = "aabccccaaa";
    System.out.println(str);
    System.out.println(compress(str));
    System.out.println(myCompress(str));

    boolean check = myCompress(str).equals(compress(str));
    AssortedMethods.checkSolution(check);
  }
}
