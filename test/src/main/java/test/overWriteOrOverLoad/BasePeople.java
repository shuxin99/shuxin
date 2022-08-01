package test.overWriteOrOverLoad;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasePeople {

    protected String name;
    protected String sex;

    public String eat(){
        return "吃";
    }

    //根据子类的不同进行重写
    public String work(){
        return "父类默认work方法";
    }

}
