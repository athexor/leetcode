class BrowserHistory {
    static Stack<String> s1;
    static Stack<String> s2;

    public BrowserHistory(String homepage) {
        s1 = new Stack<>();    
        s2 = new Stack<>();
        s1.push(homepage);    
    }
    
    public void visit(String url) {
        while(!s2.isEmpty()){
            s2.pop();
        }
        s1.push(url);
    }
    
    public String back(int steps) {
        for(int i=0; s1.size() > 1 && i<=steps-1; i++){
            s2.push(s1.pop());
        }
        return s1.peek();
    }
    
    public String forward(int steps) {
        for(int i=0; !s2.isEmpty() && i<=steps-1; i++){
            s1.push(s2.pop());
        }

        return s1.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */