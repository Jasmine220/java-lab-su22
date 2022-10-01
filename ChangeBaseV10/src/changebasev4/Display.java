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
public class Display {

    public static void display(int inputBase, String value, int outputBase) {
        if (inputBase == 1) {
            System.out.print(value + "(BIN) = " + ChangeBase.convertFrom2(value, outputBase));
            displayOutBase(outputBase);
        }
        if (inputBase == 2) {
            System.out.print(value + "(DEC) = " + ChangeBase.convertFrom10(value, outputBase));
            displayOutBase(outputBase);
        }
        if (inputBase == 3) {
            System.out.print(value + "HEX" + ChangeBase.convertFrom16(value, outputBase));
            displayOutBase(outputBase);
        }
        
    }

    public static void displayOutBase(int outputBase) {
        if (outputBase == 1) {
            System.out.println("(BIN)");
        } else if (outputBase == 2) {
            System.out.println("(DEC)");
        } else {
            System.out.println("(HEX)");
        }
    }
}
