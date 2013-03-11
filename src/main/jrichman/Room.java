package main.jrichman;

import bsh.This;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: hanyi
 * Date: 2/11/13
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Room {

    private Prop prop = null;
    private ArrayList<Player> currentPlayer = new ArrayList<Player>();
    private int no;

    private Room next = null;
    private Room last = null;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public abstract boolean execute(Player player);

    public boolean hasProp()
    {
        if( prop != null )
            return true;
        else
            return false;
    }

    public void addProp(Prop prop)
    {
        this.prop = prop;
    }

    public abstract Room clone();

    public boolean hasPlayer()
    {
        if( currentPlayer.size() > 0 )
            return true;
        else
            return false;
    }

    public void arrive(Player player)
    {
        currentPlayer.add(player);
    }

    public void leave(Player player)
    {
        currentPlayer.remove(player);
    }

    public abstract RoomType type();

    public void setNext(Room room)
    {
        next = room;
    }

    public Room next() {
        return next;
    }

    public boolean hasBlock()
    {
        if ( hasProp() && prop.type() == PropName.ROADBLOCK )
        {
            return true;
        }
        return false;
    }

    public Prop getProp() {
        return prop;  //To change body of created methods use File | Settings | File Templates.
    }

    public void cleanprop() {
        //To change body of created methods use File | Settings | File Templates.
        prop = null;
    }

    public void setLast(Room room) {
        last = room;
    }

    public Room last() {
        return last;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }

    public int getPlayerNumber() {
        return currentPlayer.size();
    }

    public Player getCurrentPlayer(int i) {
        return currentPlayer.get(i);
    }
}
