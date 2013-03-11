package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/11/13
 * Time: 3:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandQuit extends AbstractCommand {
    @Override
    public boolean execute(Player player, Map mainmap, String[] params) {
        System.out.println("GoodBye~");
        return false;
    }
}
