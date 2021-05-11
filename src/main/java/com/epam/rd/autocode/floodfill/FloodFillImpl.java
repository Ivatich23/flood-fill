package com.epam.rd.autocode.floodfill;

public class FloodFillImpl implements FloodFill {

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

    }
}
