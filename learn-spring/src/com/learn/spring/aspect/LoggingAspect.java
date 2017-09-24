package com.learn.spring.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	// @Before("execution(public String com.learn.spring.aop.dto.Square.getName())")
	// @Before("execution(public String getName())")
	// @Before("execution(* get*())")
	// @Before("execution(* get*(*))")
	// @Before("execution(* get*(..))")
	// @Before("pointCutForGetMethods()")
	// @Before("pointCutForGetMethods() && allSquareMethods()")
	// public void adivceBeforeExecutionExpression() {
	// System.out.println("Advice run - Aspect before method called for 'execution' expression");
	// }

	// @Before("args(name)")
	// public void adviceBeforeArgsExpression(String name) {
	// System.out.println("Advice run - Aspect before method called for 'args' expression. Arg value is " + name);
	// }

	// @Before("within(com.learn.spring.aop.dto.Square)")
	// public void adviceBeforeWithinExpression() {
	// System.out.println("Advice run - Aspect before method called for 'within' expression");
	// }

	// @Before("pointCutForGetMethods()")
	// public void adviceJoinPoint(JoinPoint joinPoint) {
	// Square target = (Square) joinPoint.getTarget();
	// System.out.println("Printed from advice - " + target.getName());
	// }

	// @Before("execution(* get*(..))")
	// @Before("pointCutForGetMethods()")
	// public void secondAdvice() {
	// System.out.println("Second advice executed");
	// }

	// @After("args(name)")
	// @AfterReturning("args(name)")
	@AfterReturning(pointcut = "args(name)", returning = "returnString")
	public void adviceAfterReturning(String name, String returnString) {
		System.out.println("A method that takes String object as an argument. The value is - " + name);
		System.out.println("The output value is - " + returnString);
	}

	// @AfterThrowing("within(com.learn.spring.aop.dto.Square)")
	// public void adviceAfterThrowing() {
	// System.out.println("Advice run - Aspect after exception has been thrown");
	// }

	// @Around(value = "pointCutForGetMethods()")
	// @Around("@annotation(com.learn.spring.aspect.Loggable)")
	// public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
	// Object returnValue = null;
	// try {
	// System.out.println("Before advice");
	// returnValue = joinPoint.proceed();
	// System.out.println("After returning");
	// } catch (Throwable e) {
	// System.out.println("After throwing");
	// }
	// System.out.println("After finally");
	// return returnValue;
	//
	// }

	@Pointcut("execution(public String getName())")
	public void pointCutForGetMethods() {}

	// @Pointcut("execution(* com.learn.spring.aop.dto.Square.*(*))")
	// @Pointcut("within(com.learn.spring.aop.dto.Square)")
	// @Pointcut("within(com.learn.spring.aop.dto.*)")
	@Pointcut("within(com.learn.spring.aop.dto..*)")
	public void allSquareMethods() {}

}
