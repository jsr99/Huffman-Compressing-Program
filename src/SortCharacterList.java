import java.util.*;
import java.util.Arrays;

public class SortCharacterList {
  
  public static void sortList(List<CharacterList> a) {
    CharacterList[] cl = a.toArray(new CharacterList[a.size()]);
    quicksort(cl);
    //List<CharacterList> sortedList = new ArrayList<CharacterList>();
    for(int i = 0; i < cl.length; i++) {
      a.set(i, cl[i]);
    }
  }
  
  private static void quicksort(CharacterList[] a) {
    quicksort(a, 0, a.length - 1);
  }
  
  private static void quicksort(CharacterList[] a, int left, int right) {
    if (left < right) {
      int pivotIndex = partition(a, left, right);
      quicksort(a, left, pivotIndex);
      quicksort(a, pivotIndex + 1, right);
    }
  }
  
  private static void swap(CharacterList[] a, int i, int j) {
    int temp = a[i].getCount();
    char tempChar = a[i].getChar();
    a[i].setCount(a[j].getCount());
    a[i].setChar(a[j].getChar());
    a[j].setCount(temp);
    a[j].setChar(tempChar);
  }
  
  private static int partition(CharacterList[] a, int left, int right) {
    //printArray(a, left, right);
    Integer pivotValue = a[left].getCount();
    CharacterList pivot = a[left];
    int i = left; // index going from left to right
    int j = right; // index going from right to left
    while (i < j) {
      /**
       * In each iteration, we will identify a number from left side which
       * is greater then the pivot value, and also we will identify a number
       * from right side which is less then the pivot value. Once the search
       * is done, then we exchange both numbers.
       */
      while (i < a.length && a[i].getCount() <= pivotValue)
        i++;
      while (a[j].getCount() >= pivotValue && a[j] != pivot)
        j--;
      if (i < j)
        swap(a, i, j);
    }
    swap(a, left, j);
    //printArray(a, left, right);
    return j; // a[j] = end of left array
  }
}