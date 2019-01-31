import java.util.LinkedList;
import java.util.concurrent.Semaphore;
 

 
 class semaphore {
    static Object Lock = new Object();
    static LinkedList<String> List = new LinkedList<String>();
    
  
    static Semaphore semaphore = new Semaphore(0);
    static Semaphore mutex = new Semaphore(1);
    
    
    static class Producer extends Thread {
        public void run() {
            
            int counter = 1;
            try {
                while (true) {
                    String threadName = Thread.currentThread().getName() + counter++;
                    
                    mutex.acquire();
                    List.add(threadName);
                    System.out.println("Producer is prdoucing new value: " + threadName);
                    mutex.release();
                    
                    
                    semaphore.release();
                    Thread.sleep(500);
                }
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }
    
    
    static class Consumer extends Thread {
        String consumerName;
        
        public Consumer(String name) {
            this.consumerName = name;
        }
        
        public void run() {
            try {
                
                while (true) {
                    
                    
                    semaphore.acquire();
                    
                    
                    mutex.acquire();
                    String result = "";
                    for (String value :List) {
                        result = value + ",";
                    }
                    System.out.println(consumerName + " consumes value: " + result);
                    mutex.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        new Producer().start();
        new Consumer("C1").start();
        new Consumer("c2").start();
        new Consumer("c3").start();
    }
}