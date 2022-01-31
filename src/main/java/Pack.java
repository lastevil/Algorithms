public class Pack {
    private int maxWeight;
    private int bestPrice;
    private Thingth[] bestList;

    public Pack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setBestList(Thingth[] bestList) {
        this.bestList = bestList;
    }

    public void setBestPrice(int bestPrice) {
        this.bestPrice = bestPrice;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getBestPrice() {
        return bestPrice;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public Thingth[] getBest()
    {
        return bestList;
    }
}

