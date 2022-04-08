
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Array2 {

	public Object mismatchedPair(char[] arr1, char[] arr2) {
		ArrayList<String> list = new ArrayList<String>();
		String out = "";
		if (arr1.length != arr2.length) {
			return "not found";
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i] && i < arr1.length - 1 && arr1[i + 1] != arr2[i + 1]) {
				out += arr1[i] + "" + arr2[i];
				list.add(out);
				out = "";
				out += arr1[i + 1] + "" + arr2[i + 1];
				list.add(out);
				i++;
			} else {
				if (arr1[i] != arr2[i]) {
					out += "" + arr1[i];
					list.add(out);
					out = "";
					out += "" + arr2[i];
					list.add(out);
				}
			}
			out = "";
		}
		return list;
	}

	public void unionExceptIntercept(List arr1, List arr2) {
		List<Integer> union = new ArrayList<Integer>();
		List<Integer> except = new ArrayList<Integer>();
		List<Integer> intersect = new ArrayList<Integer>();
		for (int i = 0; i < arr1.size(); i++) {
			Integer temp = (Integer) arr1.get(i);
			if (!union.contains(temp)) {
				union.add(temp);
			}
			if (temp % 2 == 0) {
				except.add(temp);
			}
			if (arr2.contains(temp) && !intersect.contains(temp)) {
				intersect.add(temp);
			}
		}
		for (int i = 0; i < arr2.size(); i++) {
			Integer temp = (Integer) arr2.get(i);
			if (!union.contains(temp)) {
				union.add(temp);
			}
			if (temp % 2 == 1) {
				except.add(temp);
			}
			if (arr1.contains(temp) && !intersect.contains(temp)) {
				intersect.add(temp);
			}
		}
		System.out.println("intersect " + intersect);
		System.out.println("except " + except);
		System.out.println("union " + union);
	}

	public int[] oneRotation(int[] arr) {
		int n = arr.length;
		int temp = arr[n - 1];
		for (int i = n - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
		return arr;
	}

	public int[] rotationLength(int[] arr) {
		int n = arr.length;
		for (int j = 0; j < arr.length; j++) {
			int temp = arr[n - 1];
			for (int i = n - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = temp;
		}
		return arr;
	}

	public int[] rotationNumber(int[] arr, int num) {
		int n = arr.length;
		for (int j = 0; j < num; j++) {
			int temp = arr[n - 1];
			for (int i = n - 1; i > 0; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = temp;
		}
		return arr;
	}

	public boolean checkAscOne(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				count++;
			}
		}
		if (count <= 1) {
			return true;
		}
		return false;
	}

	public List<Integer> minDifference(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		int val = 0;
		int val1 = 0;
		int temp = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != j && Math.abs(arr[i] - arr[j]) < temp) {
					temp = Math.abs(arr[i] - arr[j]);
					val = arr[i];
					val1 = arr[j];
				}
			}
		}
		list.add(val);
		list.add(val1);
		return list;
	}

	public void duplicated(int[] arr) {
		Arrays.sort(arr);
		int count = 1;
		for (int i = 0; i < arr.length; i++) {
			while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
				count++;
				i++;
			}
			System.out.println(arr[i] + "-" + count);
			count = 1;
		}

	}

	public int digitAdder(int number) {
		int sum = 0, digit = 0;
		while (number > 0) {
			digit = number % 10;
			sum = sum + digit;
			number = number / 10;
		}
		return sum;
	}

	public int sumTen(int inp) {
		String out = "";
		int temp = 0;
		if (inp <= 10) {
			temp = 10 - inp;
		} else {
			temp = inp;
			while (temp > 10) {
				temp = digitAdder(temp);
			}
			temp = 10 - temp;
		}
		out = inp + "" + temp;
		return Integer.parseInt(out);
	}

	public List<Integer> closestPair(int[] arr, int val) {
		List<Integer> list = new ArrayList<Integer>();
		int temp = Integer.MAX_VALUE;
		int val1 = 0;
		int val2 = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				int sum = Math.abs(val - (arr[i] + arr[j]));
				if (sum < temp && i != j) {
					temp = Math.min(temp, sum);
					val1 = arr[i];
					val2 = arr[j];
				}
			}
		}
		list.add(val1);
		list.add(val2);
		return list;
	}

	public List<String> sumNumber(int[] arr, int val) {
		String out = "";
		List<String> list = new ArrayList<String>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			int temp = val - arr[i];
			if (map.containsKey(temp)) {
				out = "(" + arr[i] + "," + temp + ")";
				list.add(out);
				out = "";
			} else {
				map.put(arr[i], 1);
			}
		}

		return list;
	}

	public void printArrayPattern(int[] arr) {
		int rows = 4;
		int num = 0;
		for (int i = 0; i <= rows; i++) {
			num = i;
			for (int j = 1; j <= i+1; j++) {
				System.out.print(arr[num] + " ");
				num = i + rows + j;
			}
			System.out.println();
		}
	}

	public int chocolates(int[] arr, int m) {
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		return chocolateSum(arr, 0, m - 1, min);
	}

	public int chocolateSum(int[] arr, int start, int end, int min) {
		min = Math.min(Math.abs(arr[end] - arr[start]), min);
		if (end == arr.length - 1) {
			return min;
		}
		return chocolateSum(arr, start + 1, end + 1, min);
	}

	public int maxSum(int[] arr) {
		int min = 0;
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				for (int k = 0; k < len; k++) {
					min = Math.max(min, arr[i] * arr[j] * arr[k]);
				}
			}
		}
		return min;
	}

	public int[] orderSumDigit(int[] arr) {
		int temp = 0;
		int temp1 = 0;
		for (int i = 0; i < arr.length-1; i++) {
			temp1 = digitAdder(arr[i]);
			if (temp1 > temp) {
             int val=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=val;
			}
		}
		return arr;
	}
	
	public List<Integer> longestSubSequence(int[] arr)
	{
		List<Integer> list=new ArrayList<Integer>();

		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]<arr[i+1])
			{
				list.add(arr[i]);
			}
		}
      if(arr[arr.length-1]>arr[arr.length-2])
      {
    	  list.add(arr[arr.length-1]);
      }
		return list;
	}

	public void childLevel() {
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		
	}
	
	public static void main(String[] args) {
		Array2 arrObj = new Array2();
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		switch (num) {
		case 1: {
			char[] arr1 = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' };
			char[] arr2 = { 'a', 'b', 'd', 'e', 'e', 'g', 'g', 'i', 'i' };
			System.out.println(arrObj.mismatchedPair(arr1, arr2));
			break;
		}
		case 2: {
			List<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 3, 8, 9));
			List<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1, 7, 5, 8, 8));
			arrObj.unionExceptIntercept(arr1, arr2);
			break;
		}
		case 3: {
			System.out.print("Enter number");
			num = scan.nextInt();
			System.out.print(arrObj.sumTen(num));
			break;
		}
		case 4: {
			int[] arr = { 1, 2, 3, 4, 5 };
			System.out.print(Arrays.toString(arrObj.oneRotation(arr)));
			break;
		}
		case 5: {
			int[] arr = { 1, 2, 3, 4, 5 };
			System.out.print(Arrays.toString(arrObj.rotationLength(arr)));
			break;
		}
		case 6: {
			int[] arr = { 10, 5, 1 };
			System.out.print(arrObj.checkAscOne(arr));
			break;
		}
		case 7: {
			int[] arr = { 1, 2, 3, 4, 5 };
			System.out.print(Arrays.toString(arrObj.rotationNumber(arr, 2)));
			break;
		}
		case 8: {
			int[] arr = { 901, 40, 35, 0, 60, 900, 903, 1000 };
			System.out.print(arrObj.minDifference(arr));
			break;
		}
		case 9: {
			int[] arr = { 2, 3, 6, 2, 2, 1, 6 };
			arrObj.duplicated(arr);
			break;
		}
		case 10: {
			int[] arr = { 10, 22, 28, 29, 30, 40 };
			System.out.println(arrObj.closestPair(arr, 54));
			break;
		}
		case 11: {
			int[] arr = { 12, 19, 38, 56, 34, 23, 18, 69, 41, 12, 45, 78, 43, 99, 10 };
			arrObj.printArrayPattern(arr);
			break;
		}
		case 12: {
			int[] arr = { 0, 14, 0, 4, 7, 8, 3, 5, 7 };
			System.out.println(arrObj.sumNumber(arr, 11));
			break;
		}
		case 13: {
			int[] arr = { 7, 3, 2, 4, 9, 12, 56 };
			System.out.println(arrObj.chocolates(arr, 3));
			break;
		}
		case 14: {
			int[] arr = { -10, -10, 5, 2 };
			System.out.println(arrObj.maxSum(arr));
			break;
		}
		case 15: {
			int[] arr = {  332 ,165, 2345, 2643, 934};
			System.out.println(Arrays.toString( arrObj.orderSumDigit(arr)));
			break;
		}
		case 16: {
			int[] arr = {  1,5,2,3,4 };
			System.out.println(arrObj.longestSubSequence(arr));
			break;
		}
		case 17: {
			int[] arr = {  1,5,2,3,4 };
			System.out.println(arrObj.longestSubSequence(arr));
			break;
		}
		default:
			break;
		}

	}

}
