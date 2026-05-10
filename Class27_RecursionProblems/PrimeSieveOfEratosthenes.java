import java.util.Scanner;

public class PrimeSieveOfEratosthenes{

	public static void generatePrimeSieve(boolean[] primeSieve){
		primeSieve[2] = true;

		// make all odd nos equal to true
		for(int i=3; i< primeSieve.length; i+=2){
			primeSieve[i] = true;
		}

		// make all multiples of prime nos equal to false
		for(int i=3; i< primeSieve.length; i+=2){
			if(primeSieve[i]){
				for(int j=2*i; j<primeSieve.length; j+=i){
					primeSieve[j] = false;
				}
			}
		}
	}

	public static void main(String[] args){
		boolean[] primeSieve = new boolean[1000000001];		// by default all values are prefilled with false
		// Arrays.fill(primeSieve, false);
		generatePrimeSieve(primeSieve);

		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();

		for(int i=1; i<=n; i++){
			if(primeSieve[i]){
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}