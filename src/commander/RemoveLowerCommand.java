package commander;

import util.DataCollector;
import util.DataInputSource;
import util.StudyGroup;

import java.util.Set;
import java.util.TreeSet;

public class RemoveLowerCommand extends Command{
    TreeSet<StudyGroup> collection;
    DataInputSource source;

    public RemoveLowerCommand(TreeSet<StudyGroup> c, DataInputSource s){
        collection = c;
        source = s;
        this.name = CommandEnum.REMOVE_LOWER;
    }

    @Override
    public TreeSet<StudyGroup> execute(){
        System.out.println("С какой группой сравнить?");
        StudyGroup aGroup = new DataCollector(source).requestStudyGroup();
        Set<StudyGroup> groupsToRemove = collection.headSet(aGroup);
        collection.removeAll(groupsToRemove);
        return collection;
    }
    @Override
    public String describe() {
        return "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
