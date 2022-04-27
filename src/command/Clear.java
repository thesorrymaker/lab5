package command;
import collection.NullException;
/**
 * command clear
 */
public class Clear extends AbstractCommand {
    public Clear(){
        this.name="Clear";
        this.help="clear collections";
    }
    /**
     * clear the collections
     * {@link CommandManager#executeClear()}
     * @param commandManager
     * @param args
     * @throws ParalnapproException
     */
    public void execute(CommandManager commandManager,String args[],String Saver) throws ParalnapproException
    {
        if(args.length>1){
            throw new ParalnapproException("this command don't accept any parameter\n");
        }else if(args.length==0){
            throw new NullException("please input the name of command");
        }else {
            commandManager.executeClear();
        }
    }


}
