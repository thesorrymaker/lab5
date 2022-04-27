package command;

import collection.NullException;
import collection.ValueTooSmallException;

import java.io.IOException;

public class Save extends AbstractCommand {
    Save(){
        this.name="Save";
        this.help="save collection to file";
    }

    /**
     * save data to file Person.csv.Don't accept any parameter
     * {@link CommandManager#executeSave(String Saver)}
     * @param commandManager
     * @param args
     * @throws IOException
     * @throws ParalnapproException
     */
    public void execute(CommandManager commandManager,String args[],String Saver) throws IOException,ParalnapproException{
        if(args.length>1){
            throw new ParalnapproException("this command don't accept parameter\n");
        }else {
            commandManager.executeSave(Saver);
        }
    }


    }

