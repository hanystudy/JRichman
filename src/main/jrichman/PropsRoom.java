package main.jrichman;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: hanyi
 * Date: 2/14/13
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class PropsRoom extends Room {

    public PropsRoom() {
    }

    public PropsRoom(PropsRoom propsRoom) {

    }

    @Override
    public boolean execute(Player player) {
        //To change body of implemented methods use File | Settings | File Templates.
        welcome();
        if( player.getStatus().getPoint() < 30 )
        {
            System.out.println("点数不足买点数最少的道具,自动推出道具屋");
            return true;
        }
        boolean quit = false;
        while(!quit)
        {
            Scanner scanner = new Scanner(System.in);
            String content = scanner.next();
            switch(content.charAt(0))
            {
                case '1':
                    addRoadblock(player);
                    break;
                case '2':
                    addRobot(player);
                    break;
                case '3':
                    addBomb(player);
                    break;
                case 'F':
                case 'f':
                    quit = true;
                    break;
                default:
                    System.out.println("非法输入");
                    break;
            }
        }
        return true;
    }

    @Override
    public Room clone() {

        return new PropsRoom(this);
    }

    @Override
    public RoomType type() {
        return RoomType.PropRoom;
    }

    private boolean addBomb(Player player) {
        //To change body of created methods use File | Settings | File Templates.
        if( player.costPoint(50) )
        {
            Bomb bomb = new Bomb();
            player.buyProp(bomb);
            System.out.println("购买了一个炸弹");
            return true;
        }
        else
        {
            System.out.println("剩余点数不足");
            return false;
        }
    }

    private boolean addRobot(Player player) {
        //To change body of created methods use File | Settings | File Templates.
        if( player.costPoint(30) )
        {
            Robot robot = new Robot();
            player.buyProp(robot);
            System.out.println("购买了一个机器娃娃");
            return true;
        }
        else
        {
            System.out.println("剩余点数不足");
            return false;
        }
    }

    private boolean addRoadblock(Player player) {
        //To change body of created methods use File | Settings | File Templates.
        if( player.costPoint(50) )
        {
            Roadblock block = new Roadblock();
            player.buyProp(block);
            System.out.println("购买了一个路障");
            return true;
        }
        else
        {
            System.out.println("剩余点数不足");
            return false;
        }
    }

    private void welcome() {
        System.out.println("欢迎光临道具屋， 请选择您所需要的道具,输入F/f键离开:");
        System.out.println("道具\t\t编号\t价值（点数）\t显示方式");
        System.out.println("路障\t\t1\t50\t\t\t＃");
        System.out.println("机器娃娃\t2\t30\t\t\t&");
        System.out.println("炸弹\t\t3\t50\t\t\t@");
    }
}