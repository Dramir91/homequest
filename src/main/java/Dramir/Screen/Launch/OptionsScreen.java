package Dramir.Screen.Launch;

import Dramir.Screen.Screen;
import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class OptionsScreen implements Screen {
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.clear();
        terminal.write("Unlimited Lives = yes", 4, 3);
        terminal.repaint();
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return new MenuScreen();
    }
}
