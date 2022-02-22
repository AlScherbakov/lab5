package commander;

/**
 * Abstract Command class - superclass for all commands - a part of Command pattern
 */

public abstract class Command implements Invokeable{
    protected CommandEnum name;
    public abstract String describe();
    public CommandEnum getName(){
        return name;
    }
}
