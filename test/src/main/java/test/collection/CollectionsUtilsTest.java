package test.collection;

import test.collection.entity.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionsUtilsTest {


    public static void main(String[] args) {
        //可变参数可以不传参
//        test();
//        //可变参数可以传多个
//        test("first","second");
//        test("first");
//        //可变参数可以传个数组
//        test(new String[]{"first","second","third"});
//        //可变参数写在参数列表的最后面
//        test2("str", "first");
//
////        Collections.addAll();
//        HashSet<Object> hashSet = new HashSet<>();
//        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>();
//        TreeSet<Object> treeSet = new TreeSet<>();

        ArrayList<Student> studentArrayList = new ArrayList<>();
        Collections.addAll(studentArrayList,new Student("1",24,183.6));
        Map<Object, Object> map = studentArrayList.stream().collect(Collectors.toMap(new Function<Student, Object>() {
            @Override
            public Object apply(Student student) {
                return student.getName();
            }
        }, new Function<Student, Object>() {
            @Override
            public Object apply(Student student) {
                return student.getHeight();
            }
        }));


        Map<Object, Object> map2 = studentArrayList.stream().collect(Collectors.toMap(Student::getName, Student::getHeight));
        System.out.println(map2);
    }

    public static void test(String...strings){
        System.out.println(Arrays.stream(strings).count());
        System.out.println(strings.length);
        System.out.println("----------------------------------");
    }

    public static void test2(String s,String...strings){
        System.out.println(Arrays.stream(strings).count());
        System.out.println("s:" + s + "  strings:" + strings.length);
        System.out.println("=================================");
    }


   //可变参数只能写在参数列表的最后面
//    public static void test3(String...strings, int i){
//        System.out.println(Arrays.stream(strings).count());
//        System.out.println(strings.length);
//        System.out.println("----------------------------------");
//    }


//    一个参数列表只能有一个可变参数
//    public static void test1(String...strings, int...ints){
//        System.out.println(Arrays.stream(strings).count());
//        System.out.println("s:" + s + "  strings:" + strings.length);
//        System.out.println("=================================");
//    }
}
