Programmierung 2

# Übung 5

Klonen Sie dieses Repository direkt in Eclipse und importieren Sie das Projekt. Legen Sie einen neuen Branch an, den Sie nach Ihrem GitHub-Benutzernamen benennen.

## Aufgabe 1


## Aufgabe 2 (optional)

Im Spiel ["Türme von Hanoi"](https://de.wikipedia.org/wiki/Türme_von_Hanoi) besteht die Aufgabe darin, einen Stapel Scheiben vom linken auf den rechten Stab zu befördern. Dazu darf ein dritter Stab in der Mitte verwendet werden. In jedem Zug darf nur eine Scheibe auf einen anderen Stab gelegt werden, allerdings darf niemals eine größere auf einer kleineren Scheibe liegen.

![](https://upload.wikimedia.org/wikipedia/commons/0/07/Tower_of_Hanoi.jpeg)

In der Klasse `idh.java.Hanoi` finden Sie eine Implementierung für das Spiel, wobei die Stäbe hier waagerecht dargestellt werden, und die Scheibengröße nur durch Zahlen repräsentiert werden. Eine gültige Situation im Spiel sieht in der Fassung so aus:

```
  | 
 l|9 8 7 6
  |
 m|5 4
  |
 r|3 2 1
  |
```

Wenn Sie die `main`-Funktion starten, können Sie sich zwischen einem manuellen und automatischen Spiel entscheiden. Das manuelle Spiel ist fertig implementiert, und Sie können direkt loslegen. Als Benutzer:in gibt man dabei immer zwei Buchstaben ein, einen für den Quell- (von wo eine Scheibe entnommen wird) und einen für den Zielstab (wo die Scheibe abgelegt wird), also z.B. `lm` für "Nimm die oberste Scheibe vom linken Stab und lege sie auf den mittleren". Das manuelle Spiel ist in der Funktion `run()` implementiert. 

In dieser Aufgabe geht es allerdings um die automatische Variante, die in der Funktion `runAutomatically()` implementiert werden soll/kann (Aufgabe ist optional und ein bisschen was zum Knobeln).

Die Türme von Hanoi lassen sich sehr schön rekursiv lösen: 

1. Wir wissen, wie wir eine Scheibe (`n=1`) von einem Stab auf einen anderen verschieben können. Das ist der **Basisfall**, und er ist in der Funktion `movePiece` implementiert. 
2. Wenn wir einen Turm aus `n` (mit `n>1`) Scheiben von Stab `l` auf Stab `r` verschieben wollen, können wir a) `n-1` Scheiben von `l` auf `m` legen, b) die eine übrige Scheibe von `l` auf `r` legen, und c) `n-1` Scheiben von `m` auf `r` legen. Dabei handelt es sich dann um den Rekursionsschritt, den wir allerdings mehrfach benötigen.

Implementieren Sie dieses Verfahren in Java! In der Methode `runAutomatically()` finden Sie bereit eine Implementierung, die darin besteht, dass wir die Methode `movePieces()` aufrufen. Dies ist die rekursive Methode, die Sie implementieren sollen. 

Es macht das Leben leichter, sich den aktuellen Zustand der Türme anschauen zu können. Sie können dazu jederzeit die Zeile `System.out.println(this);` einfügen, um die "ASCII-Art"-Repräsentation der Türme zu sehen.

Hinweise:

- Für das verschieben einer einzelnen Scheibe sollte ausschließlich die Methode `movePiece(from, to)` verwendet werden. 

- Jeder einzelne Schritt sollte natürlich legal sein, d.h. den Anforderungen an die analogen Spielregeln genügen.



