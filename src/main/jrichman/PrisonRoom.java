package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/10/13
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrisonRoom extends Room {
    public PrisonRoom() {
    }

    public PrisonRoom(PrisonRoom prisonRoom) {
        super();
    }

    @Override
    public boolean execute(Player player) {
        System.out.println("抵达监狱,被扣留两天");
        player.getStatus().setState(PlayerState.JAIL);
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Room clone() {
        return new PrisonRoom(this);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public RoomType type() {
        return RoomType.PrisonRoom;
    }
}
