import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfEachCharacter{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();

		HashMap<Character, Integer> charFreqMap = new HashMap<Character, Integer>();

		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
		}

		for(Map.Entry<Character, Integer> entry: charFreqMap.entrySet()){
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
		System.out.println();
		return;
	}
}