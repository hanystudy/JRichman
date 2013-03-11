package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/11/13
 * Time: 3:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandQuery extends AbstractCommand {
    @Override
    public boolean execute(Player player, Map mainmap, String[] params) {

        int k,w,y,m;
        int l,z,j;
        k = player.getRoomNumberByLevel(0);
        w = player.getRoomNumberByLevel(1);
        y = player.getRoomNumberByLevel(2);
        m = player.getRoomNumberByLevel(3);
        l = player.getPropNumberByType(PropName.ROADBLOCK);
        z = player.getPropNumberByType(PropName.BOMB);
        j = player.getPropNumberByType(PropName.ROBOT);
        System.out.println("资金:"+player.getStatus().getMoney());
        System.out.println("点数:"+player.getStatus().getPoint());
        System.out.println("地产:"+"空地"+k+"处;"+"茅屋"+w+"处;"+"洋房"+y+"处;"+"摩天楼"+m+"处;");
        System.out.println("道具:"+"路障"+l+"个;"+"炸弹"+z+"个;"+"机器娃娃"+j+"个;");

        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }
}
