package test.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class People {

    private String name;

    private String sex;

    public String age;

    protected String skinColor;


    public void eat() {
        System.out.println("people都会吃饭~~~");
    }

    protected void getSkin() {
        System.out.println("子类可以根据需要重写此方法获取子类特有肤色");
    }

    private String getAge() {
        return this.age;
    }

}
