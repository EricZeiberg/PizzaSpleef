package me.masterejay.pizzaspleef.match;

import me.masterejay.pizzaspleef.PizzaSpleef;

/**
 * @author MasterEjay
 */
public class MatchHandler {

    public static void start(){
        PizzaSpleef.setState(MatchState.PLAYING);
    }

    public static void finish(){

    }
}
