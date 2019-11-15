package utils;

import java.util.ArrayList;
import java.util.Random;

public class SalesSeeder {

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

}
