package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/10/13
 * Time: 4:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class MoneyRoom extends Room {

    private int point = 0;

    public MoneyRoom(MoneyRoom moneyRoom) {
        super();
    }

    public MoneyRoom() {
        //To change body of created methods use File | Settings | File Templates.
    }

    @Override
    public boolean execute(Player player) {
        System.out.println("经过矿地,获得点数"+point);
        player.getStatus().setPoint(player.getStatus().getPoint()+point);
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Room clone() {
        return new MoneyRoom(this);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public RoomType type() {
        return RoomType.MoneyRoom;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
