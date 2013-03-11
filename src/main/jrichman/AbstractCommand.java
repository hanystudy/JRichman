package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/11/13
 * Time: 12:54 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractCommand {

    public abstract boolean execute(Player player, Map mainmap, String[] params);
}
