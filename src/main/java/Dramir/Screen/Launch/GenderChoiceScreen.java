package Dramir.Screen.Launch;

import Dramir.Game.GameState;
import Dramir.Screen.Screen;

import java.awt.event.KeyEvent;

public class GenderChoiceScreen extends ChoiceScreen {

    public GenderChoiceScreen() {
        super(new String[]{"Female", "Male", "Potato"}, "Choose your characters gender: ");
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        var result = super.respondToUserInput(key);
        if (result == null) {
            GameState.Gender = menuOptions[selectedIndex];
            return new ProfessionChoiceScreen();
        }
        return this;
    }
}
