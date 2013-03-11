package main.jrichman;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/10/13
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainLoop {

    private Map mainmap = new Map();
    private ArrayList<Player> players = new ArrayList<Player>();
    private int initialMoney = 10000;
    private int alive = 0;

    public void setInitialMoney(int initialMoney) {
        this.initialMoney = initialMoney;
    }

    public int getInitialMoney() {
        return initialMoney;
    }

    public MainLoop() {
        mainmap.createMap();
    }

    public void run(InputStream in) {
        try
        {
            initialEnvironment(in);

            Iterator<Player> it = players.iterator();

            while( alive > 1 )
            {
                if( !it.hasNext() )
                {
                     it = players.iterator();
                }
                printMap();
                Player player = it.next();
                player.getStatus().update();
                boolean br = false;
                while ( player.isLive() && !br )
                {
                    System.out.print(player.getStatus().getNickname()+">");
                    if( player.getStatus().getState() == PlayerState.JAIL || player.getStatus().getState() == PlayerState.ILL )
                    {
                        System.out.println("玩家"+player.getStatus().getNickname()+"被锁定,距离解锁还有"+player.getStatus().getLastDays()+"天");
                        br = true;
                        continue;
                    }
                    Scanner input = new Scanner(in);
                    String content = input.nextLine();
                    AbstractCommand command = FromNameToCommand.getCommand(content);
                    if( command == null )
                    {
                        System.out.println("未知命令,请输入help查看帮助");
                        continue;
                    }
                    br = command.execute(player,mainmap,content.split(" "));
                    if( content.equals("quit") || content.equals("QUIT") )
                    {
                        return;
                    }
                }
                if( !player.isLive() )
                {
                    players.remove(player);
                    --alive;
                }
                System.out.println("\n===================next=====================");
            }
            System.out.println("游戏结束,胜利者是"+players.get(0).getStatus().getNickname());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void initialEnvironment(InputStream in) {
        Scanner input=new Scanner(in);
        do {
            System.out.println("请设置玩家初始资金,范围1000~50000(默认10000):");
            String money = input.next();
            initialMoney = Integer.parseInt(money);
        }
        while( initialMoney < 1000 || initialMoney > 50000);

        boolean member = false;

        while( !member ) {
            players.clear();
            alive = 0;
            member = true;
            System.out.println("请选择2~4位不重复玩家,输入编号即可.(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):");
            String m = input.next();
            int put = Integer.parseInt(m);
            String nn = "", an = "";
            if( put < 12 || put > 4321 )
            {
                member = false;
                continue;
            }
            while( put != 0)
            {
                int no = put % 10;
                switch (no)
                {
                    case 1:
                        nn = "钱夫人";
                        an = "Q";
                        break;
                    case 2:
                        nn = "阿土伯";
                        an = "A";
                        break;
                    case 3:
                        nn = "孙小美";
                        an = "S";
                        break;
                    case 4:
                        nn = "金贝贝";
                        an = "J";
                        break;
                    default:
                        member = false;
                        break;
                }
                PlayerStatus ps = new PlayerStatus(nn, an, initialMoney, 0);
                Player player = new Player(ps);
                players.add(0,player);
                player.setCurrentRoom(mainmap.getRoom(0));
                put/=10;
                ++alive;
            }
        }
    }

    public void printMap() {
        String b = OutputInfo.printMap(mainmap.getRoomList());
        //if( mainmap.get(0).type() == RoomType.StartRoom)
            System.out.println(b);
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }
}
