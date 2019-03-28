import java.util.Scanner;
public class QuickSorter extends Sorter{

  @SuppressWarnings("unchecked")
  public <E extends Comparable<E>> void sort(E[] array){
    this.sort(array,0,array.length-1);
  }

/** private sorter
  * @param E array to sort
  * @param int left
  * @param int right
  */
  private <E extends Comparable<E>> void sort(E[] array, int left, int right){
    int index = partition(array, left, right);
    if(left < index - 1) sort(array, left, index - 1);
    if(index < right) sort(array, index, right);
  }

/** partition function
  * @param E array
  * @param int left
  * @param int right
  * @return int index
  */
  private <E extends Comparable<E>> int partition(E[] array, int left, int right){
    int l = left, r = right;
    E pivot = array[(left + right)/2];
    int temp = 0;
    while(l <= r){
      while(array[l].compareTo(pivot) < 0){
        l++;
      }
      while(array[r].compareTo(pivot) > 0){
        r--;
      }
      if(l <= r){
        swap(array, l, r);
        l++;
        r--;
      }

    }
    return l;
  }

/** function for swapping two elements at given indexes
  * @param int index first
  * @param int index second
  */
  private <E extends Comparable<E>> void swap(E[] array, int first, int second){
    E temp = array[first];
    array[first] = array[second];
    array[second] = temp;
  }


  public static void main(String[] args){
    Scanner calledScanner = new Scanner(System.in);
    System.out.println("Welcome!");
    String input;
    boolean try_again;
    int size = 0;
    do{
      try_again = false;
      System.out.print("Please enter a positive integer to quick sort: ");
      input = calledScanner.nextLine();
      try{
        size = Integer.parseInt(input);
      }
      catch(NumberFormatException e){
        System.out.println("that was not a positive number");
        try_again = true;
      }
      if(size <= 0) try_again = true;
    } while(try_again);

    QuickSorter ss = new QuickSorter();

    System.out.println("time took to sort selection: " + ss.timeSort(size) + "ms");
  }
}
