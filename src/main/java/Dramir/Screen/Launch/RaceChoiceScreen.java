package Dramir.Screen.Launch;

import Dramir.Game.GameState;
import Dramir.Screen.Screen;

import java.awt.event.KeyEvent;

public class RaceChoiceScreen extends ChoiceScreen {

    public RaceChoiceScreen() {
        super(new String[]{"Normal", "Jew", "Nigga", "Slavic", "Gypsy", "Jap"},
                "Choose your characters race: ");
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        var result = super.respondToUserInput(key);
        if (result == null) {
            GameState.Race = menuOptions[selectedIndex];
            switch (GameState.Race) {
                case "Normal":
                    GameState.Player.DEX -= 2;
                    GameState.Player.INT += 2;
                    break;
                case "Jew":
                    GameState.Player.STR -= 5;
                    GameState.Player.INT += 4;
                    break;
                case "Nigga":
                    GameState.Player.INT -= 5;
                    GameState.Player.DEX += 5;
                    break;
                case "Slavic":
                    GameState.Player.STR += 4;
                    GameState.Player.INT -= 2;
                    break;
                case "Gypsy":
                    GameState.Player.STR -= 4;
                    GameState.Player.VIT -= 2;
                    GameState.Player.INT -= 4;
                    GameState.Player.DEX -= 2;
                    break;
                case "Jap":
                    GameState.Player.STR -= 8;
                    GameState.Player.INT += 8;
                    GameState.Player.DEX += 1;
                    GameState.Player.VIT -= 2;
                    break;
            }
            return new CharacterSummaryScreen();
        }
        return this;
    }
}
