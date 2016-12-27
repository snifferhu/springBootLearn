package com.webbase;

import com.common.cache.annotation.Cached;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * @auth snifferhu
 * @date 2016/12/22 23:35
 */
@Aspect
@Component
public class WebLogAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private final static Map<String,Method> methodCache = new ConcurrentHashMap<>(1024);

//    @Pointcut("execution(public * com.*.controller..*.*(..))")
//    @Pointcut("@annotation(com.common.cache.annotation.Cached)")
    public void webLog() {
    }

//    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HEAD : " + request.getHeaderNames());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        Optional<Annotation> opt = getAnnotation(joinPoint);
        if (opt.isPresent()){
            Annotation annotation = opt.get();
        }
        opt.orElseThrow(RuntimeException::new);

        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

//    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }


    private Optional<Annotation> getAnnotation(JoinPoint jp){
        Class<?> clazz = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        Method  method = null;;

        if (methodCache.containsKey(methodName)){
//            logger.info("Cache key : " + method.getAnnotation(Cached.class).key());
        }
        Method[] methods = clazz.getMethods();
        for (Method method0 : methods) {
            String methodName0 =  method0.getName();
            if( methodName0.equals(methodName)) {
                method = method0;
                methodCache.put(methodName,method);
            }
        }

        if (method == null){
            logger.error("AOP pointcut method not found! methodName={}",methodName);
        }
        Stream.of( method.getAnnotations()).forEach(x -> logger.info(x.toString()));
        Stream.of( method.getAnnotations()).forEach(x -> logger.info(x.annotationType().toString()));
        return Stream.of(method.getAnnotations())
                .filter(x -> x.getClass().equals(Cached.class))
                .findAny();
    }
}