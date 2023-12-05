interface Vehicle
{
   void runs ();

   void acceralates ();
}

class Bike implements Vehicle
{
 public void runs ()
 {
    System.out.println("bike runs");
 }
 public void acceralates ()
 {
    System.out.println("bike acceralates");
 }
 public void accident()
 {
    System.out.println("bike accidents");
 }
}
public class I1
{
public static void main (String [] args)
{
    Bike b = new Bike();
    b.runs();
    b.acceralates();
    b.accident();

    Vehicle v = new Bike();
    v.acceralates();
    v.runs();
    //v.accident();
}
}