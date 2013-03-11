package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: hanyi
 * Date: 2/14/13
 * Time: 11:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Roadblock extends Prop{
    @Override
    public boolean deploy(Map map, int currentPosition, int distance) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Room execute(Player player, Map map) {
        System.out.println("遇到路障,停止前进");
        return player.getCurrentRoom();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PropName type() {
        return PropName.ROBOT;
    }
}
