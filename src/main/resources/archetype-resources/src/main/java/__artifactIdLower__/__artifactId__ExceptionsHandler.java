package ${customPackage};

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * The @ControllerAdvice annotation was first introduced in Spring 3.2.
 * It allows you to handle exceptions across the whole application, not just to an individual controller.
 * You can think of it as an interceptor of exceptions thrown by methods annotated with @RequestMapping or
 * one of the shortcuts.
 * --
 * https://medium.com/@jovannypcg/understanding-springs-controlleradvice-cd96a364033f
 */
@ControllerAdvice
public class ${artifactId}ExceptionsHandler{
    //TODO
}