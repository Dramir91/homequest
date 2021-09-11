package Dramir.Window;

import Dramir.App.ApplicationMain;
import Dramir.Game.GameState;
import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;

public class LogWindow extends Window {

    ArrayList<ArrayList<String>> log = new ArrayList<>();
    int currentPage = 0;


    public LogWindow(int x, int y, int width, int height) {
        super(x, y, width, height);
        log.add(new ArrayList<>());
        write("test... dlugi dlugi tekst ktory jest wiekszy niz kilkanascie znakow i jest na dwie linie");

    }

    public void draw(AsciiPanel terminal) {
        drawBorder(terminal);
        int lineY = 0;
        for (var line : log.get(currentPage)) {
            terminal.write(line, deltaX(0), deltaY(lineY));
            lineY++;
        }

    }


    public ArrayList<String> partitionText(String text) {
        int maxWidth = width - (borderOffset * 2);
        String wordsInLine = "";
        ArrayList<String> partitionedText = new ArrayList<>();
        for (var word : text.split(" ")) {
            // łączna długość poprzednich słów + kolejne <= maxWidth
            if (wordsInLine.length() + word.length() > maxWidth) {
                partitionedText.add(wordsInLine.substring(0, wordsInLine.length() - 1));
                wordsInLine = "";
            }
            wordsInLine += word + " ";
        }
        partitionedText.add(wordsInLine.substring(0, wordsInLine.length() - 1));
        return partitionedText;
    }

    public void write(String s) {
        int maxHeight = height - borderOffset * 2;
        var text = partitionText(s);

        var page = log.get(log.size()-1);
        for(var line : text) {
            if (page.size()==maxHeight) {
                if (currentPage == log.size() - 1)
                    currentPage++;
                page = new ArrayList<>();
                log.add(page);
            }
            page.add(line);
        }
    }

    public void changePage(int offset) {
        int nextPage = currentPage + offset;
        if (nextPage >= 0 && nextPage <= log.size()-1) {
            currentPage = nextPage;
        }
    }

    public void respondToUserInput(KeyEvent key) {
        if (key.getKeyCode() == KeyEvent.VK_PAGE_UP)
            changePage(-1);
        if (key.getKeyCode() == KeyEvent.VK_PAGE_DOWN)
            changePage(1);
    }
}


