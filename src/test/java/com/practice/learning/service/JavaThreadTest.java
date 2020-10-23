package com.practice.learning.service;


import com.practice.learning.threads.ProducerConsumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class JavaThreadTest {



    @Test
    public void runnablePattern() throws Exception {
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());

        Thread t1 = new Thread(runnable);

        t1.start();


        //to interrupt a thread
//        t1.interrupt();


        t1.join();
    }


    // wait() releases the key from inside the synchhronized block and puts the object thread in a waiting state. To release we use the notify() method and puts it
    //into runnable state
    @Test
    public void waitAndNotifyPattern() throws Exception
    {
        ProducerConsumer.Producer producer = new ProducerConsumer.Producer();
        ProducerConsumer.Consumer consumer = new ProducerConsumer.Consumer();

        Runnable prodRunnable = ()->{
          for(int i=0;i<50;i++){
                  producer.produce();
          }
        };

        Runnable consumeRunnable = ()->{
            for(int i=0;i<50;i++){
                    consumer.consume();
            }
        };

        Thread prodThread = new Thread(prodRunnable);
        Thread consumeThread = new Thread(consumeRunnable);

        prodThread.start();
        consumeThread.start();


        prodThread.join();
        consumeThread.join();


        System.out.println("Data in buffer counter: " + ProducerConsumer.count);
    }


    //states of a thread
    // thread.start() => Thread is in a runnable state
            // with respect to this state
            // thread could be in blocked state, like without wait and notify the thread would go in infinite loop and not release its lock. So other thread is blocked since it cannot get the lock.
            // thread could be in waiting state, as it would wait for another thread having lock would notify the releasing of the lock
            // thread could be in timed waiting state, as it would be waiting but after some fixed time the system would notify it to be active and not any other threads like in the waiting state.
            //A blocked/waiting thread not getting a notify would eventually put the application into a blocked state
    //terminated => thread has completed its task



    //A thread is in the blocked state when it tries to access a protected section of code that is currently locked by some other thread.
    // When the protected section is unlocked, the schedule picks one of the thread which is blocked for that section and moves it to the runnable state.
    // Whereas, a thread is in the waiting state when it waits for another thread on a condition. When this condition is fulfilled,
    // the scheduler is notified and the waiting thread is moved to runnable state.



    //A synchronized keyword at two methods in a class basically tells that one instance of the class can't be used by two threads at the same time to hit the method together with a race condition.

}
