package Dramir.Game;

import Dramir.Window.LogWindow;
import Dramir.Window.StatsWindow;

public class GameState {
    public static String Race;
    public static String Profession;
    public static String Gender;
    public static Character Player = new Character();
    public static Map Location = new Map(0, 0, 48, 37);
    public static LogWindow LogWindow = new LogWindow(48, 0, 32, 37 );
    public static StatsWindow Stats = new StatsWindow(0, 37, 80, 3);
}
