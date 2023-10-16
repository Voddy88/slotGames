package com.example.GANGAMES.service;

import com.example.GANGAMES.DTO.MultiGameResponse;
import com.example.GANGAMES.DTO.MultiRoundsGameRequest;
import com.example.GANGAMES.DTO.SingleGameRequest;
import com.example.GANGAMES.DTO.SpiderAntSingleGameResponse;
import com.example.GANGAMES.game.SpiderAntGame;
import org.springframework.stereotype.Service;

@Service
public class SpiderService {

    public SpiderAntSingleGameResponse startGame(SingleGameRequest request) {
        SpiderAntGame game = new SpiderAntGame(11, 1);
        game.start();
        SpiderAntSingleGameResponse response = spiderGameResponse(game);
        response.setType(request.getType());
        return response;
    }

    public MultiGameResponse startGame(MultiRoundsGameRequest request){
        MultiGameResponse response = new MultiGameResponse();
        for (int i = 0; i < request.getRounds(); i++) {
            SpiderAntGame spiderGame = new SpiderAntGame(11, 1);
            spiderGame.start();
            response.setTotalWin(response.getTotalWin() + spiderGame.getTotalWin());
            response.setTotalAmountOfStakes(response.getTotalAmountOfStakes() + spiderGame.getStake());
        }
        return response;
    }

    private SpiderAntSingleGameResponse spiderGameResponse(SpiderAntGame game) {
        SpiderAntSingleGameResponse response = new SpiderAntSingleGameResponse();
        response.setStake(game.getStake());
        response.setDetails(game.getSpiderState());
        response.setTotalWin(game.getTotalWin());
        if(game.getStake() >= game.getTotalWin()){
            response.setPlayerWins(false);
        }else{
            response.setPlayerWins(true);
        }
        return response;
    }
}
