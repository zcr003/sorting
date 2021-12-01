package edu.cnm.deepdive;

public class BinarySearch {

  public static int search(int[] haystack, int needle) {
    return search(haystack, needle, 0, haystack.length);
  }


  public static int search(int[] haystack, int needle, int start, int end) {
    int position;
    if (end > start) {
      int midpoint = (start + end) / 2;
      int midpointValue = haystack[midpoint];
      if (midpointValue < needle) { // Oatmeal too cold
        position = search(haystack, needle, midpoint + 1, end);
      } else if (midpointValue > needle) { // Oatmeal too hot
        position = search(haystack, needle, start, midpoint);
      } else { // Oatmeal is just right
        position = midpoint;
      }
    } else {
      position = ~start;
    }
    return position;
  }

}
