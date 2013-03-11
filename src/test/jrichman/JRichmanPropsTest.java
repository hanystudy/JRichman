package test.jrichman;

import main.jrichman.*;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/9/13
 * Time: 5:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class JRichmanPropsTest {

    @Test
    public void shouldHaveProps()
    {
        PlayerStatus playerStatus = new PlayerStatus("Tom","T",10000,0);
        Player player = new Player(playerStatus);
        assertThat( player.haveProps(PropName.BOMB), is( (Prop)null) );
    }
}
