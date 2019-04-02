package com.patryk.app.game_logic;

/**
 * @author Patryk Kucharski
 */
public class GameLogicAPI {

    private final GameJudge gameJudge;
    private BoardConfig boardConfig;

    GameLogicAPI(){
        this.gameJudge = new GameJudge();
    }

    void addPlayerToTheGame(Player player){
        boardConfig.addPlayer(player);
    }


}
