package Dramir.Screen;

import Dramir.App.ApplicationMain;
import Dramir.Game.GameState;
import Dramir.Game.Map;
import Dramir.Window.LogWindow;
import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class GameView implements Screen {
    Map location = GameState.Location;
    LogWindow logWindow = GameState.LogWindow;

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.clear();
        location.draw(terminal);
        GameState.Stats.draw(terminal);
        logWindow.draw(terminal);
        terminal.repaint();
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        var player = GameState.Player;
        int x = player.x, y = player.y;
        if (key.getKeyCode() == KeyEvent.VK_UP)
            y--;
        if (key.getKeyCode() == KeyEvent.VK_DOWN)
            y++;
        if (key.getKeyCode() == KeyEvent.VK_RIGHT)
            x++;
        if (key.getKeyCode() == KeyEvent.VK_LEFT)
            x--;

        logWindow.respondToUserInput(key);

        player.tryMove(location, x, y);
        location.tick();
        return this;
    }
}
