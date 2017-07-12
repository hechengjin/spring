package api.controller.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hechengjin on 17-7-12.
 */
@RestController
@RequestMapping(value = "/w/hello")  //http://localhost:9090/api/w/hello/add
public class HelloController extends WebParentController{

    @RequestMapping(value = "/add")
    public String add() throws Exception{
        return "add";
    }


}
