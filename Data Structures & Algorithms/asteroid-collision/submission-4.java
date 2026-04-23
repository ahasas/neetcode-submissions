class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> res=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        boolean add=true;
        for(int i:asteroids){
            while(!st.isEmpty()&&st.peek()>0&&i<0){
                if(Math.abs(st.peek())-Math.abs(i)>0){
                    add=false;
                    break;
                }
                else if(Math.abs(st.peek())-Math.abs(i)==0){
                    st.pop();
                    add=false;
                    break;
                }
                else{
                    st.pop();
                }
            }
            if(add){
                st.push(i);
            }
            add=true;
        }
        while(!st.isEmpty()){
            res.add(st.pop());
        }

        Collections.reverse(res);

        return res.stream().mapToInt(Integer::intValue).toArray();
        
    }
}