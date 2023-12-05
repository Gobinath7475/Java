public class accessModifier {
    public int m1()
    {
        System.out.println("public is running");
        return 0;
    }
    //public access modifier can be accessed within all the packages and methods
    private int m2()
    {
        System.out.println("private is running");
        return 1;
    }
    // private can be accessed within the specific class and we can access outside the class using getter and setter methods
    public static void main(String[] args) {
        accessModifier obj=new accessModifier();
        obj.m1();
        obj.m2();
    }
}
