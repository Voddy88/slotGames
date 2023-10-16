package com.example.GANGAMES.game;

import com.example.GANGAMES.models.Spider;
import lombok.Getter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class SpiderAntGame extends Game{
    private final Random valueGenerator = new Random();
    @Getter
    private int totalWin = 0;
    @Getter
    private Map<Integer,SpiderDirection> spiderState= new LinkedHashMap<>();
    private int[][] myArr =
            {
                    {1, 2, 3},
                    {0, 4, 6},
                    {0, 5, 6},
                    {0, 4, 5},
                    {3, 1, 7},
                    {3, 7, 2},
                    {1, 2, 7}
            };

    public SpiderAntGame(int stake, int bet) {
        super(stake, bet);
    }

    public void start() {
        Spider spider = new Spider();
        int counter = 0;
        while (spider.getSpiderPosition() != 7) {
            counter++;
            totalWin += super.getBet();
            spider.setSpiderPosition(changeSpiderPosition(myArr[spider.getSpiderPosition()]));
            spiderState.put(counter,SpiderDirection.values()[spider.getSpiderPosition()]);
        }
    }

    private int changeSpiderPosition(int[] currentState) {
        int randomInt = valueGenerator.nextInt(currentState.length);
        return currentState[randomInt];
    }
}
