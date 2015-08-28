package threadexercise1;

/**
 *
 * @author Pernille
 */
public class ThreadExercise1
{

    public static long sum;
//    public static final int TEN_SECONDS = 10000;
    public static volatile boolean stop = false;
    

    public static class Thread1 extends Thread
    {

        public void run()
        {
            for (long i = 0; i < 1000000000; i++)
            {
                sum = sum + i;

            }
            System.out.println("sum af alle tal er" + sum);
        }

    }

    public static class Thread2 extends Thread
    {

        public void run()
        {
            for (int i = 0; i < 6; i++)
            {
                System.out.println("" + i);
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
// fall through
                }
            }

        }
    }

    public static class Thread3 extends Thread
    {

        public void run()
        {
            while (stop == false)
            {
                for (int i = 0; i<5000; i++)
                {
                System.out.println("" + i);
                }
                try
                {
                    Thread.sleep(3000);
                    
                } catch (InterruptedException e)
                {
// fall through
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();   
        thread1.start();
        thread2.start();
        thread3.start();
        try
        {
        Thread.sleep(10_000);
        }catch (InterruptedException e)
                {
// fall through
                }
           stop = true;
            }
 

    }

