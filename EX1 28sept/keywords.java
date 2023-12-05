public class keywords 
{
    static int a = 10;
    int b = 20;
    
    void t1()
    {
        this.a = 100;
        System.out.println(this.a);
        System.out.println(this.b);
    }
   public static void main(String[] args) 
    {   
        keywords k = new keywords();
        superkey s = new superkey();
        s.t1();
        //k.t1();
    }
}

//Suoer key word calling parent class variable in child class

class superkey extends keywords
{
    // public static void main(String[] args) 
    // {
    //     superkey s = new superkey();
    //     s.t1();
    // }
    void t1()
    {
     super.b = 1000;
     System.out.println(super.b);
     super.t1();
    }
}