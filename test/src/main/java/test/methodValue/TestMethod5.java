package test.methodValue;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TestMethod5 {

    public static void main(String[] args) {

//        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();

        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
        //没有指定类型的话会报错
        s=list.toArray(new String[0]);
        Object[] objects = list.toArray();

//        for (String s1 : s) {
//            if (s1 instanceof String){
//                System.out.println(s1);
//            }
//        }
//        System.out.println("===============");
//        for (Object object : objects) {
//            if (object instanceof String){
//                System.out.println(object);
//            }
//        }
        testMethod1();
    }



    public static void testMethod1(){
        int[] myArray = {1, 2, 3};
        List myList = Arrays.asList(myArray);
        System.out.println(myList.size());//1
        System.out.println(myList.get(0));//数组地址值
//        System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
        int[] array = (int[]) myList.get(0);
        System.out.println(array[0]);//1
        System.out.println(array[1]);//2
        System.out.println(array[2]);//3

        myList.add(new int[0]);// 不能够在对myList做add/remove/clear操作，否则报错 UnsupportedOperationException

    }
}
