import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //System.out.println(Pow.pow(2,8));
        //System.out.println(Pow.pow(2,-5));
        //System.out.println(Pow.pow(4,0));

        //«Задача о рюкзаке»
        Random random = new Random();
        Thingth[] thingths = new Thingth[5];
        for (int i = 0; i < thingths.length; i++) {
            int price = (random.nextInt(4000) + 10); // цена от 500 до 2000 шаг 50
            int weight = random.nextInt(6)+1; // память от 4 до 24 шаг 4
            thingths[i] = new Thingth(price, weight);
        }
        System.out.println("\n"+Arrays.toString(thingths));
        //Создадим рюкзак с вместимостью ()
        Pack pack = new Pack(5);
        //найдем лучший вариант и оставим его в рюкзаке
        FindBest.allLists(thingths,pack);
        System.out.println("");
        System.out.println("Колличество вещей в рюкзаке: "+pack.getBest().length+" Общая сумма: "+pack.getBestPrice());
        System.out.println(Arrays.toString(pack.getBest()));
    }
}