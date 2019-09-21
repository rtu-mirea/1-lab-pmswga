package pack;

public class ArrayFiller {

    static public void fill(short arr[], int a, int b) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (short)( (Math.random() * b + 1) - a);
        }
    }

}
