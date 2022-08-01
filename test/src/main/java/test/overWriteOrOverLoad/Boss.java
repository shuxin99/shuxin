package test.overWriteOrOverLoad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boss extends BasePeople{

    private String type;

    private String salary;

    @Override
    public String work() {
        return "我是大老板！！！";
    }
}
