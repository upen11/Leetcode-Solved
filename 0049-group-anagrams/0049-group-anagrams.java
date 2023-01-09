class Solution {

     // T: O(N * M)
    // S: O(N)
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        HashMap<HashMap<Character, Integer>, ArrayList<String>> bigMap = new HashMap<>();

        // bigMap
        // smallMap
        // "eat" --> e = 1, a = 1, t = 1

        for (String s : strs) {
            HashMap<Character, Integer> smallMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                smallMap.put(ch, smallMap.getOrDefault(ch, 0) + 1);
            }
            if (bigMap.containsKey(smallMap)) {
                ArrayList list1 = bigMap.get(smallMap);
                list1.add(s);
                bigMap.put(smallMap, list1);
            } else {
                ArrayList list2 = new ArrayList<>();
                list2.add(s);
                bigMap.put(smallMap, list2);
            }
        }

        // System.out.println(bigMap.values());

        // traversing map values
        for (ArrayList<String> a : bigMap.values()) {
            ans.add(a);
        }

        return ans;
    }
    
    
    // T: O(N log N)
    // S: O(N)
    /*
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String str = String.valueOf(arr);

            if (map.containsKey(str)) {
                List<String> temp = map.get(str);
                temp.add(s);
                map.put(str, temp);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(str, list);
            }
        }

        for (String m : map.keySet()) {
            List<String> l = map.get(m);
            ans.add(l);
        }

        return ans;
    }
    */
}
