package tasks;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;

/*!
    Дан текст, который содержит информацию о продажах в магазине и о каждой продаже известно:
    название товара (одно слово строчными буквами) и сумма.
    Продаж может быть несколько и информация по одной продаже завершается символом ;(точка с запятой).

    Реализовать функции:
    •	Найти сумму всех продаж.
    •	Отредактировать текст: название товара  должно начинаться с прописной буквы.
    •	Сформировать рейтинг товаров, учтенных в продажах (по количеству продаж). Результат представить строкой.
    •	Показать информацию по заданной по номеру продаже.
 */


import java.util.ArrayList;
import java.util.Map;

public class Task1 {

    private ArrayList<Sale> sales;
    private Map<String, Integer> rating;

    public Task1(List<String> lines) {
        this.sales = new ArrayList<Sale>();
        this.rating = new HashMap<String, Integer>();

        if (!lines.isEmpty()) {
            for (String line : lines) {
                for (String product : line.split(";")) {
                    String productData[] = product.split(" ");

                    if (productData.length == 2) {
                        String productName = productData[0];
                        int productPrice = Integer.parseInt(productData[1]);

                        sales.add(new Sale(productName, productPrice));
                    }
                }
            }
        }

        for (Sale product : this.sales) {
            String productName = product.getProductName();

            if (!productName.isEmpty()) {
                String letter = String.valueOf(productName.charAt(0)).toUpperCase();
                productName = letter + productName.substring(1);
            }

            product.setProductName(productName);
        }

        for (Sale product : this.sales) {
            String productName = product.getProductName();

            if (!this.rating.containsKey(productName)) {
                this.rating.put(productName, 1);
            } else {
                this.rating.put(productName, this.rating.get(productName) + 1);
            }
        }

    }

    public int getCountSales() {
        return this.sales.size();
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (Sale product : this.sales) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    public Map<String, Integer> getRating() {
        return this.rating;
    }

    public String getRatingAsString() {
        String rating = "";

        for (String key : this.rating.keySet()) {
            rating = rating.concat(key + " " + Integer.toString(this.rating.get(key)));
            rating = rating.concat(", ");
        }

        return rating;
    }

}
