package vdcomtest.parallelcorrecter;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static vdcomtest.parallelcorrecter.ParallelCorrectedFile.startParallelThread;
import static vdcomtest.parallelcorrecter.WorkWithDataEntry.getNumberGreaterZeroAndMultiple;

public class Application {

    public static void main(String[] args) {

        int n =getNumberGreaterZeroAndMultiple();
        while (n % 2 != 0) {
            System.out.println("The entered number is not a multiple of 2. Try again.");
            n = WorkWithDataEntry.getNumberGreaterZero();
        }
        File file = new File("out.txt");

        try {
            if (!file.createNewFile()) {
                file.delete();
                file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("0");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            startParallelThread(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
