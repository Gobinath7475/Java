 public class a1 
{ 
    public static void main(String[] args) 
    {
    animal a = new cat();
    a.run();;

}

}
class animal 
{
    @myfunction
    void run()
    {
        System.out.println("parent runs");
    }
}
class cat extends animal
{
    @Override
    void run()
    {
        System.out.println("child runs");
    }
}