
/**
 * @author: vamsi krishna allu
 * student number : A00259393
 * MAPD - JAV-1001 - App Development for Android
 */
import java.util.Scanner;

public class ArrayTools {

    /**
     * This method is used to encrypt the given value based on the shift value
     * 
     * @param valueToBeEncrypted
     * @param shiftValue
     * @return
     */
    private static String encrypt(String valueToBeEncrypted, int shiftValue) {
        String valueAfterEncryption = "";
        for (int index = 0; index < valueToBeEncrypted.length(); index++) {
            char characterAfterShift = (char) (valueToBeEncrypted.charAt(index) + shiftValue);
            valueAfterEncryption = valueAfterEncryption + characterAfterShift;
        }
        return valueAfterEncryption;
    }

    /**
     * This is used to calculate average of a given array
     * Sum of the array elements is calculated and it is
     * divided by length of array to get the average
     * 
     * @param inputArray
     * @return double
     */
    private static double arrayAvg(int[] inputArray) {
        int arrayLength = getArrayLength(inputArray);
        double sumOfData = 0;
        for (int currentValue : inputArray) {
            sumOfData = sumOfData + currentValue;
        }
        // Ternary condition to verify if input array size is zero to avoid exception
        // due to divide by zero
        return sumOfData == 0 ? 0 : sumOfData / arrayLength;
    }

    /**
     * This is used to verify if array contains given search element
     * Compare the value of each element in array with search value
     * if any match is found return true
     * 
     * @param inputArray
     * @param searchValue
     * @return boolean
     */
    private static boolean arrayContains(int[] inputArray, int searchValue) {
        for (int currentValue : inputArray) {
            if (currentValue == searchValue) {
                return true;
            }
        }
        return false;
    }

    /**
     * This is used to reverse given array
     * swap the first half with last half to reverse array
     * 
     * @param inputArray
     * @return int array
     */
    private static int[] reverse(int[] inputArray) {
        int arrayLength = getArrayLength(inputArray);
        for (int index = 0; index < arrayLength / 2; index++) {
            int temporaryValue = inputArray[index];
            inputArray[index] = inputArray[arrayLength - index - 1];
            inputArray[arrayLength - index - 1] = temporaryValue;
        }
        return inputArray;
    }

    /**
     * This is used to return length of an array
     * 
     * @param inputArray
     * @return int
     */
    private static int getArrayLength(int[] inputArray) {
        int arrayLength = 0;
        for (int index : inputArray) {
            arrayLength++;
        }
        return arrayLength;
    }

    /**
     * This method converts given input array to string with space between each
     * element of array
     * 
     * @param inputArray
     * @return
     */
    private static String getArrayAsString(int[] inputArray) {
        String arrayAsString = "";
        for (int currentValue : inputArray) {
            arrayAsString = arrayAsString + " " + currentValue;
        }
        return arrayAsString;
    }

    /**
     * In ACII characters elements from 127 to 159 are not printable
     * so this method replaces all characters that are not printable to ?
     * 
     * @param valueAfterEncryption
     * @return
     */
    private static String getValueWithPrintableCharacters(String valueAfterEncryption) {
        String valueToBePrinted = "";
        for (int index = 0; index < valueAfterEncryption.length(); index++) {
            if(valueAfterEncryption.charAt(index) >=127 && valueAfterEncryption.charAt(index) <=159){
                valueToBePrinted = valueToBePrinted + "?";
            }else{
                valueToBePrinted = valueToBePrinted + valueAfterEncryption.charAt(index);
            }
        }
        return valueToBePrinted;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string to encrypt. ");
            String valueToBeEncrypted = scanner.next();
            System.out.print("Enter a value to encrypt with. ");
            int shiftValue = scanner.nextInt();
            String valueAfterEncryption = encrypt(valueToBeEncrypted, shiftValue);
            String valueWithPrintableCharacters = getValueWithPrintableCharacters(valueAfterEncryption);
            System.out.println("The encrypted string is " + valueWithPrintableCharacters);
            System.out.println("Decrypting " + valueWithPrintableCharacters + " with -" + shiftValue + "...");
            // we dont need to check for value with printable characters while decrypting as user can't enter the values that are not printable
            System.out.println(encrypt(valueAfterEncryption, (-1 * shiftValue)));

            int[] inputArray = { 44, 78, 45, 77, 44, 98, 67, 68, 91, 54 };
            System.out.println("Testing methods with [ 44 78 45 77 44 98 67 68 91 54 ]");
            System.out.println("The average is " + arrayAvg(inputArray));

            System.out.print("Enter a value to search for. ");
            int searchValue = scanner.nextInt();
            if (arrayContains(inputArray, searchValue)) {
                System.out.println("The array contains " + searchValue);
            } else {
                System.out.println("The array does not contain " + searchValue);
            }

            int[] reversedArray = reverse(inputArray);
            // reversed array is converted to string to show it properly in output
            String reversedArrayAsString = getArrayAsString(reversedArray);
            System.out.println("The array reversed is [" + reversedArrayAsString + " ]");
        }
    }
}
