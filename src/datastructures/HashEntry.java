package datastructures;

public class HashEntry {
    String key;
    int value;

    //Reference to next entry
    HashEntry next;

    public HashEntry(String key, int value){
        this.key=key;
        this.value = value;
    }
}
