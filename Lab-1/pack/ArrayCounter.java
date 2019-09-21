package pack;

public class ArrayCounter {

    static public int getCount(short search, short array[]) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= search) {
                count++;
            }
        }

        return count;
    }

}
