public class boxing 
{
    public static void main(String[] args) 
    {
        //auto-boxing
        int a = 10;
        Integer i = 10;   
        Integer b = Integer.valueOf(a); 
        System.out.println(b);


        //unboxing
        Integer i1 = new Integer(10);
        int b1 = i1.intValue();
        int b2 = i1;
        System.out.println(b1);
        System.out.println(b2);

        // primitive to warapperclass
        System.out.println("primitive to warapperclass");
        
        int i2 = 100;
        long l1 = 15432;
        float f1 = 50.0f;
        double d1 = 12.25;

        Integer intobj=i2;  
        Long longobj=l1;  
        Float floatobj=f1;  
        Double doubleobj=d1; 

        System.out.println(intobj);
        System.out.println(longobj);
        System.out.println(floatobj);
        System.out.println(doubleobj);


        //wrapper to primitive
        System.out.println("wrapper to primitive");

        int intobj1 = intobj;
        long longobj1 = longobj;
        float floatobj1 = floatobj;
        double doubleobj1 = doubleobj;

        System.out.println(intobj1);
        System.out.println(longobj1);
        System.out.println(floatobj1);
        System.out.println(doubleobj1);


    }
}
