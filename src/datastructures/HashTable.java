package datastructures;

import java.util.ArrayList;

public class HashTable {
    private ArrayList<HashEntry> bucket;
    private int slots;
    private int size;

    public HashTable(){
        bucket = new ArrayList<>();
        slots=10;
        size=0;
        //initialize buckets
        for (int i = 0; i < slots; i++)
            bucket.add(null);
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    private int getIndex(String key) {

        //hashCode is a built in function of Strings
        int hashCode = key.hashCode();
        int index = hashCode % slots;
        return index;
    }

    public void insert(String key, int value){
        int b_index = getIndex(key);
        HashEntry head = bucket.get(b_index);

        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        // Inserts key in the chain
        size++;
        head = bucket.get(b_index);
        HashEntry new_slot = new HashEntry(key, value);
        new_slot.next=head;
        bucket.set(b_index,new_slot);

        //Checks if array >60% of the array gets filled
        if((1.0*size)/slots >= 0.6){
            ArrayList<HashEntry> temp = bucket;
            bucket = new ArrayList<>();
            slots = slots * 2;
            size = 0;
            for(int i=0; i< slots; i++){
                bucket.add(null);
            }
            for(HashEntry headnode : temp){
                while(headnode != null){
                    insert(headnode.key,headnode.value);
                    headnode = headnode.next;
                }
            }
        }
    }

    public int getValue(String key){
        // Find the head of chain
        int b_index = getIndex(key);
        HashEntry head = bucket.get(b_index);
        // Search key in the slots
        while (head != null)
        {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        // If key not found
        return 0;
    }

    public int delete(String key){
        //Find index
        int b_Index = getIndex(key);

        // Get head of the chain for that index
        HashEntry head = bucket.get(b_Index);
        //Find the key in slots
        HashEntry prev = null;
        while (head != null)
        {
            //If key exists
            if (head.key.equals(key))
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }
        // If key does not exist
        if (head == null)
            return 0;

        // Decrease the size by one
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            bucket.set(b_Index, head.next);

        return head.value;
    }
}
