package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2024/3/21 下午2:35
 */
public class Group {

    private String name;

    private List<Group> subgroups;

    public Group(String name) {

        this.name = name;
        this.subgroups = new ArrayList<>();
    }

    public String getName() {

        return name;
    }

    public List<Group> getSubgroups() {

        return subgroups;
    }

    public void addSubgroup(Group subgroup) {

        subgroups.add(subgroup);
    }

    public void displayAllGroups() {

        displayAllGroups(this, 0);
    }

    private void displayAllGroups(Group group, int depth) {

        for (int i = 0; i < depth; i++) {
            System.out.print("\t"); // 使用制表符来表示深度
        }
        System.out.println(group.getName());

        for (Group subgroup : group.getSubgroups()) {
            displayAllGroups(subgroup, depth + 1);
        }
    }

    public static void main(String[] args) {
        // 构建组织结构
        Group group1 = new Group("集团");
        Group department1 = new Group("部门1");
        Group department2 = new Group("部门2");
        Group group11 = new Group("小组1-1");
        Group group12 = new Group("小组1-2");
        Group group21 = new Group("小组2-1");

        group1.addSubgroup(department1);
        group1.addSubgroup(department2);
        department1.addSubgroup(group11);
        department1.addSubgroup(group12);
        department2.addSubgroup(group21);

        // 展示组织结构
        group1.displayAllGroups();
    }


}
