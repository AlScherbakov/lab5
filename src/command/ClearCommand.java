package command;

import util.StudyGroup;

import java.util.Set;
import java.util.TreeSet;

/**
 * Clear command returns empty TreeSet
 */

public class ClearCommand extends Command{

    public ClearCommand(){
        this.name = CommandEnum.CLEAR;
    }

    @Override
    public Set<StudyGroup> execute (){
        return new TreeSet<>();
    }

    @Override
    public String describe() {
        return "clear : очистить коллекцию";
    }
}
