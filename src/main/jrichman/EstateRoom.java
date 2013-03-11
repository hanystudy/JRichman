package main.jrichman;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: hanyi
 * Date: 2/11/13
 * Time: 7:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class EstateRoom extends Room {

    private Player owner = null;
    private int price = 0;
    private int level = 0;

    public EstateRoom(int price, int level) {
        this.price = price;
        this.level = level;
        //To change body of created methods use File | Settings | File Templates.
    }

    public EstateRoom(EstateRoom estateRoom) {
        super();
        price = estateRoom.price;
        level = estateRoom.level;
        owner = estateRoom.owner;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {

        this.level = level;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;

    }

    @Override
    public boolean execute(Player player) {
        //To change body of implemented methods use File | Settings | File Templates.
        if( this.owner == null )
            return buy(player);
        else if( this.owner == player )
            return levelup(player);
        else
            return punish(player);
    }

    @Override
    public Room clone() {
        return new EstateRoom(this);
    }

    @Override
    public RoomType type() {
        return RoomType.EstateRoom;
    }

    public boolean punish(Player player) {
        if( player.hasMascot() )
        {
            System.out.println("福神附身，可免过路费！");
        }
        else if( owner.hasTrouble() )
        {
            System.out.println("主人不在，可免过路费！");
        }
        else
        {
            System.out.println("到达"+this.owner.getStatus().getNickname()+"的地产,扣除"+price*(level+1)/2+"元");
            owner.getStatus().setMoney(owner.getStatus().getMoney()+price*(level+1)/2);
            if( !player.costMoney(price*(level+1)/2) )
                player.kill();
        }
        return true;
        //To change body of created methods use File | Settings | File Templates.
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player player) {
        owner = player;
    }

    private boolean buy(Player player)
    {
        System.out.println("是否购买该处空地，"+price+"元(Y/N)？");
        Scanner scanner = new Scanner(System.in);
        String content = scanner.next();
        if( content.equals("Y") || content.equals("y") )
        {
            if(cost(player, price))
            {
                this.owner = player;
                player.buyEstateRoom(this);
                return true;
            }
        }
        return false;
    }

    private boolean levelup(Player player)
    {
        if( level == 3 )
        {
            System.out.println("该地产已升至最高级");
            return false;
        }
        System.out.println("是否升级该处地产，"+price+"元(Y/N)？");
        Scanner scanner = new Scanner(System.in);
        String content = scanner.next();
        if( content.equals("Y") || content.equals("y") )
        {
            if( cost(player, price) )
            {
                this.level++;
                return true;
            }
        }
        return false;
    }

    public boolean cost(Player player, int price) {
        if( player.costMoney(price) )
        {
            System.out.println("购买成功！");
            return true;
        }
        else
        {
            System.out.println("余额不足！");
            return false;
        }
    }

    public void reset() {
        owner = null;
        level = 0;//To change body of created methods use File | Settings | File Templates.
    }
}
