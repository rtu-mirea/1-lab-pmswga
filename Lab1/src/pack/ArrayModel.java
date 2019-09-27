package pack;

import java.util.Scanner;

public class ArrayModel {

    private int     size;
    private short[] arr;

    public ArrayModel() {
        this.size = 0;
    }

    public ArrayModel(int size) {
        this.arr  = new short[size];
        this.size = size;
    }

    public ArrayModel(short[] arr) {
        this.arr  = arr;
        this.size = arr.length;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.arr  = new short[size];
        this.size = size;
    }
    
    public short[] getModel() {
        return this.arr;
    }

    public void fill(int a, int b) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (short)( (Math.random() * b + 1) - a);
        }
    }

    public void input() {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter value [" + i + "]: ");
            arr[i] = input.nextShort();
        }
    }

    public int getCount(short search) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > search) {
                count++;
            }
        }

        return count;
    }

    public void sort()
    {
        short key;

        for (int i = 1, j = i - 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }

}
