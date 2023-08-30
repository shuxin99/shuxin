package test.methodValue;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestMethod {

    public static void main(String[] args) {


        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("1","10","nan",1000.0));
        list.add(new Student("2","20","nan",2000.0));
        list.add(new Student("3","30","nan",3000.0));

        list.stream().peek(s -> {
            s.setSalary(5000.0);
        }).collect(Collectors.toList());

        list.forEach(student -> System.out.println(JSON.toJSONString(student)));



        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        list2.add(1);
        list2.add(2);
        list2.add(3);

//        List<Integer> collect = list2.stream().peek().collect(Collectors.toList());
        List<Integer> collect =list2.stream().peek(list3::add).collect(Collectors.toList());

        list2.forEach(student -> System.out.println(JSON.toJSONString(student)));
        System.out.println("====================");
        collect.forEach(student -> System.out.println(JSON.toJSONString(student)));



    }

}
