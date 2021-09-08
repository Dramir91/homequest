package Dramir.Screen.Launch;

import Dramir.Screen.Screen;
import asciiPanel.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ChoiceScreen implements Screen {
    int selectedIndex = 0;
    int x = 4;
    String[] menuOptions;
    String prompt;
    public ChoiceScreen(String[] menuOptions, String prompt) {
        this.menuOptions = menuOptions;
        this.prompt = prompt;
    }
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.clear();
        terminal.write(prompt, x, 1, Color.GREEN );
        int i = 0;
        for (var entry : menuOptions) {
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
        if (key.getKeyCode() == KeyEvent.VK_DOWN)
            selectedIndex++;
        if (key.getKeyCode() == KeyEvent.VK_UP)
            selectedIndex--;
        if (selectedIndex > menuOptions.length - 1)
            selectedIndex = 0;
        if (selectedIndex < 0)
            selectedIndex = menuOptions.length - 1;
        if (key.getKeyCode() == KeyEvent.VK_ENTER) {
            return null;
        }
        return this;
    }
}
