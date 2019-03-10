package com.baizhi.aop;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Log;
import com.baizhi.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
//表明这个类是一个切面  适用范围在类上
@Aspect
@Component
public class Aount{
    @Autowired
    private LogService ls;

    public void setLs(LogService ls) {
        this.ls = ls;
    }

    private String adminName;

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    //指定是环绕通知  配置切入点   Before前置----->After后置
    @Around("@annotation(com.baizhi.aop.LogAnnotation)")
    public Object doAround(ProceedingJoinPoint mi) throws Throwable {
        //什么人--------》于Servlet-api耦合
        /*ServletRequestAttributes s = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpSession session = s.getRequest().getSession();
        Admin admin = (Admin)session.getAttribute("admin");
        String username = admin.getName();*/
        //什么时间
        Date date = new Date();
        //做了什么操作
        //拿到方法名称
        String MethodName = mi.getSignature().getName();
        //获取类的对象
        Class<?> target = mi.getTarget().getClass();
        //获取方法签名的的方法的参数类型
        Class<?>[] par=((MethodSignature) mi.getSignature()).getParameterTypes();
        //获取到具体方法
        //通过类对象的---->利用方法名和方法参数类型数组获取到具体方法
        Method method = target.getMethod(MethodName, par);
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        String opertionName = annotation.name();
        //是否成功
        String flag="失败";
        Object res = null;
        try {
            //目标方法开始运行，并返回执行结果
            res = mi.proceed();
            flag="成功";
        }catch (Exception e){
            e.printStackTrace();
        }
        ls.addData(new Log(null,adminName,date,opertionName,flag));
        return res;
    }
}
