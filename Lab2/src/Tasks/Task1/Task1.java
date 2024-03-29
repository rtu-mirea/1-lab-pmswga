package Tasks.Task1;

import Tasks.Sale;

import java.util.HashMap;

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

    public Task1(String text) {
        this.sales = new ArrayList<Sale>();
        this.rating = new HashMap<String, Integer>();

        if (!text.isEmpty()) {
            String []products = text.split(";");

            for (String product : products) {
                String []productData = product.split(" ");

                if (productData.length == 2) {
                    sales.add(new Sale(productData[0], Integer.parseInt(productData[1])));
                }
            }
        }

        this.productNameToUpperCase();
        this.formirateRating();
    }

    private void productNameToUpperCase() {
        for (Sale product : this.sales) {
            String productName = product.getProductName();

            if (!productName.isEmpty()) {
                productName = String.valueOf(productName.charAt(0)).toUpperCase() + productName.substring(1);
            }

            product.setProductName(productName);
        }
    }

    private void formirateRating() {
        for (Sale product : this.sales) {
            String productName = product.getProductName();

            if (!this.rating.containsKey(productName)) {
                this.rating.put(productName, 1);
            } else {
                this.rating.put(productName, this.rating.get(productName) + 1);
            }
        }
    }


    public Sale getSaleByID(int saleId) {
        return this.sales.get(saleId-1);
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
            rating = rating.concat(",");
        }

        return rating;
    }

}
