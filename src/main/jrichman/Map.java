package main.jrichman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: hanyi
 * Date: 2/11/13
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Map {

    private ArrayList<Room> mainmap = new ArrayList<Room>();

    public Map() {
    }

    public ArrayList<Room> createMap() {
        try {
            BufferedReader bfreader = new BufferedReader(new FileReader("./map"));
            String temp;
            int i = 0;
            while ( (temp = bfreader.readLine()) != null )
            {
                Room room = FromNameToRoom.getRoom(temp);
                if( i > 0 )
                {
                    mainmap.get(i-1).setNext(room);
                    room.setLast(mainmap.get(i-1));
                }
                mainmap.add(room);
                mainmap.get(i).setNo(i);
                ++i;
            }
            mainmap.get(mainmap.size()-1).setNext(mainmap.get(0));
            mainmap.get(0).setLast(mainmap.get(mainmap.size()-1));
            bfreader.close();
        }
        catch(Exception e)
        {
            System.out.println("Can't read map files.");
            return null;
        }
        return mainmap;
    }

    public Room getRoom(int position) {

        return mainmap.get(position % mainmap.size());
        //To change body of created methods use File | Settings | File Templates.
    }

    public ArrayList<Room> getRoomList() {
        return this.mainmap;
    }

    public Room getHospitalRoom() {
        Iterator<Room> it = mainmap.iterator();
        while(it.hasNext())
        {
            Room room = it.next();
            if( room.type() == RoomType.HospitalRoom )
            {
                return room;
            }
        }
        return null;
    }
}
