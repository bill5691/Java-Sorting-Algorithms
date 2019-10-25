import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class SortDriver 
{

	public static void main(String[] args) 
	{
		int[] arrOne = new int[20];
		int[] arrTwo = new int[100];
		int[] arrThree = new int[500];
		int[] arrFour = new int[1000];
		int[] bogoArr = {};
		int bogoSize;
		int low;
		int highOne = arrOne.length - 1;
		int highTwo = arrTwo.length - 1;
		int highThree = arrThree.length - 1;
		int highFour = arrFour.length - 1;
		long startTime, endTime, durationOne = 0, durationTwo = 0, durationThree = 0, durationFour = 0;
		String entry, redo;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n\t   Sorting Algorithms\n");
		System.out.print(" Menu:\n\t1 - Bogo\n\t2 - Selection\n\t3 - Insertion\n\t4 - Bubble\n\t5 - Quick\n\t6 - Shell\n\t7 - Merge\n\t8 - Gnome"
				+ "\n\t9 - Cocktail\n\t10 - Radix\n\t11 - Heap\n\n");
		
		do
		{
			System.out.print(" Enter a number to choose sorting method: ");
			entry = scan.next();
			
			switch (entry)
			{
				case "1":
					System.out.print(" Enter an array size (Warning: larger sizes take longer to complete): ");
					bogoSize = scan.nextInt();
					bogoArr = new int[bogoSize];
					startTime = System.nanoTime();
					Sorting.bogo(randomizer(bogoArr));
					endTime = System.nanoTime();
					durationOne = (endTime - startTime);
					System.out.print("\n Bogo Sort\n");
					break;
				case "2":
					startTime = System.nanoTime();
					Sorting.selection(randomizer(arrOne));
					endTime = System.nanoTime();
					durationOne = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.selection(randomizer(arrTwo));
					endTime = System.nanoTime();
					durationTwo = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.selection(randomizer(arrThree));
					endTime = System.nanoTime();
					durationThree = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.selection(randomizer(arrFour));
					endTime = System.nanoTime();
					durationFour = (endTime - startTime);
					System.out.print("\n Selection Sort\n");
					break;
				case "3":
					startTime = System.nanoTime();
					Sorting.insertion(randomizer(arrOne));
					endTime = System.nanoTime();
					durationOne = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.insertion(randomizer(arrTwo));
					endTime = System.nanoTime();
					durationTwo = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.insertion(randomizer(arrThree));
					endTime = System.nanoTime();
					durationThree = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.insertion(randomizer(arrFour));
					endTime = System.nanoTime();
					durationFour = (endTime - startTime);
					System.out.print("\n Insertion Sort\n");
					break;
				case "4":
					startTime = System.nanoTime();
					Sorting.bubble(randomizer(arrOne));
					endTime = System.nanoTime();
					durationOne = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.bubble(randomizer(arrTwo));
					endTime = System.nanoTime();
					durationTwo = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.bubble(randomizer(arrThree));
					endTime = System.nanoTime();
					durationThree = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.bubble(randomizer(arrFour));
					endTime = System.nanoTime();
					durationFour = (endTime - startTime);
					System.out.print("\n Bubble Sort\n");
					break;
				case "5":
					low = 0;
					startTime = System.nanoTime();
					Sorting.quick(randomizer(arrOne), low, highOne);
					endTime = System.nanoTime();
					durationOne = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.quick(randomizer(arrTwo), low, highTwo);
					endTime = System.nanoTime();
					durationTwo = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.quick(randomizer(arrThree), low, highThree);
					endTime = System.nanoTime();
					durationThree = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.quick(randomizer(arrFour), low, highFour);
					endTime = System.nanoTime();
					durationFour = (endTime - startTime);
					System.out.print("\n Quick Sort\n");
					break;
				case "6":
					startTime = System.nanoTime();
					Sorting.shell(randomizer(arrOne));
					endTime = System.nanoTime();
					durationOne = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.shell(randomizer(arrTwo));
					endTime = System.nanoTime();
					durationTwo = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.shell(randomizer(arrThree));
					endTime = System.nanoTime();
					durationThree = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.shell(randomizer(arrFour));
					endTime = System.nanoTime();
					durationFour = (endTime - startTime);
					System.out.print("\n Shell Sort\n");
					break;
				case "7":
					startTime = System.nanoTime();
					Sorting.merge(randomizer(arrOne));
					endTime = System.nanoTime();
					durationOne = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.merge(randomizer(arrTwo));
					endTime = System.nanoTime();
					durationTwo = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.merge(randomizer(arrThree));
					endTime = System.nanoTime();
					durationThree = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.merge(randomizer(arrFour));
					endTime = System.nanoTime();
					durationFour = (endTime - startTime);
					System.out.print("\n Merge Sort\n");
					break;
				case "8":
					startTime = System.nanoTime();
					Sorting.gnome(randomizer(arrOne));
					endTime = System.nanoTime();
					durationOne = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.gnome(randomizer(arrTwo));
					endTime = System.nanoTime();
					durationTwo = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.gnome(randomizer(arrThree));
					endTime = System.nanoTime();
					durationThree = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.gnome(randomizer(arrFour));
					endTime = System.nanoTime();
					durationFour = (endTime - startTime);
					System.out.print("\n Gnome Sort\n");
					break;
				case "9":
					startTime = System.nanoTime();
					Sorting.cocktail(randomizer(arrOne));
					endTime = System.nanoTime();
					durationOne = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.cocktail(randomizer(arrTwo));
					endTime = System.nanoTime();
					durationTwo = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.cocktail(randomizer(arrThree));
					endTime = System.nanoTime();
					durationThree = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.cocktail(randomizer(arrFour));
					endTime = System.nanoTime();
					durationFour = (endTime - startTime);
					System.out.print("\n Cocktail Sort\n");
					break;
				case "10":
					startTime = System.nanoTime();
					Sorting.radix(randomizer(arrOne));
					endTime = System.nanoTime();
					durationOne = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.radix(randomizer(arrTwo));
					endTime = System.nanoTime();
					durationTwo = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.radix(randomizer(arrThree));
					endTime = System.nanoTime();
					durationThree = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.radix(randomizer(arrFour));
					endTime = System.nanoTime();
					durationFour = (endTime - startTime);
					System.out.print("\n Radix Sort\n");
					break;
				case "11":
					startTime = System.nanoTime();
					Sorting.heap(randomizer(arrOne));
					endTime = System.nanoTime();
					durationOne = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.heap(randomizer(arrTwo));
					endTime = System.nanoTime();
					durationTwo = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.heap(randomizer(arrThree));
					endTime = System.nanoTime();
					durationThree = (endTime - startTime);
					startTime = System.nanoTime();
					Sorting.heap(randomizer(arrFour));
					endTime = System.nanoTime();
					durationFour = (endTime - startTime);
					System.out.print("\n Heap Sort\n");
					break;
				default:
					System.out.print("\n Error: Invalid option selected");
					break;
			}
			
		if (Integer.parseInt(entry) > 0 && Integer.parseInt(entry) < 12)
		{
			if (entry.equals("1"))
			{
				System.out.print("\n " + Arrays.toString(bogoArr) + "\n Execution Time: " + durationOne + " nanoseconds");
			}
			else
			{	
				System.out.print("\n " + Arrays.toString(arrOne) + "\n Execution Time: " + durationOne + " nanoseconds\n\n " + Arrays.toString(arrTwo) + "\n Execution Time: " 
						+ durationTwo + " nanoseconds\n\n " + Arrays.toString(arrThree) + "\n Execution Time: " + durationThree + " nanoseconds\n\n " + Arrays.toString(arrFour) 
						+ "\n Execution Time: " + durationFour + " nanoseconds");
			}
		}
			
			System.out.print("\n\n Continue sorting? (Y/N): ");
			redo = scan.next();
			
		}while (redo.equalsIgnoreCase("y"));
		
		scan.close();
	}

	private static int[] randomizer(int[] arr)
	{
		int[] array = arr;
		
		Random ran = new Random();
		
		for (int i = 0; i < array.length; i++)
		{
			array[i] = ran.nextInt(999) + 1;
		}
		
		return array;
	}
}