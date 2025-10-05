public class SortingAlgorithms {
  public static void heapSort(int[] arr) {
    int n = arr.length;

    //Build max heap
    for (int i = n/2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }

    //One by one extracts elements from heap
    for (int i = n - 1; i >= 0; i--) {
      //Move the current root to end
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      heapify(arr, i, 0);
    }
  }

  public static void heapify(int[] arr, int n, int i) {
    int largest = i; //largest as root
    int left = 2 * i + 1; //left child
    int right = 2 * i + 2; //right child

    //if left child is larger than root
    if (left < n && arr[left] > arr[largest]) {
      largest = left;
    }
    //if right child is larger than root
    if (right < n && arr[right] > arr[largest]) {
      largest = right;
    }
    //if largest is not root
    if(largest != i) {
      int swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      heapify(arr, n, largest);
    }
  }

  public static void quickSort(int[] arr, int low, int high) {
    if (low < high){
      int q = partition(arr, low, high);
      quickSort(arr, low, q - 1);
      quickSort(arr, q + 1, high);
    }
  }

  private static int partition(int[] arr, int low, int high){
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++){
      if (arr[j] <= pivot){
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
  }
}
