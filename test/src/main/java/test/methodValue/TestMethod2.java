package test.methodValue;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;

public class TestMethod2 {

    public static void main(String[] args) {

//        ArrayList<String> list1 = new ArrayList<>(
//                Arrays.asList("99629000202112060299500",
//                "99629000202112060299490",
//                "99629000202112060299480",
//                "79757000202107296503270"));
//        ArrayList<String> list2 = new ArrayList<>(
//                Arrays.asList("99629000202112060299500",
//                        "99629000202112060299490",
//                        "99629000202112060299480",
//                        "79757000202107296503270",
//                        "79757000202105212177830",
//                        "79757000202105212176560",
//                        "79757000202107296501360")
//        );
//
//        list2.removeAll(list1);
//        list2.forEach(System.out::println);
//
//
//        System.out.println("============");
//
//        List<String> collect = list2.stream().filter(s -> !list1.contains(s)).collect(Collectors.toList());
//        collect.forEach(System.out::println);


        ArrayList<ResultVo> resultVos = new ArrayList<>();

        ResultVo resultVo = new ResultVo();
        resultVo.setImg("头像1");
        resultVo.setStudent(new Student("1","22","n",20.4));
        resultVo.setOlayBacklist(new ArrayList<>(Collections.singletonList(new Student("2", "32", "n", 2555.6))));
        resultVo.setVideoList((new ArrayList<>(Collections.singletonList(new Student("3", "33", "nv", 56.6)))));


        ResultVo resultVo2 = new ResultVo();
        resultVo2.setImg("头像2");
        resultVo2.setStudent(new Student("1","22","n",20.4));
        resultVo2.setOlayBacklist(new ArrayList<>(Collections.singletonList(new Student("2", "32", "n", 2555.6))));
        resultVo2.setVideoList((new ArrayList<>(Collections.singletonList(new Student("3", "33", "nv", 56.6)))));

        resultVos.add(resultVo);
        resultVos.add(resultVo2);


        Result result = new Result();
        result.setCode("0000");
        result.setMessage("成功");
        result.setData(resultVos);

        System.out.println(JSON.toJSONString(result));
    }
}
