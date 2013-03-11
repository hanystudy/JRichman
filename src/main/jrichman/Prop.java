package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: hanyi
 * Date: 2/14/13
 * Time: 10:21 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Prop {

    public abstract boolean deploy(Map map, int currentPosition, int distance);

    public abstract Room execute(Player player, Map mainmap);

    public abstract PropName type();
}
