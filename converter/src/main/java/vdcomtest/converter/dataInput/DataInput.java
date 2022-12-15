package vdcomtest.converter.dataInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataInput {
    public static List<String> inputStrings(){
        String str = "start";
        List<String> inputStrings = new ArrayList<>();
        while (!str.isEmpty()){
            str = getStringFromConsole();
            inputStrings.add(str);
        }
        inputStrings.remove(inputStrings.size() - 1);
        return inputStrings;
    }

    private static String getStringFromConsole(){
            String str = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
}
