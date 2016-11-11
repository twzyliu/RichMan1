/**
 * Created by zyongliu on 11/11/16.
 */
public class Building {
    private String Name;

    private int price;

    public Building(String name, int price) {
        this.Name = name;
        this.price = price;
    }

    public Building(String name) {
        this.Name = name;
        this.price = 0;
    }

    public String getName() {
        return Name;
    }

    public int getPrice() {
        return price;
    }
}
