package org.imooc.controller.interceptor;

import org.imooc.util.CommonUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {

    /***
     * 在进入Handler方法执行之前执行本方法
     *
     * @param request
     * @param response
     * @param handler
     * @return true:执行下一个拦截器，直到所有拦截器都执行完，再执行被拦截的Controller
     *          false:从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * @throws Exception
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(CommonUtil.contains(request.getSession(),request.getServletPath() ,request.getMethod() )){
            return true;
        }
        //针对Ajax请求
        if(request.getHeader("x-requested-with")!=null){
            String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
            response.setHeader("url",basePath+"/login/noAuth" );
        }else {
            request.getRequestDispatcher("/login/noAuth").forward(request,response );
        }
        return false;
    }

    /**
     * 在进入Handler方法之后，返回ModelAndView之前执行
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在Handler方法执行完之后执行
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
