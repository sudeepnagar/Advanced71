package test;

public class Access
{
       public static ITest getRef()
       {
           ITest ob = new ITest()
            {

                    public void m1(int x)
                    {
                       System.out.println("******Implemented method m1(x)*****");
                       System.out.println("The value x:"+x);
                      }
             };
              return ob;
         }//OuterClass static method
}//OuterClass
