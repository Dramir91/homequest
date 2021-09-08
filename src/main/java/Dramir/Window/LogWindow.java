package Dramir.Window;

import Dramir.App.ApplicationMain;
import Dramir.Game.GameState;
import asciiPanel.AsciiPanel;

import java.util.ArrayList;

public class LogWindow extends Window {

    ArrayList<ArrayList<String>> log = new ArrayList<>();


    public LogWindow(int x, int y, int width, int height) {
        super(x, y, width, height);
        log.add(new ArrayList<>());
        write("test... dlugi dlugi tekst ktory jest wiekszy niz kilkanascie znakow i jest na dwie linie");

    }

    public void draw(AsciiPanel terminal) {
        drawBorder(terminal);
        int lastIndex = log.size() - 1;
        int lineY = 0;
        for (var line : log.get(lastIndex)) {
            terminal.write(line, deltaX(0), deltaY(lineY));
            lineY++;
        }

    }

    //a dvsd vkoasdpv aoskvakdp oakdfopv pdfkgop dfsoi poijriportjniob msrotibm soriptmbio psrmtb ioprtsm biosrmbto ipsrm
    //
    //[                                     ]
    //
    //[a dvsd vkoasdpv aoskvakdp oakdfopv]
    //[pdfkgop dfsoi poijriportjniob]
    //[msrotibm soriptmbio psrmtb ioprtsm]
    //[biosrmbto ipsrm]

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
                page = new ArrayList<>();
                log.add(page);
            }
            page.add(line);
        }
//
//      if (text.size() > maxHeight) {
//            log.add(page);
//        }
//        if (text.size() < maxHeight) {
//            page.addAll(text);
//        }

        /*

        [ 'pierwszy tekst',

        ]
        -> addEvent / addToLog -> write()
        [ 'pierwszy tekst',
           'you hit a wal'
        ] -> renderPage();

        1. interaction('wall')
            -> dodajemy element do loga || zmienic statsy bohatera || zakoncz gre // bo wiemy ze uderzylismy w sciane
                -> writeLog -> moze dodac sie do pierwszej strony albo do drugiej
            -> odswiezyc pole gry // a to pole gry juz ma policzonego loga odpowiednio
         */


    }

}


