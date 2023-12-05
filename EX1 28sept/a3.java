public class a3 
{
    public static void main(String[] args) 
    {
        a a1 = new a();
        a1.n();
    }
}
class a 
{
  void m()
  {
    System.out.println("error");
  }
  @Deprecated
  void n()
  {
    System.out.println("error");
  }
}
