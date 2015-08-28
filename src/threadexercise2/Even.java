package threadexercise2;

/**
 *
 * @author Pernille
 */
public class Even
{
      private static int n = 0;

    public synchronized static int next()
    {
      
        n++;
        n++;

        return n;
    }

    public static class Thread1 extends Thread
    {
        Even ev;
        private Thread1(Even even)
        {
        ev = even;
        }

        public void run()
        {
            
            for(int i = 0; i<200; i++)
            {
            System.out.println(""+ev.next());
            
            }
            

        }
    }
    
    public static void main(String[] args)
    {
        Even even = new Even();
        Thread1 thread1 = new Thread1(even);
        Thread1 thread2 = new Thread1(even);
        thread1.start();
        thread2.start();
        try
        {
         thread1.join();
         thread2.join();
            System.out.println("n er: "+ n);
        }catch (InterruptedException ex)
        {
            
        }
    }

}
