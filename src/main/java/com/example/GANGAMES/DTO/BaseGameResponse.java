package com.example.GANGAMES.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseGameResponse {
    private String type;
    private int stake;
    private boolean playerWins;
    private int totalWin;
}
