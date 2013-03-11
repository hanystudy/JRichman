package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/10/13
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class MagicRoom extends Room {
    public MagicRoom() {
    }

    public MagicRoom(MagicRoom magicRoom) {

    }

    @Override
    public boolean execute(Player player) {
        System.out.println("抵达魔法屋,呆了一会儿");
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Room clone() {
        return new MagicRoom(this);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public RoomType type() {
        return RoomType.MagicRoom;
    }
}
