package Aufgabe3;

public class QueueList2 implements QueueListInterface {

    int list[] = new int[5];
    int popFrontCount = 0;

    private int firstIndex() {
        if (popFrontCount > list.length - 1) {
            popFrontCount -= list.length;
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
        int i = lastIndex();
        while (i != firstIndex()) {
            if (list[i] != 0) {
                temp = list[i];
                list[i] = 0;
                break;
            } else {
                if (i == 0) {
                    i = list.length - 1;
                } else {
                    i--;
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

        int temp = -1;
        int j = lastIndex();
        while (j != firstIndex()) {
            if (list[j] != 0) {
                temp = list[i];
                if (j == list.length - 1) {
                    list[0] = i;
                } else {
                    list[j + 1] = i;
                }
                break;
            } else {
                if (j == 0) {
                    j = list.length - 1;
                } else {
                    j--;
                }
            }
        }
        return temp;

    }

    @Override
    public int pushFront(int i) {
        int temp = -1;
        if (list[lastIndex()] != 0) {
            list = doubleArrayLenght(list);
        }
        if (list[firstIndex()] != 0) {
            int j = lastIndex();
            while(j!=firstIndex()) {
                if(j!=0 && j != list.length - 1) {
                list[j + 1] = list[j];
                } else if (j == list.length - 1) {


                }
            }



        }
        list[firstIndex()] = i;
        if (list[firstIndex()] != 0) {
            temp = list[0];
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
        for (int i = 0; i < array2Coppy.length; i++) {
            temp[i] = array2Coppy[i];
        }
        return temp;
    }

    public void printQueue() {
        System.out.println();
        System.out.println("Queue List");
        System.out.println();
        for(int i : list) {
            System.out.print(i + " ");
        }

        System.out.println("FrontCount :" + popFrontCount + "FirstIndex :" + firstIndex() + "LastIndex :" + lastIndex());
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