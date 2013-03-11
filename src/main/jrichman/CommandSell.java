package main.jrichman;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/11/13
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandSell extends AbstractCommand {
    @Override
    public boolean execute(Player player, Map mainmap, String[] params) {

        ArrayList<EstateRoom> estateRoomArrayList = player.getEstateRoomList();
        int no = Integer.parseInt(params[1]);
        Iterator<EstateRoom> it = estateRoomArrayList.iterator();
        while( it.hasNext() )
        {
            EstateRoom er = it.next();
            if( er.getNo() == no )
            {
                player.sellroom(er);
                er.reset();
                System.out.println("地产出售成功");
                return false;
            }
        }
        System.out.println("找不到所拥有的地产");
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }
}
