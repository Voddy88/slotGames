package com.example.GANGAMES.game;

import com.example.GANGAMES.exception.CustomException;
import lombok.Data;

@Data
public abstract class Game {
    private int stake;
    private int bet;

    public Game(int stake, int bet) {
        if(stake < bet){
            throw new CustomException("Stake cannot be less than the bet");
        }
        this.stake = stake;
        this.bet = bet;
    }

    public abstract void start();
}
