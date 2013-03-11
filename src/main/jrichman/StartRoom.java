package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/10/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class StartRoom extends Room {
    public StartRoom() {
    }

    public StartRoom(StartRoom startRoom) {
    }

    @Override
    public boolean execute(Player player) {
        System.out.println("进入下一地图周期");
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Room clone() {
        return new StartRoom(this);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public RoomType type() {
        return RoomType.StartRoom;
    }
}
