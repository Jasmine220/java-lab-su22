/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changebasev4;

/**
 *
 * @author Admin
 */
public class Validate {

    public static String inputBin = "[01]+";
    public static String inputDec = "[0-9]+";
    public static String inputHex = "[0-9|A-F]+";
    
    public static boolean checkBinary(String value){
        if(value.matches(inputBin))
            return true;
        else
            return false;
    }
    public static boolean checkDecimal(String value){
        if(value.matches(inputDec))
            return true;
        else
            return false;
    }
    public static boolean checkHexadecimal(String value){
        if(value.matches(inputHex))
            return true;
        else
            return false;
    }

}
