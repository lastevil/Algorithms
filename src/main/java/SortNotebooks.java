import java.util.ArrayList;
import java.util.Arrays;

public class SortNotebooks {
    public static void sort(Notebook [] notebooks){
        selectionSort(notebooks);
        //ищем смену цены если в группе больше 1 ноутбука с одной ценой, сортируем.
        ArrayList indexes = new ArrayList<>();
        indexes.add(0);
        for (int i = 0; i < notebooks.length-1; i++) {
            if (notebooks[i].getPrice()!=notebooks[i+1].getPrice()){
                indexes.add(i+1);
            }
        }
        indexes.add(notebooks.length);
        //сортируем только там где больше 1 с одинаковой ценой.
        for (int i = 0; i < indexes.size()-1; i++) {
            int a = (int)indexes.get(i);
            int b =(int)indexes.get(i+1);
            if ( (b-a)>1){
                insertionSort(notebooks,a,b);
            }
        }
        //постороим индексы с ноутбуками с равной ценой и памятью.
        System.out.println("Первые индексы "+indexes);
        ArrayList memIndexes = new ArrayList<>();
        for (int i = 0; i < indexes.size()-1; i++) {
            int a = (int)indexes.get(i);
            int b =(int)indexes.get(i+1);
            if ( (b-a)>1){
                memIndexes.add(a);
                for (int m=a;m<b-1;m++){
                    if(notebooks[m].getMemory()!=notebooks[m+1].getMemory()){
                    memIndexes.add(m+1);
                    }
                }
                memIndexes.add(b);
            }
        }
        memIndexes.add(notebooks.length);
        //сортируем по названию только те у которых больше 2х в группе (одинаковая цена и память)
        System.out.println("Вторые индексы "+memIndexes);
       for (int i = 0; i < memIndexes.size()-1; i++) {
            int a = (int)memIndexes.get(i);
            int b =(int)memIndexes.get(i+1);
            if ( (b-a)>1){
                nameSort(notebooks,a,b);
            }
        }

}
private static void selectionSort(Notebook[] notebooks) {
    int end = notebooks.length;
    for (int i = 0; i < end - 1; i++) {
        int min = i;
        int max = i;
        boolean minfind = false;
        boolean maxfind = false;
        for (int j = min + 1; j < end; j++) {
            if (notebooks[j].getPrice() < notebooks[min].getPrice()) {
                min = j;
                minfind =true;
            }
            if (notebooks[j].getPrice() > notebooks[max].getPrice()) {
                max = j;
                maxfind = true;
            }
        }

        if (minfind && !maxfind){
            if(min!=end-1){
            Notebook temp = notebooks[end-1];
            notebooks[end-1]=notebooks[i];
            notebooks[i] = notebooks[min];
            notebooks[min] = temp;
            }
            if(min==end-1) {
                Notebook temp = notebooks[min];
                notebooks[min]=notebooks[i];
                notebooks[i]=temp;
            }

        }
        if (maxfind && !minfind) {
            Notebook temp = notebooks[end - 1];
            notebooks[end - 1] = notebooks[max];
            notebooks[max] = temp;
        }
        if(maxfind==minfind) {
            Notebook temp = notebooks[i];
            notebooks[i] = notebooks[min];
            notebooks[min] = temp;
            temp = notebooks[end - 1];
            notebooks[end - 1] = notebooks[max];
            notebooks[max] = temp;
        }
        end--;
    }
}
private static void insertionSort(Notebook[] notebooks, int begin, int end){
    for (int i = begin+1; i < end;i++){
        int j = i - 1;
        int value = notebooks[i].getMemory();
        while (j >= begin && notebooks[j].getMemory() > value) {
            Notebook tmp = notebooks[j+1];
            notebooks[j + 1] = notebooks[j];
            notebooks[j]=tmp;
            j--;
        }
    }
}
private static void nameSort(Notebook[] notebooks,int begin, int end){
        String[] companys = new String[]{"Lenuvo","Asos","MacNote","Eser","Xamiou"};
        for (int j=0;j<companys.length;j++){
            for (int i = begin; i < end;i++){
                if(notebooks[i].getCompany().equals(companys[j])){
                    Notebook tmp = notebooks[begin];
                    notebooks[begin]=notebooks[i];
                    notebooks[i]=tmp;
                    begin++;
                }
            }
        }
    }
}
