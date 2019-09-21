package pack;

public class ArrayUtil {

    private int size;
    private short[] arr;

    public ArrayUtil() {
        this.size = 0;
    }

    public ArrayUtil(int size) {
        this.arr  = new short[size];
        this.size = size;
    }

    public ArrayUtil(short[] arr) {
        this.arr  = arr;
        this.size = arr.length;
    }

    public int size() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void show() {
        for (int value : arr) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public void showReverse() {
        for (int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public void fill(int a, int b) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (short)( (Math.random() * b + 1) - a);
        }
    }

    public void input() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter value [" + i + "]: ");
            arr[i] = Short.parseShort(System.console().readLine());
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
