import pack.*;

class Main {

    static public void main(String args[]) {
        int input = 0, size = 0;
        short value = 0;
        ArrayUtil arrayUtil = new ArrayUtil();

        System.out.print("Enter size of array: ");
        size = Integer.parseInt(System.console().readLine());

        arrayUtil.setSize(size);

        System.out.println("1. Random fill");
        System.out.println("2. Manual fill");

        System.out.print("Enter: ");
        input = Integer.parseInt(System.console().readLine());

        switch (input)
        {
            case 1: {
                arrayUtil.fill(0, 100);
            } break;
            case 2: {
                arrayUtil.input();
            } break;
        }

        System.out.print("Source array: ");
        arrayUtil.show();
        
        System.out.print("Enter value: ");
        value = Short.parseShort(System.console().readLine());

        System.out.println("Count of elements more than " + input + " = " + arrayUtil.getCount((short)value));

        arrayUtil.sort();
        System.out.print("Sorted array: ");
        arrayUtil.showReverse();
    }

}