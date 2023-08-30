package test.methodValue;

public class TestMethod3 {

    public static void main(String[] args) {

        Integer i1 = 30;
        Integer i2 = 30;

        Integer i3 = 40;
        Integer i4 = new Integer(30);

        Integer i5 = 128;
        Integer i6 = 128;

        Integer i7 = -128;
        Integer i8 = -128;


        System.out.println(i1.equals(i2));
        System.out.println(i1.equals(i3));
        System.out.println(i1.equals(i4));
        System.out.println("==========");
        System.out.println(i1 == i2);
        System.out.println(i1 == i4);
        System.out.println("==========");
        System.out.println(i5.equals(i6));
        System.out.println(i5 == i6);
        System.out.println("==========");
        System.out.println(i7.equals(i8));
        System.out.println(i7 == i8);

        //接口的成员变量默认为
        System.out.println(InterfaceTestMethod.interfaceName);

    }



}
