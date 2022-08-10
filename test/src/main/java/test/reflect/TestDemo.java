package test.reflect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");


        List<String> arrayList = new ArrayList<>();
        arrayList.add("5");
        arrayList.addAll(list);
        arrayList.forEach(System.out::println);

        List<String> l = arrayList.stream().filter(s -> s.length()==1).collect(Collectors.toList());

        l.forEach(System.out::println);

    }
}
