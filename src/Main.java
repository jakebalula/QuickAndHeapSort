import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

    public class Main {
      public static void main(String[] args) throws IOException {
        int[] sizes = {100, 1000, 10000, 100000};
        Random random = new Random();

        System.out.printf("%-10s %-20s %-20s%n", "Size", "Heap sort (ms)", "Quick Sort (ms)");

        for (int size: sizes) {
          int arr[] = new int[size];
          for (int i = 0; i < size; i++){
            arr[i] = random.nextInt(1000000); //creates random integers
          }
          //Save array to file
          String filename = "array_" + size + ".txt";
          try (FileWriter fw = new FileWriter(filename)) {
            for (int num : arr){
              fw.write(num + " ");
            }
          }
          //Copies array
          int[] arrCopy1 = arr.clone();
          int[] arrCopy2 = arr.clone();

          //Insertion Sort time
          long start = System.nanoTime();
          SortingAlgorithms.heapSort(arrCopy1);
          long end = System.nanoTime();
          long heapTime = (end - start) / 1000000; //converts into ms

          //Merge Sort time
          start = System.nanoTime();
          SortingAlgorithms.quickSort(arrCopy2, 0, arrCopy2.length - 1);
          end = System.nanoTime();
          long quickTime = (end - start) / 1000000; //converts into ms

          //Print sorted arrays
          try (FileWriter fw = new FileWriter("heap_sorted_" + size + ".txt")) {
            for (int num : arrCopy1) fw.write(num + " ");
          }
          try (FileWriter fw = new FileWriter("quick_sorted_" + size + ".txt")) {
            for (int num : arrCopy2) fw.write(num + " ");
          }

          //Print it all
          System.out.printf("%-10d %-20d %-20d%n", size, heapTime, quickTime);
        }
      }
    }
