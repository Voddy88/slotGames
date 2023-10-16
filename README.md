# slotGames
Simple craps game and spider-ant on the cubic game

The server is working on port 8080.
There are 2 endpoints which accept POST requests:
1:
 localhost:8080/games/single
 
 Example body:
 
 {
    "type":"Craps",
    "stake":1
}

2:
 localhost:8080/games/multi
 
 Example body:
 
 {
    "type":"Spider",
    "stake":1,
    "rounds":5
}
