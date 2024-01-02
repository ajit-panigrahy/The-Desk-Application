import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* System.out.println("Hello World!"); */
		System.out.println("\n**************************************\n");
		System.out.println("\tWelcome to TheDesk \n");
		System.out.println("**************************************");
		optionsSelection();
	}

	private static void optionsSelection() {
		String[] arr = { "1. I wish to review my expenditure", "2. I wish to add my expenditure",
				"3. I wish to delete my expenditure", "4. I wish to sort the expenditures",
				"5. I wish to search for a particular expenditure", "6. Close the application" };
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		int slen = arr1.length;
		for (int i = 0; i < slen; i++) {
			System.out.println(arr[i]);
			// display the all the Strings mentioned in the String array
		}
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		ArrayList<Integer> expenses = new ArrayList<Integer>();
		expenses.add(1000);
		expenses.add(2300);
		expenses.add(45000);
		expenses.add(32000);
		expenses.add(110);
		expenses.addAll(arrlist);
		System.out.println("\nEnter your choice:\t");
		Scanner sc = new Scanner(System.in);
		int options = sc.nextInt();
		for (int j = 1; j <= slen; j++) {
			if (options == j) {
				switch (options) {
				case 1:
					System.out.println("Your saved expenses are listed below: \n");
					System.out.println(expenses + "\n");
					optionsSelection();
					break;
				case 2:
					System.out.println("Enter the value to add your Expense: \n");
					int value = sc.nextInt();
					expenses.add(value);
					System.out.println("Your value is updated\n");
					expenses.addAll(arrlist);
					System.out.println(expenses + "\n");
					optionsSelection();

					break;
				case 3:
					System.out.println(
							"You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
					int con_choice = sc.nextInt();
					if (con_choice == options) {
						expenses.clear();
						System.out.println(expenses + "\n");
						System.out.println("All your expenses are erased!\n");
					} else {
						System.out.println("Oops... try again!");
					}
					optionsSelection();
					break;
				case 4:
					sortExpenses(expenses);
					optionsSelection();
					break;
				case 5:
					searchExpenses(expenses);
					optionsSelection();
					break;
				case 6:
					closeApp();
					break;
				default:
					System.out.println("You have made an invalid choice!");
					break;
				}
			}
		}

	}

	private static void closeApp() {
		System.out.println("Closing your application... \nThank you!");
	}

	private static void searchExpenses(ArrayList<Integer> arrayList) {
		Scanner sc = new Scanner(System.in);
		int leng = arrayList.size();

		// Ensure the list is sorted before performing binary search
		Collections.sort(arrayList);

		System.out.println("Enter the expense you need to search:\t");
		int searchValue = sc.nextInt();

		if (binarySearch(arrayList, searchValue)) {
			System.out.println("Expense found: " + searchValue);
		} else {
			System.out.println("Expense not found");
		}
	}

	private static boolean binarySearch(ArrayList<Integer> arrayList, int searchValue) {
		int low = 0;
		int high = arrayList.size() - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			int midValue = arrayList.get(mid);

			if (midValue == searchValue) {
				return true; // Found the value
			} else if (midValue < searchValue) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return false; // Value not found
	}

	private static void sortExpenses(ArrayList<Integer> arrayList) {
		if (arrayList.isEmpty()) {
			System.out.println("No expenses to sort.");
			return;
		}

		quickSort(arrayList, 0, arrayList.size() - 1);

		System.out.println("Expenses sorted in ascending order: " + arrayList);
	}

	private static void quickSort(ArrayList<Integer> arrayList, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(arrayList, low, high);

			quickSort(arrayList, low, pivotIndex - 1);
			quickSort(arrayList, pivotIndex + 1, high);
		}
	}

	private static int partition(ArrayList<Integer> arrayList, int low, int high) {
		int pivot = arrayList.get(high);
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (arrayList.get(j) < pivot) {
				i++;
				swap(arrayList, i, j);
			}
		}

		swap(arrayList, i + 1, high);
		return i + 1;
	}

	private static void swap(ArrayList<Integer> arrayList, int i, int j) {
		int temp = arrayList.get(i);
		arrayList.set(i, arrayList.get(j));
		arrayList.set(j, temp);
	}

}
