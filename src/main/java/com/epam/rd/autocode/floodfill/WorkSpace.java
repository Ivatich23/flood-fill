package com.epam.rd.autocode.floodfill;


public class WorkSpace implements FloodFill,FloodLogger {
    FloodLogger logger;

    @Override
    public void flood(String map, FloodLogger logger) {
        int lineLength = map.split("\n")[0].length();
        logger.log(map);
        char[] tempMap = map.toCharArray();
        int lastIndex = 0;
        int indexOfWater;
        while ((indexOfWater = map.indexOf(WATER, lastIndex)) > 0) {
            if (indexOfWater + 1 < tempMap.length && map.indexOf(tempMap[indexOfWater + 1]) != lineLength) {
                tempMap[indexOfWater + 1] = WATER;
                if (indexOfWater + lineLength < tempMap.length && map.indexOf(tempMap[indexOfWater + lineLength]) != lineLength)
                    tempMap[indexOfWater + lineLength] = WATER;
            }
            if (indexOfWater >= 1 && map.indexOf(tempMap[indexOfWater - 1]) != lineLength) {
                tempMap[indexOfWater - 1] = WATER;
                if (indexOfWater - lineLength > 0 && map.indexOf(tempMap[indexOfWater - lineLength]) != lineLength)
                    tempMap[indexOfWater - lineLength] = WATER;
            }
            if (lastIndex > tempMap.length) {
                indexOfWater = -1;
            }
            lastIndex = indexOfWater + 1;
        }
        String newMap = String.valueOf(tempMap);
        if (newMap.indexOf(LAND) > -1) {
            flood(newMap, logger);
        }

    }


    @Override
    public void log(String floodState) {

    }
}
