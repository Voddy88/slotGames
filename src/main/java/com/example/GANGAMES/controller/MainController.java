package com.example.GANGAMES.controller;

import com.example.GANGAMES.DTO.*;
import com.example.GANGAMES.exception.CustomException;
import com.example.GANGAMES.service.CrapsService;
import com.example.GANGAMES.service.SpiderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private final CrapsService crapsService;
    private final SpiderService spiderService;

    public MainController(CrapsService crapsService, SpiderService spiderService) {
        this.crapsService = crapsService;
        this.spiderService = spiderService;
    }

    @PostMapping(value = "/games/single")
    public ResponseEntity<? extends BaseGameResponse> startGame(@RequestBody SingleGameRequest request) {
        if (request.getType().equals("Craps")) {
            CrapsSingleGameResponse game;
            game = crapsService.startGame(request);
            return new ResponseEntity<>(game, HttpStatus.OK);
        } else if (request.getType().equals("Spider")) {
            SpiderAntSingleGameResponse game;
            game = spiderService.startGame(request);
            return new ResponseEntity<>(game, HttpStatus.OK);
        }
        return null;
    }

    @PostMapping(value = "/games/multi")
    public ResponseEntity<MultiGameResponse> startGame(@RequestBody MultiRoundsGameRequest request) {
        MultiGameResponse game;
        if (request.getType().equals("Craps")) {
            game = crapsService.startGame(request);
            return new ResponseEntity<>(game, HttpStatus.OK);
        } else if (request.getType().equals("Spider")) {
            game = spiderService.startGame(request);
            return new ResponseEntity<>(game, HttpStatus.OK);
        }
        return null;
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorCustomResponse> exceptionResponse (CustomException ex){
        ErrorCustomResponse errorResponse = new ErrorCustomResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
