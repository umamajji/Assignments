package NewToursProj;

import org.testng.annotations.Test;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
   @Test
    public void generateFirstName()
    {
        int count=0;
        final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

       final int N=ALPHA_NUMERIC_STRING.length();
        Random r=new Random();
       for(int i=0;i<7;i++)
       {
        System.out.print(ALPHA_NUMERIC_STRING.charAt(r.nextInt(N)));
        }

    }

}
