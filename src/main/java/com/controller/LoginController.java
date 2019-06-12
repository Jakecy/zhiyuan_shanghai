package com.controller;

import com.result.Result;
import com.service.LoginService;
import com.vo.LoginData;
import com.vo.LoginParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Api(value = "LoginApiDoc")
@CrossOrigin
@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;


    @ApiOperation(value = "登录", httpMethod = "GET", notes = "登录")
    @RequestMapping(value = "/backLogin", method = RequestMethod.GET)
    public Result<LoginData> login( @RequestParam("username") String username, @RequestParam("password") String password,HttpServletRequest  request, HttpServletResponse response) {
        LoginParam vo=new LoginParam();
        vo.setUsername(username);
        vo.setPassword(password);
        System.out.println(vo);
        return loginService.backLogin(vo,request,response);
    }

    @ApiOperation(value = "登出", httpMethod = "POST", notes = "登出接口")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result<Boolean> logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if(session!=null){
            //清除session中的信息
            session.invalidate();
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            return new Result<Boolean>().ok(true);
        }
        return new Result<Boolean>().ok(true);
    }


}
