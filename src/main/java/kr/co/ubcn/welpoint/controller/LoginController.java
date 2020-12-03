package kr.co.ubcn.welpoint.controller;

import kr.co.ubcn.welpoint.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@CrossOrigin
@RestController
public class LoginController {

    @RequestMapping(value = "v1/login", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<User> loginUser(@RequestBody User user, HttpSession session){
        log.info("UserInfo:{}",user);
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<User>(user,status);
    }
}
