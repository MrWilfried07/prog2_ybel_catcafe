## -Was sind Vorteile, was sind Nachteile dieser Modellierung?

Die Modellierung des Binärbaums mit den Klassen Tree, Empty und Node ermöglicht eine klare Trennung zwischen leeren und belegten Knoten.
    Dies führt zu einer sauberen, rekursiven Struktur, die leicht zu verstehen und zu erweitern ist.

Vorteile sind die einfache Handhabung von leeren Knoten ohne Nullwerte und die klare Trennung von Baumzuständen.
    Nachteile sind der etwas höhere Implementierungsaufwand und der potenzielle Speicherverbrauch durch viele kleine Objekte.



## Was musste getan werden, um die selbst implementierten Bäume in Schleifen (Tree<X> mytree; for (Tree<X> t: mytree) {...}) und in Streams Tree<X> mytree; mytree.stream(). ... nutzen zu können?

Um die Bäume in einer for-each-Schleife und mit Streams nutzen zu können, musste das Interface Tree<T> das Interface Iterable<T> implementieren.
    Dadurch kann man einen Iterator über die Baumknoten erhalten. Zusätzlich wurde eine stream()-Methode definiert, die auf diesem Iterator basiert, um die Vorteile der Stream-API von Java zu nutzen.


## Wie funktioniert der TreeIterator?

Der TreeIterator arbeitet mit einem Stack und einer Inorder-Traversierung.
Er speichert alle linken Knoten eines Teilbaums auf dem Stack.
Beim Aufruf von next() wird der oberste Knoten vom Stack genommen, dessen Wert zurückgegeben und anschließend der rechte Teilbaum durchlaufen, indem dessen linke Knoten wieder auf den Stack gelegt werden. So wird der Baum effizient in Inorder-Reihenfolge durchlaufen, ohne Rekursion zu verwenden.
