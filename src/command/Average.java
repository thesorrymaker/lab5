package command;

public class Average extends AbstractCommand {
    public Average() {
        this.name = "Average";
        this.help = "out put the average of the heights of all collections(People)";
    }

    public void execute(CommandManager commandManager, String args[], String Saver) throws ParalnapproException {
        if (args.length > 1) {
            throw new ParalnapproException("this command don't accept any parameter\n");
        } else {
            commandManager.executeAverage();
        }
    }
}
