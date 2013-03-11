package main.jrichman;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/10/13
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class OutputInfo {

    public OutputInfo() {

    }

    //Mapsize: 4, 8, 12, 16, 20, 24, ...
    public static String printMap(ArrayList<Room> roomList)
    {
        int line = 7;
        StringBuffer buffer = new StringBuffer();
        for(int count = 0; count <= line; ++count)
        {
            if(count == 0 )
                for(int i = 0; i < 29; ++i)
                {
                    buffer.append(FromRoomToName.getName(roomList.get(i)));
                }
            else if ( count == line )
                for(int i = roomList.size() - count; i > (roomList.size() - line - 29); --i)
                {
                    buffer.append(FromRoomToName.getName(roomList.get(i)));
                }
            else
            {
                buffer.append(FromRoomToName.getName(roomList.get( roomList.size() - count )));
                for(int i = 1; i < 28; ++i)
                {
                    buffer.append(" ");
                }
                buffer.append(FromRoomToName.getName(roomList.get( 28 + count )));
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
