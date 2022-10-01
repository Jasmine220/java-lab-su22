/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changebasev4;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ChangeBase {
    public static String convertFrom2(String value, int choice) {
        //2 to 2
        if (choice == 1) {
            return value;
            //2 to 10
        } else if (choice == 2) {
            return from2_16To10(value, 2);
        } else {
            //2 to 16    
            return from2To16(value);
        }
    }

    public static String convertFrom10(String value, int choice) {
        //10 to 10
        if (choice == 2) {
            return value;
            //10 to 2
        } else if (choice == 1) {
            return from10To2_16(value, 2);
            //10 to 16
        } else {
            return from10To2_16(value, 16);
        }
    }

    public static String convertFrom16(String value, int choice) {
        //16 to 16
        if (choice == 3) {
            return value;
            //16 to 2    
        } else if (choice == 1) {
            return from16To2(value);
            //16 to 10    
        } else {
            return from2_16To10(value, 16);
        }
    }

    //convert from 2, 16 to 10
    public static String from2_16To10(String value, int base) {
        char arr[] = value.toCharArray();
        BigInteger bigSum = new BigInteger("0");//gán sum ban đầu = 0
        BigInteger baseInput = new BigInteger(Integer.toString(base));//chuyển baseInput thành String
                                                                      //-> BigInteger
        int indexPow = arr.length - 1;
        //chuyển indexPow thành String
        //-> BigInteger
        //loop use to access from first element to last element
        for (int i = 0; i < arr.length; i++) {
            int c = changeFromCharacter(arr[i]);
            BigInteger cBig = new BigInteger(Integer.toString(c));
            //bigSum = bigSum + cBig * (baseInput ^ indexPow);
            bigSum = bigSum.add(cBig.multiply(baseInput.pow(indexPow)));
            indexPow--;
        }
        String valueLast = bigSum.toString();
        return valueLast;
    }

    //convert from 10 to 2, 16
    public static String from10To2_16(String value, int base) {
        BigInteger valueBig = new BigInteger(value);
        BigInteger baseBig = new BigInteger(Integer.toString(base));
        ArrayList<String> list = new ArrayList<>();
        //loop until valueBig equal "0"
        while (valueBig.compareTo(new BigInteger("0")) != 0) {
            BigInteger remainderBig = valueBig.remainder(baseBig);//chia lấy dư valueBig cho baseBig
            String remainderBigString = remainderBig.toString();//chuyển remainderBig sang String
            list.add(changeFromString(remainderBigString));//chuyển remainderBigString sang dạng chuỗi Hex
            valueBig = valueBig.divide(baseBig);//valueBig = valueBig / baseBig
        }
        String valueLast = "";
        //loop use to access from last element to first element
        for (int i = list.size() - 1; i >= 0; i--) {
            valueLast = valueLast + list.get(i);
        }
        return valueLast;
    }

    //convert from 2 to 16
    public static String from2To16(String value) {
        //2 to 10
        String convertFrom2To10 = from2_16To10(value, 2);
        //10 to 16
        return from10To2_16(convertFrom2To10, 16);
    }

    //convert from 16 to 2
    public static String from16To2(String value) {
        //16 to 10
        String convertFrom16To10 = from2_16To10(value, 16);
        //10 to 2
        return from10To2_16(convertFrom16To10, 2);
    }

    public static int changeFromCharacter(char character) {
        switch (character) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;

        }
        return -1;
    }
    public static String changeFromString(String string) {
        switch (string) {
            case "0":
                return "0";
            case "1":
                return "1";
            case "2":
                return "2";
            case "3":
                return "3";
            case "4":
                return "4";
            case "5":
                return "5";
            case "6":
                return "6";
            case "7":
                return "7";
            case "8":
                return "8";
            case "9":
                return "9";
            case "10":
                return "A";
            case "11":
                return "B";
            case "12":
                return "C";
            case "13":
                return "D";
            case "14":
                return "E";
            case "15":
                return "F";

        }
        return null;
    }
}
