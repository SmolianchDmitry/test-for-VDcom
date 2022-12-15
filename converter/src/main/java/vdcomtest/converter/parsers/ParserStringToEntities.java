package vdcomtest.converter.parsers;

import vdcomtest.converter.entities.Entity;

public class ParserStringToEntities {
    public static Entity[] getEntities(String str){
        Entity[] result = new Entity[2];
        String[] arrayStr = str.split(" ");
        result[0] = new Entity(arrayStr[1], Double.parseDouble(arrayStr[0]));
        if (arrayStr[3].equals("?")) {
            result[1] = new Entity(arrayStr[4], null);
        } else {
            result[1] = new Entity(arrayStr[4], Double.parseDouble(arrayStr[3]));
        }
        return result;
    }
}
