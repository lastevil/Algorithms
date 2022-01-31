public class Thingth {
    private int price;
    private int weight;
    private int index;

    public Thingth(int price,int weight){
        this.price=price;
        this.weight=weight;
        this.index = this.hashCode()/100000;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Вещь(" +index+
                ") [Цена: " + price +
                ", Масса: " + weight +
                ']';
    }
}
