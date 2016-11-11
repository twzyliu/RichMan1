import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyongliu on 11/11/16.
 */
public class Player {
    private String name;
    private int position = 0;
    private String input = "";
    private List<Building> buildings = new ArrayList<>();
    private int money = 10000;
    private boolean inputStatus = false;
    private int turn = 0;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void roll(int step, int mapSize) {
        position = (position + step) % mapSize;
    }

    public int getPosition() {
        return position;
    }

    public boolean getInputStatus() {
        return inputStatus;
    }

    public void setInputStatus(boolean inputStatus) {
        this.inputStatus = inputStatus;
    }

    public boolean sayYes() {
        if (getInputStatus()) {
            input = "Y";
            return true;
        }
        input = "";
        return false;
    }

    public boolean buyBuilding(Building e) {
        if (input.equals("Y") & money >= e.getPrice()) {
            buildings.add(e);
            money -= e.getPrice();
            return true;
        }
        return false;
    }

    public int getMoney() {
        return money;
    }

    public int getTurn() {
        return turn;
    }

    public boolean sayNo() {
        turn += 2;
        return true;
    }
}
