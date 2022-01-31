public class FindBest {

    //Общая стоимость предметов
    public static int calcPrice(Thingth[] arr)
    {
        int sumPrice = 0;
        for (Thingth i : arr) {
            sumPrice += i.getPrice();
        }
        return sumPrice;
    }

    //Общий вес предметов
    public static int calcWeigth(Thingth[] arr) {
        int sumWeigth = 0;
        for (Thingth i : arr) {
            sumWeigth += i.getWeight();
        }
        return sumWeigth;
    }

    //создадим набор из всх вариаций значений
    public static void allLists(Thingth[] arr, Pack pack) {
        if (arr.length > 0)
            //проверим массив
            checkBest(arr,pack);
        for (int i = 0; i < arr.length; i++) {
            Thingth[] temp = arr.clone();
            for (int j=i;j<temp.length-1;j++){
                temp[j]=temp[j+1];
            }
            Thingth[] newList = new Thingth[temp.length-1];
            for (int j=0;j<temp.length-1;j++){
                newList[j]=temp[j];
            }
            allLists(newList,pack);
        }
    }

    //проверим лучший ли массив
    private static void checkBest(Thingth[] arr, Pack pack) {
        if (pack.getBest() == null) {
            if (calcWeigth(arr) <= pack.getMaxWeight()) {
                pack.setBestList(arr);
                pack.setBestPrice(calcPrice(arr));
            }
        }
        else {
            if(calcWeigth(arr) <= pack.getMaxWeight() && calcPrice(arr) > pack.getBestPrice()) {
                pack.setBestList(arr);
                pack.setBestPrice(calcPrice(arr));
            }
        }
    }
}
