package objcom;
public class objcompersion

{
        public static void main(String[] args)
    {
        book b1 = new book(1 , "harrypotter");
        book b2 = new book(2 , "harrypotter");
        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
        //book b2 = null;
        if(b1.hashCode() == b2.hashCode())
        {
            if(b1.equals(b2))
                System.out.println("Both Objects are equal. ");
            else
                System.out.println("Both Objects are not equal. ");
        }
        else
        System.out.println("Both Objects are not equal. ");
    }
}