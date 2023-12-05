import java.util.ArrayList;

public class a2 
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) 
    {
        ArrayList a = new ArrayList();
        a.add(10);
        a.add(100);
        a.add(150);
        for(Object obj : a)
    {
        System.out.println(obj);
    } 
    }
    
}
