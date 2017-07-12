package api.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hechengjin on 17-7-12.
 */
//@RestController
@Controller
@RequestMapping(value = "/w")
public class WebParentController {

    @RequestMapping("/zeroException")
    @ResponseBody
    public int zeroException(){
        return 100/0;
    }

    @RequestMapping(value = "/except1", method = RequestMethod.GET)
    @ResponseBody
    public String test2() {
        throw new RuntimeException("advice1 - exception1");
    }
}
