package Aufgabe2;

import java.util.Queue;

public class QueueList implements QueueListInterface {
    int maxSize = 5;
    int list[] = new int[maxSize];



    @Override
    public int popFront() {
        int temp = list[0];//ersten Wert zwischenspeichern
        for (int i = 0; i < list.length-1; i++) {//alle Werte um einen Platz nach vorne schieben
            list[i]= list[i+1];
        }
        return temp;
    }

    @Override
    public int popLast() {
        int tempCount=maxSize;
        while(list[tempCount-1]!=0){
            
        }
        
        int temp = 0;
        
        return temp;
    }

    @Override
    public int pushLast(int i) {
        return 0;
    }

    @Override
    public int pushFront(int i) {
        return 0;
    }

    @Override
    public int get(int i) {
        return 0;
    }
}
