package com.cbry.annotation;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)	//不指定注解获取不到值
@Documented
public @interface MyAnnotation {
   /**
    // 8种基本类型
    intValue = 1,
    longValue = 0L,

    // String
    name = "annotation on class",
    // 枚举
    cityName = CityEnum.BEIJING,
    // Class
    clazz = Demo.class,
    // 注解
    annotation2 = @MyAnnotation2,
    // 一维数组
    intValueArray = {1, 2},
    names = {"Are", "you", "OK?"}
    **/

   String name = "MyAnnotation Default Name";

    String name() default "MyAnnotation name() Default Name";
}
