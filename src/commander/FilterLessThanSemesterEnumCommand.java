package commander;

import util.Semester;
import util.StudyGroup;

import java.util.Comparator;
import java.util.TreeSet;

public class FilterLessThanSemesterEnumCommand extends Command{
    Semester semester;
    TreeSet<StudyGroup> collection;
    public FilterLessThanSemesterEnumCommand(Semester s, TreeSet<StudyGroup> c){
        semester = s;
        collection = c;
        this.name = CommandEnum.FILTER_LESS_THAN_SEMESTER_ENUM;
    }
    @Override
    public TreeSet<StudyGroup> execute(){
        TreeSet<StudyGroup> g = new TreeSet<>(Comparator.comparing(StudyGroup::getSemesterEnum));
        g.addAll(collection);
        g.removeIf((StudyGroup x) -> semester.compareTo(x.getSemesterEnum()) <= 0);
        if (g.size() > 0){
            return g;
        } else {
            System.out.println("Нет элементов, значение поля semesterEnum которых меньше " + semester);
            return collection;
        }
    }
    @Override
    public String describe() {
        return "filter_less_than_semester_enum (SECOND, THIRD, SIXTH, SEVENTH)semesterEnum : вывести элементы, значение поля semesterEnum которых меньше заданного";
    }
}
