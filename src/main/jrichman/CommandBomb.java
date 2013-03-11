package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/11/13
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandBomb extends AbstractCommand {

    @Override
    public boolean execute(Player player, Map mainmap, String[] params) {

        Prop prop = null;
        if( (prop = player.haveProps(PropName.BOMB)) != null )
        {
            int offset = Integer.parseInt(params[1]);
            if( Math.abs(offset) > 10 )
            {
                System.out.println("请输入[-10,10]之间的整数");
                return false;
            }
            Room room = player.getCurrentRoom();
            if(offset < 0)
            {
                for(int i = 0; i > offset; --i)
                {
                    room = room.last();
                }
                if( !room.hasPlayer() && !room.hasProp() )
                {
                    player.useprop(prop, room);
                    return false;
                }
            }
            else
            {
                for(int i = 0; i < offset; ++i)
                {
                    room = room.next();
                }
                if( !room.hasPlayer() && !room.hasProp() )
                {
                    player.useprop(prop, room);
                    return false;
                }
            }
            System.out.println("该位置已有玩家或道具");
        }
        else
        {
            System.out.println("缺少道具:炸弹");
        }
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }
}
