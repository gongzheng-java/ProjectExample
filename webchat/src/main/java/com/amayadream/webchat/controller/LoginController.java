package com.amayadream.webchat.controller;

import com.amayadream.webchat.pojo.User;
import com.amayadream.webchat.service.ILogService;
import com.amayadream.webchat.service.IUserService;
import com.amayadream.webchat.utils.CommonDate;
import com.amayadream.webchat.utils.LogUtil;
import com.amayadream.webchat.utils.NetUtil;
import com.amayadream.webchat.utils.WordDefined;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Author :  Amayadream
 * Date   :  2016.01.08 14:57
 * TODO   :  用户登录与注销
 */
@Controller
@RequestMapping(value = "/user")
public class LoginController {

    @Resource
    private IUserService userService;

    @Resource
    private ILogService logService;

    /**
     * 当发生异常不能正常登录时，重新进入登陆页面
     * @return String 页面视图的名称
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";//
    }

    /**
     * 用户登录
     * @param userid   用户id 相当于用户名
     * @param password 用户密码
     * @param session
     * @param attributes  RedirectAttributes 重定向类 用于重定向到另一个controller方法的时候传递参数
     * @param defined 消息工具类
     * @param date 时间工具类
     * @param logUtil 日志工具类
     * @param netUtil 网络工具类
     * @param request 
     * @return String 
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String userid, String password, HttpSession session, RedirectAttributes attributes,
                        WordDefined defined, CommonDate date, LogUtil logUtil, NetUtil netUtil, HttpServletRequest request) {
        User user = userService.selectUserByUserid(userid);
        if (user == null) {
        	//使用重定向，带参传递登陆结果信息，对应key，value，此处对应“用户名不存在”
            attributes.addFlashAttribute("error", defined.LOGIN_USERID_ERROR);
            return "redirect:/user/login";//重定向到另一个controller映射方法中，即该类上面的第一个login方法
        } else {
            if (!user.getPassword().equals(password)) {
                attributes.addFlashAttribute("error", defined.LOGIN_PASSWORD_ERROR);//密码错误
                return "redirect:/user/login";
            } else {
                if (user.getStatus() != 1) { //查询到结果，但是账号被禁用
                    attributes.addFlashAttribute("error", defined.LOGIN_USERID_DISABLED);
                    return "redirect:/user/login";
                } else {
                	//调用日志方法，写入日志到数据库
                    logService.insert(logUtil.setLog(userid, date.getTime24(), defined.LOG_TYPE_LOGIN, defined.LOG_DETAIL_USER_LOGIN, netUtil.getIpAddress(request)));
                    System.out.println("查看用户角色（0 普通访客  1 管理员 ）："+user.getCharacter()); 
                    session.setAttribute("Character", user.getCharacter());//保存角色状态
                    session.setAttribute("userid", userid);//保存用户名
                    session.setAttribute("login_status", true);//保存登陆状态
                    user.setLasttime(date.getTime24());//保存最后的登陆时间
                    userService.update(user);//更新到数据库
                    attributes.addFlashAttribute("message", defined.LOGIN_SUCCESS);//重定向到聊天页面，传递登陆成功信息
                    return "redirect:/chat";//重定向到UserController.java类中的getIndex()方法
                }
            }
        }
    }

    /*退出登录*/
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, RedirectAttributes attributes, WordDefined defined) {
        session.removeAttribute("userid");
        session.removeAttribute("login_status");
        attributes.addFlashAttribute("message", defined.LOGOUT_SUCCESS);
        return "redirect:/user/login";
    }
}
