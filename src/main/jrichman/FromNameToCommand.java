package main.jrichman;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/11/13
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class FromNameToCommand {

    private static final java.util.Map<String, AbstractCommand> map = new java.util.HashMap<String, AbstractCommand>();
    static {
        map.put("roll", new CommandRoll());
        map.put("block", new CommandBlock());
        map.put("bomb", new CommandBomb());
        map.put("help", new CommandHelp());
        map.put("query", new CommandQuery());
        map.put("quit", new CommandQuit());
        map.put("robot", new CommandRobot());
        map.put("sell", new CommandSell());
        map.put("selltool", new CommandSelltool());
    }

    protected FromNameToCommand() {
    }

    public static AbstractCommand getCommand(String input)
    {
        return map.get(input);
    }
}
