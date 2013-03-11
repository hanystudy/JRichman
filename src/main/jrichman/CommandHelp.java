package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/11/13
 * Time: 3:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandHelp extends AbstractCommand {
    @Override
    public boolean execute(Player player, Map mainmap, String[] params) {
        System.out.println("roll 掷骰子命令,行走1~6步\n" +
                "block n 玩家拥有路障后,可将路障放置到离当前位置前后10步的距离,任一玩家经过路障,都将被拦截,n前后的相对距离,负数表示后方\n" +
                "bomb n 可将路障放置到离当前位置前后10步的距离,任一玩家j经过在该位置,将被炸伤,送往医院,住院三天.n前后的相对距离,负数表示后方\n" +
                "robot 使用该道具,可清扫前方路面上10步以内的其它道具,如炸弹,路障\n" +
                "sell x 出售自己的房产,x地图上的绝对位置,即地产的编号\n" +
                "sellTool x出售道具,x道具编号\n" +
                "query 显示自家资产信息\n" +
                "help 查看命令帮助\n" +
                "quit 强制退出");
        //To change body of implemented methods use File | Settings | File Templates.
        return false;
    }
}
