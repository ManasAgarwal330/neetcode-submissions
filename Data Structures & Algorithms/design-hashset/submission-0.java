class MyHashSet {
    ListNode[] ar ;
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public MyHashSet() {
        ar = new ListNode[10000];
    }
    
    public void add(int key) {
        int idx = key%10000;
        if(ar[idx] == null){
            ListNode node = new ListNode(key);
            ar[idx] = node;
        }else{
            ListNode temp = ar[idx];
            ListNode prev = null;
            while(temp != null){
                if(temp.val == key)return;
                else{
                    prev = temp;
                    temp = temp.next;
                } 
            }
            prev.next = new ListNode(key);
        }
    }
    
    public void remove(int key) {
        int idx = key%10000;
        if(ar[idx] == null){
            return;
        }else{
            ListNode temp = ar[idx];
            ListNode prev = null;
            while(temp != null){
                if(temp.val == key){
                    if(prev == null){
                        ar[idx] = temp.next;
                    }else{
                        prev.next = temp.next;
                    }
                    return;
                }
                else {
                    prev = temp;
                    temp = temp.next;
                }
            }
        }
        return;
    }
    
    public boolean contains(int key) {
        int idx = key%10000;
        ListNode temp = ar[idx];
        while(temp != null){
            if(temp.val == key)
            {
                return true;
            }else temp = temp.next;
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */