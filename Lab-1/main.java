import pack.*;

class Main {

    static public void main(String args[]) {
        short input;
        short arr[] = new short[10];
        
        ArrayFiller.fill(arr, 0, 20);

        System.out.print("Source array: ");
        ArrayOutput.show(arr);
        
        System.out.print("Enter value: ");
        input = Short.parseShort(System.console().readLine());

        System.out.println("Count of elements more than " + input + " = " + ArrayCounter.getCount(input, arr));

        ArraySorter.sort(arr);
        System.out.print("Sorted array: ");
        ArrayOutput.show(arr);
    }

}