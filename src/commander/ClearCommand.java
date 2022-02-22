package commander;

import util.StudyGroup;

import java.util.TreeSet;

public class ClearCommand extends Command{

    public ClearCommand(){
        this.name = CommandEnum.CLEAR;
    }

    @Override
    public TreeSet<StudyGroup> execute (){
        System.out.println("Коллекция очищена");
        return new TreeSet<>();
    }

    @Override
    public String describe() {
        return "clear : очистить коллекцию";
    }
}
