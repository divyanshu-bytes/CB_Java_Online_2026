class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String str: strs){
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);

            /*
            List<String> list;
            if(anagramMap.containsKey(sortedStr)){
                list = anagramMap.get(sortedStr);
            }
            else{
                list = new ArrayList<>();
            }

            list.add(str);
            anagramMap.put(sortedStr, list);
            */
            List<String> list = anagramMap.getOrDefault(sortedStr, new ArrayList<String>());
            list.add(str);
            anagramMap.put(sortedStr, list);
        }

        List<List<String>> ans = new ArrayList<>();
        Set<Map.Entry<String, List<String>>> sett = anagramMap.entrySet();
        for(Map.Entry<String, List<String>> entry: sett){
            // entry.getKey() -> entry.getValue()
            ans.add(entry.getValue());
        }
        return ans;
    }
}