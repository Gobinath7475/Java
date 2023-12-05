abstract class vehiclemain
{
abstract void vehicle();

 void runs()
 {
    System.out.println("Vehicle runs");
 }

}

class car extends vehiclemain
{
    void vehicle()
    {
        System.out.println("Vehicle...");
    }
    void petrol()
    {
        System.out.println("car petrol runs");
    }
    void diesel()
    {
        System.out.println("car diesel runs");
    }
}

class bike extends vehiclemain
{
     void vehicle()
    {
        System.out.println("Vehicle...");
    }
    void petrol()
    {
        System.out.println("bike petrol runs");
    }
    void diesel()
    {
        System.out.println("bike diesel runs");
    }
}

class Abstractclass 
{
public static void main(String[] args) 
{
    bike b = new bike();
    car c = new car();

    System.out.println(b);
    System.out.println(c);

    System.out.println(b.equals(c));

    System.out.println(b.hashCode());
    System.out.println(c.hashCode());

    System.out.println(b.toString());
    System.out.println(c.toString());

    
    // b.petrol();
    // b.diesel();

    // c.petrol();
    // c.diesel();

    // b.vehicle();
    // b.runs();
    // b.getClass();
}
}
