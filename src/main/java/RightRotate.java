import java.util.Arrays;

public class RightRotate {

	public static void main(String[] args) {

		int[] arr = { 12, 31, 52, 2, 3, 5, 16 };
		int num = 3;
		for (int i = 0; i < num; i++) {
			int last = arr[arr.length - 1];
			for (int j = arr.length - 1; j > 0; j--) {
				arr[j] = arr[j - 1];
			}

			arr[0] = last;
		}

		System.out.println(Arrays.toString(arr));
	}
}
