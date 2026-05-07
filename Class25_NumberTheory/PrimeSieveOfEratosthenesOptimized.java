import java.util.*;

public class PrimeSieveOfEratosthenesOptimized{

	public static void generatePrimeSieve(boolean[] primeSieve){
		primeSieve[2] = true;
		int len = primeSieve.length;

		// make all odd nos as true
		for(int i=3; i<len; i+=2){
			primeSieve[i] = true;
		}

		// make all multiples of prime nos as false
		for(int i=3; i<len; i+=2){
			if(primeSieve[i] == true){
				// i -> prime => make all multiples of i as false (not prime)
				for(int j=i*i; j<len; j+=2*i){
					primeSieve[j] = false;
				}
			}
		}
		return;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input n: ");
		int n = scanner.nextInt();
		boolean[] primeSieve = new boolean[n + 1];			// by default fills array elements as false in primeSieve array
		// Arrays.fill(primeSieve, false);

		System.out.println("Prime Sieve Generating...");
		generatePrimeSieve(primeSieve);
		System.out.println("Prime Sieve Generated.");



		System.out.println("All Prime nos in between 1 and " + n + " are: ");
		for(int i=1; i<=n; i++){
			if(primeSieve[i] == true){
				System.out.print(i + ", ");
			}
		}
		System.out.println();
	}
}