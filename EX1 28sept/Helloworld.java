
public class Helloworld {
   
        static{
            System.out.println("static block");
        }
        {
        System.out.println("non static block ");
        }
        public Helloworld()
        {
            System.out.println("constructor call");
        }
        static void m1()
        {
            System.out.println(" static");
        }
        public static void main(String[] args)
         {
         System.out.println("Hello World");
         Helloworld obj=new Helloworld();
         m1();
    }
    static
        {
            System.out.println("static block12");
        }
    static
        {
            System.out.println("static block123");
        }
}
//when an object is created constructor is called and also nonstatic block is called