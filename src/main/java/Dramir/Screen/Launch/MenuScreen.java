package Dramir.Screen.Launch;

import Dramir.Screen.Screen;
import asciiPanel.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuScreen implements Screen {
    int selectedIndex = 0;
    int x = 4;
    String[] mainMenuOptions = new String[]{"Start Dramir.Game", "Options", "Credits", "Exit"};

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.clear();
        terminal.write("HOMEQUEST", 35, 1, new Color(135, 213, 17));
        int i = 0;
        for (var entry : mainMenuOptions) {
            var y = 3 + 2 * i;
            var foreColor = selectedIndex == i ? Color.RED : Color.WHITE;
            var backColor = Color.BLACK;
            terminal.write(entry, x, y, foreColor, backColor);
            i++;
        }
        terminal.repaint();
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        if (selectedIndex == 0 && key.getKeyCode() == KeyEvent.VK_ENTER) {
            return new CharacterNameScreen();
        }
        if (selectedIndex == 1 && key.getKeyCode() == KeyEvent.VK_ENTER) {
            return new OptionsScreen();
        }

        if (key.getKeyCode() == KeyEvent.VK_DOWN)
            selectedIndex++;
        if (key.getKeyCode() == KeyEvent.VK_UP)
            selectedIndex--;
        if (selectedIndex > mainMenuOptions.length - 1)
            selectedIndex = 0;
        if (selectedIndex < 0)
            selectedIndex = mainMenuOptions.length - 1;
        return this;
    }
}
