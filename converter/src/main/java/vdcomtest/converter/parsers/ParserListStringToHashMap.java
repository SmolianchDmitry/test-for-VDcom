package vdcomtest.converter.parsers;

import vdcomtest.converter.entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static vdcomtest.converter.parsers.ParserStringToEntities.getEntities;

public class ParserListStringToHashMap {

    public static HashMap<String, List<Entity>> parsDataEntryToMap(List<String> dataEntry) {
        HashMap<String, List<Entity>> mapDataEntry = new HashMap<>();
        for (String str : dataEntry) {
            Entity[] entities = getEntities(str);
            List<Entity> entityList = new ArrayList<>();
            String entityName = entities[0].getName();
            Double conversionFactor = entities[1].getConversionFactor() / entities[0].getConversionFactor();
            if (mapDataEntry.containsKey(entityName)) {
                entityList = mapDataEntry.get(entityName);
                for (Entity entity : entityList) {
                    if (entity.getName().equals(entities[1].getName())
                            && !entity.getConversionFactor().equals(conversionFactor)) {
                        System.out.println("Не корректный ввод данных. Необходимо перезапустить приложение");
                        System.exit(0);
                    }
                }
            }
            entities[1].setConversionFactor(conversionFactor);
            entityList.add(entities[1]);
            mapDataEntry.put(entityName, entityList);
            entityList = new ArrayList<>();
            entityName = entities[1].getName();
            conversionFactor = entities[0].getConversionFactor() / entities[1].getConversionFactor();
            if (mapDataEntry.containsKey(entityName)) {
                entityList = mapDataEntry.get(entityName);
                for (Entity entity : entityList) {
                    if (entity.getName().equals(entities[0].getName())
                            && !entity.getConversionFactor().equals(conversionFactor)) {
                        System.out.println("Не корректный ввод данных. Необходимо перезапустить приложение");
                        System.exit(0);
                    }
                }
            }

            entities[0].setConversionFactor(conversionFactor);
            entityList.add(entities[0]);
            mapDataEntry.put(entityName, entityList);
        }
        return mapDataEntry;
    }

    public static HashMap<String, List<Entity>> parsQuestionToMap(List<String> dataEntry) {
        HashMap<String, List<Entity>> mapDataEntry = new HashMap<>();
        for (String str : dataEntry) {
            Entity[] entities = getEntities(str);
            List<Entity> entityList = new ArrayList<>();
            String entityName = entities[0].getName();
            if (mapDataEntry.containsKey(entityName)) {
                entityList = mapDataEntry.get(entityName);
            }
            entities[1].setConversionFactor(null);
            entityList.add(entities[1]);
            mapDataEntry.put(entityName, entityList);
        }
        return mapDataEntry;
    }

}
