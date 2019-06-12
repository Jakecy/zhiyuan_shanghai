package com.service;


import com.dao.SysUserMapper;
import com.model.SysUser;
import com.result.Result;
import com.vo.LoginData;
import com.vo.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service("loginService")
public class LoginService  {


    @Autowired
    private SysUserMapper sysUserMapper;

    public Result<LoginData> backLogin(LoginParam param, HttpServletRequest request, HttpServletResponse response) {// 用户名和密码
        String username = param.getUsername();
        String password = param.getPassword();

        if (StringUtils.isEmpty(username)){
            return new Result<LoginData>().error("用户名为空");
        }
        if (StringUtils.isEmpty(password)){
            return   new Result<LoginData>().error("密码为空");
        }
        SysUser user = sysUserMapper.selectByUsername(username.trim());
        System.out.println(user);
        if (user == null) {
            return new Result<LoginData>().error("用户不存在");
        }
        if (!password.equals(user.getPassword())) {
            return new Result<LoginData>().error("用户名或密码错误");
        }
        LoginData loginData = new LoginData();

        //把用户信息保存在session中
        HttpSession session = request.getSession(true);
        session.setAttribute(String.valueOf(user.getId()), user);
        session.setAttribute("curUser", user);
        loginData.setAccountId(user.getId());
        loginData.setUsername(user.getUserName());
        //以秒为单位
        //设置时间为12小时
        session.setMaxInactiveInterval(12 * 60 * 60);
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(session.getMaxInactiveInterval());
        request.getContextPath();
        cookie.setPath("/");
        response.addCookie(cookie);
        return new Result<LoginData>().ok(loginData);
    }
}
