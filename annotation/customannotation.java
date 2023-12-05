//package annotation;

import java.lang.reflect.Method;

public class customannotation 
{
   public static void main(String[] args)throws Exception 
   {
    sample s =new sample();
    Method m = s.getClass().getMethod("sayHello");
    myAnno a = m.getAnnotation(myAnno.class);
    System.out.println("value is " +a.value());
   } 
}