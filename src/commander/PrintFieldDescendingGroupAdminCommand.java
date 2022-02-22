package commander;

import util.StudyGroup;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class PrintFieldDescendingGroupAdminCommand extends Command{
    TreeSet<StudyGroup> collection;

    public PrintFieldDescendingGroupAdminCommand(TreeSet<StudyGroup> c){
        collection = c;
        this.name = CommandEnum.PRINT_FIELD_DESCENDING_GROUP_ADMIN;
    }

    @Override
    public String execute() {
        TreeSet<StudyGroup> g = new TreeSet<>((o1, o2) -> o2.getAdmin().compareTo(o1.getAdmin()));
        g.addAll(collection);
        ArrayList<String> admins = new ArrayList<>();
        g.forEach((StudyGroup e) -> admins.add(e.getAdmin().toString()));
        return String.join("\n", admins);
    }

    @Override
    public String describe() {
        return "print_field_descending_group_admin : вывести значения поля groupAdmin всех элементов в порядке убывания";
    }
}
