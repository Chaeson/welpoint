package kr.co.ubcn.welpoint.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginUser(HttpServletRequest request, HttpServletResponse response,
                            @RequestBody Object item){
        log.info("userId::{}",item.toString());
        return "Success";
    }
}
