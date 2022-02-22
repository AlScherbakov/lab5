package commander;

public class ExitCommand extends Command{
    public ExitCommand(){
        this.name = CommandEnum.EXIT;
    }
    @Override
    public Integer execute(){
        System.exit(0);
        return 0;
    }
    @Override
    public String describe(){
        return "exit : завершить программу (без сохранения в файл)";
    }
}
