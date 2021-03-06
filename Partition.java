import java.util.*;

public class Partition{
    /*Modify the array such that:
   *1. Only the indices from start to end inclusive are considered in range
   *2. A random index from start to end inclusive is chosen, the corresponding
   *   element is designated the pivot element.
   *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
   *4. all elements in range that are larger than the pivot element are placed after the pivot element.
   *@return the index of the final position of the pivot element.
   */
  public static int partition(int[] data, int start, int end){
    int pivotIndex = (int)(Math.random() * data.length);
    int pivot = data[pivotIndex];
    swap(data, start, pivotIndex);
    while (start != end) {
      if (data[start] > pivot) {
        swap(data, start, end);
        end -= 1;
      } else {
        start += 1;
      }
    }

    if (data[start] <= pivot) {
      swap(data, start, pivotIndex);
      pivotIndex = start;
      pivot = data[pivotIndex];
    } else {
      swap(data, start-1, pivotIndex);
      pivotIndex = start-1;
      pivot = data[pivotIndex];
    }
    return pivotIndex;
  }

  private static void swap(int[] data, int a, int b){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  public static void main(String[] args){
    int[] test = new int[] {17,61,67,47,93,12,20,4,44,68};
    System.out.println(Partition.partition(test,0,test.length-1));
  }
}
