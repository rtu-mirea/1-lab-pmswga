import Tasks.Task1.Task1;
import Tasks.Task2.Task2;
import Tasks.Task3.Task3;
import utils.FileReader;

import java.util.*;

/*!
    Вариант заданий №3
 */

public class Main {

    private static void task1() {
        Task1 task1 = new Task1(FileReader.getText("sales.txt"));

        System.out.println("Count sales: " + Integer.toString(task1.getCountSales()));
        System.out.println("Total price: " + Integer.toString(task1.getTotalPrice()) + " RUB");
        System.out.print("Rating of goods: ");
        System.out.println(task1.getRatingAsString());

        Scanner input = new Scanner(System.in);
        int saleId = 0;

        System.out.print("Enter sale id (1, 100): ");
        saleId = input.nextInt();

        if (saleId > 0 && saleId < task1.getCountSales()) {
            System.out.println("Sale #" + Integer.toString(saleId) + " is " + task1.getSaleByID(saleId));
        }

        //input.close();
    }

    private static void task2() {
        Task2 task2 = new Task2(FileReader.getText("sales.txt"));

    }

    private static void task3() {
        // USA date format: MM/DD/YYYY
        // RUS date format: DD.MM.YYYY

        String text = FileReader.getText("dates.txt");

        Task3 task3 = new Task3(text);

        System.out.println("All correct dates (USA and RUS formats): ");
        System.out.println(task3.getValidatedDates());

        System.out.println("Replaced USA dates to RUS dates: ");
        System.out.println(task3.usaDate2rusDate());

    }

    public static void main(String args[]) {
        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Task 1");
                System.out.println("2. Task 2");
                System.out.println("3. Task 3");
                System.out.println("4. Exit");
                System.out.print(":>");
                switch (input.nextInt()) {
                    case 1: {
                        Main.task1();
                    } break;
                    case 2: {
                        Main.task2();
                    } break;
                    case 3: {
                        Main.task3();
                    } break;
                    case 4: {
                        System.out.println("Goodbye!");
                        input.close();
                        System.exit(0);
                    } break;
                    default: {
                        System.out.println("Input error, please try again");
                    } break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
