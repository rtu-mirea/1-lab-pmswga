import tasks.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Path;

/*!
    Вариант заданий №3
 */


public class Main {

    public static void generateSales() {
        ArrayList<String> goods = new ArrayList<String>();
        goods.add("молоко");
        goods.add("сыр");
        goods.add("колбаса");
        goods.add("сок");
        goods.add("мясо");
        goods.add("рыба");

        Random rand = new Random();

        for(int i = 0; i < 100; i++) {
            System.out.print(goods.get(rand.nextInt(goods.size())));
            System.out.print(" ");
            System.out.print(rand.nextInt(1000) + 50);
            System.out.println(";");
        }

    }

    private static void task1() {
        File file = new File(".", "sales.txt");
        String text = "";

        try {
            if (file.exists()) {
                if (file.canRead()) {
                    List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

                    for (String line : lines) {
                        text = text.concat(line);
                    }
                }
            } else {
                System.out.println("File not exists");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Task1 task1 = new Task1(text);

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

        input.close();
    }

    private static void task2() {

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
        Main.task3();
        System.exit(0);

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("1. Task 1");
            System.out.println("2. Task 2");
            System.out.println("3. Task 3");
            System.out.println("4. Exit");
            System.out.print(":>");
            switch (input.nextInt()) {
                case 1: {
                    Main.task1();
                }
                break;
                case 2: {
                    Main.task2();
                }
                break;
                case 3: {
                    Main.task3();
                }
                break;
                default: {
                    System.out.println("Input error, please try again");
                }
                break;
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

}
