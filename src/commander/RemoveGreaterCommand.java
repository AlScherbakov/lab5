package commander;

import util.DataCollector;
import util.DataInputSource;
import util.StudyGroup;

import java.util.Set;
import java.util.TreeSet;

public class RemoveGreaterCommand extends Command{
    TreeSet<StudyGroup> collection;
    DataInputSource source;

    public RemoveGreaterCommand(TreeSet<StudyGroup> c, DataInputSource s){
        collection = c;
        source = s;
        this.name = CommandEnum.REMOVE_GREATER;
    }

    @Override
    public TreeSet<StudyGroup> execute(){
        System.out.println("С какой группой сравнить?");
        StudyGroup aGroup = new DataCollector(source).requestStudyGroup();
        Set<StudyGroup> groupsToRemove = collection.tailSet(aGroup);
        collection.removeAll(groupsToRemove);
        return collection;
    }
    @Override
    public String describe() {
        return "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный";
    }
}