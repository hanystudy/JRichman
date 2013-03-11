package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: hanyi
 * Date: 2/14/13
 * Time: 10:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bomb extends Prop {

    @Override
    public boolean deploy(Map map, int currentPosition, int distance) {
        if( distance < -10 || distance > 10 )
        {
            System.out.println("输入应在[-10,10]");
        }
        else
        {
            if ( addBomb(map, currentPosition+distance) )
                return true;
        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private boolean addBomb(Map map, int position) {
        Room room = map.getRoom(position);
        if( !room.hasProp() )
        {
            room.addProp(this);
            return true;
        }
        else
        {
            System.out.println("当前位置已有一个道具");
        }
        return false;
    }

    @Override
    public Room execute(Player player, Map map) {
        System.out.println("被炸弹炸伤,住院三天");
        player.getStatus().setState(PlayerState.ILL);
        player.setCurrentRoom(map.getHospitalRoom());
        return map.getHospitalRoom();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PropName type() {
        return PropName.BOMB;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
