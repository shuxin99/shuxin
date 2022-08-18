package cors.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/cors")
public class CORSTestClass {


    @RequestMapping("/withoutParameter")
    public String testCorsWithoutParameter(HttpServletRequest request){

        StringBuilder builder = new StringBuilder();
        builder.append("进入withoutParameter方法了");
        System.out.println(builder.toString());
        return builder.toString();
    }


    @RequestMapping("/withParameter")
    public String testCorsWithParameter(HttpServletRequest request, @RequestBody String jsonStr){
        System.out.println("进入withParameter方法了");
        return jsonStr;
    }

}
