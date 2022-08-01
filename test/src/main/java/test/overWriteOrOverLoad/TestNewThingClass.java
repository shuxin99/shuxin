package test.overWriteOrOverLoad;

public class TestNewThingClass {

    public static void main(String[] args) {

        Boss boss = new Boss();

        String eat = boss.eat();
        String work = boss.work();

        System.out.println("eat:" + eat);
        System.out.println("work:" + work);

        Employee employee = new Employee();
        String eat1 = employee.eat();
        String work1 = employee.work();
        System.out.println("eat1:" + eat1);
        System.out.println("work1:" + work1);

        employee.getMoney();
        //测试方法重载
        employee.getMoney("java开发部","162029");

    }

}
