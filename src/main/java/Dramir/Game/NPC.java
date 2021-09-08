package Dramir.Game;

import java.util.Random;

public class NPC extends Character {

    public NPC(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public void tick(Map map) {
        Random rand = new Random(); // tworzy generator liczb losowych

        int nextX = x + rand.nextInt(3) - 1; // przesuwa o -1 ... 1
        int nextY = y + rand.nextInt(3) - 1; // przesuwa o -1 ... 1

        tryMove(map, nextX, nextY);
    }
}
