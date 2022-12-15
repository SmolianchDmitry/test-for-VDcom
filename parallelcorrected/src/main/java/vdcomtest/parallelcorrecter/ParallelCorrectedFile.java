package vdcomtest.parallelcorrecter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ParallelCorrectedFile{

    private static class MyThread extends Thread {
        private final int n;

        public MyThread(String name, int n) {
            this.n = n;
            super.setName(name);
        }

        @Override
        public void run() {
            countRunning(n);
        }
    }
    private static void countRunning(int n){
        int num = 0;
        while (num < n - 1) {
           num = fileCorrected(num);
        }
    }

    synchronized static int fileCorrected(Integer num){
        File file = new File("out.txt");
        try {
            FileReader reader = new FileReader(file);
            Scanner scan = new Scanner(reader);
            String str = scan.next();
            reader.close();
            synchronized (scan) {
                num = Integer.parseInt(str);
                System.out.print(num + " ");
                System.out.print(++num + " ");
                System.out.println(Thread.currentThread().getName());
            }
            FileWriter writer = new FileWriter(file);
            writer.write(num.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }
    public static void startParallelThread(int n) throws InterruptedException {
        MyThread thread1 = new MyThread("Thread 1", n);
        MyThread thread2 = new MyThread("Thread 2", n);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
