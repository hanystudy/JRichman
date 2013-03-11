package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/10/13
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class FromNameToRoom {

    private static final java.util.Map<String, Room> map = new java.util.HashMap<String, Room>();
    static {
        map.put("start", new StartRoom());
        map.put("estate", new EstateRoom(0,0));
        map.put("prop", new PropsRoom());
        map.put("magic", new MagicRoom());
        map.put("gift", new GiftRoom());
        map.put("hospital", new HospitalRoom());
        map.put("prison", new PrisonRoom());
        map.put("money", new MoneyRoom());
    }

    protected FromNameToRoom() {
    }

    public static Room getRoom(String input)
    {
        if( input.contains("estate") )
        {
            String[] result = input.split(" ");
            EstateRoom room = (EstateRoom)map.get("estate").clone();
            room.setPrice(Integer.parseInt(result[1]));
            room.setLevel(Integer.parseInt(result[2]));
            return room;
        }
        else if( input.contains("money") )
        {
            String[] result = input.split(" ");
            MoneyRoom room = (MoneyRoom) map.get("money").clone();
            room.setPoint(Integer.parseInt(result[1]));
            return room;
        }
        else
        {
            return map.get(input);
        }
    }
}

