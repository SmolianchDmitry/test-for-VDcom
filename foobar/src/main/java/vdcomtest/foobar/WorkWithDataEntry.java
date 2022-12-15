package vdcomtest.foobar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorkWithDataEntry {

    private static String getStringFromConsole(){
        String str = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter number more zero: ") ;
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static Integer getNumberGreaterZero(){
        int n = 0;
        while (n == 0) {
            String num = getStringFromConsole();
            try {
                n = Integer.parseInt(num);
                if (n < 1){
                    n = 0;
                    System.out.println("Incorrect data entry. The number must be greater than 0. Try again.");
                }
            } catch (NumberFormatException e) {
                n = 0;
                System.out.println("A number must be entered. Try again.");
            }
        }
        return n;
    }
}
