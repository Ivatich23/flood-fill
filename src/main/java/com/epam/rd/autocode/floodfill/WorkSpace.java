package com.epam.rd.autocode.floodfill;


<<<<<<< HEAD
public class WorkSpace implements FloodFill, FloodLogger {

    @Override
    public void flood(String map, FloodLogger logger) {
        int lineLength = map.split("\n")[0].length() + 1;
        logger.log(map);
        if (map.indexOf(LAND) > -1) {
            char[] tempMap = map.toCharArray();
            int lastIndex = 0;
            int indexOfWater;
            while ((indexOfWater = map.indexOf(WATER, lastIndex)) >= 0 && lastIndex < map.length()) {
                int rightIndex = indexOfWater + 1;
                int leftIndex = indexOfWater - 1;
                int upIndex = indexOfWater - lineLength;
                int downIndex = indexOfWater + lineLength;
                int currentLine = indexOfWater / lineLength;
                if ((rightIndex - currentLine * lineLength) < lineLength - 1) {
                    tempMap[rightIndex] = WATER;
                }
                if ((leftIndex - currentLine * lineLength) >= 0) {
                    tempMap[leftIndex] = WATER;
                }
                if (upIndex >= 0) {
                    tempMap[upIndex] = WATER;
                }
                if (downIndex < map.length()) {
                    tempMap[downIndex] = WATER;
                }
                lastIndex = indexOfWater + 1;
            }
            String newMap = String.valueOf(tempMap);
            flood(newMap, logger);
        }
=======
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

>>>>>>> origin/master
    }


    @Override
    public void log(String floodState) {
<<<<<<< HEAD

=======
        System.out.println(floodState);
>>>>>>> origin/master
    }
}
