class MyQueue {
    static Stack<Integer> s1;
    static Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();    
        s2 = new Stack<>();    
    }
    
    public void push(int x) {
        s1.push(x);
        return;
    }
    
    public int pop() {
        if(s1.isEmpty() && s2.isEmpty()) return -1;

        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }
    
    public int peek() {
        if(s1.isEmpty() && s2.isEmpty()) return -1;

        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */