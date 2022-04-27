package command;

/***
 * Command UpdateID
 */
public class UpdateID extends AbstractCommand {
    public UpdateID(){
        this.name="UpdateID";
        this.help="update the value of the collection item whose id is equal to the given";
    }

    /**
     *reset elements with specified id
     * {@link CommandManager#executeUpdateID(String)}
     * @param commandManager
     * @param args
     * @throws ParalnapproException
     * @throws NumberFormatException
     */
    public void execute(CommandManager commandManager,String args[],String Saver) throws ParalnapproException,NumberFormatException{
        if(args.length>2||args.length==1){
            throw new ParalnapproException("this command only accepts one number parameter\n");
        }else {
            commandManager.executeUpdateID(args[1]);
        }
    }
}