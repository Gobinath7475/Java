public class customwraper 
{
    private int a ;

   customwraper(){}

   customwraper(int a)
   {
    this.a = a;
   }

   public int getvalue()
   {
    return a;
   }

   public void setvalue(int a)
   {
    this.a = a; 
   }

   public String toString()
   {
    return Integer.toString(a);
   }


   public static void main(String[] args) 
   {
    customwraper c = new customwraper(10);
    System.out.println(c);
   }
}
