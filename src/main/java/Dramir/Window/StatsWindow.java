package Dramir.Window;

import Dramir.App.ApplicationMain;
import Dramir.Game.GameState;
import asciiPanel.AsciiPanel;

public class StatsWindow extends Window {
    public StatsWindow(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void draw(AsciiPanel terminal) {
        drawBorder(terminal);

        String stats = GameState.Player.toString();
        int x = this.x + (width / 2) - (stats.length() / 2);
        int y = this.y + 1;
        terminal.write(stats, x, y); // punkt poczatkowy musi byc identycznie daleko od krawedzi co koncowy na osi x
    }
}
