package ir.sharif.ce.fastdatastructure;

import ir.sharif.ce.fastdatastructure.avl_tree.AvlTree;
import ir.sharif.ce.fastdatastructure.red_black_tree.RedBlackTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		AvlTree avlTree = new AvlTree();
		RedBlackTree redBlackTree = new RedBlackTree();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter 1 if you want to turn on logging or enter 0 if you want to turn off logging");
		boolean log = sc.nextInt() == 1;

		System.out.println(
				"Enter 1 if you want to choose specific numbers that should be inserted or enter 2 if you want to insert random numbers");
		int mode = sc.nextInt();

		if (mode == 1) {
			while (true) {
				System.out.println(
						"Enter a new positive integer to be inserted or enter -1 to finish insertion process or enter 0 to print all the inserted numbers");
				int toBeInserted = sc.nextInt();
				if (toBeInserted == -1)
					break;
				if (toBeInserted == 0) {
					printAllInsertedNumbers(set, avlTree, redBlackTree);
					System.out.println();
				} else if (toBeInserted > 0) {
					set.add(toBeInserted);
					avlTree.insert(toBeInserted);
					redBlackTree.insert(toBeInserted);
					if (log)
						System.out.println(toBeInserted + " is inserted.");
				}
			}
			while (true) {
				System.out.println(
						"Enter a new positive integer if you want to check whether or not it is inserted or enter -1 to quit or enter 0 to print all the inserted numbers");
				int toBeChecked = sc.nextInt();
				if (toBeChecked == -1)
					break;
				if (toBeChecked == 0) {
					printAllInsertedNumbers(set, avlTree, redBlackTree);
					System.out.println();
				} else if (toBeChecked > 0) {
					boolean setCheck = set.contains(toBeChecked), avlCheck = avlTree.contains(toBeChecked),
							redBlackCheck = redBlackTree.contains(toBeChecked);
					System.out.println(
							"(Actual, AVL, RED_BLACK: " + setCheck + ", " + avlCheck + ", " + redBlackCheck + ")");
				}
			}
		} else if (mode == 2) {
			System.out.println(
					"Please enter the first and last number of the range from which random numbers will be selected and inserted (ex. '1 1000')");
			int first = sc.nextInt(), last = sc.nextInt();
			System.out.println("Please enter the number of random numbers that should be inserted");
			int n = sc.nextInt();

			Random r = new Random();
			for (int i = 0; i < n; i++) {
				Integer toBeInserted = r.nextInt(last - first) + first;
				set.add(toBeInserted);
				avlTree.insert(toBeInserted);
				redBlackTree.insert(toBeInserted);
				if (log)
					System.out.println(toBeInserted + " is inserted.");
			}

			System.out.println(
					"Please enter the number of random numbers that should be checked whether they are inserted or not");
			int checkCnt = sc.nextInt();
			boolean avlWrong = false, redBlackWrong = false;
			for (int i = 0; i < checkCnt; i++) {
				Integer toBeChecked = r.nextInt(last - first) + first;
				boolean setCheck = set.contains(toBeChecked), avlCheck = avlTree.contains(toBeChecked),
						redBlackCheck = redBlackTree.contains(toBeChecked);
				if(log){
					System.out.println("Checking " + toBeChecked);
					System.out.println("(Actual, AVL, RED_BLACK: " + setCheck + " " + avlCheck + " " + redBlackCheck + ")");
				}
				avlWrong = avlWrong || (avlCheck != setCheck);
				redBlackWrong = redBlackWrong || (redBlackCheck != setCheck);
			}

			System.out.println("AVL_TREE did " + (avlWrong ? "" : "not ") + "have wrong answers and RED_BLACK_TREE did "
					+ (redBlackWrong ? "" : "not ") + "have wrong answers");
		}

		sc.close();
	}

	private static void printAllInsertedNumbers(Set<Integer> set, AvlTree avlTree, RedBlackTree redBlackTree) {
		System.out.println("ACTUAL");
		List<Object> setLst = Arrays.asList(set.toArray());
		for (Object item : setLst) {
			System.out.print(item + " ");
		}
		System.out.println();
		System.out.println("AVL_TREE");
		avlTree.print();
		System.out.println();
		System.out.println("RED_BLACK_TREE");
		redBlackTree.print();
	}
}
