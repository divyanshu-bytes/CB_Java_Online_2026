import java.util.Random;

public class HashMapRehashingDemo{
	public static void main(String[] args){
		HashMap<Integer, Integer> m = new HashMap<>();

		Random random = new Random();
		for(int i=0; i<50; i++){
			int key = random.nextInt(500);		// generate any random no in range 0 to 499
			int value = random.nextInt(100);

			m.put(key, value);
		}
	}
}