class MyHashMap {
    ListNode[] ar ;
    class ListNode{
    int val;
    int key;
    ListNode next;
        public ListNode(int key,int val){
            this.val = val;
            this.key = key;
        }
    }

    public MyHashMap() {
        ar = new ListNode[10000];
    }
    
    public void put(int key, int value) {
         int idx = key%10000;
        if(ar[idx] == null){
            ListNode node = new ListNode(key,value);
            ar[idx] = node;
        }else{
            ListNode temp = ar[idx];
            ListNode prev = null;
            while(temp != null){
                if(temp.key == key){
                    temp.val = value;
                    return;
                }
                else{
                    prev = temp;
                    temp = temp.next;
                } 
            }
            prev.next = new ListNode(key,value);
        }

    }
    
    public int get(int key) {
        int idx = key%10000;
        ListNode temp = ar[idx];
        while(temp != null){
            if(temp.key == key)
            {
                return temp.val;
            }else temp = temp.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int idx = key%10000;
        if(ar[idx] == null){
            return;
        }else{
            ListNode temp = ar[idx];
            ListNode prev = null;
            while(temp != null){
                if(temp.key == key){
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
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */