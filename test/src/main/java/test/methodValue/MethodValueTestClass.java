package test.methodValue;


import java.util.Arrays;

public class MethodValueTestClass {

    public static int c = 30;


    public static void main(String[] args) {
        //值传递
        int a = 10;
        int b = 20;
        swap(a, b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        //静态变量值传递
        change(c);
        System.out.println("c = " + c);

        //改变静态变量的值
        c = change(c);
        System.out.println("c = " + c);

        //方法的引用传递
        //1.字符串
        String s1 = "a";
        String s2 = "b";

        resetString(s1);
        System.out.println("s1 = " + s1);

        //2.数组
        System.out.println("数组:");
        int[] arr = new int[]{0, 1, 2, 3, 4};
        changeArr(arr);
        Arrays.stream(arr).forEach(System.out::println);

        //3.实体类
        System.out.println("实体类:");
        Student student = new Student("小强", "22", "男",33.66);
        changeEntity(student);
        System.out.println("student.name = " + student.getName());
    }

    //两值交换
    public static void swap(int a, int b) {
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
    }

    //静态变量
//    public static void change(int i) {
//        i = 33;
//    }

    //方法重载只改变返回值的类型是不行的
    public static int change(int i) {
        i = 33;
        return i;
    }

    //重新设置字符串的值
    public static void resetString(String s) {
        s = "reset";
    }

    //改变数组中的值
    public static void changeArr(int[] arr) {
        arr[0] = 10;
    }

    //实体对象
    public static void changeEntity(Student student){
        student.setName("蟑螂");
    }


}
