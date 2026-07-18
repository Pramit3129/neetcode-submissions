class Solution {
    class Pair{
        int dis;
        String state;
        public Pair(int dis, String state){
            this.dis = dis;
            this.state=state;
        } 
    }
    public int openLock(String[] deadends, String target)  {
        HashSet<String> dE = new HashSet<>();
        dE.addAll(Arrays.asList(deadends));
        if(dE.contains("0000")){
            return -1;
        }
        if ("0000".equals(target)) return 0;
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        Pair start = new Pair(0, "0000");
        q.add(start);
        vis.add("0000");
        while (!q.isEmpty()){
            Pair cur = q.poll();
            int curDis = cur.dis;
            char[] state = cur.state.toCharArray();

            for(int i = 0; i < state.length; i++){
                int curChar = state[i] - '0';
                int[] moves = {(curChar + 1) % 10, (curChar + 9) % 10};
                
                for (int nextVal : moves) {
                    char[] temp = state.clone();
                    temp[i] = (char) (nextVal + '0');
                    String adjStr = new String(temp);
                    
                    if (adjStr.equals(target)) {
                        return curDis + 1;
                    }
                    
                    if (!dE.contains(adjStr) && !vis.contains(adjStr)) {
                        vis.add(adjStr);
                        q.add(new Pair(curDis + 1, adjStr));
                    }
                }
            }
        }
        return -1;
    }
}