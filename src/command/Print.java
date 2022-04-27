package command;
import collection.NullException;
/**
 * command Print
 */
public class Print extends AbstractCommand {
    public Print(){
        this.name="print";
        this.help="print the location field values of all elements in ascending order";
    }
    /**
     * print all the location of collections
     * {@link CommandManager#executePrint()}
     * @param commandManager
     * @param args
     * @throws ParalnapproException
     * @throws NullException
     */
    public void execute(CommandManager commandManager,String[] args,String Saver) throws ParalnapproException,NullException{
        if(args.length>1){
            throw new ParalnapproException("this command don't accept any parameter\n");
        }else {
            commandManager.executePrint();
        }
    }


}