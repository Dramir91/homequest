package Dramir.Game;

import Dramir.App.ApplicationMain;
import Dramir.Game.Field.Door;
import Dramir.Game.Field.Field;
import Dramir.Game.Field.Ground;
import Dramir.Game.Field.Wall;
import Dramir.Window.Window;
import asciiPanel.AsciiPanel;

import java.util.ArrayList;

public class Map extends Window {
    Field[][] grid = new Field[(ApplicationMain.width / 2) - 3][30];
    ArrayList<Character> npcs = new ArrayList<>();

    /*
       ........
       ..###...
       ..#.#...
       ..##&...
       ........
     */
    public Map(int x, int y, int width, int height) {
        super(x, y, width, height);

        for (int ix = 0; ix < getWidth(); ix++) {
            for (int iy = 0; iy < getHeight(); iy++) {
                grid[ix][iy] = new Ground();

            }
        }
        grid[3][1] = new Wall();
        grid[4][1] = new Door(true);
        grid[5][1] = new Wall();
        grid[3][2] = new Wall();
        grid[5][2] = new Wall();
        grid[3][3] = new Wall();
        grid[4][3] = new Door(false);
        grid[5][3] = new Wall();
        grid[10][3] = new Wall();
        grid[11][3] = new Wall();
        grid[12][3] = new Wall();
        grid[13][3] = new Wall();
        grid[14][3] = new Wall();
        grid[15][3] = new Wall();
        grid[16][3] = new Wall();
        grid[10][4] = new Wall();
        grid[11][4] = new Wall();
        grid[12][4] = new Wall();
        grid[13][4] = new Wall();
        grid[14][4] = new Wall();
        grid[15][4] = new Wall();
        grid[16][4] = new Wall();
        npcs.add(new NPC(5, 5));
        npcs.add(new NPC(5, 8));
    }

    public Field getField(int x, int y) {
        return grid[x][y];
    }

    public int getWidth() {
        return grid.length;
    }

    public int getHeight() {
        return grid[0].length;
    }

    public void draw(AsciiPanel terminal) {
        drawBorder(terminal);
        for (int fx = 0; fx < getWidth(); fx++) {
            for (int fy = 0; fy < getHeight(); fy++) {
                var field = getField(fx, fy);
                terminal.write(field.getSymbol(), deltaX(fx), deltaY(fy), field.getColor());
            }
        }
        for (var npc : npcs) {
            terminal.write("X", deltaX(npc.x), deltaY(npc.y));
        }
        terminal.write("@", deltaX(GameState.Player.x), deltaY(GameState.Player.y));
    }

    public void tick() {
        for (var npc : npcs) {
            npc.tick(this);
        }
    }
    public boolean isInBounds(int nextX, int nextY) {
        return nextX >= 0 && nextX < getWidth() && nextY >= 0 && nextY < getHeight();
    }
}

