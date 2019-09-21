package pack;

public class ArraySorter {
        
    static public void sort(short arr[])
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
