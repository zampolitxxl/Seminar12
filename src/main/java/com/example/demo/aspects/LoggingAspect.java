package com.example.demo.aspects;

import com.example.demo.Repository.NoteRepository;
import com.example.demo.domain.Note;
import com.example.demo.service.NoteService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
public class LoggingAspect {
//private  static  NoteService noteService;
//private final NoteRepository noteRepository;


    //https://docs.spring.io/spring-framework/reference/core/aop/ataspectj.html
    @Around("execution(* com.example.demo.service.*.*(..))")
    @Order(1)
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        System.out.println("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute");

        System.out.println("Сообщение до вызова декаоируемого метода");



        Note note = new Note();
        note.setName("Jenny");
        note.setNote("Some other text!");




        Object [] newArguments = {note};

        //noteService.addNote(note);





        Object returnedByMethod = joinPoint.proceed();
        //System.out.println("Сообщение после вызова декаоируемого метода");


        return returnedByMethod;
    }



    @Around("execution(* com.example.demo.service.*.*(..))")
    @Order(2)
    public Object log2(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();





        Note note = new Note();
        note.setName("Jenny");
        note.setNote("Some other text!");



        //Object [] newArguments = {note};

        //noteService.addNote(note);





        Object returnedByMethod = joinPoint.proceed();
        //System.out.println("Сообщение после вызова декаоируемого метода");


        return returnedByMethod;
    }

    /*
    @Around("execution(* org.example.services.*.*(..))")
    @Order(2)
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() -start;
        System.out.println("Метод: "+joinPoint.getSignature().getName() + " - "+elapsedTime+" милсек");
        return result;
    }

    */

    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returnedValue")
    public void log(Object returnedValue) {
        System.out.println("Method executed and returned " + returnedValue);
    }


}
