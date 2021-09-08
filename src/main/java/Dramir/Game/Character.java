package Dramir.Game;
import Dramir.App.ApplicationMain;
import asciiPanel.AsciiPanel;

import java.util.HashMap;

public class Character {
    public String Name;
    public int STR = 10;
    public int INT = 10;
    public int DEX = 10;
    public int VIT = 10;
    public int POW = 10;
    public int MP = 10;
    public int HP = 10;
    public int x = 0;
    public int y = 0;

    public HashMap<String , Integer> Skills = new HashMap<>();

    @Override
    public String toString() {
        return "STR:" + STR + " INT:" + INT + " DEX:" + DEX + " VIT:" + VIT + " POW:" + POW + " MP:" + MP + " HP:" + HP;
    }



    public void tick(Map map) {

    }

    public void tryMove(Map map, int nextX, int nextY) {
        // zablokowanie możliwości wyjścia poza mapę
        if (!map.isInBounds(nextX, nextY))
            return;

        var field = map.getField(nextX, nextY);

        if (!field.isPassable()) {
            field.interact(this);
            return;
        }

        x = nextX;
        y = nextY;
    }
}
