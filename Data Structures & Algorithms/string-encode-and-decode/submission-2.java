class Solution {

    public String encode(List<String> strs) {
        if(strs == null || strs.isEmpty()){
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for(String str: strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        if(str == null || str.isEmpty()){
            return list;
        }
        int i = 0;
        while(i < str.length()){
            int delimiterIndex = str.indexOf('#',i);
            String lengthStr = str.substring(i,delimiterIndex);
            int length = Integer.parseInt(lengthStr);
            i = delimiterIndex + 1;
            String currentStr = str.substring(i, i + length);
            list.add(currentStr);
            i += length;
        }
        return list;
    }
}
