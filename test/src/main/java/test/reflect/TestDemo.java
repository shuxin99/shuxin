package test.reflect;

import test.methodValue.Student;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class TestDemo {

    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//
//        list.add("1");
//        list.add("2");
//        list.add("3");
//
//
//        List<String> arrayList = new ArrayList<>();
//        arrayList.add("5");
//        arrayList.addAll(list);
//        arrayList.forEach(System.out::println);
//
//        List<String> l = arrayList.stream().filter(s -> s.length()==1).collect(Collectors.toList());
//
//        l.forEach(System.out::println);


//        int intervals[][] = { {1,3},{2,6},{8,10},{4,7}};
//        //对二维数组中的每个数组中第一个值进行排序
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//
//        for (int[] interval : intervals) {
//            System.out.println(interval[0]+","+interval[1]);
//        }
//
//        List<int[]> list = new ArrayList();
//
//        list.toArray(new int[0][0]);

//        Collectors.maxBy(),
//        Collectors.minBy()
          testCollectsGroupBy();

    }



    public static void testCollectsGroupBy(){

        Student s1 = new Student("1号","22","男",20.6);
        Student s2 = new Student("2号","24","男",345.3462344);
        Student s7 = new Student("7号","24","男",345.346);
        Student s5 = new Student("5号","28","男",345.340);
        Student s3 = new Student("3号","21","女",356.78996);
        Student s6 = new Student("6号","24","女",33555.6666669);
        Student s4 = new Student("4号","24","女",33555.66666);
        Student s8 = new Student("8号","24","女",33555.66667);

        List<Student> studentsList = new ArrayList<>();
        studentsList.add(s1);
        studentsList.add(s2);
        studentsList.add(s3);
        studentsList.add(s4);
        studentsList.add(s5);
        studentsList.add(s6);
        studentsList.add(s7);
        studentsList.add(s8);

        //求每组中年龄最大值
        Map<String, Optional<Student>> collect = studentsList.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.maxBy(Comparator.comparing(Student::getAge))));

        collect.forEach( (key,value)->{
            System.out.println("最大值 key:" + key);
            value.ifPresent(v -> System.out.println("最大值 value:" + v));
        });

        System.out.println("=============================");
        //求每组中年龄最大值
        Map<String, Optional<Student>> collect2 = studentsList.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.minBy(Comparator.comparing(Student::getAge))));

        collect2.forEach( (key,value)->{
            System.out.println("最小值 key:" + key);
            value.ifPresent(v -> System.out.println("最小值 value:" + v));
        });

        System.out.println("===================");

        Map<String, Optional<Student>> collect3 = studentsList.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.minBy(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.parseInt(o2.getAge()) - Integer.parseInt(o1.getAge());
            }
        })));

        collect3.forEach( (key,value)->{
            System.out.println("最小值 key2:" + key);
            value.ifPresent(v -> System.out.println("最小值 value2:" + v));
        });

        System.out.println("===================");

        Map<String, Optional<Student>> collect4 = studentsList.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.minBy(Comparator.comparingInt(o -> o.getSalary().intValue()))));
        Map<String, Optional<Student>> collect5 = studentsList.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.maxBy(Comparator.comparingInt(o -> o.getSalary().intValue()))));


        Map<String, Optional<Student>> collect6 = studentsList.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.maxBy(Comparator.comparing(o -> BigDecimal.valueOf(o.getSalary())))));
        Map<String, Optional<Student>> collect7 = studentsList.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.minBy(Comparator.comparing(o -> BigDecimal.valueOf(o.getSalary())))));

        Map<String, Optional<Student>> collect8 = studentsList.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.maxBy(Comparator.comparingDouble(Student::getSalary))));


        collect4.forEach( (key,value)->{
            System.out.println("最小值 key4:" + key);
            value.ifPresent(v -> System.out.println("最小值 value4:" + v));
        });
        System.out.println("=====================");
        collect5.forEach( (key,value)->{
            System.out.println("最小值 key5:" + key);
            value.ifPresent(v -> System.out.println("最小值 value5:" + v));
        });
        System.out.println("=====================");
        collect6.forEach( (key,value)->{
            System.out.println("最大值 key6:" + key);
            value.ifPresent(v -> System.out.println("最大值 value6:" + v));
        });

        System.out.println("=====================");
        collect7.forEach( (key,value)->{
            System.out.println("最小值 key7:" + key);
            value.ifPresent(v -> System.out.println("最小值 value7:" + v));
        });

        System.out.println("=====================");
        collect8.forEach( (key,value)->{
            System.out.println("最小值 key8:" + key);
            value.ifPresent(v -> System.out.println("最小值 value8:" + v));
        });


    }
}
