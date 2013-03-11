package main.jrichman;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/11/13
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandRoll extends AbstractCommand {
    @Override
    public boolean execute(Player player, Map mainmap, String[] params) {
        if( player.getStatus().getState() == PlayerState.ACTIVE )
        {
            int step = (int) (Math.random()*6+1);
            player.leavecurrentroom();
            Room room = player.stepforward(step,mainmap);
            player.arrive(room);
            System.out.println("前进"+step+"步");
            room.execute(player);
        }
        //To change body of implemented methods use File | Settings | File Templates.
        return true;
    }
}
