class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->
            -Integer.compare(a,b)
        );
        int[] freq = new int[26];
        for(char it: tasks){
            freq[it - 'A']++;
        }
        for(int i = 0 ; i < 26; i++){
            if(freq[i] > 0)
                pq.add(freq[i]);
        }
        Queue<int[]> q = new LinkedList<>();
        while (!pq.isEmpty() || !q.isEmpty()){
            time++;

            if(!pq.isEmpty()){
                int curTask = pq.poll();
                int newVal = curTask - 1;
                if(newVal > 0){
                    int nextAvailableTIme = time + n;
                    q.add(new int[]{newVal, nextAvailableTIme});
                }
            }

            if(!q.isEmpty()){
                if(q.peek()[1] == time){
                    pq.add(q.poll()[0]);
                }
            }
        }
        return time;
    }
}
