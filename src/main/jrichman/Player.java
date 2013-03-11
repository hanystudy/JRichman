package main.jrichman;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: hanyi
 * Date: 2/11/13
 * Time: 8:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player {

    private PlayerStatus playerStatus = null;

    private boolean live = true;

    private ArrayList<EstateRoom> estateRoomList = new ArrayList<EstateRoom>();
    private ArrayList<Prop> propsList = new ArrayList<Prop>();
    private Room currentRoom = null;
    private int mascot = 0;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Player(PlayerStatus playerStatus) {

        this.playerStatus = playerStatus;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public boolean isLive() {
        return live;
    }

    public PlayerStatus getStatus() {
        return playerStatus;  //To change body of created methods use File | Settings | File Templates.
    }

    public boolean costMoney(int price) {
        if( price > this.playerStatus.getMoney() )
        {
            return false;
        }
        else
        {
            playerStatus.setMoney(playerStatus.getMoney()-price);
            return true;
        }
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public boolean hasMascot() {
        if( playerStatus.getMascot() > 0 )
            return true;
        else
            return false;
        //To change body of created methods use File | Settings | File Templates.
    }

    public boolean hasTrouble() {
        if( playerStatus.getState() == PlayerState.JAIL || playerStatus.getState() == PlayerState.ILL )
            return true;
        else
            return false;
        //To change body of created methods use File | Settings | File Templates.
    }

    public void buyEstateRoom(EstateRoom estateRoom) {
        estateRoomList.add(estateRoom);//To change body of created methods use File | Settings | File Templates.
    }

    public void kill() {
        Iterator<EstateRoom> it = estateRoomList.iterator();
        while(it.hasNext())
        {
            EstateRoom room = it.next();
            room.reset();
        }
        this.live = false;
        System.out.println(this.playerStatus.getNickname()+"破产了");
        //To change body of created methods use File | Settings | File Templates.
    }

    public Prop haveProps(PropName prop) {
        Iterator<Prop> it = propsList.iterator();
        while(it.hasNext())
        {
            Prop m = it.next();
            if(m.type() == prop)
            {
                return m;
            }
        }
        return null;  //To change body of created methods use File | Settings | File Templates.
    }


    public void buyProp(Prop prop) {
        propsList.add(prop);
    }

    public void leavecurrentroom() {
        currentRoom.leave(this);
        //To change body of created methods use File | Settings | File Templates.
    }

    public Room stepforward(int step, Map map) {
        //To change body of created methods use File | Settings | File Templates.
        Room room = currentRoom;
        for(int i = 0; i < step; ++i)
        {
            room = room.next();
            if( room.hasProp() )
            {
                Room temproom = room;
                Prop prop = room.getProp();
                temproom = prop.execute(this, map);
                room.cleanprop();
                if( temproom != room && room.hasProp() )
                {
                    prop = temproom.getProp();
                    temproom.cleanprop();
                    temproom = prop.execute(this, map);
                }
                room = temproom;
                break;
            }
        }
        return room;
    }

    public void arrive(Room room) {
        currentRoom = room;
        currentRoom.arrive(this);
    }

    public boolean costPoint(int i) {
        if( i > this.playerStatus.getPoint() )
        {
            return false;
        }
        else
        {
            playerStatus.setPoint(playerStatus.getPoint() - i);
            return true;
        }
    }

    public void useprop(Prop prop, Room room) {
        room.setProp(prop);
        propsList.remove(prop);
        System.out.println("放置成功");
    }

    public int getRoomNumberByLevel(int i) {
        int count = 0;
        Iterator<EstateRoom> it = estateRoomList.iterator();
        while(it.hasNext())
        {
            EstateRoom room = it.next();
            if( room.getLevel() == i )
                ++count;
        }
        return count;  //To change body of created methods use File | Settings | File Templates.
    }

    public int getPropNumberByType(PropName name) {
        int count = 0;
        Iterator<Prop> it = propsList.iterator();
        while( it.hasNext() )
        {
            Prop prop = it.next();
            if( prop.type() == name )
                ++count;
        }
        return count;  //To change body of created methods use File | Settings | File Templates.
    }

    public ArrayList<EstateRoom> getEstateRoomList() {
        return estateRoomList;  //To change body of created methods use File | Settings | File Templates.
    }

    public void sellroom(EstateRoom room) {
        int money = room.getPrice() * (room.getLevel() + 1) * 2;
        playerStatus.setMoney( playerStatus.getMoney() + money );
        estateRoomList.remove(room);
        //To change body of created methods use File | Settings | File Templates.
    }

    public ArrayList<Prop> getPropsList() {
        return propsList;
    }

    public void sellprop(Prop er) {
        switch (er.type())
        {
            case ROBOT:
                playerStatus.setPoint(playerStatus.getPoint()+30);
                break;
            case BOMB:
                playerStatus.setPoint(playerStatus.getPoint()+50);
                break;
            case ROADBLOCK:
                playerStatus.setPoint(playerStatus.getPoint()+50);
                break;
        }
        propsList.remove(er);
        //To change body of created methods use File | Settings | File Templates.
    }

    public void setMascot(int i) {
        playerStatus.setMascot(i);
        //To change body of created methods use File | Settings | File Templates.
    }
}
