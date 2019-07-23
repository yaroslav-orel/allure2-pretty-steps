package com.github.yorel;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.splitByCharacterTypeCamelCase;
import static org.apache.commons.text.WordUtils.capitalizeFully;

@Aspect
public class HumanReadableStepAspect {

    @Around("execution(* io.qameta.allure.util.AspectUtils.getName(..))")
    public Object interceptStepName(ProceedingJoinPoint joinPoint) throws Throwable {
        String stepValue = (String) joinPoint.getArgs()[0];
        if(StringUtils.isNotEmpty(stepValue))
            return joinPoint.proceed();

        String retrievedMethodName = ((MethodSignature) joinPoint.getArgs()[1]).getName();
        return splitCamelCase(retrievedMethodName);
    }

    private static String splitCamelCase(String camelCase) {
        return capitalizeFully(join(splitByCharacterTypeCamelCase(camelCase), " "));
    }
}
