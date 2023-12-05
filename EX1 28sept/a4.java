import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

public class a4 
{
    public static void main(String[] args) 
    {
        a4 a = new a4();
        a.myfunction();
    }

    private void myfunction() 
    {
        
    }
}

@Target({ElementType.ANNOTATION_TYPE , ElementType.FIELD, ElementType.METHOD })
@interface myfunction {}
@Inherited
@interface myfunction1
{
    int value()  default 0;
}
@interface myfunction2
{
    int value()  default 0 ;
    int value1() default 1 ;
}


