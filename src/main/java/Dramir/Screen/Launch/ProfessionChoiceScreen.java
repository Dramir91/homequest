package Dramir.Screen.Launch;

import Dramir.Game.GameState;
import Dramir.Screen.Screen;

import java.awt.event.KeyEvent;

public class ProfessionChoiceScreen extends ChoiceScreen {

    public ProfessionChoiceScreen() {
        super(new String[]{"Drunkard", "Junkie", "Whore", "Bandit", "Thug", "Nerd"},
                "Choose your characters profession: ");
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        var result = super.respondToUserInput(key);
        if (result == null) {
            GameState.Profession = menuOptions[selectedIndex];
            switch (GameState.Profession) {
                case "Drunkard":
                    GameState.Player.DEX += 2;
                    GameState.Player.INT -= 2;
                    break;
                case "Junkie":
                    GameState.Player.POW += 10;
                    GameState.Player.INT -= 2;
                    break;
                case "Whore":
                    GameState.Player.VIT += 5;
                    GameState.Player.POW -= 2;
                    break;
                case "Bandit":
                    GameState.Player.STR += 2;
                    GameState.Player.INT -= 2;
                    break;
                case "Thug":
                    GameState.Player.STR += 4;
                    GameState.Player.VIT += 2;
                    GameState.Player.INT -= 4;
                    GameState.Player.DEX -= 2;
                    break;
                case "Nerd":
                    GameState.Player.STR -= 8;
                    GameState.Player.INT += 8;
                    GameState.Player.DEX -= 5;
                    GameState.Player.VIT -= 2;
                    GameState.Player.POW += 2;
                    break;
            }
            return new RaceChoiceScreen();
        }
        return this;
    }
}
