import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        String[] companys = new String[]{"Lenuvo","Asos","MacNote","Eser","Xamiou"};
        Notebook[] notebooks = new Notebook[10000];
        for (int i = 0; i < notebooks.length; i++) {
            String company = companys[random.nextInt(companys.length)];
            int price = (random.nextInt(31)+10)*50; // цена от 500 до 2000 шаг 50
            int memory = (random.nextInt(6)+1)*4; // память от 4 до 24 шаг 4
            notebooks[i] = new Notebook(company,memory,price);
        }
        for (Notebook n:notebooks) {
            System.out.println(n.toString());
        }
        SortNotebooks.sort(notebooks);
        System.out.println("after sort");
        for (Notebook n:notebooks) {
            System.out.println(n.toString());
        }
    }
}
