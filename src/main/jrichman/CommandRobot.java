package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/11/13
 * Time: 3:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandRobot extends AbstractCommand {
    @Override
    public boolean execute(Player player, Map mainmap, String[] params) {
        Prop prop = null;
        if( (prop = player.haveProps(PropName.ROBOT)) != null )
        {
            Room room = player.getCurrentRoom();
            for(int i = 0; i < 10; ++i)
            {
                room = room.next();
                room.cleanprop();
            }
        }
        else
        {
            System.out.println("缺少道具:机器娃娃");
        }
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }
}
