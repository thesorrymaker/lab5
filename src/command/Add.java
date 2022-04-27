package command;
import collection.*;
/**
 * Add command allows user set and add a new element to collection
 */
public class Add extends AbstractCommand {
    public Add(){
        this.name="add";
        this.help="add a new element to collection";
    }
    /**
     * when length of command line argument bigger than 1,throw ParaInapproException
     * {@link command.CommandManager#executeAdd(Vehicle)}
     * @param commandManager
     * @param args
     * @throws ParalnapproException
     * @throws ValueTooSmallException
     * @throws ValueTooBigException
     * @throws NullException
     */
    public void execute(CommandManager commandManager,String args[],String Saver) throws ParalnapproException,ValueTooSmallException,ValueTooBigException,NullException{
        if(args.length>1){
            throw new ParalnapproException("command add don't accept any parameter.\n");
        }else {
            commandManager.executeAdd(Vehicle.VehicleCreate());
        }
    }



    }
