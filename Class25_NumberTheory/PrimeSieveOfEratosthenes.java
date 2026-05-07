import java.util.*;

public class PrimeSieveOfEratosthenes{
	public static int len = 1000000001;
	public static boolean[] primeSieve = new boolean[len];

	public static void generatePrimeSieve(){
		primeSieve[2] = true;

		// make all odd nos as true
		for(int i=3; i<len; i+=2){
			primeSieve[i] = true;
		}

		// make all multiples of prime nos as false
		for(int i=3; i<len; i+=2){
			if(primeSieve[i] == true){
				// i -> prime => make all multiples of i as false (not prime)
				for(int j=2*i; j<len; j+=i){
					primeSieve[j] = false;
				}
			}
		}
		return;
	}

	public static void main(String[] args){
		// boolean[] primeSieve = new boolean[1000000001];
		// Arrays.fill(primeSieve, false);

		System.out.println("Prime Sieve Generating...");
		generatePrimeSieve();
		System.out.println("Prime Sieve Generated.");

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		System.out.println("All Prime nos in between 1 and " + n + " are: ");
		for(int i=1; i<=n; i++){
			if(primeSieve[i] == true){
				System.out.print(i + ", ");
			}
		}
		System.out.println();
	}
}