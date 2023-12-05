import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)

@Target(ElementType.METHOD)

@interface MyAnnotation
{
double value1();
int value2();
}

//Applying annotation
class Hello
{
@MyAnnotation(value1=10.5 , value2=10)

public void sayHello()
{
    System.out.println("hello annotation");
}
}

//Accessing annotation
class a5 
{
public static void main(String args[])throws Exception
{
 
Hello h=new Hello();

Method m = h.getClass().getMethod("sayHello");

MyAnnotation manno=m.getAnnotation(MyAnnotation.class);

System.out.println("my value 1 is: "+manno.value1());
System.out.println("my value 2 is: "+manno.value2());

}
}


