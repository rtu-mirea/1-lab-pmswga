import pack.*;

import java.util.Scanner;
import java.util.Scanner.*;

class MainController {

    static public void main(String args[]) {
        int size = 0;
        short value = 0;

        Scanner input = new Scanner(System.in);

        ArrayModel model = new ArrayModel();
        ArrayView view = new ArrayView();
        view.setModel(model);

        System.out.print("Enter size of array: ");

        size = Integer.parseInt( input.nextLine() );

        model.setSize(size);

        System.out.println("1. Random fill");
        System.out.println("2. Manual fill");

        System.out.print("Enter: ");

        switch (Integer.parseInt( input.nextLine() ) )
        {
            case 1: {
                model.fill(0, 100);
            } break;
            case 2: {
                model.input();
            } break;
        }

        System.out.print("Source array: ");
        view.view();
        
        System.out.print("Enter value: ");
        value = Short.parseShort( input.nextLine() );

        System.out.println("Count of elements more than " + value + " = " + model.getCount((short)value));

        model.sort();
        System.out.print("Sorted array: ");
        view.viewReverse();
    }

}