package Q1_03_URLify;

import CtCILibrary.AssortedMethods;

public class Question {
	// Assume string has sufficient free space at the end
	public static void replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, index, i = 0;
		for (i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		index = trueLength + spaceCount * 2;
		if (trueLength < str.length) str[trueLength] = '\0';
		for (i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}
	
	public static int findLastCharacter(char[] str) {
		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i] != ' ') {
				return i;
			}
		}
		return -1;
	}

	public static void myReplaceSpaces(char[] str,int truelength){
		int arrayIndex = str.length - 1;
		for (int i = truelength-1; i >= 0 ; i--) {
			if(str[i] == ' '){
				str[arrayIndex--] = '0';
				str[arrayIndex--] = '2';
				str[arrayIndex--] = '%';
			}
			else {
				str[arrayIndex--] = str[i];
			}
		}
	}

	public static void main(String[] args) {
		String str = "Mr John Smith    ";
		char[] arr = str.toCharArray();
		int trueLength = findLastCharacter(arr) + 1;
		replaceSpaces(arr, trueLength);
		System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
		char[] arr2 = str.toCharArray();
		myReplaceSpaces(arr2,trueLength);
		System.out.println("\"" + AssortedMethods.charArrayToString(arr2) + "\"");
		boolean check = AssortedMethods.charArrayToString(arr).equals(AssortedMethods.charArrayToString(arr2));
		AssortedMethods.checkSolution(check);
	}
}
