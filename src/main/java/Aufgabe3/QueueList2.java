package Aufgabe3;

public class QueueList2 implements QueueListInterface {

    int list[] = new int[5];
    protected int popFrontCount = 0;
    protected int popLastCount = 0;
    protected boolean firstEntry=true;

    private int lastIndex (){
        while (popLastCount > list.length -1){
            popLastCount -= list.length;
        }
        while (popLastCount < 0){
            popLastCount+= list.length;
        }
        return popLastCount;
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
        }
        return temp;
    }

    @Override
    public int popLast() {
        int temp = -1;
        if (list[firstIndex()] != 0) {
                    temp = list[lastIndex()];
                    list[lastIndex()] = 0;
                    popLastCount--;
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
            popLastCount++;
            list[lastIndex()] = i;
            temp = list[lastIndex()];
        }else {
            list[lastIndex()] = i;
            temp = list[lastIndex()];
            firstEntry=false;
        }
        return temp;
    }


    public boolean queueListFull() {
           popFrontCount--;
        if(firstIndex() == lastIndex()) {
            popFrontCount++;
            return true;
        }else{
            popFrontCount++;
            return false;
        }
    }

    @Override
    public int pushFront(int i) {
        int temp = -1;
        if (queueListFull()) {   //Change array full condition
            list = doubleArrayLenght(list);
        }
        if (!firstEntry) {
            popFrontCount--;
            list[firstIndex()] = i;
            temp = list[firstIndex()];
        } else {
            list[firstIndex()] = i;
            temp = list[firstIndex()];
            firstEntry = false;
        }
        return temp;
    }

    @Override
    public int get(int i) {
        if (list[i] != 0) {
            return list[i];
        }
        return -1;
    }

    private int[] doubleArrayLenght(int[] array2Coppy) {
        int[] temp = new int[array2Coppy.length * 2];
        int j = 0;

        if (firstIndex() != 0) {
            for (int i = firstIndex(); i <= array2Coppy.length-1; i++) {
                temp[j] = array2Coppy[i];
                j++;
            }
            for (int i = 0; i <= lastIndex(); i++) {
                temp[j] = array2Coppy[i];
                j++;
            }
        }else {
            for (int i = 0; i <= lastIndex(); i++) {
                temp[j] = array2Coppy[i];
                j++;
            }
        }
        popFrontCount = 0;
        popLastCount = array2Coppy.length-1;
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
        }else{
            for ( int i = 0; i <= lastIndex(); i++){
              //  if(i != 0) {
                    System.out.print(list[i] + " ");
              //  }
            }
        }
        System.out.println();
        System.out.println("FrontCount: " + popFrontCount + " FirstIndex: " + firstIndex() + " LastIndex: " + lastIndex());
    }
}
