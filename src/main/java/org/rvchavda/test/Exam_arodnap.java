package org.rvchavda.test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Exam_arodnap {
    public static void main2(String[] args) throws InterruptedException {
        int n = 0;
        Random random = new Random(45456);
        //ExperimentWebHandler experimentWebHandler = new ExperimentWebHandler();

        while (n < 5) {
            //System.out.println(experimentWebHandler.isInExperiment(random.nextInt(), 1));
            n++;

        }
        //1. Batch the experimentEvents and log in the batch sizes that can be configured runtime
        //2. Should be Async call to post the experiment events
        //3. Try and think of muti threading processing paradigm to improve perf

    }

    public static void main(String[] args) {
        System.out.println("Hello, world!");
        //int[] nums = new int[]{10,2,3,5,1,8};// 1-6

        //Add all the numbers in TreeSet<Integer> ->
        //iterate
        //10 => sum from 1:10 => 55 (n/2(n+1)
        //Sum of all the array Elements

        int number = 12344321;
        int rem = Integer.MAX_VALUE;
        int pow = 0;
        while (rem > 0) {
            rem = number / (int) Math.pow(10, pow);
            pow++;
        }
        System.out.println("Pow:" + pow);
        pow--;

        System.out.println(number / (int) Math.pow(10, pow / 2));
        int secondHalf = number % (int) Math.pow(10, pow / 2);

        int newNum = 0;
        newNum = newNum + (secondHalf % (int)Math.pow(10, pow / 2));
        System.out.println("newNum:" + newNum);
    }
}



/*class ExperimentWebHandler {
    //	web api to compute if a listener belongs to an experiment
    public boolean isInExperiment(long listenerId, long experimentId) throws InterruptedException {
        ExperimentHelper experimentHelper = new ExperimentHelper();
//		Sync call
        boolean isInExperiment = experimentHelper.computeExperiment(listenerId, experimentId);
        EventLoggingManager eventLoggingManager = new EventLoggingManager();
//		Sync call
        eventLoggingManager.logEvent(new ListenerExperimentInfo(listenerId,experimentId,isInExperiment));
        return isInExperiment;
    }
}

class ExperimentHelper {
    public boolean computeExperiment(long listenerId, long experimentId) throws InterruptedException {
        return compute(listenerId, experimentId);
    }

    private boolean compute(long listenerId, long experimentId) throws InterruptedException {
        Thread.sleep(2);
        Random random = new Random(experimentId);
        Random random1 = new Random(listenerId);
        return random.nextBoolean() && random1.nextBoolean();
    }
}

class EventLoggingManager implements Runnable {
    //	method to log the result of each isInExperiment api to the backend hadoop server
    ExecutorService exService;
    public EventLoggingManager() {
        exService = Executors.newFixedThreadPool(10);
        exService.submit(EventLoggingManager::new);
    }

    BlockingQueue<ListenerExperimentInfo> listenerExperimentInfoQueue = new ArrayBlockingQueue<>(1000000);
    BlockingQueue<Set<ListenerExperimentInfo>> failedMessageQueue = new ArrayBlockingQueue<>(1000000);
    void logEvent(ListenerExperimentInfo listenerExperimentInfo) throws InterruptedException {
        System.out.println("Logging the experiment info events to the hadoop backend."+ listenerExperimentInfo);
        listenerExperimentInfoQueue.offer(listenerExperimentInfo);
        //Thread.sleep(1000);
    }

    //void accumulateListenerInfo
    void logEvents(Set<ListenerExperimentInfo> listenerExperimentInfoSet) throws InterruptedException {
        System.out.println("Logging the experiment info events to the hadoop backend."+ listenerExperimentInfoSet+ "Thread Name");
        Thread.sleep(1000);
    }


    /*@Override
    public void run() {
        System.out.println("Logging the experiment info events to the hadoop backend async.");
        try {
            while(true) {
                Set<ListenerExperimentInfo> listenerExperimentInfoSet = new HashSet<>();
                IntStream.of(300).forEach(i -> {
                    try {
                        //Cover Overflow and Underflow condition
                        listenerExperimentInfoSet.add(listenerExperimentInfoQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                System.out.println("Log Events called from logging task");
                logEvents(listenerExperimentInfoSet);
                //Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Inturrupted Exeption");
            //Add all the failed messages in deadLetterQueue
            //failedMessageQueue.add(listenerExperimentInfoSet);
        }
    }

    @Override
    public void run() {
        System.out.println("Logging the experiment info events to the hadoop backend async.");
        try {
            while(true) {
                Set<ListenerExperimentInfo> listenerExperimentInfoSet = new HashSet<>();
                failedMessageQueue.iterate ->
                IntStream.of(300).forEach(i -> {
                    try {
                        //Cover Overflow and Underflow condition
                        listenerExperimentInfoSet.add(failedMessageQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                System.out.println("Log Events called from logging task");
                logEvents(listenerExperimentInfoSet);
                //Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Inturrupted Exeption");
        }
    }
}*/

class ListenerExperimentInfo {
    long listenerId;
    long experimentId;
    boolean isInExperiment;

    public ListenerExperimentInfo(long listenerId, long experimentId, boolean isInExperiment) {
        this.listenerId = listenerId;
        this.experimentId = experimentId;
        this.isInExperiment = isInExperiment;
    }

    @Override
    public String toString() {
        return "ListenerExperimentInfo{" +
                "listenerId=" + listenerId +
                ", experimentId=" + experimentId +
                ", isInExperiment=" + isInExperiment +
                '}';
    }
}
