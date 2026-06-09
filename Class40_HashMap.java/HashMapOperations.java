import java.util.Map;
import java.util.HashMap;

public class HashMapOperations{

	public static void main(String[] args){
		Map<String, Integer> marksMap = new HashMap<>();		// key => String, value => Integer
		String key = "Pankaj";
		// add / insert key value pair
		marksMap.put("Pankaj", 98);
		marksMap.put("Tripti", 95);
		marksMap.put("Akash", 97);
		marksMap.put("Manisha", 99);

		// read value corresponding to a key
		int pankajMarks = marksMap.get("Pankaj");
		System.out.println("Pankaj = " + pankajMarks);

		// update value corresponding to a key
		pankajMarks += 2;
		marksMap.put(key, pankajMarks);

		System.out.println("Pankaj = " + marksMap.get("Pankaj"));

		// traverse a hashmap
		System.out.println("Traversing marksMap: ");
		for(Map.Entry<String, Integer> entry: marksMap.entrySet()){
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
		System.out.println();

		// Size of Map / HashMap
		System.out.println("Size of marksMap = " + marksMap.size());


		marksMap.putIfAbsent("Pankaj", 89);
		System.out.println("Pankaj (after putIfAbsent) = " + marksMap.get("Pankaj"));

		// Delete a key in HashMap
		marksMap.remove("Pankaj");
		System.out.println("Pankaj = " + marksMap.get("Pankaj"));

		marksMap.putIfAbsent("Pankaj", 89);
		System.out.println("Pankaj = " + marksMap.get("Pankaj"));

		System.out.println("Jaskirat: " + marksMap.getOrDefault("Jaskirat", -1));

		marksMap.put("Jaskirat", 94);
		System.out.println("Jaskirat: " + marksMap.getOrDefault("Jaskirat", -2));

	}

}