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
public class ChangeBaseV4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Choose the base number input 
        int inputBase = Input.menu("Enter base number input: ");
        //Choose the base number out
        int outputBase = Input.menu("Convert to ");
        //Enter the input value
        String value = Input.inputValue(inputBase);
        //Print output value
        Display.display(inputBase, value, outputBase);
    }
    
    

}
