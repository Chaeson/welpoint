package kr.co.ubcn.welpoint.controller;

import kr.co.ubcn.welpoint.model.User;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@CrossOrigin
@RestController
public class LoginController {

    //@RequestMapping(value = "v1/login",method = {RequestMethod.GET,RequestMethod.POST})
    @PostMapping(value = "v1/login", consumes = {MediaType.APPLICATION_JSON_VALUE})
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> loginUser(@RequestBody User user, HttpSession session){
        log.info("UserInfo:{}",user.getUserId());
        log.info("Session:{}",session.getId());
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(user, status);
    }
}
