package test.jrichman;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.TypeCheckError;
import main.jrichman.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: hanyi
 * Date: 2/11/13
 * Time: 7:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class JRichmanMapTest {

    @Test
    public void shouldHaveSize()
    {
        Size size = new Size(100,100);
        assertThat(size.getWidth(),is(100));
        assertThat(size.getHeight(),is(100));
    }

    @Test
    public void shouldHaveMapSize()
    {
    }

    @Test
    public void shouldHaveEstateRoom(){
        EstateRoom estateRoom = new EstateRoom(200,0);
        estateRoom.setPrice(100);
        assertThat(estateRoom.getPrice(), is(100));
    }

    @Test
    public void shouldHaveEstateOwner() {
        EstateRoom estateRoom = new EstateRoom(200,0);
        PlayerStatus playerStatus = new PlayerStatus("Tom","T",10000,0);
        Player player = new Player(playerStatus);
        estateRoom.setOwner(player);
        assertThat(estateRoom.getOwner(),is(player));
    }

    @Test
    public void shouldHavePropsRoom() throws Exception {

        PlayerStatus playerStatus = new PlayerStatus("Tom","T",10000,0);
        Player player = new Player(playerStatus);
        PropsRoom propsRoom = new PropsRoom();
        propsRoom.execute(player);

    }

    @Test
    public void shouldHavePlayerKilled() throws Exception {
        PlayerStatus playerStatus = new PlayerStatus("Tom","T",10000,0);
        Player player = new Player(playerStatus);
        EstateRoom estateRoom = new EstateRoom(200,1);
        estateRoom.setOwner(player);
        PlayerStatus bplayerStatus = new PlayerStatus("Jack","J",10,0);
        Player bplayer = new Player(bplayerStatus);
        estateRoom.punish(bplayer);
        assertThat(bplayer.isLive(),is(false));
    }

    @Test
    public void shouldPrintMap() throws Exception {
        MainLoop mainLoop = new MainLoop();
        mainLoop.printMap();
    }

    @Test
    public void shouldSetEnvironment() throws Exception {
        String input = "150\n15000\n2435\n42";
        MainLoop mainLoop = new MainLoop();
        mainLoop.run(new ByteArrayInputStream(input.getBytes()));
        assertThat(mainLoop.getInitialMoney(),is(15000));
        assertThat(mainLoop.getPlayer(0).getStatus().getAbbrname(),is("J"));
        assertThat(mainLoop.getPlayer(1).getStatus().getAbbrname(),is("A"));
    }



}
