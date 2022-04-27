package command;

import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class Show extends AbstractCommand {
    public Show(){
        this.name="show";
        this.help="display all elements of the collection in string representation to standard output";
    }

    /**
     * show all the elements in the collection.Don't accept any parameter
     * {@link CommandManager#executeShow()}
     * @param commandManager
     * @param args
     * @throws ParalnapproException
     * @throws NullException
     */
    public void execute(CommandManager commandManager,String args[],String Saver) throws ParalnapproException,NullException{
        if(args.length>1){
            throw new ParalnapproException("this command don't accept any parameter\n");
        }else {
            commandManager.executeShow();
        }
    }




}