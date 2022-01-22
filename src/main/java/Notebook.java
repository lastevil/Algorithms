public class Notebook{

    private final String company;
    private final int price;
    private final int memory;

    public Notebook(String company, int memory, int price) {
        this.company = company;
        this.price = price;
        this.memory = memory;
    }
    public String getCompany() {
        return company;
    }

    public int getPrice() {
        return price;
    }

    public int getMemory() {
        return memory;
    }
    @Override
    public String toString() {
        return "Notebook: " +
             + price + "$ " +
                + memory + " Gb "
                + company +
                " ";
    }

}
