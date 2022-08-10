package test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class GetReflectTestClass {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //获取反射的三种方法
        //1.对象获取反射
        People people = new People("小明", "男", "24","yellow");
        Class<? extends People> class1 = people.getClass();
        System.out.println(class1);

        //2.类名.class
        Class<People> class2 = People.class;
        System.out.println(class2);

        //3.Class.forName()
        Class<?> class3 = Class.forName("test.reflect.People");
        System.out.println(class3);


        //获取到的只是public修饰的成员变量
        Field[] fields = class1.getFields();
        System.out.println("fields.length = " + fields.length);

        //获取到的是类名
        String simpleName = class1.getSimpleName();
        System.out.println("simpleName = " + simpleName);

        //获取到是所有声明的Field 包括private修饰的
        Field[] declaredFields = class1.getDeclaredFields();
        System.out.println("declareFields.length = " + declaredFields.length);

        //获取到的只是 public修饰的
        Field age = class1.getField("age");
        System.out.println("age = " + age);
        //获取成员变量的名字
        String ageName = age.getName();
        System.out.println("ageName = " + ageName);

        //获取成员变量Field的值
        try {
            Object o = age.get(people);
            System.out.println("ageValue = " + o.toString());
        } catch (IllegalAccessException e) {
            System.out.println("出异常了");
        }

//        Field skinColor = class1.getField("skinColor");
//        System.out.println("skinColor = " + skinColor);


        //获取到的也是声明过的 名称为name的field
        Field name = class1.getDeclaredField("name");
        System.out.println("name = " + name);

        // protect修饰的也可以获取
        Field skinColor = class1.getDeclaredField("skinColor");
        System.out.println("skinColor = " + skinColor);

        //获取的是反射的名字
        String s = class1.getName();
        System.out.println(s);
        System.out.println("======================================");


        //根据字节码对象创建示例对象
        //1. class对象.newInstance()方法
        People p1 = class1.newInstance();
        System.out.println("p1 = " + p1);
        //2. 根据Constructor的呢哇Instance()方法
        Constructor<? extends People> constructor = class1.getConstructor();
        People p2 = constructor.newInstance();
        System.out.println("p2 = " + p2);

        //

    }

}
