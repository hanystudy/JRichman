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
public class CommandSelltool extends AbstractCommand {
    @Override
    public boolean execute(Player player, Map mainmap, String[] params) {
        ArrayList<Prop> propArrayList = player.getPropsList();
        int no = Integer.parseInt(params[1]);
        PropName prop;
        switch (no)
        {
            case '1':
                prop = PropName.ROADBLOCK;
                break;
            case '2':
                prop = PropName.ROBOT;
                break;
            case '3':
                prop = PropName.BOMB;
                break;
            default:
                System.out.println("道具不存在");
                return false;
        }
        Iterator<Prop> it = propArrayList.iterator();
        while( it.hasNext() )
        {
            Prop er = it.next();
            if( er.type() == prop )
            {
                player.sellprop(er);
                System.out.println("道具出售成功");
                return false;
            }
        }
        System.out.println("找不到所拥有的道具");
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }
}
