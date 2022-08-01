package test.overWriteOrOverLoad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BasePeople {

    private String dept;

    private String employeeNo;

    public void getMoney() {
        System.out.println("雇员子类特有方法,努力赚钱!!!");
    }

    public void getMoney(String dept, String employeeNo) {
        System.out.println("getMoney方法重载1,dept:" + dept + ",employeeNo：" + employeeNo);
    }

    //只换顺序不会重载  是按参数类型，参数个数
//    public void getMoney(String employeeNo,String dept){
//        System.out.println("getMoney方法重载1");
//    }

}
