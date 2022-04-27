package command;
/**
 * when user use command with incorrect parameters,will be thrown
 */
public class ParalnapproException extends RuntimeException{
    public ParalnapproException(String message){
        super(message);
    }
}