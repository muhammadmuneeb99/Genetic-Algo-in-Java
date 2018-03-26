import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.BaseStream;

import javax.security.auth.kerberos.KerberosCredMessage;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("The Population is 3");
		ArrayList<String> arrayList = new ArrayList<String>();
		System.out.println("Chromosome must have length of 3 and\nPlace ',' after each cell.");
		for (int i = 0; i < 3; i++) {
			String chromoSome = scanner.next();
			arrayList.add(chromoSome);
		}
		int c1 = 0;
		int c2 = 0;
		ArrayList<Integer> vals = new ArrayList<Integer>();
		// int count = 0;
		HashMap<Integer, String[]> dictionary = new HashMap<Integer, String[]>();
		for (String string : arrayList) {
			String[] aStrings = string.split(",");
			for (int j = 0; j < aStrings.length; j++) {
				if (aStrings[j].contains("1")) {
					c2 = c2 + 1;
				}
			}
			System.out.println(string + " has " + c2 + " fitness value");
			vals.add(c2);
			dictionary.put(c2, aStrings);
			c1 = c2;
			c2 = 0;
		}
		String[] best = dictionary.get(vals.get(findmax(vals)));
		int del = vals.remove(findmax(vals));
		
		String[] sbest = dictionary.get(vals.get(findmax(vals)));
		
		System.out.println("These two are selected for CrossOver");
		for (int i = 0; i < best.length; i++) {
			System.out.print(best[i]);
		}
		System.out.println();
		for (int i = 0; i < sbest.length; i++) {
			System.out.print(sbest[i]);
		}
		
		for (int i = 0; i < sbest.length; i++) {
			String temp = sbest[i];
			sbest[i] = best[i];
			best[i] = temp;
		}
		System.out.println("\nAfter Cross Over");
		for (int i = 0; i < best.length; i++) {
			System.out.print(best[i]);
		}
		System.out.println();
		for (int i = 0; i < sbest.length; i++) {
			System.out.print(sbest[i]);
		}
		
		for (int i = 0; i < sbest.length; i++) {
			if (sbest[i].contains("0")) {
				sbest[i] = "1";
				break;
			} else {
				if (best[i].contains("0")) {
					best[i] = "1";
					break;
				}
			}
		}
		System.out.println("\nAfter Mutation");
		for (int i = 0; i < best.length; i++) {
			System.out.print(best[i]);
		}
		System.out.println();
		for (int i = 0; i < sbest.length; i++) {
			System.out.print(sbest[i]);
		}
		
	}

	static int findmax(ArrayList<Integer> arr) {
		int max = 0;
		int index = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (max < arr.get(i)) {
				max = arr.get(i);
				index = i;
			}

		}
		return index;
	}

}
