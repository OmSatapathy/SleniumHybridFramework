import java.util.Arrays;

public class MergeArray {

	public static void main(String[] args) {

		int[] arr1 = { 3, 5, 12, 7, 31, 9 };
		int[] arr2 = { 6, 7, 2, 52 };

		int[] mergearray = new int[arr1.length + arr2.length];

		System.arraycopy(arr1, 0, mergearray, 0, arr1.length);
		System.arraycopy(arr2, 0, mergearray, arr1.length, arr2.length);

		System.out.println(Arrays.toString(mergearray));

		// accending order

		for (int i = 0; i < mergearray.length; i++) {
			for (int j = i + 1; j < mergearray.length; j++) {
				if (mergearray[i] > mergearray[j]) {
					int temp = mergearray[i];
					mergearray[i] = mergearray[j];
					mergearray[j] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(mergearray));

		int num = 4;
		int[] mergearray1 = {1, 2, 3, 4, 5};
		
	
		int j = 0;
		for (int i = 0; i < num; i++) {
			int first = mergearray[0];
			for (j = 0; j < mergearray.length-1; j++) {
				mergearray[j] = mergearray[j + 1];
			}
			mergearray[j] = first;
		}
		System.out.println(Arrays.toString(mergearray));

		
	}

	

}
