public class keymethods 
{
     keymethods()
    {
       System.out.println("parent is running......");
    }
    public static void main(String[] args) 
    {
        child c = new child();
    }
}

class child extends keymethods
{
    child ()
    {
        super();
        System.out.println("child is running.....");
    }
}
