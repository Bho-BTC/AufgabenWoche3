package Aufgabe3;

public class QueueList2 implements QueueListInterface {

    int list[] = new int[5];
    int popFrontCount = 0;

    private int firstIndex() { //erster Index ist immer zwischen
        while (popFrontCount > list.length - 1) {
            popFrontCount -= list.length;
        }
        while (popFrontCount < 0) {
            popFrontCount += list.length;
        }
        return popFrontCount;
    }

    private int lastIndex() {
        int i = firstIndex();
        for (int j = list.length; j > 0; j--) {
            i++;
            if (i > list.length) {
                i -= list.length;
            }
        }
        return i - 1;
    }
    // [2] [3] [4] [5] [0] [1]

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
        if (firstIndex() != 0) {
            //         4 2 0 0 1 2
            for (int i = lastIndex(); i >= 0; i--) {
                if (list[i] != 0) {
                    temp = list[i];
                    list[i] = 0;
                    break;
                }
            }
            for (int i = list.length - 1; i >= firstIndex(); i--) {
                if (list[i] != 0) {
                    temp = list[i];
                    list[i] = 0;
                    break;
                }
            }
        }
        return temp;
    }


    @Override
    public int pushLast(int i) {
        if (list[lastIndex()] != 0) {
            list = doubleArrayLenght(list);
        }
        //         4 2 0 0 1 2
        for (int a = firstIndex(); a < list.length; a++) {
            if (list[a] == 0) {
                list[a] = i;
                return i;
            }
        }
        for (int a = 0; a <= lastIndex(); a++) {
            if (list[a] == 0) {
                list[a] = i;
                return i;
            }
        }

        return -1;
    }

    @Override
    public int pushFront(int i) {
        int temp = -1;
        if (list[lastIndex()] != 0) {
            list = doubleArrayLenght(list);
        }

        if (list[firstIndex()] != 0) {
            popFrontCount--;
            list[firstIndex()] = i;
            temp = list[firstIndex()];
        } else {

            list[firstIndex()] = i;
            temp = list[firstIndex()];
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

        return temp;
    }

    public void printQueue() {
        System.out.println();
        System.out.println("Queue List");
        System.out.println();

        if (firstIndex() != 0) {
            for (int i = firstIndex(); i < list.length; i++) {
                if( list[i] != 0) {
                    System.out.print(list[i] + " ");
                }
            }
            for (int i = 0; i <= lastIndex(); i++) {
                if( list[i] != 0) {
                    System.out.print(list[i] + " ");
                }
            }
        }else{
            for ( int i : list){
                if(i != 0) {
                    System.out.print(i + " ");
                }

            }
        }

 /*
        int j =0;
        for(int i : list) {
            System.out.print("I:"+ j+ " = "+ i + " |");
            j++;
        }*/
        System.out.println();
        System.out.println("FrontCount: " + popFrontCount + " FirstIndex: " + firstIndex() + " LastIndex: " + lastIndex());
    }


}


/*
  for (int j = lastIndex(); j != firstIndex(); j--) {
        if (list[j] != 0) {
list[j + 1] = i;
                return i;
            } else if (j == 0 && list[j] == 0) {
list[j] = i;
                return i;
            }
                    }
                    return -1;










else if (list[0] == 0) {
System.out.println("Die Queue List ist leer.");
break;
} else {
break;
}


 int i = firstIndex();
        for (int j = list.length; j > 0; j--) {
            System.out.print(list[i] + " ");

            if (i == list.length - 1) {
                i = 0;
            } else {
                i++;
            }

        }
*/