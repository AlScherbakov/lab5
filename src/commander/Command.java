package commander;

public abstract class Command implements Invokeable{
    protected CommandEnum name;
    public abstract String describe();
    public CommandEnum getName(){
        return name;
    }
}
