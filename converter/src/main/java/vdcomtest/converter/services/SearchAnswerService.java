package vdcomtest.converter.services;

import vdcomtest.converter.entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static vdcomtest.converter.parsers.ParserStringToEntities.getEntities;

public class SearchAnswerService {
    public static ArrayList<String> getAnswer(HashMap<String, List<Entity>> mapDataEntry, List<String> questions){
        ArrayList<String> answers = new ArrayList<>();
        for (String question : questions){
            Entity[] searchParam = getEntities(question);
            answers.add(searchAnswer(mapDataEntry, searchParam[0], searchParam[1]));
        }
        return answers;
    }

    private static String searchAnswer(HashMap<String, List<Entity>> mapDataEntry,
                                       Entity searchParam1,
                                       Entity searchParam2){
        String result;
        Double answer;
        answer = getConversionFactor(mapDataEntry, searchParam1, searchParam2);
        if(answer == null){
            result =  "Conversion not possible.";
        } else {
            searchParam2.setConversionFactor(answer);
            result = searchParam1 + " = " + searchParam2;
        }
        return result;

    }

    private static Double getConversionFactor(HashMap<String, List<Entity>> mapDataEntry,
                                              Entity searchParam1,
                                              Entity searchParam2){
        Double conversionFactor = searchParam1.getConversionFactor();
        if(mapDataEntry.containsKey(searchParam1.getName())){
            List<Entity> entityList = mapDataEntry.get(searchParam1.getName());
            for (Entity entity : entityList){
                if(mapDataEntry.containsKey(entity.getName())){
                    if(entity.getName().equals(searchParam2.getName())){
                        searchParam2.setConversionFactor(entity.getConversionFactor());
                        return conversionFactor * searchParam2.getConversionFactor();
                    }else {
                        mapDataEntry.remove(searchParam1.getName());
                        return getConversionFactor(mapDataEntry, entity, searchParam2) == null ?
                                null : getConversionFactor(mapDataEntry, entity, searchParam2) * conversionFactor;
                    }
                }
            }
        }
        return conversionFactor;
    }
}
