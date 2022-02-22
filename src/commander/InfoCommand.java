package commander;

import util.StudyGroup;

import java.util.Date;
import java.util.TreeSet;

public class InfoCommand extends Command{
    TreeSet<StudyGroup> collection;
    String creationDate;
    public InfoCommand(TreeSet<StudyGroup> t, String d){
        collection = t;
        creationDate = d;
        this.name = CommandEnum.INFO;
    }
    @Override
    public String execute(){
        return String.format("Тип коллекции - %s. Дата инициализации - %s. Количество элементов - %d\n", collection.getClass(), creationDate, collection.size());
    }
    @Override
    public String describe() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
