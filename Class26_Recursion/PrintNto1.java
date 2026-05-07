import java.util.Scanner;

public class PrintNto1{

	public static void printNto1(int n){
		if(n == 0)
			return;

		System.out.print(n + " ");
		printNto1(n-1);
		return;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		printNto1(n);
		System.out.println();
	}
}