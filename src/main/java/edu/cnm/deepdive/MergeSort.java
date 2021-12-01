package edu.cnm.deepdive;

import java.awt.SystemTray;

public class MergeSort {

  /* These methods will manipulate the contents of the array.
   They don't return an array we are simply giving it an array and allowing it to sort.
   Implementation of this first method is only an invocation of the second method.*/
  public static void sort(int[] data) {
    sort(data, 0, data.length);
  }

  public static void sort(int[] data, int start, int end) {
    if (end > start + 1) {

      // Divide
      int midpoint = (start + end) / 2;
      sort(data, start, midpoint); // Sort the left side.
      sort(data, midpoint, end); // Sort the right side.

      // Conquer (merge)
      int[] merged = new int[end - start];
      int leftIndex = start;
      int rightIndex = midpoint;
      int mergedIndex = 0;
      while (leftIndex < midpoint && rightIndex < end) {
        int leftValue = data[leftIndex];
        int rightValue = data[rightIndex];
        if (leftIndex <= rightValue) {
          merged[mergedIndex] = leftValue;
          leftIndex++;
        } else {
          merged[mergedIndex] = rightValue;
          rightIndex++;
        }
        mergedIndex++;
      }
      if (leftIndex < midpoint) { // We know there are items remaining in the left-hand side.
        System.arraycopy(data, leftIndex, merged, mergedIndex, midpoint - leftIndex);
      } else { // We now know that right index is less than end.
        System.arraycopy(data, rightIndex, merged, mergedIndex, end - rightIndex);
      } // Copying our sorted merged pile back to our original array - data.
      System.arraycopy(merged, 0, data, start, merged.length);
    }
  }
}
