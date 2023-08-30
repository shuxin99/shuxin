package test.methodValue;

public class TestMethod4 {

    public static void main(String[] args) {

        int a = 5;
        changeValue(5);
        System.out.println(a);
        Integer bb = 66;
        changeValue(bb);
        System.out.println(bb);
        Boolean cc = false;
        changeValue(cc);
        System.out.println(cc);

        String s = "caigou";
        changeValue(s);
        System.out.println(s);

    }


    public static void changeValue(int a){
        a = 10;
    }
    public static void changeValue(Integer b){
        b = 6;
    }
    public static void changeValue(Boolean c){
        c = true;
    }

    public static String changeValue(String s){
        s = "大菜狗";
        return s;
    }
}
