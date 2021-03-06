package Dramir.Game;

import java.util.Random;
import java.util.function.Consumer;

public class NPC extends Character {
    Consumer<Map> routine = this::moveRandomlyRoutine;
    int tickCounter = 0;

    public NPC(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public void tick(Map map) {
        routine.accept(map);
        tickCounter++;
    }

    private void moveRandomlyRoutine(Map map) {
        Random rand = new Random(); // tworzy generator liczb losowych

        int nextX = x + rand.nextInt(3) - 1; // przesuwa o -1 ... 1
        int nextY = y + rand.nextInt(3) - 1; // przesuwa o -1 ... 1

        tryMove(map, nextX, nextY);
        if (playerIsNear(2))
            routine = this::attackRoutine;
    }

    private boolean playerIsNear(int distance) {
        int playerX = GameState.Player.x;
        int playerY = GameState.Player.y;
        int deltaX = Math.abs(playerX - x);
        int deltaY = Math.abs(playerY - y);

        return deltaX <= distance && deltaY <= distance;
    }

    private void attackRoutine(Map map) {
        if (playerIsNear(1))
            GameState.LogWindow.write("npc hit u");
        else if (!playerIsNear(3))
            routine = this::moveRandomlyRoutine;
        else
            moveTowardsPlayer(map);
    }

    private void moveTowardsPlayer(Map map) {
        int playerX = GameState.Player.x;
        int playerY = GameState.Player.y;
        int deltaX = x - playerX; // -1, 0, +1 - cel
        int deltaY = y - playerY;
        int nextX = x - Integer.signum(deltaX);
        int nextY = y - Integer.signum(deltaY);

        if ((tickCounter % 5) != 0)
            tryMove(map, nextX, nextY);
    }
}
