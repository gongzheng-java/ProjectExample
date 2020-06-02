package com.amayadream.webchat.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 拦截器
 * NAME   :  EmailSystem/com.amayadream.interceptor
 * Author :  Amayadream
 * Date   :  2015.10.06 17:33
 * TODO   :
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private List<String> IGNORE_URI;//该集合的值是通过spring-mvc.xml 注入其中的

    /*
     * 重写父类方法
     *  preHandle：预处理回调方法，实现处理器的预处理（如登录检查），第三个参数为响应的处理器；
                返 回 值：true表示继续流程（如调用下一个拦截器或处理器）；
               false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取URI后缀
        String requestUri = request.getServletPath();

        //
        if(requestUri.equalsIgnoreCase("/"))    return true;

        //过滤不需要拦截的地址  遍历集合判断请求是否是/user/login、/user/logout结尾的，如果是则不用拦截，继续执行
        for (String uri : IGNORE_URI) {  //集合IGNORE_URI 中注入的值是 /user/login、/user/logout
            if (requestUri.startsWith(uri)) {//startsWith() 方法用于检测字符串是否以指定的前缀开始
                return true;
            }
        }
        //如果不是，则获取session信息，判断是否为空，如果为空 则跳转到登录页面，不过不为空则继续执行
        HttpSession session = request.getSession();
        if(session != null && session.getAttribute("login_status") != null){
            return true;
        }else{
            response.sendRedirect("/user/login?timeout=true");//重定向到登录页面
            return false;
        }
    }

    
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
    
    

    public List<String> getIGNORE_URI() {
        return IGNORE_URI;
    }

    public void setIGNORE_URI(List<String> IGNORE_URI) {
        this.IGNORE_URI = IGNORE_URI;
    }
}
