import java.util.Scanner;

public class Q3 {
    public static final int FORMAT_0_OPTION = 0;
    public static final String FORMAT_1_2 = "05";
    public static final int FORMAT_1_SIZE = 10;
    public static final int FORMAT_1_OPTION = 1;
    public static final int FORMAT_2_SIZE = 11;
    public static final int FORMAT_2_OPTION = 2;
    public static final String FORMAT_3 = "9725";
    public static final int FORMAT_3_SIZE = 12;
    public static final int FORMAT_3_OPTION = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your phone number -  only numbers or '-' :  ");
        String userInputPhoneNumber = scanner.nextLine();
        int witchFormat = witchFormat(userInputPhoneNumber);
        String normalPhoneNumber = changePhoneNumber(witchFormat, userInputPhoneNumber);
        System.out.println(normalPhoneNumber);
    }
    public static boolean isInFormatValues (String phoneNumber){
        String possibleValues = "1234567890-";
        boolean isInFormatValues = false;
        int count = 0;
            for (int i = 0; i < phoneNumber.length(); i++) {
                for (int j = 0; j < possibleValues.length(); j++) {
                    if (phoneNumber.charAt(i) == possibleValues.charAt(j)) {
                        count++;
                        break;
                    }
                }
            }
        if (count == phoneNumber.length()){
            isInFormatValues=true;
        }
        return isInFormatValues;
    }

    public static int witchFormat(String phoneNumber) {
        int format=FORMAT_0_OPTION;
        int isInsideChar = isInside(phoneNumber, "-");
        boolean isInFormatValue = isInFormatValues(phoneNumber);
        if (isInFormatValue==true) {
            if (objectEquals(subString(0, 1, phoneNumber), FORMAT_1_2)) {
                if (isInsideChar == 0 && phoneNumber.length() == FORMAT_1_SIZE) {
                    format = FORMAT_1_OPTION;
                } else if (phoneNumber.length() == FORMAT_2_SIZE && phoneNumber.charAt(3) == '-' && isInsideChar == 1) {
                    format = FORMAT_2_OPTION;
                }
            }
            if (isInsideChar == 0) {
                if (objectEquals(subString(0, 3, phoneNumber), FORMAT_3) && phoneNumber.length() == FORMAT_3_SIZE) {
                    format = FORMAT_3_OPTION;
                }
            }
        }
        return format;
    }


    public static String changePhoneNumber(int format, String phoneNumber) {
        String normalPhoneNumber = "";
        switch (format) {
            case FORMAT_0_OPTION:
                normalPhoneNumber = "";
                break;
            case FORMAT_1_OPTION:
                normalPhoneNumber = subString(0, 2, phoneNumber) + "-" + subString(3, phoneNumber.length() - 1, phoneNumber);
                break;
            case FORMAT_2_OPTION:
                normalPhoneNumber = phoneNumber;
                break;
            case FORMAT_3_OPTION:
                normalPhoneNumber = '0' + subString(3, 4, phoneNumber) + '-' + subString(5, phoneNumber.length() - 1, phoneNumber);
                break;
        }
        return normalPhoneNumber;
    }

    public static String subString(int startIndex, int finishIndex, String userInputPhoneNumber) {
        String newString = "";
        for (int i = startIndex; i <= finishIndex; i++) {
            newString = newString + userInputPhoneNumber.charAt(i);
        }
        return newString;
    }

    public static int isInside(String phoneNum, String wantedChar) {
        int isInsideCount = 0;
        for (int i = 0; i < phoneNum.length(); i++) {
            if (phoneNum.charAt(i) == wantedChar.charAt(0)) {
                isInsideCount++;
            }
        }
        return isInsideCount;
    }

    static public boolean objectEquals(String s1, String s2) {
        boolean isEqual = false;
        if (s1.length() != s2.length()) {
            isEqual = false;
        } else {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    isEqual = false;
                    break;
                } else {
                    isEqual = true;
                }
            }
        }
        return isEqual;
    }
}

