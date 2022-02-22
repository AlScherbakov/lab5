package commander;

import util.StudyGroup;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;

public class ShowCommand extends Command{
    TreeSet<StudyGroup> collection;
    public ShowCommand(TreeSet<StudyGroup> c){
        collection = c;
        this.name = CommandEnum.SHOW;
    };
    @Override
    public String execute(){
        if (collection.size() < 1){
            return "Коллекция пуста";
        } else {
            ArrayList<String> groups = new ArrayList<>();
            collection.forEach((StudyGroup g) -> groups.add(g.toString()));
            return String.join("\n", groups);
        }
    }
    @Override
    public String describe(){
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
