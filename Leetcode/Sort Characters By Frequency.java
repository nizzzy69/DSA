class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch: s.toCharArray()) hm.put(ch, hm.getOrDefault(ch,0)+1);
        List<Character>[] bucket= new ArrayList[s.length()+1];
        for(Map.Entry<Character, Integer> entry: hm.entrySet()){
            int freq=entry.getValue();
            if(bucket[freq]==null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=bucket.length-1;i>=1;i--){
            if(bucket[i]==null) continue;
            for(char ch: bucket[i]){
                for(int j=0;j<i;j++){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}


'''
class Pair{
    char ch;
    int freq;
    Pair(char ch, int f){
        this.ch = ch;
        this.freq = f;
    }
    char getChar(){
        return this.ch;
    }
    int getFreq(){
        return this.freq;
    }
}


class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch: s.toCharArray()) hm.put(ch, hm.getOrDefault(ch,0)+1);
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> b.freq-a.freq);
        for(Map.Entry<Character, Integer> entry: hm.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p= pq.poll();
            for(int i=0;i<p.getFreq();i++) sb.append(p.getChar());
        }
        return sb.toString();
    }
}
'''
