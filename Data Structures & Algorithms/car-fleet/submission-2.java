class Solution {
    class Pair{
        double time;
        int position;

        public Pair(double time, int position){
            this.time = time;
            this.position = position;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Pair> stack = new Stack<>();
        Pair[] ar = new Pair[position.length];
        for(int i=0;i<position.length;i++){
            double time = (target-position[i])*1.0/speed[i];
            Pair p  = new Pair(time,position[i]);
            ar[i] = p;
        }

        Arrays.sort(ar,(a,b) -> Integer.compare(a.position,b.position));
        int i = 0;
        while(i < ar.length){
            double time = ar[i].time;
            int positionR = ar[i].position;
            while(!stack.isEmpty() && stack.peek().position < positionR && stack.peek().time <= time)stack.pop();

            stack.push(ar[i]);
            i++;
        }

        return stack.size();
    }
}
