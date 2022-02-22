package commander;

import java.util.ArrayList;

public class HistoryCommand extends Command{
    private final ArrayList<CommandEnum> history;
    public HistoryCommand(ArrayList<CommandEnum> h){
        history = h;
        this.name = CommandEnum.HISTORY;
    }
    @Override
    public ArrayList<CommandEnum> execute(){
        int historySize = history.size();
        if (historySize <= 6){
//            history.forEach(System.out::println);
            return history;
        } else{
           return new ArrayList<>(history.subList(historySize - 6, historySize));//.forEach(System.out::println);
        }
    }
    @Override
    public String describe(){
        return "history : вывести последние 6 команд (без их аргументов)";
    }
}
