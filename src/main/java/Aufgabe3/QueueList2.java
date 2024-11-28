package Aufgabe3;

public class QueueList2 implements QueueListInterface {

    int list[] = new int[5];
    protected int popFrontCount = 0;
    protected int pushLastCount = 0;
    protected int countEntries = 0;
    protected boolean firstEntry = true;

    private int lastIndex() {
        while (pushLastCount > list.length - 1) {
            pushLastCount -= list.length;
        }
        while (pushLastCount < 0) {
            pushLastCount += list.length;
        }
        return pushLastCount;
    }

    private int firstIndex() { //erster Index ist immer zwischen
        while (popFrontCount > list.length - 1) {
            popFrontCount -= list.length;
        }
        while (popFrontCount < 0) {
            popFrontCount += list.length;
        }
        return popFrontCount;
    }

    @Override
    public int popFront() {
        int temp = -1;
        if (list[firstIndex()] != 0) {
            temp = list[firstIndex()];
            list[firstIndex()] = 0;
            popFrontCount++;
            countEntries--;
        }
        return temp;
    }

    @Override
    public int popLast() {
        int temp = -1;
        if (list[firstIndex()] != 0) {
            temp = list[lastIndex()];
            list[lastIndex()] = 0;
            pushLastCount--;
            countEntries--;
            return temp;
        }
        return temp;
    }


    @Override
    public int pushLast(int i) {
        int temp = -1;
        if (queueListFull()) {   //Change array full condition
            list = doubleArrayLenght(list);
        }
        if (!firstEntry) {
            pushLastCount++;
            countEntries++;
            list[lastIndex()] = i;
            temp = list[lastIndex()];
        } else {
            list[lastIndex()] = i;
            temp = list[lastIndex()];
            firstEntry = false;
            countEntries++;
        }
        return temp;
    }


    @Override
    public int pushFront(int i) {
        int temp = -1;
        if (queueListFull()) {   //Change array full condition
            list = doubleArrayLenght(list);
        }
        if (!firstEntry) {
            popFrontCount--;
            countEntries++;
            list[firstIndex()] = i;
            temp = list[firstIndex()];
        } else {
            list[firstIndex()] = i;
            temp = list[firstIndex()];
            firstEntry = false;
            countEntries++;
        }
        return temp;
    }

    @Override
    public int get(int i) {
        int actualIndex = firstIndex();
        if (    (i < firstIndex() && firstIndex() == 0) ||              //unter 0 und first index = 0
                (i > countEntries) ||                                   // über last index und kleiner als first index
                (i > lastIndex() + 1 && lastIndex() > firstIndex()))    //über lastindex wenn lastindex gleich listen länge
        {
            return -1;
        } else {
            for (int j = 1; j < i; j++) {

                actualIndex += 1;
                if (actualIndex > list.length - 1) {
                    actualIndex -= list.length;
                }
            }
            return list[actualIndex];
        }
    }

    public boolean queueListFull() {
        popFrontCount--;
        if (firstIndex() == lastIndex()) {
            popFrontCount++;
            return true;
        } else {
            popFrontCount++;
            return false;
        }
    }


    private int[] doubleArrayLenght(int[] array2Coppy) {
        int[] temp = new int[array2Coppy.length * 2];
        int j = 0;

        if (firstIndex() != 0) {
            for (int i = firstIndex(); i <= array2Coppy.length - 1; i++) {
                temp[j] = array2Coppy[i];
                j++;
            }
            for (int i = 0; i <= lastIndex(); i++) {
                temp[j] = array2Coppy[i];
                j++;
            }
        } else {
            for (int i = 0; i <= lastIndex(); i++) {
                temp[j] = array2Coppy[i];
                j++;
            }
        }
        popFrontCount = 0;
        pushLastCount = array2Coppy.length - 1;
        return temp;
    }

    public void printQueue() {
        System.out.println();
        System.out.println("Queue List");
        System.out.println();

        if (firstIndex() != 0) {
            for (int i = firstIndex(); i < list.length; i++) {
                // if( list[i] != 0) {
                System.out.print(list[i] + " ");
                // }
            }
            for (int i = 0; i <= lastIndex(); i++) {
                //  if( list[i] != 0) {
                System.out.print(list[i] + " ");
                //  }
            }
        } else {
            for (int i = 0; i <= lastIndex(); i++) {
                //  if(i != 0) {
                System.out.print(list[i] + " ");
                //  }
            }
        }
        System.out.println();
        System.out.println("FrontCount: " + popFrontCount + " FirstIndex: " + firstIndex() + " LastIndex: " + lastIndex());
    }


    public int getFirstIndex() {
        return firstIndex();
    }

    public int getLastIndex() {
        return lastIndex();
    }


}
