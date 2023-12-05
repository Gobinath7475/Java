public class unique 
{
    public static void main(String[] args) 
    {
        int a [] = {10 , 20 , 10 , 30 , 10 , 30 , 40 ,40};
        for (int i = 0; i < a.length; i++) 
        {
            for (int j = i+1; j < a.length; j++) 
            {
                if(a[i] == a[j])
                    a[j]=0;
            }
        }
        for (int i = 0; i < a.length; i++) 
        {
            if(a[i]!=0)
            System.out.println(a[i]);
        }
    }  
}
