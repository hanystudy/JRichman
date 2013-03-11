package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/10/13
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class HospitalRoom extends Room {
    public HospitalRoom() {
    }

    public HospitalRoom(HospitalRoom hospitalRoom) {
        super();
    }

    @Override
    public boolean execute(Player player) {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Room clone() {
        return new HospitalRoom(this);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public RoomType type() {
        return RoomType.HospitalRoom;
    }
}
