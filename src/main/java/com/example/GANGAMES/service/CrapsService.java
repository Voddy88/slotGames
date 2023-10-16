package com.example.GANGAMES.service;

import com.example.GANGAMES.DTO.CrapsSingleGameResponse;
import com.example.GANGAMES.DTO.MultiGameResponse;
import com.example.GANGAMES.DTO.MultiRoundsGameRequest;
import com.example.GANGAMES.DTO.SingleGameRequest;
import com.example.GANGAMES.game.CrapsGame;
import org.springframework.stereotype.Service;

@Service
public class CrapsService {
    public CrapsSingleGameResponse startGame(SingleGameRequest request) {
        CrapsGame crapsGame = new CrapsGame(request.getStake(), 1);
        crapsGame.start();
        CrapsSingleGameResponse crapsCrapsSingleGameResponse = crapsGameResponse(crapsGame);
        crapsCrapsSingleGameResponse.setType(request.getType());
        return crapsCrapsSingleGameResponse;
    }

    public MultiGameResponse startGame(MultiRoundsGameRequest request) {
        MultiGameResponse response = new MultiGameResponse();
        for (int i = 0; i < request.getRounds(); i++) {
            CrapsGame crapsGame = new CrapsGame(request.getStake(), request.getStake());
            crapsGame.start();
            response.setTotalWin(response.getTotalWin() + crapsGame.getPlayerTotalWin());
            response.setTotalAmountOfStakes(response.getTotalAmountOfStakes() + crapsGame.getStake());
        }
        return response;
    }

    private CrapsSingleGameResponse crapsGameResponse(CrapsGame crapsGame) {
        CrapsSingleGameResponse response = new CrapsSingleGameResponse();
        response.setStake(crapsGame.getStake());
        response.setTotalWin(crapsGame.getPlayerTotalWin());
        response.setDetails(crapsGame.getDiceValuesByRounds());
        response.setPlayerWins(crapsGame.isPlayerWins());
        return response;
    }

}
