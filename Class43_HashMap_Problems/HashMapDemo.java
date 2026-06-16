public class HashMapDemo{
	public static void main(String[] args){
		HashMap<String, Integer> studentVsMarksMap = new HashMap<>();

		studentVsMarksMap.put("Ankit", 87);
		studentVsMarksMap.put("Naman", 99);
		studentVsMarksMap.put("Prakhar", 86);
		studentVsMarksMap.put("Aman", 98);
		studentVsMarksMap.put("Yash", 92);

		studentVsMarksMap.put("Aman", 100);

		System.out.println("Ankit -> " + studentVsMarksMap.get("Ankit"));
		System.out.println("Naman -> " + studentVsMarksMap.get("Naman"));
		System.out.println("Prakhar -> " + studentVsMarksMap.get("Prakhar"));
		System.out.println("Aman -> " + studentVsMarksMap.get("Aman"));
		System.out.println("Yash -> " + studentVsMarksMap.get("Yash"));

		System.out.println("Removing Prakhar from HashMap...");
		studentVsMarksMap.remove("Prakhar");
		System.out.println("Prakhar -> " + studentVsMarksMap.get("Prakhar"));

		System.out.println("studentVsMarksMap: Size = " + studentVsMarksMap.size());
	}
}