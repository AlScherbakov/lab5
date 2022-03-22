package command;

import util.StudyGroup;

import java.util.Objects;
import java.util.TreeSet;

/**
 * Remove by id command returns collection without an element with given id
 */

public class RemoveByIdCommand extends Command {
    int id;
    TreeSet<StudyGroup> collection;
    public RemoveByIdCommand(int i, TreeSet<StudyGroup> c){
        id = i;
        collection = c;
        this.name = CommandEnum.REMOVE_BY_ID;
    }
    @Override
    public TreeSet<StudyGroup> execute(){
        collection.removeIf(g -> Objects.equals(g.getId(), id));
        return collection;
    }
    @Override
    public String describe() {
        return "remove_by_id (int)id : удалить элемент из коллекции по его id";
    }
}
