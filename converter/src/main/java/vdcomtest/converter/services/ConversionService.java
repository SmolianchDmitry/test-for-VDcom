package vdcomtest.converter.services;


import vdcomtest.converter.entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static vdcomtest.converter.parsers.ParserListStringToHashMap.parsDataEntryToMap;
import static vdcomtest.converter.services.SearchAnswerService.getAnswer;

public class ConversionService {
    public static ArrayList<String> dataProcessing(List<String> stringsEnter, List<String> stringsQuestion){

        HashMap<String, List<Entity>> mapDataEntry = parsDataEntryToMap(stringsEnter);
        return getAnswer(mapDataEntry, stringsQuestion);
    }
}
