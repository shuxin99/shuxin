package test.collection;

import test.collection.entity.Student;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class CollectionTest {

    public static void main(String[] args) {

        Set<Student> treeSet = new TreeSet<>();
        //treeSet底层为红黑树，不存相同的值，所以只有3条数据
        treeSet.add(new Student("小红", 22, 165.7));
        treeSet.add(new Student("小美", 22, 168.7));
        treeSet.add(new Student("小明", 23, 179.7));
        treeSet.add(new Student("小刚", 21, 183.7));
        System.out.println(treeSet);
        System.out.println("=====================================");

        Set<Student> studentTreeSet = new TreeSet<>(Comparator.comparingDouble(Student::getHeight));

        studentTreeSet.add(new Student("小红", 22, 165.7));
        studentTreeSet.add(new Student("小美", 22, 168.7));
        studentTreeSet.add(new Student("小明", 23, 179.7));
        studentTreeSet.add(new Student("小刚", 21, 183.7));
        System.out.println(studentTreeSet);

    }



}
