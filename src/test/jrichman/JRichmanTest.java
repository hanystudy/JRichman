package test.jrichman;

import main.jrichman.EstateRoom;
import main.jrichman.Player;
import main.jrichman.PlayerStatus;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JRichmanTest{

    @Test
    public void shouldHavePlayerStatus()
    {
        PlayerStatus playerstat = new PlayerStatus("Tom","T",10000,0);
        assertThat(playerstat.getNickname(),is("Tom"));
        assertThat(playerstat.getMoney(),is(10000));
        assertThat(playerstat.getPoint(),is(0));
    }

    @Test
    public void shouldHavePlayer() throws Exception {
        PlayerStatus playerStatus = new PlayerStatus("Tom","T",10000,0);
        Player player = new Player(playerStatus);
        assertThat(player.getStatus().getNickname(), is("Tom"));
    }

    @Test
    public void shouldBuyAEstateRoom() throws Exception {
        PlayerStatus playerStatus = new PlayerStatus("Tom","T",10000,0);
        Player player = new Player(playerStatus);

        EstateRoom estateRoom = new EstateRoom(200,0);
        estateRoom.cost(player, estateRoom.getPrice());
        assertThat(player.getStatus().getMoney(),is(10000-200));
    }

    @Test
    public void shouldCostAStranger() throws Exception {
        PlayerStatus playerStatus = new PlayerStatus("Tom","T",10000,0);
        Player player = new Player(playerStatus);
        EstateRoom estateRoom = new EstateRoom(200,0);
        player.buyEstateRoom(estateRoom);
    }
}