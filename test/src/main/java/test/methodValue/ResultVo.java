package test.methodValue;

import lombok.Data;

import java.util.List;

@Data
public class ResultVo {


    private String img;

    private Student student;

    private List<Student> olayBacklist;

    private List<Student> videoList;

}
