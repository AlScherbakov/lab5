package commander;

import util.DataCollector;
import util.DataInputSource;
import util.StudyGroup;

public class AddElementCommand extends Command{
    private final DataInputSource source;
    public AddElementCommand(DataInputSource s) {
        source = s;
        this.name = CommandEnum.ADD;
    }
    @Override
    public StudyGroup execute(){
        return new DataCollector(source).requestStudyGroup();
    }
    @Override
    public String describe(){
        return "add {element} : добавить новый элемент в коллекцию";
    }
}
