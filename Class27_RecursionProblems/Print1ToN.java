import java.util.Scanner;

public class Print1ToN{

	public static void print1toN(int n){
		if(n == 0)
			return;

		print1toN(n-1);
		System.out.print(n + " ");
		return;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		print1toN(n);
		System.out.println();
	}
}