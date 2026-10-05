class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        int n = strs.length;

        for(int i=0; i<=n-1; i++){
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String Key = new String(str);

            if(map.containsKey(Key)){
                map.get(Key).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(Key, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}