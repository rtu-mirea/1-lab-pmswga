package Tasks.Task2;

import Tasks.Sale;

import java.util.ArrayList;

/*!
    Дан текст, который содержит информацию о продажах в магазине и о каждой продаже известно:
    название товара (одно слово строчными буквами) и сумма.
    Продаж может быть несколько и информация по одной продаже завершается символом ;(точка с запятой).

    Реализовать функции:
    • Удалить из текста сведения о продажах с суммой равной 0.
    • Найти информацию о продаже, имеющей наименьшую длину. Заменить эту продажу на продажу наибольшего размера.
    • Добавить новую продажу в текст.
 */

public class Task2 {

    private ArrayList<Sale> sales;

    public Task2(String text) {
        this.sales = new ArrayList<Sale>();

        if (!text.isEmpty()) {
            String []products = text.split(";");

            for (String product : products) {
                String []productData = product.split(" ");

                if (productData.length == 2) {

                    if (Integer.parseInt(productData[1]) > 0) {
                        sales.add(new Sale(productData[0], Integer.parseInt(productData[1])));
                    }

                }
            }
        }

    }

    public void addNewSale(Sale sale) {
        this.sales.add(sale);
    }

    public ArrayList<Sale> getSales() {
        return this.sales;
    }

    public String getSalesAsString() {
        StringBuffer salesText = new StringBuffer();
        for (Sale sale : this.sales) {
            salesText.append(sale.getProductName()).append(" ").append(sale.getPrice()).append(";");
        }

        return salesText.toString();
    }

}
