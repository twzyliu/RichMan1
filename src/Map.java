import java.util.Arrays;
import java.util.List;

/**
 * Created by zyongliu on 11/11/16.
 */
public class Map {
    private List<Building> buildings;

    public Map(Building... buildings) {
        this.buildings = Arrays.asList(buildings);
    }

    public int getMapSize() {
        return buildings.size();
    }

    public Building getBuilding(int position) {
        return buildings.get(position);
    }


    public String checkPlayerPosition(Player player) {
        String name = getBuilding(player.getPosition()).getName();
        if (name.equals("E")) {
            player.setInputStatus(true);
        }
        return name;
    }
}
