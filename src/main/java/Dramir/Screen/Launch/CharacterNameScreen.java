package Dramir.Screen.Launch;

import Dramir.Game.GameState;
import Dramir.Screen.Screen;
import asciiPanel.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CharacterNameScreen implements Screen {
    String name = "";

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.clear();
        terminal.write("Enter your character's name (press enter to confirm): ", 4, 1, Color.GREEN);
        terminal.write(name, 4, 4, Color.RED);
        terminal.repaint();
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        var asciiCode = ((int) key.getKeyChar());
        if (name.length() <= 16)
            if (isLowerCaseLetter(asciiCode) || isSpace(asciiCode) || isUpperCaseLetter(asciiCode))
                name += key.getKeyChar();
        if (key.getKeyCode() == KeyEvent.VK_BACK_SPACE && name.length() > 0)
            name = name.substring(0, name.length() - 1);
        if (key.getKeyCode() == KeyEvent.VK_ENTER && name.length() > 0) {
            GameState.Player.Name = name;
            return new GenderChoiceScreen();
        }
        return this;
    }

    private boolean isUpperCaseLetter(int asciiCode) {
        return asciiCode >= 65 && asciiCode <= 90;
    }

    private boolean isSpace(int asciiCode) {
        return asciiCode == 32;
    }

    private boolean isLowerCaseLetter(int asciiCode) {
        return asciiCode >= 97 && asciiCode <= 122;
    }
}
