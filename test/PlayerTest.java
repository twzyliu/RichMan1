import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zyongliu on 11/11/16.
 */
public class PlayerTest {

    public static final int STEP = 1;
    private Map map;
    private Building e;

    @Before
    public void setUp() throws Exception {
        e = new Building("E", 200);
        map = new Map(new Building("S"), e);
    }

    @Test
    public void should_go_to_empty_land_when_player_roll_empty_land() throws Exception {
        Player player = new Player("A");
        player.roll(STEP, map.getMapSize());
        assertThat(map.checkPlayerPosition(player), is("E"));
    }

    @Test
    public void should_waitting_for_input_when_player_go_to_a_empty_land() throws Exception {
        Player player = new Player("A");
        player.roll(STEP, map.getMapSize());
        map.checkPlayerPosition(player);
        assertThat(player.getInputStatus(), is(true));
    }

    @Test
    public void should_say_yes_after_player_go_to_a_empty_land() throws Exception {
        Player player = new Player("A");
        player.roll(STEP, map.getMapSize());
        map.checkPlayerPosition(player);
        assertThat(player.sayYes(), is(true));
    }

    @Test
    public void should_buy_empty_land_when_money_enough() throws Exception {
        Player player = new Player("A");
        player.roll(STEP, map.getMapSize());
        map.checkPlayerPosition(player);
        player.sayYes();
        int money = player.getMoney();
        assertThat(player.buyBuilding(e), is(true));
        assertThat(player.getMoney(), is(money - e.getPrice()));
    }

    @Test
    public void should_not_buy_empty_land_when_no_enough_money() throws Exception {
        Player player = new Player("A", 0);
        player.roll(STEP, map.getMapSize());
        map.checkPlayerPosition(player);
        player.sayYes();
        int money = player.getMoney();
        assertThat(money < e.getPrice(), is(true));
        assertThat(player.buyBuilding(e), is(false));
    }

    @Test
    public void should_end_turn_after_player_say_no() throws Exception {
        Player player = new Player("A", 0);
        player.roll(STEP, map.getMapSize());
        map.checkPlayerPosition(player);
        int turn = player.getTurn();
        assertThat(player.sayNo(), is(true));
        assertThat(player.getTurn() > turn, is(true));
    }
}
