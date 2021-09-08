package Dramir.Window;

import asciiPanel.AsciiPanel;

import java.util.ArrayList;

public class LogWindowBackup extends Window {

    ArrayList<String> log = new ArrayList<>();

    public LogWindowBackup(int x, int y, int width, int height) {
        super(x, y, width, height);
        log.add("test... dlugi dlugi tekst ktory jest wiekszy niz kilkanascie znakow i jest na dwie linie");
    }

    public void draw(AsciiPanel terminal) {
        drawBorder(terminal);
        int lineY = 0;
        int lineX = 0;
        int maxWidth = width - (borderOffset * 2);

        for (var line : log) {
            for (var word : line.split(" ")) {
                int wordLength = word.length();
                if (lineX + wordLength > maxWidth) {
                    lineX = 0;
                    lineY++;
                }
                terminal.write(word, deltaX(lineX), deltaY(lineY));
                lineX += (wordLength + 1);
            }
        }
    }

    public void write(String s) {
        log.add(s);
    }

}
