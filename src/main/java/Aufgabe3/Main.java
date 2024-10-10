package Aufgabe3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueList2 list = new QueueList2();
        int toDo = 0;
        while (toDo != -1) {
            System.out.println();
            System.out.println("Was möchtest du machen?");
            System.out.println(" (1)  Erstes Element löschen");
            System.out.println(" (2)  Letztes Element löschen");
            System.out.println(" (3)  Objekt am Ende einfügen");
            System.out.println(" (4)  Objekt am Anfang hinzufügen");
            System.out.println(" (5)  Ein bestimmtes Element auslesen?");
            System.out.println(" (-1) Programm beenden");
            toDo = sc.nextInt();

            if (toDo == 1) {

                System.out.println("Das Element " + list.popFront() + " wurde gelöscht");


            } else if (toDo == 2) {
                System.out.println("Das Element " + list.popLast() + " wurde gelöscht");


            } else if (toDo == 3) {
                System.out.println("Was möchtest du hinzufügen?");
                int input = sc.nextInt();
                System.out.println("Das Objekt " + list.pushLast(input) + " wurde der Warteschlange am Ende hinzugefügt!");


            } else if (toDo == 4) {
                System.out.println("Was möchtest du hinzufügen?");
                int input = sc.nextInt();
                System.out.println("Das Objekt " + list.pushFront(input) + " wurde der Warteschlange am Anfang hinzugefügt!");

            } else if (toDo == 5) {
                System.out.println("Welches Element willst du auslesen?");
                int input = sc.nextInt();
                System.out.println("Das " + input + ". Element der Queue ist " + list.get(input) + ".");

            }
            list.printQueue();
        }


    }


}
