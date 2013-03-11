package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/10/13
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class FromRoomToName {

    private static final java.util.Map<RoomType, String> map = new java.util.HashMap<RoomType, String>();
    static {
        map.put(RoomType.StartRoom, "S");
        map.put(RoomType.EstateRoom, "0");
        map.put(RoomType.PropRoom, "T");
        map.put(RoomType.MagicRoom, "M");
        map.put(RoomType.GiftRoom, "G");
        map.put(RoomType.HospitalRoom, "H");
        map.put(RoomType.PrisonRoom, "P");
        map.put(RoomType.MoneyRoom, "$");
    }

    protected FromRoomToName() {

    }

    public static String getName(Room room)
    {
        Player player;
        if( room.hasPlayer() )
        {
            return room.getCurrentPlayer(room.getPlayerNumber()-1).getStatus().getAbbrname();
        }
        if( room.hasProp() )
        {
            switch (room.getProp().type())
            {
                case BOMB:
                    return "@";
                case ROADBLOCK:
                    return "#";
                case ROBOT:
                    return "&";
                default:
                    return "x";
            }
        }
        if( room.type() == RoomType.EstateRoom )
        {
            return ""+((EstateRoom)room).getLevel();
        }
        return map.get(room.type());
    }
}
