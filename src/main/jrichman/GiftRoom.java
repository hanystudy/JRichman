package main.jrichman;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/10/13
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class GiftRoom extends Room {
    public GiftRoom() {
    }

    public GiftRoom(GiftRoom giftRoom) {
        super();
    }

    @Override
    public boolean execute(Player player) {
        welcome();
        Scanner scanner = new Scanner(System.in);
        String content = scanner.next();
        switch(content.charAt(0))
        {
            case '1':
                addMoney(player);
                break;
            case '2':
                addPoint(player);
                break;
            case '3':
                addMascot(player);
                break;
            default:
                break;
        }
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private void addMascot(Player player) {
        player.setMascot(5);
        //To change body of created methods use File | Settings | File Templates.
    }

    private void addPoint(Player player) {
        player.getStatus().setPoint(player.getStatus().getPoint() + 200);
        System.out.println("获得点数200点");
        //To change body of created methods use File | Settings | File Templates.
    }

    private void addMoney(Player player) {
        player.getStatus().setMoney( player.getStatus().getMoney() + 2000);
        System.out.println("获得奖金2000元");
        //To change body of created methods use File | Settings | File Templates.
    }

    @Override
    public Room clone() {
        return new GiftRoom(this);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public RoomType type() {
        return RoomType.GiftRoom;
    }

    private void welcome()
    {
        System.out.println("欢迎光临礼品屋!");
        System.out.println("1 奖金:2000元");
        System.out.println("2 点数卡:200点");
        System.out.println("3 福神:福神俯身,路过其它玩家地盘,均可免费.5轮内有效(在监狱、医院中也计轮次)");
    }
}
