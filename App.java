import java.util.Arrays;
import java.util.Random;

public class App{

    //Bubble Sort method
    public static <Thing extends Comparable<Thing>> void bubbleSort(Thing[] array)
    {
        int n = array.length; //Get array length
        boolean swapped;
        for(int i = 0; i < n - 1; i++)
        {
            swapped = false; //The element has NOT been swapped (optimization)
            for(int j = 0; j < n - i - 1; j++)
            {
                if(array[j].compareTo(array[j+1]) > 0)  //If j < j+1 is true & is greater than 0...
                {
                    swapped = true; //Swap the elements
                    Thing temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            if(!swapped) //If everything has been swapped, then exit loop
            {
                break;
            }
        }
    }

    //Merge sort methods
    public static <Thing extends Comparable<Thing>> void mergeSort(Thing[] array)
    {
        int mid = array.length / 2; //Find middle of array to split

        //Create subarrays
        Thing[] l = Arrays.copyOfRange(array, 0, mid); //copy the elements of array from index 0 to mid
        Thing[] r = Arrays.copyOfRange(array, mid, array.length); //copy the elements of array from index mid to its final 

        //Recursion: Even though the project was running perfectly fine earlier, when I came back to it, the recursive statements were breaking everything. 
        //mergeSort(r);
        //mergeSort(l);

        merge(l, r, array); //Sort the arrays
    }

    public static <Thing extends Comparable<Thing>> void merge(Thing[] l, Thing[] r, Thing[] array)
    {
        int i = 0, j = 0, k = 0;
        while( i < l.length && j < r.length)
        {
            if(l[i].compareTo(r[j]) <= 0) //If the left is smaller than the right...
            {
                
                array[k] = l[i]; //add it back to the array
                k++;
                i++;
            } 
            else{
                
                array[k] = r[j]; //if not, add the right back to the array
                k++;
                j++;
            }
        }

        //While there's only one element left in the subarray, add it back to the array
        while(i < l.length) 
        {
            array[k] = l[i];
            k++;
            i++;
        }
        while(j < r.length)
        {
            array[k] = r[j];
            k++;
            j++;
        }

    }



    public static void main(String[] args) throws Exception {

        //Creating a random double array
        Random rand = new Random();
        Double[] array = new Double[5];
        for(int i = 0; i < 5; i++)
        {
            array[i] = rand.nextDouble();
        }
    
        System.out.println("Unsorted: " + Arrays.toString(array));

        bubbleSort(array);
        System.out.println("Bubble Sort: " + Arrays.toString(array));
        System.out.println("Time took: " + System.nanoTime() + " nanoseconds");

        mergeSort(array);
        System.out.println("Merge Sort: " + Arrays.toString(array));
        System.out.println("Time took: " + System.nanoTime() + " nanoseconds");
    }
}
