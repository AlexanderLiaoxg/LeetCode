package com.cbry.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyAnnotationDoit {
//    @MyAnnotation(name = "cbry")
//    public annotationName;

    @MyAnnotation(name = "cbryParam")
    public String test;
    
    @MyAnnotation(name = "cbryMethod")
    public static void getName(){}
    
    public static void nullMethod(){}

    public static void main(String[] args) {
    	   Class<MyAnnotationDoit> clazz = MyAnnotationDoit.class;
    	   
    	   //获得clazz（被注解类MyAnnotationDoit）里面所有方法信息
           Method[] methods = clazz.getDeclaredMethods();

           //获得clazz（被注解类MyAnnotationDoit）里面所有属性信息
           Field[] declaredFields = clazz.getDeclaredFields();
           

           System.out.println("methods个数："+methods.length);
           System.out.println("declaredFields个数："+declaredFields.length);
           System.err.println("开始遍历搜索方法注解：");
           
           //遍历循环所有方法信息
           for (Method method : methods) {
        	   System.out.println("使用类含有方法：" + method.getName());
               //判断method是否含有指定元素的注解
               if (method.isAnnotationPresent(MyAnnotation.class)) {           	   
                   //返回当前方法上的注解对象
            	   MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
                   //获得注解的值
                   System.out.println(method.getName() + "方法注解值：" + myAnnotation.name());

                   //如果一个注解有多个值，通过遍历取出（特别注意：reqMapping.val()，这个val()是你定义注解的成员）
/**                   String[] values = myAnnotation.val();
                   for (String value : values) {
                       System.out.println(value);
                   }
**/
               }
           }
           
           System.err.println("开始遍历搜索属性注解：");
           
           //获得类里面所有方法的注解信息
           for (Field declaredField : declaredFields) {
        	   System.out.println("使用类含有属性：" + declaredField.getName());
               if(declaredField.isAnnotationPresent(MyAnnotation.class)){
            	   MyAnnotation myAnnotation = declaredField.getAnnotation(MyAnnotation.class);
                   System.out.println(declaredField.getName() + "属性注解值："+myAnnotation.name());
               }
           }

           System.err.println("开始遍历搜索类注解：");
           //获得类上的所有注解
           Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
           for (Annotation declaredAnnotation : declaredAnnotations) {
               System.out.println("类注解值:"+ declaredAnnotation);
           } 

    }
}
