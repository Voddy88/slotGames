package com.example.GANGAMES.game;

import com.example.GANGAMES.models.Die;
import lombok.Getter;

import java.util.*;

public class CrapsGame extends Game {
    private final Random valueGenerator = new Random();
    private final Die firstDie = new Die();
    private final Die secondDie = new Die();
    private boolean keepPlaying = true;
    @Getter
    private boolean playerWins = false;
    private int counter = 0;
    @Getter
    private int playerTotalWin;
    @Getter
    private Map<Integer, Die[]> diceValuesByRounds = new LinkedHashMap<>();

    public CrapsGame(int stake, int bet) {
        super(stake, bet);
    }


    public void start() {
        rollTheDice();
        if (firstDie.getValue() + secondDie.getValue() == 7 || firstDie.getValue() + secondDie.getValue() == 11) {
            //GAME ENDS AND THE PLAYER WINS
            keepPlaying = false;
            playerTotalWin = super.getBet() + super.getStake();
            playerWins = true;
        }
        if (firstDie.getValue() + secondDie.getValue() == 2 || firstDie.getValue() + secondDie.getValue() == 3 || firstDie.getValue() + secondDie.getValue() == 12) {
            //GAME ENDS AND THE PLAYER LOOSE
            keepPlaying = false;
            playerTotalWin = 0;
        }
        int playerPoint = firstDie.getValue() + secondDie.getValue();
        while (keepPlaying) {
            rollTheDice();
            if (firstDie.getValue() + secondDie.getValue() == playerPoint) {
                //player wins
                playerWins = true;
                playerTotalWin = super.getBet() + super.getStake();
                keepPlaying = false;
            } else if (firstDie.getValue() + secondDie.getValue() == 7) {
                //player looses
                keepPlaying = false;
                this.playerTotalWin = 0;
            }
        }
    }

    private void rollTheDice() {
        counter++;
        Die[] valuesPerRound = new Die[2];
        firstDie.setValue(valueGenerator.nextInt(6) + 1);
        Die die1 = new Die(firstDie.getValue());
        valuesPerRound[0] = die1;
        secondDie.setValue(valueGenerator.nextInt(6) + 1);
        Die die2 = new Die(secondDie.getValue());
        valuesPerRound[1] = die2;
        diceValuesByRounds.put(counter, valuesPerRound);

    }
}
