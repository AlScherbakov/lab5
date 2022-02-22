package commander;

import util.StudyGroup;

import java.util.Comparator;
import java.util.TreeSet;

public class MaxGroupByAdminCommand extends Command{
    TreeSet<StudyGroup> collection;
    public MaxGroupByAdminCommand(TreeSet<StudyGroup> c){
        collection = c;
        this.name = CommandEnum.MAX_BY_GROUP_ADMIN;
    }
    @Override
    public StudyGroup execute(){
        TreeSet<StudyGroup> g = new TreeSet<>(Comparator.comparing(StudyGroup::getAdmin));
        g.addAll(collection);
        return g.last();
    }
    @Override
    public String describe(){
        return "max_by_group_admin : вывести любой объект из коллекции, значение поля groupAdmin которого является максимальным";
    }
}
