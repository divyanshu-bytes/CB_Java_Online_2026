public class HashmapDemo{
	public static void main(String[] args){
		Hashmap myMap = new Hashmap();
		myMap.put("bat", 3);
		myMap.put("lion", 7);
		myMap.put("cow", 8);
		myMap.put("cat", 13);

		System.out.println("cat -> " + myMap.search("cat"));
		System.out.println("lion -> " + myMap.search("lion"));
		System.out.println("Size of Map = " + myMap.size());
		myMap.erase("lion");
		System.out.println("lion -> " + myMap.search("lion"));
	}
}