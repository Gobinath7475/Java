public class thisparent 
{
    thisparent()
    {
        this(10);
        System.out.println("default is running");
    }
    thisparent(int a )
    {
         this("");
        System.out.println("integer running");
    }
    thisparent(String a)
    {
        this("","");
        System.out.println("String running");
    }
    thisparent(String a , String b)
    {
        System.out.println("String1 running");
    }

    public static void main(String[] args) 
    {
        // thisparent, t = new thisparent(10);
        thisparent t1 = new thisparent();
    }
}
