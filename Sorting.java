import java.util.*;

public class Sorting
{	
	private static int[] mergeArr;
	private static int[] tempMerge;
	private static int n;
	
	// If the array is not currently sorted, each element is placed in a randomly generated position in the
	// array. This shuffling continues until each element is in the correct order.
	//
	// *Big-O average complexity: O((n+1)!)
	// **Source: http://www.javacodex.com/Sorting/Bogo-Sort
	public static void bogo(int[] array)  
	{
		final Random random = new Random();
		int position, temp;
		
		while (!isSorted(array))
		{
			for (int i = 0; i < array.length; i++)
			{
				position = random.nextInt(array.length);
				temp = array[i];
				array[i] = array[position];
				array[position] = temp;	
			}
		}					
	}
	
	// Fully passes through the array, finding the smallest element and places it in the beginning of the array.
	// The process then repeats, finding the next smallest element and places it after the previous smaller element.
	//
	// *Big-O average complexity: O(n^2)
	// **Source: http://www.java2novice.com/java-sorting-algorithms/selection-sort/
	public static int[] selection(int[] array)  
	{
		for (int i = 0; i < array.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j] < array[index])
                {
                    index = j;
                }
            }
              
            int temp = array[index]; 
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
	}
	
	// Passes through the array until an element smaller than the previous is found, then takes that element and places 
	// it in the correct position in the array. This process repeats until there are no more elements left out of place.
	//
	// *Big-O average complexity: O(n^2)
	// **Source: http://www.java2novice.com/java-sorting-algorithms/insertion-sort/
	public static int[] insertion(int[] array)  
	{
		int temp;
        for (int i = 1; i < array.length; i++) 
        {
            for(int j = i ; j > 0 ; j--)
            {
                if(array[j] < array[j - 1])
                {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        
        return array;
	}
	
	// Starting with the beginning element, passes through compares adjacent elements until a smaller element is found after a bigger
	// element. The elements are swapped, and the process repeats. The process repeats until it passes through the array with no swaps.
	//
	// *Big-O average complexity: O(n^2)
	// **Source: http://mathbits.com/MathBits/Java/arrays/Bubble.htm
	public static void bubble(int[] array)  
	{
		boolean swap = true;
		int temp;
		
		while (swap)
		{
			swap = false;
			
			for (int i = 0; i < array.length - 1; i++)
			{
				if (array[i] > array[i + 1])
				{
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swap = true;
				}
			}
		}
	}
	
	// Divides the array into two smaller arrays using the "pivot" (middle) point. It then swaps elements to each sub array based
	// on if it less than or greater than the pivot point. It then recursively sorts the sub arrays until the whole array is sorted.
	//
	// *Big-O average complexity: O(n log(n))
	// **Source: http://www.programcreek.com/2012/11/quicksort-array-in-java/
	public static void quick(int[] array, int l, int h)  
	{
		int temp;
		int low = l;
		int high = h;
		int middle = low + (high - low) / 2;
		int pivot = array[middle];
		
		if (array == null || array.length == 0)
			return;
		
		if (low >= high)
			return;
		
		while (low <= high)
		{
			while (array[low] < pivot)
			{
				low++;
			}
			
			while (array[high] > pivot)
			{
				high--;
			}
			
			if (low <= high)
			{
				temp = array[low];
				array[low] = array[high];
				array[high] = temp;
				low++;
				high--;
			}
		}
		
		if (l < high)
		{
			quick(array, l, high);
		}
		
		if (h > low)
		{
			quick(array, low, h);
		}
	}
	
	// Starts by comparing and sorting elements far apart from each other, then reduces the "gap" through each pass. As each pass through 
	// is complete, the start point for the next pass gradually moves closer to the beginning of the array, until the array is sorted.
	//
	// *Big-O average complexity: O(n(log(n))^2)
	// **Source: http://www.javacodex.com/Sorting/Shell-Sort
	public static void shell(int[] array)  
	{
		int inner, outer, temp, h = 1;
		
		while (h <= array.length / 3)
		{
			h = h * 3 + 1;
		}
		
		while (h > 0)
		{
			for (outer = h; outer < array.length; outer++)
			{
				temp = array[outer];
				inner = outer;
				
				while (inner > h - 1 && array[inner - h] >= temp)
				{
					array[inner] = array[inner - h];
					inner = inner - h;
				}
				
				array[inner] = temp;
			}
			
			h = (h - 1) / 3;
		}
	}
	
	// Divides array into multiple sub arrays until each sub array has one element, then "merges" sub arrays
	// into a sorted array.
	//
	// *Big-O average complexity: O(n log(n))
	// **Source: http://www.java2novice.com/java-sorting-algorithms/merge-sort/
	public static void merge(int[] array)  
	{
		tempMerge = new int[array.length];
		mergeArr = array;
		sort(0, array.length - 1);
		array = mergeArr;
	}
	
	private static void sort(int low, int high)
	{
		if (low < high)
		{
			int middle = low + (high - low) / 2;
			sort(low, middle);
			sort(middle + 1, high);
			mergeParts(low, middle, high);
		}
	}
	
	private static void mergeParts(int low, int mid, int high)
	{
		for (int i = low; i <= high; i++)
		{
			tempMerge[i] = mergeArr[i];
		}
		
		int i = low;
		int j = mid + 1;
		int k = low;
		
		while (i <= mid && j <= high)
		{
			if (tempMerge[i] <= tempMerge[j])
			{
				mergeArr[k] = tempMerge[i];
				i++;
			}
			else
			{
				mergeArr[k] = tempMerge[j];
				j++;
			}
			
			k++;
		}
		
		while (i <= mid)
		{
			mergeArr[k] = tempMerge[i];
			k++;
			i++;
		}
	}
	
	// Passes through the array, checking and comparing each element. If the element after the current element is smaller,
	// the elements are swapped. The swapped element is then compared to the element before it, swapping again if it is
	// smaller than the previous. The process repeats until it fully passes through the array with no swaps occurring.
	//
	// *Big-O average complexity: O(n^2)
	// **Source: http://professorjava.weebly.com/gnome-sort.html
	public static void gnome(int[] array) 
	{
		int i = 1, temp;
		
		while (i < array.length)
		{
			if (array[i] < array[i - 1])
			{
				temp = array[i];
				array[i] = array[i - 1];
				array[i - 1] = temp;
				i--;
				if (i == 0)
				{
					i = 1;
				}
			}
			else
			{
				i++;
			}
		}
	}
	
	// Passes forward through the array comparing elements, finding the largest element and swapping until it is at the end. It then passes
	// backwards, finding the smallest element and swapping until it is at the beginning. The process repeats, finding the next largest and 
	// smallest values and swapping until the array is sorted.
	//
	// *Big-O average complexity: O(n^2)
	// **Source: http://www.javacodex.com/Sorting/Cocktail-Sort
	public static void cocktail(int[] array)  
	{
		boolean swap;
		int temp = 0;
		
		do
		{
			swap = false;
			
			for (int i = 0; i <= array.length - 2; i++)
			{
				if (array[i] > array[i + 1])
				{
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swap = true;
				}
			}
			
			if (!swap)
			{
				break;
			}
			
			swap = false;
			
			for (int i = array.length - 2; i >= 0; i--)
			{
				if (array[i] > array[i + 1])
				{
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swap = true;
				}
			}
		} while (swap);
	}
	
	// Compares the right most digit of each element, then places the elements in a queue based on that digit. The elements
	// are removed, and the process is repeated starting at the next digit to the left. The end product is a sorted array.
	//
	// *Big-O average complexity: O(n * k)
	// **Source: http://eddmann.com/posts/least-significant-digit-lsd-radix-sort-in-java/
	public static void radix(int[] array)
	{
		Queue<Integer>[] buckets = new Queue[10];
		int div = 1;
		int maxVal = 0;
		
		for (int i = 1; i < array.length; i++)
		{
			if (array[i] < array[i - 1])
			{
				maxVal = array[i];
			}
		}
		
		for (int i = 0; i < buckets.length; i++)
		{
			buckets[i] = new LinkedList<Integer>();
		}
		
		while (maxVal / div > 0)
		{
			
			for (int i = 0; i < array.length; i++)
			{
				int bucket = (array[i] / div) % 10;
				
				buckets[bucket].add(array[i]);
			}
			
			div = div * 10;
			int index = 0;
		    
		    for (int j = 0; j < buckets.length; j++)
		    {
		    	while (!buckets[j].isEmpty())
		    	{
		    		array[index++] = (int) buckets[j].remove();
		    	}
		    }
		}
	}
	
	// Uses a max-heap binary tree to sort elements. The root of the heap has child elements less than itself. After making
	// the initial tree complete, the root is removed and the tree is heapified. As each root is removed, the array is filled
	// with the elements sorted.
	//
	// *Big-O average complexity: O(n log(n))
	// **Source: http://www.code2learn.com/2011/09/heapsort-array-based-implementation-in.html
	public static void heap(int[] array)  
	{
		int[] arr = array;
		int temp;
		
		buildHeap(array);
		
		for (int i = n; i > 0; i--)
		{
			temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			n = n - 1;
			maxHeap(arr, 0);
			
		}
	}
	
	private static void buildHeap(int[] array)
	{
		
		n = array.length - 1;
		
		for (int i = n / 2; i >= 0; i--)
		{
			maxHeap(array, i);
		}
	}
	
	private static void maxHeap(int[] array, int i)
	{
		int left;
		int right;
		int largest;
		int temp;
		
		left = 2 * i;
		right = 2 * i + 1;
		
		if (left <= n && array[left] > array[i])
		{
			largest = left;
		}
		else
		{
			largest = i;
		}
		
		if (right <= n && array[right] > array[largest])
		{
			largest = right;
		}
		
		if (largest != i)
		{
			temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			maxHeap(array, largest);
		}
	}
	
	// Checks to see if the array is sorted from least to greatest
	private static boolean isSorted(int[] array)  
	{
		for (int i = 1; i < array.length; i++)
		{
			if (array[i] < array[i - 1])
			{
				return false;
			}
		}
		
		return true;
	}
}
